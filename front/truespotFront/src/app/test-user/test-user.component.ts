import { Component, OnInit } from '@angular/core';
import {TestService} from "../services/test/test.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-test-user',
  templateUrl: './test-user.component.html',
  styleUrls: ['./test-user.component.css']
})
export class TestUserComponent implements OnInit {
  forms: FormGroup;
  data: any;
  constructor(private monService:TestService) { }

  ngOnInit() {
  }

  save() {
    this.monService.registerPerson(this.forms)
      .subscribe(
        response => this.data),
      err => "not found";
  }


}
