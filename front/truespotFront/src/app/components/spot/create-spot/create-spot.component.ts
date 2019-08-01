import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Spot} from "../../../../model/spot";
import {SpotService} from "../../../services/spot/spot-service";

@Component({
  selector: 'app-create-spot',
  templateUrl: './create-spot.component.html',
  styleUrls: ['./create-spot.component.css']
})
export class CreateSpotComponent implements OnInit {

  forms: FormGroup;
  spot: Spot;

  constructor(private spotService: SpotService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  saveSpot() {
    console.log(this.forms.value)
    this.spotService.saveSpot(this.forms)
      .subscribe(
        response => this.forms)

  }

  initForm (){
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        nearestCity: new FormControl(),
        carAccess: new FormControl(),
        carParking: new FormControl(),
        accessDescription: new FormControl(),
        nearestHospital: new FormControl(),
        supplyComment: new FormControl(),
      }
    );

  }
}
