import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {Department} from "../../../../model/department";
import {TopoService} from "../../../services/topo/topo.service";

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-myprofil.component.html',
  styleUrls: ['./view-myprofil.component.css']
})
export class ViewMyprofilComponent implements OnInit {

  user: User;
  topos: any;
  department: Department;


  constructor( private userService:UserService,private token: TokenStorageService, private toposervice:TopoService) { }

  ngOnInit() {
    this.initProfil(this.token);
    this.initTopos(this.token);
  }

  initProfil(token : TokenStorageService){
    this.userService.getProfil(this.token.getPseudo()).subscribe(
      res => {
        this.user = res;
      }
    );
  }
  initTopos(token : TokenStorageService){
    this.toposervice.getTopoByUser(this.token.getPseudo()).subscribe(
      res => {
        this.topos = res;
      }
    )
  }

}
