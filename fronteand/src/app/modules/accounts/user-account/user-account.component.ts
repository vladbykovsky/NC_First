import { Component, OnInit } from '@angular/core';
import {UserAccount} from "./models/user-account.model";
import {UserAccountService} from "./user-account.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {TokenStorage} from "../../main/login/token.storage";
import {AuthService} from "../../main/login/service/auth.service";
import {BillingAccountService} from "../billing-account/billing-account.service";
import {BillingAccount} from "../billing-account/models/billing-account.model";

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  public userAccount : UserAccount;

  constructor(
    private userAccountService : UserAccountService,
    //private baService: BillingAccountService,
    private activateRoute: ActivatedRoute,
    private router: Router,
    private token: TokenStorage,
    private auth: AuthService
    //private ba: BillingAccount
  ) {}

  ngOnInit() {
    this.userAccountService.getUserByLogin(this.auth.user.login).subscribe((value:UserAccount) => {
      this.userAccount = value;
    });
    //this.baService.getBillingByUserId(this.auth.user.userId).subscribe((value:BillingAccount) => {
      //this.ba = value;
    //});
  }

  signOut(): void{
    this.auth.logOut();
    this.token.signOut();
  }

  //getBA(): void{
    //this.baService.getBillingByUserId(this.auth.user.userId).subscribe((value)=>{
      //this.ba = value;
    //});
  //}

}
