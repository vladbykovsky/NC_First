import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders } from '@angular/common/http';
import {UserAccount} from "../../../accounts/user-account/models/user-account.model";
import {Router} from "@angular/router";

@Injectable()
export class AuthService {

  public user: UserAccount;
  public token: string;

  constructor(private http: HttpClient, private router: Router) {
    if (JSON.parse(localStorage.getItem('user'))&&(localStorage.getItem('token'))){
      this.user = JSON.parse(localStorage.getItem('user'));
      this.token = localStorage.getItem('token');
    }
    else {
      this.user = null;
      this.token = "";
    }
  }

  public getUser(user: String):Observable<UserAccount>{
    return this.http.get<UserAccount>("/api/user-account/login/"+user);
  }

  public getToken(user: UserAccount):Observable<any>{
    return this.http.post("/api/token/generate-token", user);
  }

  public signIn(user: UserAccount):void{
    this.getToken(user).subscribe(data=>{
      this.token = data.token;
      this.getUser(user.login).subscribe(data=>{
        this.user = data;
        localStorage.setItem("user", JSON.stringify(this.user));
        localStorage.setItem("token", this.token);
        if(this.user.rolesByRoleId.roleId == "1"){
          this.router.navigate(['/user-account']);
        }else{
          this.router.navigate(['/admin/users']);
        }
      })
    })
  }

  public logOut():void{
    localStorage.clear();
    this.user = null;
    this.token = "";
  }



}
