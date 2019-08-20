import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {Topo} from "../../../../model/topo";
import {RoadService} from "../../../services/road/roadservice";
import {Area} from "../../../../model/area";
import {ClimbingRoad} from "../../../../model/climbingRoad";



@Component({
  selector: 'app-view-topo',
  templateUrl: './view-topo.component.html',
  styleUrls: ['./view-topo.component.css']
})
export class ViewTopoComponent implements OnInit {

  private sub: any;
  idRoad: string;
  topo : Topo;
  areas: any;
  road: ClimbingRoad;


  constructor(private route: ActivatedRoute, private topoService: TopoService, private roadService: RoadService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idRoad = params['idRoad']; // (+) converts string 'id' to a number
    });
    this.getRoad();

  }

  // getTopo(){
  //   this.topoService.getTopo(this.idTopo)
  //     .subscribe(
  //       response => {
  //         this.topo = response;
  //         console.log("response: ", response);
  //       },
  //       err => {
  //         console.log("error: ", err);
  //       })
  //
  // }

  getRoad() {
    console.log(" getRoad :idRoad", this.idRoad);
    this.roadService.getRoad(this.idRoad)
      .subscribe(
        response => {
          this.road = response;
          this.areas = this.road.area;
          console.log("reponse ROAD: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

}
