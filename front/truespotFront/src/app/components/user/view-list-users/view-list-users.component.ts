import {Component, OnInit} from '@angular/core';
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
  userToUpdate : User;
  authorities: string;


  constructor(private token:TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getUsers().subscribe(
      response => {
        this.users = response;
        console.log("URRRRRR ", response);
      },
      err => {
        console.log("error: ", err.error.message);
      });
  }

  updateRole(user: User) {
    this.userToUpdate = user;
    console.log("User to Up :", this.userToUpdate);
    this.userService.updateUserRole(this.userToUpdate).subscribe(
      response => {
       this.getAllUsers();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }
}
