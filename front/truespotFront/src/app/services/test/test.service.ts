import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class TestService {
  private userUrl = 'http://localhost:8080';
  constructor(private http:HttpClient) { }

  registerPerson(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.userUrl + '/user', form.value);
  }
}
