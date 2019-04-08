import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  adminFlag: boolean = false;
  loginFlag: boolean = false;

  clickAdmin(){
    this.adminFlag=!this.adminFlag;
  }

  clickLogin(){
    this.loginFlag=!this.loginFlag;
  }

  constructor() { }

  ngOnInit() {
  }

}
