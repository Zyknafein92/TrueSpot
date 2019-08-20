import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Form, FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
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

  getRoad(idRoad: string) :Observable<ClimbingRoad>{
    console.log("idRoad: ", idRoad)
    return this.http.get<ClimbingRoad>( this.roadUrl + '/getRoad',
      {
        params: new HttpParams()
          .set('id', idRoad),
      });
  }

  getRoads(idArea: string){
    return this.http.get<ClimbingRoad[]>( this.roadUrl + '/getAllByArea',
      {
        params: new HttpParams()
          .set('idArea', idArea),
      });
  }


  updateRoad(form: FormGroup): Observable<FormGroup>{
    return this.http.put<FormGroup>(this.roadUrl + '/road/{id}', form.value)
  }
}
