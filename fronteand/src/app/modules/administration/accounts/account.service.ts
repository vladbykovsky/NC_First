import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "./models/user.model";
import {UserAccount} from "../../accounts/user-account/models/user-account.model";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor( private http: HttpClient ) { }

  public getAllUsers():Observable<UserAccount[]>{
    return this.http.get<UserAccount[]>('/api/admin/users')
  }

  public deleteUser(id:number):Observable<void>{
    return this.http.delete<void>('/api/admin/users/'+id);
  }

}
