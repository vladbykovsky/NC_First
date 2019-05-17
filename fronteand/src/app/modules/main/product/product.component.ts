import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "./models/product.model";
import {ProductService} from "./product.service";
import {SubscriptionModel} from "../../accounts/subscriptions/models/subscription.model";
import {BillingAccount} from "../../accounts/billing-account/models/billing-account.model";
import {SubscriptionsService} from "../../accounts/subscriptions/subscriptions.service";
import {AuthService} from "../login/service/auth.service";
import {Subscription} from "rxjs";
import {BillingAccountService} from "../../accounts/billing-account/billing-account.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public product: Product;
  public newSubscription: SubscriptionModel =  new SubscriptionModel();
  public billingAccount: BillingAccount;
  public billingId: number;

  private subscription: Subscription[] = [];
  private dataStart: Date;
  private dataEnd: Date;

  constructor(
    private productService: ProductService,
    private subscriptionService : SubscriptionsService,
    private billingAccountService: BillingAccountService,
    private activateRoute: ActivatedRoute,
    private auth: AuthService,
    private router: Router
  ) { }



  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    this.productService.getProductsById(id).subscribe((value:Product) => {
      this.product = value;
    })

  }


  // public getBillingId():void{
  //   this.billingAccountService.getBillingByUserId(this.auth.user.userId).subscribe(value => {
  //     this.newSubscription.billingId = value.billingId;
  //   });
  // }

  public buyProduct(id:number):void{
    if(this.auth.user){
      this.newSubscription.productId = id;
      this.newSubscription.product = this.product;
      this.newSubscription.status = "active";
      this.newSubscription.billingId = 1;
      this.newSubscription.userId = this.auth.user.userId;
      this.newSubscription.dataStart = this.getStartDate();
      this.newSubscription.dataEnd = this.getEndDate();
      this.subscription.push(this.subscriptionService.saveSubscription(this.newSubscription).subscribe(()=> {
        this.router.navigate(['/subscriptions']);
      }));
    }
    else{
      this.router.navigate(['/login']);
    }
  }

  public getStartDate():string{
    this.dataStart = new Date();
    return this.dataStart.toLocaleString();
  }

  public getEndDate():string{
    this.dataEnd = this.dataStart;
    this.dataEnd.setMonth(this.dataStart.getMonth()+1);
    return this.dataEnd.toLocaleString();
  }

}
