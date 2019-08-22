import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";

@Component({
  selector: 'app-view-list-users',
  templateUrl: './view-list-users.component.html',
  styleUrls: ['./view-list-users.component.css']
})
export class ViewListUsersComponent implements OnInit {

  users: any;
  user: User;

  constructor(private token:TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getUsers().subscribe(
      response => {
        this.users = response;
        console.log(response);
      },
      err => {
        console.log("error: ", err.error.message);
      });
  }

}
