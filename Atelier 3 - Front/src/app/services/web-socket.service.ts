import { InjectableRxStompConfig, RxStompService  } from '@stomp/ng2-stompjs';
import { Observable } from 'rxjs';

import { WebSocketOptions } from '../model/websocket.options';
import { SocketResponse } from '../model/websocket.response'

/**
 * A WebSocket service allowing subscription to a broker.
 */
export class WebSocketService {
  private obsStompConnection: Observable<any>;
  private subscribers: Array<any> = [];
  private subscriberIndex = 0;
  private stompConfig = {
    heartbeatIncoming: 0,
    heartbeatOutgoing: 20000,
    reconnectDelay: 10000,
    //debug: (str) => { console.log(str); }
  };

  constructor(
    private stompService: RxStompService,
    private updatedStompConfig: InjectableRxStompConfig,
    private options: WebSocketOptions
    ) {
    // Update StompJs configuration.
    this.stompConfig = {...this.stompConfig, ...this.updatedStompConfig};
    // Initialise a list of possible subscribers.
    this.createObservableSocket();
    // Activate subscription to broker.
    this.connect();
  }

  private createObservableSocket = () => {
    this.obsStompConnection = new Observable(observer => {
      const subscriberIndex = this.subscriberIndex++;
      this.addToSubscribers({ index: subscriberIndex, observer });
      return () => {
        this.removeFromSubscribers(subscriberIndex);
      };
    });
  }

  private addToSubscribers = subscriber => {
    this.subscribers.push(subscriber);
  }

  private removeFromSubscribers = index => {
    for (let i = 0; i < this.subscribers.length; i++) {
      if (i === index) {
        this.subscribers.splice(i, 1);
        break;
      }
    }
  }

  /**
   * Connect and activate the client to the broker.
   */
  private connect = () => {
    this.stompService.stompClient.configure(this.stompConfig);
    this.stompService.stompClient.onConnect = this.onSocketConnect;
    this.stompService.stompClient.onStompError = this.onSocketError;
    this.stompService.stompClient.activate();
  }

  /**
   * On each connect / reconnect, we subscribe all broker clients.
   */
  private onSocketConnect = frame => {
    this.options.brokerEndpoint.forEach((m) => {
      this.stompService.stompClient.subscribe(m, this.socketListener);
    })
  }

  private onSocketError = errorMsg => {
    console.log('Broker reported error: ' + errorMsg);

    const response: SocketResponse = {
      type: 'ERROR',
      message: errorMsg
    };

    this.subscribers.forEach(subscriber => {
      subscriber.observer.error(response);
    });
  }

  private socketListener = frame => {
    this.subscribers.forEach(subscriber => {
      console.log(frame);
      subscriber.observer.next(this.getMessage(frame, frame.headers.destination));
    });
  }

  private getMessage = (data, ch) => {
    
    const response: SocketResponse = {
      type: 'SUCCESS',
      channel: ch,
      message: JSON.parse(data.body)
    };
    return response;
  }

  /**
   * Return an observable containing a subscribers list to the broker.
   */
  public getObservable = () => {
    return this.obsStompConnection;
  }
}