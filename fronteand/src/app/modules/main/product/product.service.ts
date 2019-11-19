import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./models/product.model";
import {AuthService} from "../login/service/auth.service";
import {SubscriptionModel} from "../../accounts/subscriptions/models/subscription.model";

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  constructor( private http: HttpClient) { }

  public getProductsById(id:string):Observable<Product>{
    return this.http.get<Product>('/api/product/' + id);

  }

}
