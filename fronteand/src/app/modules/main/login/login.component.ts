import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "./service/auth.service";
import {TokenStorage} from "./token.storage";
import {UserAccount} from "../../accounts/user-account/models/user-account.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  // login: string;
  // password: string;
  user: UserAccount = new UserAccount();

  ngOnInit(): void {
  }

  loginUser(): void {
    // localStorage.setItem("user", JSON.stringify(this.user));
    this.authService.signIn(this.user);

    // this.authService.attemptAuth(this.login, this.password).subscribe(
    //   data => {
    //     this.token.saveToken(data.token);
    //     this.router.navigate(['/user-account/login/',this.login]);
    //   }
    // );
  }
}
