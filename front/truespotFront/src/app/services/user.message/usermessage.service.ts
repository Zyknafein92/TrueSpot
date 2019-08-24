import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {User} from "../../../model/user";
import {UserMessage} from "../../../model/userMessage";
import {Topo} from "../../../model/topo";
import {TokenStorageService} from "../auth/token-storage.service";

@Injectable({
  providedIn: 'root'
})
export class UsermessageService {

  private userMessageUrl = 'http://localhost:8080/message/topo';

  constructor(private http:HttpClient) { }

  getAllMessageByTopoID(id: string): Observable<UserMessage[]>{
    return this.http.get<UserMessage[]>(this.userMessageUrl + '/userMessageByTopo' , {
      params: new HttpParams()
        .set('idTopo', id),
    });
  }

  saveUserMessage(form: FormGroup): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.userMessageUrl+ '/userMessage/save', form.value);
  }


  updateUserMessage(form: FormGroup) : Observable<UserMessage>{
    return this.http.put<UserMessage>(this.userMessageUrl + '/userMessage/update', form.value
    );
  }

  deleteUserMessage(idMessage: string){
    console.log('DELETE MessageTopo:', idMessage);
    return this.http.delete(this.userMessageUrl + '/delete', {
      params: new HttpParams()
        .set('idMessage', idMessage),
    });
  }
}
