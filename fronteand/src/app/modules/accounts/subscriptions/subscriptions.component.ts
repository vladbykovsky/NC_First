import { Component, OnInit } from '@angular/core';
import {SubscriptionModel} from "./models/subscription.model";
import {SubscriptionsService} from "./subscriptions.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../main/product/models/product.model";
import {AuthService} from "../../main/login/service/auth.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {

  public subscription : SubscriptionModel[];
  public product: Product;
  private subscriptions: Subscription[] = [];


  constructor(
    private subscriptionService : SubscriptionsService,
    private activateRoute: ActivatedRoute,
    private auth: AuthService
  ) { }

  ngOnInit() {
    this.loadSub();
  }

  public loadSub():void{
    this.subscriptionService.getSubscriptionsByUserId(this.auth.user.userId).subscribe((value:SubscriptionModel[]) => {
      this.subscription = value;
    })
  }

  public updateSub():void{
    this.loadSub();
  }

  public deleteSub(id: number):void{
    this.subscriptions.push(this.subscriptionService.deleteSub(id).subscribe(()=>{
      this.updateSub();
    }))
  }

}
