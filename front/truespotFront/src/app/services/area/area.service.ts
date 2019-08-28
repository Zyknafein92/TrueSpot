import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
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

  getArea(idArea: string) {
    return this.http.get<Area>(this.areaUrl+ '/getByID',{
      params: new HttpParams()
        .set('idArea', idArea),
    });
  }

  getAreas(idTopo: string) {
    return this.http.get<Area[]>(this.areaUrl  + '/getAllByTopo',
      {
        params: new HttpParams()
          .set('idTopo', idTopo),
      });
  }
  updateArea(form: FormGroup): Observable<Area>{
    return this.http.put<Area>(this.areaUrl + '/update', form.value);
  }

  deleteArea(idArea: string): Observable<{}>{
    console.log('DELETE AREA:', idArea);
    return this.http.delete(this.areaUrl + '/delete', {
      params: new HttpParams()
        .set('idArea', idArea),
    });
  }
}
