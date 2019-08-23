import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/auth/token-storage.service";



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchSelect : any;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.searchOptionInit()
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

  searchOptionInit() {
    this.searchSelect = [
      { value: '1', label: 'Département' },
      { value: '2', label: '' },
      { value: '3', label: 'Option 3' },
    ];
  }

}
