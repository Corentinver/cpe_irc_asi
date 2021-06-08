import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(private authentificationService: AuthentificationService) { }

  ngOnInit(): void {

  }

  getMonnaie() {
    return this.authentificationService.currentUser.money;
  }

  getSurname() {
    return this.authentificationService.currentUser.surname;
  }

}
