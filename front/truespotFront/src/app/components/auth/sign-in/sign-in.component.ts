import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {AuthenticationService} from "../../../services/authentication/authentication.service";
import {first} from "rxjs/operators";
import {ActivatedRoute, Router} from "@angular/router";



@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  forms: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router, private authenticationService: AuthenticationService) {}

  ngOnInit() {
    this.forms = this.formBuilder.group({
      pseudo: new FormControl(),
      password:new FormControl()
    });

    // reset login status
  //  this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  //get f() { return this.forms.controls; }

  onSubmit() {
    console.log("coucou");
    // this.submitted = true;
    //
    // // stop here if form is invalid
    // if (this.forms.invalid) {
    //   return;
    // }
    //
    // this.loading = true;
    // this.authenticationService.login(this.forms.value)
    //   .pipe(first())
    //   .subscribe(
    //     data => {
    //       this.router.navigate([this.returnUrl]);
    //     },
    //     error => {
    //       this.error = error;
    //       this.loading = false;
    //     });
  }
}
