import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from "./billing-account.service";
import {ActivatedRoute} from "@angular/router";
import {BillingAccount} from "./models/billing-account.model";
import {UserAccount} from "../user-account/models/user-account.model";

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  public billingAccount: BillingAccount;

  constructor(
    private billingAccountService: BillingAccountService,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];

    this.billingAccountService.getBillingByUserId(id).subscribe((value:BillingAccount) => {
      this.billingAccount = value
    })
  }

}
