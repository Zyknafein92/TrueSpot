import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Topo} from "../../../model/topo";
import {ClimbingRoad} from "../../../model/climbingRoad";

@Injectable({
  providedIn: 'root'
})
export class RoadService {

  private roadUrl = 'http://localhost:8080/road';

  constructor(private http: HttpClient) { }

  saveRoad(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.roadUrl, form.value);
  }

  getRoad(idRoad: string) {
    console.log("idRoad: ", idRoad)
    return this.http.get<ClimbingRoad>( this.roadUrl+'/getRoad',
      {
        params: new HttpParams()
          .set('id', idRoad),
      });
  }
}
