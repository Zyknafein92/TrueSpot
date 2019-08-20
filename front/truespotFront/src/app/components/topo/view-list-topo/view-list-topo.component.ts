import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";

@Component({
  selector: 'app-view-list-topo',
  templateUrl: './view-list-topo.component.html',
  styleUrls: ['./view-list-topo.component.css']
})
export class ViewListTopoComponent implements OnInit {

  topos : any;

  constructor(private route: ActivatedRoute, private topoService: TopoService, private router: Router) { }

  ngOnInit() {
    this.getAllTopos();
  }

  getAllTopos() {
    this.topoService.getAllTopo()
      .subscribe(
        response => {
          this.topos = response;
          console.log("reponse Topos: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  sendIdTopo(id){
    this.router.navigateByUrl("/topo/view-topo/"+id)
    }
}
