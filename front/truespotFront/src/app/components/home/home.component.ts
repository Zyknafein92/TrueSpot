import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/auth/token-storage.service";
import {DepartmentService} from "../../services/department/department.service";
import {Department} from "../../../model/department";
import {Topo} from "../../../model/topo";
import {TopoService} from "../../services/topo/topo.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
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
  info: any;
  formSearchDept: FormGroup;
  forms: FormGroup;





  constructor(private token: TokenStorageService,private departmentService :DepartmentService, private topoService:TopoService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    this.forms = this.formBuilder.group(
      {
        departs:new FormControl('', Validators.required),
        avaible: new FormControl(),
        type: new FormControl(),
      });
    this.initDepartmentList();

    this.info = {
      token: this.token.getToken(),
      username: this.token.getPseudo(),
      authorities: this.token.getAuthorities()
    };
    this.getAllDepart();
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


  searchCriteria() {
    this.topoService.getTopoBySearch(
      this.forms.get("departs").value!=null?this.forms.get("departs").value:"",
      this.forms.get("avaible").value!=null?this.forms.get("avaible").value:"",
      this.forms.get("type").value!=null?this.forms.get("type").value:"")
      .subscribe(
        response => {
          this.topos = response;
          console.log("TOPO Search :", this.topos)
        },
        err => {
          console.log("error: ", err);
        })
  }


  getAllDepart() {
    this.topoService.getAllTopo()
      .subscribe(
        response => {
          this.topos = response;
          console.log("TOPO Search :", this.topos)
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
