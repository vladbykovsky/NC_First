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
  public editMode: boolean = false;

  constructor(
    private accountService: AccountService
  ) { }

  ngOnInit() {
    this.loadUsers();
  }

  public deleteUser(id: number): void {
    this.subscriptions.push(this.accountService.deleteUser(id).subscribe(()=>{
      this.updateUsers();
    }));
  }

  private loadUsers(): void {
    this.subscriptions.push(this.accountService.getAllUsers().subscribe((value) => {
      this.users = value;
    }));
  }

  public updateUsers(): void {
    this.loadUsers();
  }

  public editUsers(): void{
    this.editMode = true;
  }

}
