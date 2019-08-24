import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../../../services/user/user.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {UserMessage} from "../../../../model/userMessage";
import {User} from "../../../../model/user";
import {Topo} from "../../../../model/topo";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {UsermessageService} from "../../../services/user.message/usermessage.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-user-message',
  templateUrl: './user-message.component.html',
  styleUrls: ['./user-message.component.css']
})
export class UserMessageComponent implements OnInit {

  forms: FormGroup;
  user:User;
  currentUSer: any;
  userMessage: UserMessage;
  idTopoHelpToRedirect: any;
  @Input() topo: any;
  constructor(private userServiceMessage: UsermessageService,private userService:UserService,
              private formBuilder: FormBuilder, private token:TokenStorageService,  private router:Router) { }


  ngOnInit() {
    this.getCurrentUser();
    this.initForm();

    console.log("TOPO FROM MESSAGE SAVE : ", this.topo);
  }

  private initForm() {
    this.forms = this.formBuilder.group(
      {
        user: this.userService,
        message:  new FormControl(),
        date:  new FormControl(),
        topo:  this.topo,
      }
    );
  }

  private getCurrentUser(){
    this.userService.getProfil(this.token.getPseudo()) .subscribe(
      response => {
        this.currentUSer = response
        console.log("currentUSer form message: ", this.currentUSer);
      },
      err => {
        console.log("Error: ", err);
      })

  }
  saveMessage(){
    this.forms.patchValue({
      user: this.currentUSer,
    });
    console.log("SAVE MESAGE:", this.forms.value);
    this.userServiceMessage.saveUserMessage(this.forms)
      .subscribe(
        response => {
          // @ts-ignore
          this.router.navigateByUrl("/topo/view-topo/" + response.topo.id);
          console.log("response: ", response);
        },
        err => {
          console.log("Error: ", err);
        })
  }

}
