import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from "./billing-account.service";
import {ActivatedRoute} from "@angular/router";
import {BillingAccount} from "./models/billing-account.model";
import {AuthService} from "../../main/login/service/auth.service";

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  public billingAccount: BillingAccount;

  constructor(
    private billingAccountService: BillingAccountService,
    private activateRoute: ActivatedRoute,
    private auth: AuthService
  ) { }

  ngOnInit() {

    this.billingAccountService.getBillingByUserId(this.auth.user.userId).subscribe((value:BillingAccount) => {
      this.billingAccount = value;
    })
  }

}
