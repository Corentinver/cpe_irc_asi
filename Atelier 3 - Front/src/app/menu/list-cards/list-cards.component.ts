import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { Card } from 'src/app/model/card.model';

@Component({
  selector: 'app-list-cards',
  templateUrl: './list-cards.component.html',
  styleUrls: ['./list-cards.component.scss']
})
export class ListCardsComponent implements OnInit {

  displayedColumns: string[] = ['name', 'description', 'family', 'affinity', 'energy', 'hp', 'price', 'actions'];
  dataCards: Card[] = [];

  @Input() observableCards: Observable<any>;
  @Output() onAction: EventEmitter<any> = new EventEmitter();
  isLoadingResults = true;
  
  constructor() { }

  ngOnInit(): void {
    this.observableCards.subscribe((data) => {
      console.log('data' + data);
      this.dataCards = data;
      this.isLoadingResults = false;
    });
  }

  ngChange(): void {
    this.observableCards.subscribe((data) => {
      console.log('data' + data);
      this.dataCards = data;
      this.isLoadingResults = false;
    });
  }

  actionClickedByUser(cardId: number) : void{
    this.onAction.emit(cardId);
  }

}