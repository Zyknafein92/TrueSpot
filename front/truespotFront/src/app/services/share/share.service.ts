import { Injectable } from '@angular/core';
import {FormGroup} from "@angular/forms";
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


  saveShare(shareDTO: any): Observable<Share> {
    return this.http.post<Share>(this.shareURL + '/create', shareDTO);
  }

  updateTopo(topo: any){
    console.log('UPDTAE Share:', topo);
    return this.http.put<Topo>(this.shareURL + '/update', topo);
  }

}
