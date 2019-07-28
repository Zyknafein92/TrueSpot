import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { JwtResponse } from './jwt-response';
import {CreateUserComponent} from "../../components/user/create-user/create-user.component";

import {AuthLoginInfo} from "../../../model/authLoginInfo";

const httpOptions = {
  //headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': ''})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginURL = 'http://localhost:8080/login';
  private registerURL = 'http://localhost:8080/register';

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginURL, credentials, httpOptions);
  }

  register(info: CreateUserComponent): Observable<string> {
    return this.http.post<string>(this.registerURL, info, httpOptions);
  }
}
