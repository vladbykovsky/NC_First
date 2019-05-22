import { Component, OnInit } from '@angular/core';
import {UserAccount} from "../../accounts/user-account/models/user-account.model";
import {Role} from "../../accounts/user-account/models/role.model";
import {UserAccountService} from "../../accounts/user-account/user-account.service";
import {Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../login/service/auth.service";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public userAccount: UserAccount = new UserAccount();
  private subscriptions: Subscription[] = [];

  constructor(
    private userAccountService: UserAccountService,
    public http: HttpClient,
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    this.userAccount.rolesByRoleId.roleId = '1';
  }

  public addUserAccount(): void {
    this.subscriptions.push(this.userAccountService.saveUserAccount(this.userAccount).subscribe(()=>{
      // this.userAccount = new UserAccount();
      this.router.navigate(['/login'])
    }));
  }
}
