import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.scss']
})
export class SellComponent implements OnInit {

  requestUnowned: Observable<any>;
  constructor(private cardService: CardService, private authentificationService: AuthentificationService) { }

  ngOnInit(): void {
    this.requestUnowned = this.cardService.getCollection(this.authentificationService.currentUser.id);
  }


}
