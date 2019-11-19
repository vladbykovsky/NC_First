import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubscriptionModel} from "./models/subscription.model";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsService {

  constructor( private http: HttpClient ) { }

  public getSubscriptionsByUserId(id:number):Observable<SubscriptionModel[]>{
    return this.http.get<SubscriptionModel[]>('/api/subscription/userId/'+id)
  }

  public saveSubscription(subscription: SubscriptionModel):Observable<SubscriptionModel>{
    return this.http.post<SubscriptionModel>('/api/subscription', subscription);
  }

  public deleteSub(id: number):Observable<void>{
    return this.http.delete<void>('/api/subscription/'+id);
  }

}
