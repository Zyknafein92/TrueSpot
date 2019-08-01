import { Injectable } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Area} from "../../../model/area";

@Injectable({
  providedIn: 'root'
})


export class SpotService {

  private spotUrl = 'http://localhost:8080/spot';

  constructor(private http: HttpClient) { }

  saveSpot(forms: FormGroup) {
    return this.http.post<FormGroup>(this.spotUrl, forms.value);
  }

  getArea(id: number) {
    return this.http.get<Area>(this.spotUrl + '/' + id);
  }

}
