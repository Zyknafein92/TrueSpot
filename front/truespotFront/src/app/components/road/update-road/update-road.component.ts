import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {RoadService} from "../../../services/road/roadservice";
import {ActivatedRoute, Router} from "@angular/router";
import {ClimbingRoad} from "../../../../model/climbingRoad";

@Component({
  selector: 'app-update-road',
  templateUrl: './update-road.component.html',
  styleUrls: ['./update-road.component.css']
})
export class UpdateRoadComponent implements OnInit {

  constructor(private roadService: RoadService, private formBuilder: FormBuilder) { }
  forms: FormGroup;
  road: ClimbingRoad;
  idArea: string;

  ngOnInit() {
    this.initform();
  }

  updateRoad(){
    this.roadService.updateRoad(this.forms);
  }

  private initform() {
    this.forms = this.formBuilder.group(
      {
        name: this.road.name,
        description: this.road.description,
        type: this.road.type,
        number: this.road.number,
        letter: this.road.letter,
        symbol: this.road.symbol,
        idArea : this.idArea,
      }
    );
  }
}
