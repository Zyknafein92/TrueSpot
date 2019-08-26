import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../../model/user";
import {UserService} from "../../../services/user/user.service";
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-view-userprofil',
  templateUrl: './view-userprofil.component.html',
  styleUrls: ['./view-userprofil.component.css']
})
export class ViewUserprofilComponent implements OnInit {

  user: User;
  formUser: FormGroup;

  @Input() usertoShow: User;
  constructor( private userService:UserService, private router:Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    console.log("usertoShow sss", this.usertoShow)
    this.initProfil(this.usertoShow);
    this.initFormUser()

  }

  private initFormUser() {
    this.formUser= this.formBuilder.group({
      pseudo: this.usertoShow.pseudo,
      phoneNumber : this.usertoShow.phoneNumber,
      email: this.usertoShow.email,
    });
  }

  initProfil(usertoShow: any){
    this.userService.getUser(usertoShow.id).subscribe(
      res => {
        this.user = res;
      }
    );
  }
}
