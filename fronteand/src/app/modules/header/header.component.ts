import { Component, OnInit } from '@angular/core';
import {AuthService} from "../main/login/service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  adminFlag: boolean = false;
  loginFlag: boolean = false;

  constructor(public auth: AuthService){

  }

  clickAdmin(){
    this.adminFlag=!this.adminFlag;
  }

  clickLogin(){
    this.loginFlag=!this.loginFlag;
  }

  ngOnInit() {
  }

}
