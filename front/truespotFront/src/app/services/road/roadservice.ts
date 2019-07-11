import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoadService {

  private roadUrl = 'http://localhost:8080/road';

  constructor(private http: HttpClient) { }

  saveRoad(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.roadUrl, form.value);
  }
}
