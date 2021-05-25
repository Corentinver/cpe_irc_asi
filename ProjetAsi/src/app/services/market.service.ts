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
    return this.httpClient.get(`http://localhost:8080/market/buy?cardId=${idCard}&userId=${idUser}`, {});
  }

  sellCard(idCard: number, idUser: number): Observable<any> {
    return this.httpClient.get(`http://localhost:8080/market/sell?cardId=${idCard}&userId=${idUser}`, {})
  }
}
