import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Area} from "../../../../model/area";
import {AreaService} from "../../../services/area/area.service";
import {ActivatedRoute, Router} from "@angular/router";




@Component({
  selector: 'app-create-area',
  templateUrl: './create-area.component.html',
  styleUrls: ['./create-area.component.css']
})
export class CreateAreaComponent implements OnInit {

  forms: FormGroup;
  area: Area;
  idSpot: string;
  private sub: any;
  constructor(private areaService:AreaService, private formBuilder: FormBuilder,
              private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idSpot = params['idSpot']; // (+) converts string 'id' to a number
    });
    this.initForm();
  }

  saveArea() {
    console.log(this.forms.value)
    this.areaService.saveArea(this.forms)
      .subscribe(
        response => {
          this.router.navigateByUrl("/topo/road/add-road/"+response.id)
          console.log("response: ", response);
        },
        err => {
          console.log("error: ", err.error.message);
        })
  }

  initForm(){
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        orientation  : new FormControl(),
        roadNumber: new FormControl(),
        height: new FormControl(),
        idSpot: this.idSpot
      }
    );
  }

}
