import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserAccount} from "./models/user-account.model"
import {TokenStorage} from "../../main/login/token.storage";

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {

  constructor( private http: HttpClient) { }

  public getUserByLogin(login:string):Observable<UserAccount>{
    return this.http.get<UserAccount>('/api/user-account/login/'+login)
  }

  public saveUserAccount(user: UserAccount): Observable<UserAccount> {
    return this.http.post<UserAccount>('/api/user-account', user);
  }


}
