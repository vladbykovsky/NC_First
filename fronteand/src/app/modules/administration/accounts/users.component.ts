import { Component, OnInit } from '@angular/core';
import {AccountService} from "./account.service";
import {Subscription} from "rxjs";
import {UserAccount} from "../../accounts/user-account/models/user-account.model";
import {User} from "./models/user.model";

@Component({
  selector: 'app-accounts',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  public users: UserAccount[];
  private subscriptions: Subscription[] = [];

  constructor(
    private accountService: AccountService
  ) { }

  ngOnInit() {
    this.loadUsers();
  }

  public _deleteUser(id: string): void {
    this.subscriptions.push(this.accountService.deleteUser(id).subscribe(()=>{
      this._updateUsers();
    }));
  }

  private loadUsers(): void {
    this.subscriptions.push(this.accountService.getAllUsers().subscribe((value) => {
      this.users = value;
    }));
  }

  public _updateUsers(): void {
    this.loadUsers();
  }

}
