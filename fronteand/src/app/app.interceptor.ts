import { Injectable } from '@angular/core';
import {
  HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent,
  HttpResponse, HttpUserEvent, HttpErrorResponse, HttpEvent
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from "./modules/main/login/service/auth.service";

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private authService:AuthService){

  }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.token!='') {
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + this.authService.token
        }
      });
    }
    return next.handle(request);
  }

}
