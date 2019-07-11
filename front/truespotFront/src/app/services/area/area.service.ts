import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Area} from "../../../model/area";


@Injectable({
  providedIn: 'root'
})
export class AreaService {

  private areaUrl = 'http://localhost:8080/area';

  constructor(private http: HttpClient) {
  }

  saveArea(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.areaUrl, form.value);
  }

  getArea(id: number) {
    return this.http.get<Area>(this.areaUrl + '/' + id);
  }
}
