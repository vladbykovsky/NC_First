import { Component, OnInit } from '@angular/core';
import {UserAccount} from "./models/user-account.model";
import {UserAccountService} from "./user-account.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {TokenStorage} from "../../main/login/token.storage";
import {AuthService} from "../../main/login/service/auth.service";
import {BillingAccountService} from "../billing-account/billing-account.service";

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  public userAccount : UserAccount;

  constructor(
    private userAccountService : UserAccountService,
    private baService: BillingAccountService,
    private activateRoute: ActivatedRoute,
    private router: Router,
    private token: TokenStorage,
    private auth: AuthService
  ) {}

  ngOnInit() {
    this.userAccountService.getUserByLogin(this.auth.user.login).subscribe((value:UserAccount) => {
      this.userAccount = value
    })
  }

  signOut(): void{
    this.auth.logOut();
    this.token.signOut();
  }

  loadBA(): void{
    this.baService.getBillingByUserId(this.auth.user.userId).subscribe(()=>{
      this.router.navigate(['/billing-account'])
    });
  }

}
