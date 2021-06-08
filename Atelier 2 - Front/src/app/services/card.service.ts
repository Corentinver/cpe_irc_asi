import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private httpClient: HttpClient) { }

  getCollection(userId: number): Observable<any> {
    return this.httpClient.get(`http://localhost:8080/cards/collection?id=${userId}`);
  }

  getShop(userId: number): Observable<any> {
    return this.httpClient.get(`http://localhost:8080/cards/shop?id=${userId}`);
  }

}
