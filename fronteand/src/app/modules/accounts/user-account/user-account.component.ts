import { Component, OnInit } from '@angular/core';
import {UserAccount} from "./models/user-account.model";
import {UserAccountService} from "./user-account.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  public userAccount : UserAccount;

  constructor(
    private userAccountService : UserAccountService,
    private activateRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    const login = this.activateRoute.snapshot.params['login'];

    this.userAccountService.getUserByLogin(login).subscribe((value:UserAccount) => {
      this.userAccount = value
    })
  }

}
