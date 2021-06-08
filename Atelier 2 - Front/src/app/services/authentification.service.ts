import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/login.model';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
 
  currentUser: any;

  private userId: number;

  constructor(public httpClient: HttpClient) { }


  createUser(user: User): Observable<any> {
    return this.httpClient.post<User>('http://localhost:8080/users/', user);
  }

  
  login(loginInfo: Login): Observable<any> {
    console.log(loginInfo)
    return this.httpClient.post<User>('http://localhost:8080/login', loginInfo);
  }

  logout(): Observable<any> {
    return this.httpClient.post('http://localhost:8080/logout', {});
  }

  setUserId(id: number) {
    this.userId = id;
  }

  getUserId(): number {
    return this.userId;
  }

}
