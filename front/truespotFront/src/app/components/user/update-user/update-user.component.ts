import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../../../../model/user";
import {UserService} from "../../../services/user/user.service";
import {TokenStorageService} from "../../../services/auth/token-storage.service";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  forms: FormGroup;
  // files: FileList;
  // file_src: string;
  messagError: string;

  @Input() user: User;
  constructor(private userService: UserService, private formBuilder: FormBuilder, private token:TokenStorageService) {
  }

  ngOnInit() {
    this.initForm();
  }



  private initForm() {
    console.log("User to Update: ", this.user);
    this.forms = this.formBuilder.group(
      {
        id: this.user.id,
        firstName: this.user.firstName,
        lastName: this.user.lastName,
        email: this.user.email,
        birthDate: this.user.birthDate,
        phoneNumber: this.user.phoneNumber,
        gender: this.user.gender,
        pseudo: this.user.pseudo,
        password: this.user.password,
        // image: this.user.image(),
      }
    );
  }

  updateUser(){
    this.userService.updateUser(this.forms).subscribe(
      response => {
        // @ts-ignore
        this.router.navigateByUrl("/myprofil");
        console.log("response: ", response);
      },
      err => {
        console.log("Error: ", err);
      })
  }
}
