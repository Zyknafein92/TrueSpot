import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {Topo} from "../../../../model/topo";



@Component({
  selector: 'app-view-topo',
  templateUrl: './view-topo.component.html',
  styleUrls: ['./view-topo.component.css']
})
export class ViewTopoComponent implements OnInit {

  private sub: any;
  idTopo: string;
  topo : Topo;


  constructor(private route: ActivatedRoute, private topoService: TopoService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo']; // (+) converts string 'id' to a number
    });

    console.log("IDTOPO: ",this.idTopo);
    this.getTopo();
  }

  getTopo(){
    this.topoService.getTopo(this.idTopo)
      .subscribe(
        response => {
          this.topo = response;
          console.log("response: ", response);
        },
        err => {
          console.log("error: ", err);
        })

  }


}
