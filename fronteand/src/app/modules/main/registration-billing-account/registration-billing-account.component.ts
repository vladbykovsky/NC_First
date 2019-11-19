import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {BillingAccount} from "../../accounts/billing-account/models/billing-account.model";
import {HttpClient} from "@angular/common/http";
import {BillingAccountService} from "../../accounts/billing-account/billing-account.service";
import {AuthService} from "../login/service/auth.service";

@Component({
  selector: 'app-registration-billing-account',
  templateUrl: './registration-billing-account.component.html',
  styleUrls: ['./registration-billing-account.component.css']
})
export class RegistrationBillingAccountComponent implements OnInit {

  public billingAccount: BillingAccount = new BillingAccount();
  private subscriptions: Subscription[] = [];

  constructor(
    private billingAccountService: BillingAccountService,
    public http: HttpClient,
    private auth: AuthService
  ) { }

  ngOnInit() {
  }

  public addBillingAccount(): void {
    this.billingAccount.userId = this.auth.user.userId;
    if(this.billingAccount.balance.charAt(0) == "-"){
      this.billingAccount.balance = "0";
    }
    this.subscriptions.push(this.billingAccountService.saveBillingAccount(this.billingAccount).subscribe(()=>{

    }));
  }

}
