import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {User} from "../../../model/user";
import {TokenStorageService} from "../auth/token-storage.service";




@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userRegisterUrl = 'http://localhost:8080/register';
  private userUrl = 'http://localhost:8080/user';
  private userProfilURL = 'http://localhost:8080/user/myprofil';

  constructor(private http:HttpClient, private token:TokenStorageService) { }

  saveUser(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.userRegisterUrl, form.value);
  }

  getProfil(pseudo : string) {
    return this.http.get<User>(this.userProfilURL,
      {
        params : new HttpParams()
          .set('pseudo', this.token.getPseudo())
      });
  }

  getUser(id:number){
    return this.http.get<User>(this.userUrl + '/' + id);
  }
}
