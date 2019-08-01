import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Area} from "../../../../model/area";
import {AreaService} from "../../../services/area/area.service";




@Component({
  selector: 'app-create-area',
  templateUrl: './create-area.component.html',
  styleUrls: ['./create-area.component.css']
})
export class CreateAreaComponent implements OnInit {

  forms: FormGroup;
  area: Area;

  constructor(private areaService:AreaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  saveArea() {
    console.log(this.forms.value)
    this.areaService.saveArea(this.forms)
      .subscribe(
        response => this.forms)

  }

  initForm(){
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        nearestcity: new FormControl(),
        roadNumber: new FormControl(),
        height: new FormControl()
      }
    );
  }

}
