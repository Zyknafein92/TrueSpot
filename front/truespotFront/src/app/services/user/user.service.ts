import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {User} from "../../../model/user";
import {TokenStorageService} from "../auth/token-storage.service";
import {Topo} from "../../../model/topo";




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

  getUsers(){
    return this.http.get<User>(this.userUrl + 's');
  }

  getProfil(pseudo : string) {
    return this.http.get<User>(this.userProfilURL,
      {
        params : new HttpParams()
          .set('pseudo', this.token.getPseudo())
      });
  }

  getUser(idUser:string){
    return this.http.get<User>(this.userUrl + 'userMessage', {
      params: new HttpParams()
        .set('id', idUser)
    });
  }

  updateUser(forms: FormGroup): Observable<User> {
    return this.http.put<Topo>(this.userUrl + '/update', forms.value)
  }

  updateUserRole(user : any): Observable<User> {
    return this.http.put<User>(this.userUrl + '/update/role', user)
  }

  deleteUser(idUser: any): Observable<{}>{
    return this.http.delete<User>( this.userUrl + '/delete', {
      params: new HttpParams()
        .set('idUser', idUser)
    });
  }

}
