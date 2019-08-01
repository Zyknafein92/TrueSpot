import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Topo} from "../../../../model/topo";
import {TopoService} from "../../../services/topo/topo.service";
import {DepartmentService} from "../../../services/department/department.service";
import {Department} from "../../../../model/department";
import {User} from "../../../../model/user";

@Component({
  selector: 'app-create-topo',
  templateUrl: './create-topo.component.html',
  styleUrls: ['./create-topo.component.css']
})
export class CreateTopoComponent implements OnInit {

  forms: FormGroup;
  topo: Topo;
  department: Department;
  departments: Department;



  constructor(private topoService: TopoService, private departmentService :DepartmentService, private formBuilder: FormBuilder){
  }

  ngOnInit() {
    this.initForm();
    this.initDepartmentList();
  }


  saveTopo() {
    console.log(this.forms.value);

    this.topoService.saveTopo(this.forms)
      .subscribe(
        response => this.forms)

  }

  private initForm() {
    this.forms = this.formBuilder.group({
      name: new FormControl(),
      department : new FormControl(),
    });
  }

  private initDepartmentList() {
    this.departmentService.getDepartments().subscribe(
      res =>{this.departments = res;}
    );
  }

}
