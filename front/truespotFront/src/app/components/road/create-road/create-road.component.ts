import { Component, OnInit } from '@angular/core';
import {RoadService} from "../../../services/road/roadservice";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-create-road',
  templateUrl: './create-road.component.html',
  styleUrls: ['./create-road.component.css']
})
export class CreateRoadComponent implements OnInit {

  constructor(private roadService: RoadService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.initform();
  }

  private initform() {
  }
}
