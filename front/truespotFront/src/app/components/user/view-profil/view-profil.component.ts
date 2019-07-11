import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profil.component.html',
  styleUrls: ['./view-profil.component.css']
})
export class ViewProfilComponent implements OnInit {

  forms: FormGroup;
  files: FileList;
  file_src: string;

  constructor( private userService:UserService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
  }
}
