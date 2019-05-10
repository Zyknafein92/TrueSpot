import { Component, OnInit } from '@angular/core';
import {RoadService} from "../../../services/road/roadservice";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ClimbingRoad} from "../../../../model/climbingRoad";


@Component({
  selector: 'app-create-road',
  templateUrl: './create-road.component.html',
  styleUrls: ['./create-road.component.css']
})
export class CreateRoadComponent implements OnInit {

  forms: FormGroup;
  road: ClimbingRoad;

  constructor(private roadService: RoadService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.initform();
  }

  saveRoad() {
    console.log("formsformsformsformsformsformsformsforms")
    console.log(this.forms.value)
    this.roadService.saveRoad(this.forms)
      .subscribe(
        response => this.forms)
  }

  private initform() {
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        type: new FormControl(),
        number: new FormControl(),
        letter: new FormControl(),
        symbol: new FormControl()
      }
    );
  }
}
