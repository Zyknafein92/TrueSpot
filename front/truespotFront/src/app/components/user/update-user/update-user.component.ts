import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {User} from "../../../../model/user";
import {UserService} from "../../../services/user/user.service";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {Router} from "@angular/router";

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
  constructor(private userService: UserService, private formBuilder: FormBuilder, private token:TokenStorageService, private router:Router) {
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
        password: new FormControl(),
        // image: this.user.image(),
      }
    );
  }

  updateUser(){
    this.userService.updateUser(this.forms).subscribe(
      response => {
        console.log("response: ", response);
        if(this.forms.getRawValue().password != null || this.forms.getRawValue().pseudo != this.token.getPseudo()){
          this.token.signOut();
          this.router.navigateByUrl("/sign-in").then(r => location.reload());
        }
      },
      err => {
        console.log("Error: ", err);
      })
  }
}
