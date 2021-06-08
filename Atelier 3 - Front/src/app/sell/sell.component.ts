import { Input, Output } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardService } from '../services/card.service';
import { MarketService } from '../services/market.service';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.scss']
})
export class SellComponent implements OnInit {
  observableRequestCards: Observable<any>;
  
  constructor(
    private cardService: CardService,
    private marketService: MarketService, 
    private authentificationService: AuthentificationService
  ) { }

  ngOnInit(): void {
    this.observableRequestCards = this.cardService.getCollection(this.authentificationService.currentUser.id);
  }

  onSellCard(cardId : number){
    console.log("sell card id : " + cardId);
    this.marketService.sellCard(cardId, this.authentificationService.currentUser.id).subscribe((data) => {
      this.observableRequestCards = this.cardService.getCollection(this.authentificationService.currentUser.id);
    });
  }

}
