import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Card } from 'src/app/model/card.model';

@Component({
  selector: 'app-list-cards',
  templateUrl: './list-cards.component.html',
  styleUrls: ['./list-cards.component.scss']
})
export class ListCardsComponent implements OnInit {

  displayedColumns: string[] = ['name', 'description', 'family', 'affinity', 'energy', 'hp', 'price'];
  dataCards: Card[];

  @Input() observableRequestCards: Observable<any>;

  isLoadingResults = true;
  
  constructor() { }

  ngOnInit(): void {
    this.observableRequestCards.subscribe((data) => {
      this.dataCards = data;
      this.isLoadingResults = false;
    });
  }

}