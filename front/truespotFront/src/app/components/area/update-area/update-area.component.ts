import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Area} from "../../../../model/area";
import {AreaService} from "../../../services/area/area.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-area',
  templateUrl: './update-area.component.html',
  styleUrls: ['./update-area.component.css']
})
export class UpdateAreaComponent implements OnInit {

  forms: FormGroup;
  area: Area;
  idTopo: string;


  constructor(private areaService:AreaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  updateArea(){
    this.areaService.updateArea(this.forms, this.area.id)
  }


  initForm(){
    this.forms = this.formBuilder.group(
      {
        name: this.area.name,
        description: this.area.description,
        orientation  : this.area.orientation,
        roadNumber: this.area.roadNumber,
        height: this.area.height,
        idTopo: this.idTopo,
      }
    );
  }

}
