import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Share} from "../../../model/share";
import {Topo} from "../../../model/topo";

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  private shareURL = 'http://localhost:8080/topo/share';


  constructor(private http: HttpClient) { }

  findUserShare(idTopo : string): Observable<Share>{
    return this.http.get<Share>(this.shareURL + '/user', {
      params : new HttpParams()
        .set('id', idTopo)
    });
  }


  saveShare(shareDTO: any): Observable<Share> {
    return this.http.post<Share>(this.shareURL + '/create', shareDTO);
  }

  updateTopo(topo: any){
    console.log('UPDTAE Share:', topo);
    return this.http.put<Topo>(this.shareURL + '/update', topo);
  }

}
