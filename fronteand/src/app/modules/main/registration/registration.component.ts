import { Component, OnInit } from '@angular/core';
import {UserAccount} from "../../accounts/user-account/models/user-account.model";
import {UserAccountService} from "../../accounts/user-account/user-account.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public userAccount: UserAccount = new UserAccount();
  private subscriptions: Subscription[] = [];

  constructor(
    private userAccountService: UserAccountService
  ) { }

  ngOnInit() {
  }

  public _addUserAccount(): void {
    this.subscriptions.push(this.userAccountService.saveUserAccount(this.userAccount).subscribe(()=>{
      console.log("asda");
    }));
  }

}
