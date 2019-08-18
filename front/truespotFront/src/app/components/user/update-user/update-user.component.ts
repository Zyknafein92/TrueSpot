import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../../../../model/user";
import {UserService} from "../../../services/user/user.service";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  forms: FormGroup;
  user: User;
  files: FileList;
  file_src: string;
  messagError: string;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.forms = this.formBuilder.group(
      {
        firstName: this.user.firstName,
        lastName: this.user.lastName,
        // email: this.user.email('', Validators.compose([
        //   Validators.required,
        //   Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
        // ])),
        // age: this.user.age,
        // phoneNumber: this.user.phoneNumber('', Validators.compose([
        //   Validators.required,
        //   Validators.pattern('^[0-9]{10}$')
        // ])),
        gender: this.user.gender,
        pseudo: this.user.pseudo,
        password: this.user.password,
        // image: this.user.image(),
      }
    );
  }
}
