import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {Topo} from "../../../../model/topo";
import {Department} from "../../../../model/department";
import {TopoService} from "../../../services/topo/topo.service";

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-myprofil.component.html',
  styleUrls: ['./view-myprofil.component.css']
})
export class ViewMyprofilComponent implements OnInit {

  forms: FormGroup;
  user: User;
  topos: any;
  department: Department;
  files: FileList;
  file_src: string;

  constructor( private userService:UserService, private formBuilder: FormBuilder, private token: TokenStorageService, private toposervice:TopoService) { }

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
