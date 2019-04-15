import { Component, OnInit } from '@angular/core';
import {User} from "./models/user.model";
import {AccountService} from "./account.service";

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  public users: User[];

  constructor(
    private accountService: AccountService
  ) { }

  ngOnInit() {
    this.accountService.getAllUsers().subscribe((value:User[]) => {
      this.users = value
    })
  }

}
