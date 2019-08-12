import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Spot} from "../../../../model/spot";
import {SpotService} from "../../../services/spot/spot-service";
import {ActivatedRoute, Router} from "@angular/router";
import {Topo} from "../../../../model/topo";

@Component({
  selector: 'app-create-spot',
  templateUrl: './create-spot.component.html',
  styleUrls: ['./create-spot.component.css']
})
export class CreateSpotComponent implements OnInit {

  forms: FormGroup;
  spot: Spot;
  idTopo: string;
  private sub: any;
  constructor(private spotService: SpotService, private formBuilder: FormBuilder,
              private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo']; // (+) converts string 'id' to a number
    });
    console.log("IDTOPO: ", this.idTopo);
    this.initForm();
  }


  saveSpot() {
    console.log(this.forms.value)
    this.spotService.saveSpot(this.forms)
      .subscribe(
        response => {
          this.router.navigateByUrl("/topo/area/add-area/"+response.id)
          console.log("response: ", response);
        },
        err => {
          console.log("error: ", err.error.message);
        })

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
        idTopo:this.idTopo,
      }
    );

  }
}
