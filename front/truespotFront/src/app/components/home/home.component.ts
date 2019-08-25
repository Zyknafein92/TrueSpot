import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/auth/token-storage.service";
import {DepartmentService} from "../../services/department/department.service";
import {Department} from "../../../model/department";
import {Topo} from "../../../model/topo";
import {TopoService} from "../../services/topo/topo.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  topo :Topo;
  topos : Topo[];
  idDepartement: any;
  department: Department;
  departments: Department;

  formSearchDept: FormGroup;
  departement: Department;


  constructor(private token: TokenStorageService,private departmentService :DepartmentService, private topoService:TopoService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    this.initDepartmentList();
    this.initDepartmentForm()
  }

  private initDepartmentForm(){
    this.formSearchDept = this.formBuilder.group(
      {
        idDepartment: new FormControl(),
      });
    console.log(this.formSearchDept);
  }


  private initDepartmentList() {
    this.departmentService.getDepartments().subscribe(
      res =>
      {
        this.departments = res;
      }
    );
  }

  sendIdTopo(id){
    this.router.navigateByUrl("/topo/view-topo/"+id)
  }


  getTopoByDept() {
    this.idDepartement = this.formSearchDept.value;
    console.log("value id:",this.idDepartement)
    this.topoService.getTopoByDepartment(this.idDepartement)
      .subscribe(
        response => {
          this.topos = response;
          console.log("TOPOTPTOOTP :", this.topo)
        },
        err => {
          console.log("error: ", err);
        })

  }





  logout() {
    this.token.signOut();
    window.location.reload();
  }



}
