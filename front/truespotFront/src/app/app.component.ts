import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./services/auth/token-storage.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  authorities: string;
  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.authorities = this.token.getAuthorities();

  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

}
