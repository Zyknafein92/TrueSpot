import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {TokenStorageService} from "../../../services/auth/token-storage.service";

@Component({
  selector: 'app-view-mylist-topo',
  templateUrl: './view-mylist-topo.component.html',
  styleUrls: ['./view-mylist-topo.component.css']
})
export class ViewMylistTopoComponent implements OnInit {
  topos : any;


  constructor(private route: ActivatedRoute, private topoService: TopoService, private router: Router, private token:TokenStorageService) { }

  ngOnInit() {
    this.getAllMyTopos(this.token);
  }

  getAllMyTopos(token : TokenStorageService){
      this.topoService.getTopoByUser(this.token.getPseudo()).subscribe(
        res => {
          this.topos = res;
        }
      )
    }

  sendIdTopo(id){
    this.router.navigateByUrl("/topo/view-topo/"+id)
  }
}
