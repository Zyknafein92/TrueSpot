import {Component, OnInit} from '@angular/core';

import {Router} from "@angular/router";
import {TokenStorageService} from "../../../services/auth/token-storage.service";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router, private token: TokenStorageService) { }

  ngOnInit() {
  }
  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
