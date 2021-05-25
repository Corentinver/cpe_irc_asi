import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardService } from '../services/card.service';
import { MarketService } from '../services/market.service';

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
    private authentificationService: AuthentificationService
  ) { }

  ngOnInit(): void {
    this.observableRequestCards = this.cardService.getShop(this.authentificationService.currentUser.id);
  }

  onBuyCard(cardId : number) : void {
    console.log("buy card id : " + cardId);
    this.marketService.buyCard(cardId, this.authentificationService.currentUser.id).subscribe((data) => {
      this.observableRequestCards = this.cardService.getShop(this.authentificationService.currentUser.id);
    });

  }
}
