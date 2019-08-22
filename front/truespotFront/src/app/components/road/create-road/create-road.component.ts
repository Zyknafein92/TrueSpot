import { Component, OnInit } from '@angular/core';
import {RoadService} from "../../../services/road/roadservice";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ClimbingRoad} from "../../../../model/climbingRoad";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-create-road',
  templateUrl: './create-road.component.html',
  styleUrls: ['./create-road.component.css']
})
export class CreateRoadComponent implements OnInit {

  forms: FormGroup;
  road: ClimbingRoad;
  idArea: string;
  private sub: any;

  constructor(private roadService: RoadService, private formBuilder: FormBuilder,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idArea = params['idArea']; // (+) converts string 'id' to a number
    });
    this.initform();
  }

  saveRoad() {
    console.log(this.forms.value);
    this.roadService.saveRoad(this.forms)
      .subscribe(
        response => {
          // @ts-ignore
          this.router.navigateByUrl("/topo/view-mytopo/"+response.id);
          console.log("reponse: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

private initform() {
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        type: new FormControl(),
        number: new FormControl(),
        letter: new FormControl(),
        symbol: new FormControl(),
        idArea : this.idArea
      }
    );
  }
}
