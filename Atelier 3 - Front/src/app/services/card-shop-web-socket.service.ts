
import { Injectable } from '@angular/core';
import { InjectableRxStompConfig, RxStompService } from '@stomp/ng2-stompjs';
import { WebSocketService } from './web-socket.service';
import { WebSocketOptions } from '../model/websocket.options';
import { AuthentificationService } from './authentification.service';
 
export const progressStompConfig: InjectableRxStompConfig = {
  webSocketFactory: () => {
    return new WebSocket('ws://localhost:8082/stomp');
  }
};
 
@Injectable({
  providedIn: 'root'
})
export class CardShopWebSocketService extends WebSocketService {
  constructor(
    stompService: RxStompService, 
    private authentificationService: AuthentificationService) {
    super(stompService, progressStompConfig, new WebSocketOptions([`/socket/${authentificationService.currentUser.id}/shopCard`, ]));
  }
}