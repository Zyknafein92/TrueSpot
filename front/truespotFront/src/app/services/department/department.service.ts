import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Department} from "../../../model/department";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private deparmentUrl = 'http://localhost:8080/department';

  constructor(private http: HttpClient) {
  }

  getDepartments() {
    return this.http.get<Department>(this.deparmentUrl);
  }
}
