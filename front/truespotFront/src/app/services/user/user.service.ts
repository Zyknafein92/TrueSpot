import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {User} from "../../../model/user";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userRegisterUrl = 'http://localhost:8080/register';
  private userUrl = 'http://localhost:8080/user';

  constructor(private http:HttpClient) { }

  saveUser(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.userRegisterUrl, form.value);
  }

  getUser(id:number){
    return this.http.get<User>(this.userUrl + '/' + id);
  }



}
