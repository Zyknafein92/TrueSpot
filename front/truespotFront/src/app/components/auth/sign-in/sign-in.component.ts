import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/auth/auth.service";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {AuthLoginInfo} from "../../../services/auth/login-info";
import {Router} from "@angular/router";




@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  //roles: string[] = [];
  roles: string = "[]";
  private loginInfo: AuthLoginInfo;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router:Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.form.pseudo,
      this.form.password);


    this.authService.attemptAuth(this.loginInfo).subscribe(
      response => {
        this.tokenStorage.saveToken(response.accessToken);
        this.tokenStorage.savePseudo(response.pseudo);
        this.tokenStorage.saveAuthorities(response.authorities);
        console.log(response.pseudo);
        console.log(response.accessToken + " " + response.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        this.router.navigateByUrl("/");
      },
      error => {
        console.log("errorerror:",error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  navigateToRegister() {
    this.router.navigateByUrl("/createUser");
  }
}
