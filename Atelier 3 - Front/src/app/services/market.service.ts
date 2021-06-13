import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root'
})
export class MarketService {

  constructor(private httpClient: HttpClient, private authentificationService: AuthentificationService) { }

  
  buyCard(idCard: number, idUser: number): Observable<any> {
    return this.httpClient.post(
        `http://localhost:8081/market/buy`, 
        {"id" : idUser, "cardId" : idCard}
    );
  }

  sellCard(idCard: number, idUser: number): Observable<any> {
    return this.httpClient.post(
      `http://localhost:8081/market/sell`, 
      {"id" : idUser, "cardId" : idCard}
    );
  }
}
