import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {Department} from "../../../../model/department";
import {Router} from "@angular/router";


@Component({
  selector: 'app-view-profile',
  templateUrl: './view-myprofil.component.html',
  styleUrls: ['./view-myprofil.component.css']
})
export class ViewMyprofilComponent implements OnInit {

  user: User;
  department: Department;


  constructor( private userService:UserService,private token: TokenStorageService, private router:Router) { }

  ngOnInit() {
    this.initProfil(this.token);
  }

  initProfil(token : TokenStorageService){
    this.userService.getProfil(this.token.getPseudo()).subscribe(
      res => {
        this.user = res;
      }
    );
  }

  refreshUser() {
      this.initProfil(this.token);
  }

  deleteUser(user: User) {
    this.userService.deleteUser(this.user.id).subscribe(
      response => {
        this.token.signOut();
        this.router.navigateByUrl("/");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }
}
