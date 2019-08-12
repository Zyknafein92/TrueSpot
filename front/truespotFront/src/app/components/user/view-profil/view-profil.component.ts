import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TokenStorageService} from "../../../services/auth/token-storage.service";

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profil.component.html',
  styleUrls: ['./view-profil.component.css']
})
export class ViewProfilComponent implements OnInit {

  forms: FormGroup;
  user: User;
  files: FileList;
  file_src: string;

  constructor( private userService:UserService, private formBuilder: FormBuilder, private token: TokenStorageService) { }

  ngOnInit() {
    this.initProfil(this.token);
  }

  initProfil(token : TokenStorageService){
    this.userService.getProfil(this.token.getPseudo()).subscribe(
      res => {
        console.log(res);
        this.user = res;
      }
    );
  }

}
