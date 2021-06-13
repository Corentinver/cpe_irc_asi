import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardShopWebSocketService } from '../services/card-shop-web-socket.service';
import { CardService } from '../services/card.service';
import { MarketService } from '../services/market.service';
import { WebSocketService } from '../services/web-socket.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {

  observableRequestCards: Observable<any>;
  
  constructor(
    private cardService: CardService,
    private marketService: MarketService, 
    private authentificationService: AuthentificationService,
    private webSocket: CardShopWebSocketService
  ) { }

  ngOnInit(): void {
    this.initSocket();
    this.observableRequestCards = this.cardService.getShop(this.authentificationService.currentUser.id);
  }

  onBuyCard(cardId : number) : void {
    console.log("buy card id : " + cardId);
    this.marketService.buyCard(cardId, this.authentificationService.currentUser.id).subscribe(result => {
      //this.observableRequestCards = this.cardService.getShop(this.authentificationService.currentUser.id);
    })
  }

  private initSocket = () => {
    const obsNewFire = this.webSocket.getObservable();
    obsNewFire.subscribe({
      next: this.onNewProgressMsg,
      error: err => {
        console.log(err);
      }
    });

  }

  private onNewProgressMsg = receivedMsg => {
    if (receivedMsg.type === 'SUCCESS') {
      console.log(receivedMsg.message);
      console.log(receivedMsg.channel);
      this.observableRequestCards = receivedMsg.message;
    }
  }
}
