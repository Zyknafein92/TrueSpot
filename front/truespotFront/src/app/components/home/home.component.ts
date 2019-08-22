import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/auth/token-storage.service";



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      pseudo: this.token.getPseudo(),
      authorities: this.token.getAuthorities()
    };

    console.log("HOME COMPONENET: ", this.info)
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
