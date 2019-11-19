import {Product} from "../../../main/product/models/product.model";
import {Observable} from "rxjs";

export class SubscriptionModel{

  subscribeId: number;
  status: string;
  dataStart: string;
  dataEnd: string;
  userId : number;
  productId: number;
  billingId : number;
  product : Product;

}
