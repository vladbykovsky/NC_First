import { Component, OnInit } from '@angular/core';
import {User} from "./models/user.model";
import {AccountService} from "./account.service";

@Component({
  selector: 'app-accounts',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

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
