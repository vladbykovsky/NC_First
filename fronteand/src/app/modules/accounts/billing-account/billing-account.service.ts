import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BillingAccount} from "./models/billing-account.model";

@Injectable({
  providedIn: 'root'
})
export class BillingAccountService {

  constructor( private http: HttpClient ) { }

  public getBillingByUserId(id:number):Observable<BillingAccount>{
    return this.http.get<BillingAccount>('/api/billing-account/userId/'+id)
  }

  public saveBillingAccount(billingAccount: BillingAccount): Observable<BillingAccount> {
    return this.http.post<BillingAccount>('/api/billing-account', billingAccount);
  }

}
