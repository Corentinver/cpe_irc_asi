import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../services/authentification.service';

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
    console.log(this.authentificationService.currentUser)
    return this.authentificationService.currentUser.money;
  }

  getNom() {
    return this.authentificationService.currentUser.name;
  }

}
