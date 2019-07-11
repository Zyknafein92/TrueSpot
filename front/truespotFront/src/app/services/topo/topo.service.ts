import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Topo} from "../../../model/topo";

@Injectable({
  providedIn: 'root'
})

export class TopoService {

  private topoUrl = 'http://localhost:8080/topo';

  constructor(private http:HttpClient) { }

  saveTopo(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.topoUrl, form.value);
  }

  getUser(id:number){
    return this.http.get<Topo>(this.topoUrl + '/' + id);
  }
}
