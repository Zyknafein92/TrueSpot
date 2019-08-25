import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Topo} from "../../../../model/topo";
import {TopoService} from "../../../services/topo/topo.service";
import {DepartmentService} from "../../../services/department/department.service";
import {Department} from "../../../../model/department";
import {User} from "../../../../model/user";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../../services/auth/token-storage.service";

@Component({
  selector: 'app-create-topo',
  templateUrl: './create-topo.component.html',
  styleUrls: ['./create-topo.component.css']
})
export class CreateTopoComponent implements OnInit {

  forms: FormGroup;
  topo: Topo;
  user: User;
  department: Department;
  departments: Department;
  authorities: string;



  constructor(private topoService: TopoService, private departmentService :DepartmentService, private formBuilder: FormBuilder,
              private router: Router, private token:TokenStorageService){
  }

  ngOnInit() {
    this.initForm();
    this.initDepartmentList();
  }


  saveTopo() {
    this.topoService.saveTopo(this.forms)
      .subscribe(
        response => {
          this.router.navigateByUrl("/topo/area/add-area/"+response.id)
          console.log("response: ", response);
        },
        err => {
          console.log("error: ", err.error.message);
        })
  }

  private initForm() {
    this.forms = this.formBuilder.group({
      name: new FormControl(),
      department : new FormControl(),
      user: new FormControl(),
      description: new FormControl(),
      nearestCity: new FormControl(),
      carAccess: new FormControl(),
      carParking: new FormControl(),
      accessDescription: new FormControl(),
      nearestHospital: new FormControl(),
      supplyComment: new FormControl(),
      isAmical : new FormControl(),
    });
  }

  private initDepartmentList() {
    this.departmentService.getDepartments().subscribe(
      res =>
      {
        this.departments = res;
      }
    );
  }

}
