import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from "./billing-account.service";
import {ActivatedRoute} from "@angular/router";
import {BillingAccount} from "./models/billing-account.model";
import {AuthService} from "../../main/login/service/auth.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  public billingAccount: BillingAccount;
  public editMode: boolean = false;
  public balance: string;
  public oldBalance: string;
  private subscriptions: Subscription[] = [];

  constructor(
    private billingAccountService: BillingAccountService,
    private activateRoute: ActivatedRoute,
    private auth: AuthService
  ) { }

  ngOnInit() {

    this.billingAccountService.getBillingByUserId(this.auth.user.userId).subscribe((value:BillingAccount) => {
      this.billingAccount = value;
      this.oldBalance = this.billingAccount.balance;
    })
  }

  public setEdit():void{
    this.editMode = true;
  }

  public setBalance():void{
    if(parseInt(this.balance) >= 0){
    this.billingAccount.balance = (parseInt(this.oldBalance)+parseInt(this.balance)).toString();
    this.subscriptions.push(this.billingAccountService.saveBillingAccount(this.billingAccount).subscribe(()=>{
      this.oldBalance = this.billingAccount.balance;
      this.balance = "";
      this.editMode = false;
    }));
    }else if(parseInt(this.balance) < 0){
      this.balance = "0";
      this.billingAccount.balance = (parseInt(this.oldBalance)+parseInt(this.balance)).toString();
      this.subscriptions.push(this.billingAccountService.saveBillingAccount(this.billingAccount).subscribe(()=>{
        this.oldBalance = this.billingAccount.balance;
        this.balance = "";
        this.editMode = false;
    }));
    }
  }
}
