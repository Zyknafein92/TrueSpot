import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Route, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {Topo} from "../../../../model/topo";
import {RoadService} from "../../../services/road/roadservice";
import {Area} from "../../../../model/area";
import {ClimbingRoad} from "../../../../model/climbingRoad";
import {AreaService} from "../../../services/area/area.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";



@Component({
  selector: 'app-view-topo',
  templateUrl: './view-topo.component.html',
  styleUrls: ['./view-topo.component.css']
})
export class ViewTopoComponent implements OnInit {

  private sub: any;
  idTopo: any;
  idTopoHelToRedirect: any;
  idArea: any;
  idAreaToAdd: any;
  idRoad: any;
  topo : Topo;
  areas: any;
  roads : any;
  road: ClimbingRoad;

  forms: FormGroup;

  constructor( private topoService: TopoService,
              private areaService: AreaService,private roadService: RoadService,
              private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo']; // (+) converts string 'id' to a number
    });

    this.getTopo();
    this.getArea();
    this.initform();

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
  getTopo(){
    this.topoService.getTopo(this.idTopo)
      .subscribe(
        response => {
          this.topo = response;
          console.log("TOPO: ", response);
        },
        err => {
          console.log("error: ", err);
        })

  }

  getArea(){
    this.areaService.getAreas(this.idTopo)
      .subscribe(
        response => {
          this.areas = response;
          console.log("AREAS: ", this.areas);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  getCureentIdArea(id) {
    this.idArea = id;
    this.getRoad(id);
  }
  getRoad(id) {
    this.roadService.getRoads(id)
      .subscribe(
        response => {
          this.roads = response;
          console.log("ROADs: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  addRoad(area){
    console.log("ID AREA:", area)
    this.idAreaToAdd = area.id;
    this.idTopoHelToRedirect  = area.topo.id
  }

  saveRoad() {
    console.log("ID AREA TO SAVE:", this.idAreaToAdd)
    console.log(this.forms.value);
    this.forms.patchValue({
      idArea: this.idAreaToAdd,
    });
    console.log(this.forms.value);
    this.roadService.saveRoad(this.forms)
      .subscribe(
        response => {
          // @ts-ignore
          $('#exampleModalCenter').modal('hide')
          this.router.navigateByUrl("/topo/view-topo/"+ this.idTopoHelToRedirect);
          console.log("reponse: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }
}
