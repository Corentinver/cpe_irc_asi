import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {

  requestUnowned: Observable<any>;
  
  constructor(private cardService: CardService, private authentificationService: AuthentificationService) { }

  ngOnInit(): void {
    this.requestUnowned = this.cardService.getShop(this.authentificationService.currentUser.id);
  }

}
