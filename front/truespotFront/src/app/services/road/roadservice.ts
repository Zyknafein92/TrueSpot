import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
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
    return this.http.get<ClimbingRoad>( this.roadUrl + '/getRoadByID',
      {
        params: new HttpParams()
          .set('idRoad', idRoad),
      });
  }

  getRoads(idArea: string){
    return this.http.get<ClimbingRoad[]>( this.roadUrl + '/getAllByArea',
      {
        params: new HttpParams()
          .set('idArea', idArea),
      });
  }

  deleteRoad(idRoad: string): Observable<{}>{
    console.log('DELETE ROAD:', idRoad);
    return this.http.delete(this.roadUrl, {
      params: new HttpParams()
        .set('idRoad', idRoad),
    });
  }

  updateRoad(form: FormGroup): Observable<ClimbingRoad>{
    return this.http.put<ClimbingRoad>(this.roadUrl + '/update', form.value);
  }
}
