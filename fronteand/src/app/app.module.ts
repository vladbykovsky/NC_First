import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './modules/main/home/home.component';
import { LoginComponent } from './modules/main/login/login.component';
import { ProductComponent } from './modules/main/product/product.component';
import { RegistrationComponent } from './modules/main/registration/registration.component';
import { UserComponent } from './modules/administration/user/user.component';
import { ProductsComponent } from './modules/administration/products/products.component';
import { UsersComponent } from './modules/administration/accounts/users.component';
import { BillingAccountComponent } from './modules/accounts/billing-account/billing-account.component';
import { UserAccountComponent } from './modules/accounts/user-account/user-account.component';
import { HeaderComponent } from './modules/header/header.component';
import { SubscriptionsComponent } from './modules/accounts/subscriptions/subscriptions.component';
import {FormsModule} from "@angular/forms";
import { RegistrationBillingAccountComponent } from './modules/main/registration-billing-account/registration-billing-account.component';
import {AuthService} from "./modules/main/login/service/auth.service";
import {TokenStorage} from "./modules/main/login/token.storage";
import {Interceptor} from "./app.interceptor";
import { FooterComponent } from './modules/footer/footer.component';

const appRoutes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'header', component:HeaderComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'product/:id', component:ProductComponent},
  {path: 'subscriptions', component:SubscriptionsComponent},
  {path: 'user-account',component:UserAccountComponent},
  {path: 'billing-account',component:BillingAccountComponent},
  {path: 'admin/products',component:ProductsComponent},
  {path: 'admin/users',component:UsersComponent},
  {path: 'user',component:UserComponent},
  {path: 'registrationBA', component:RegistrationBillingAccountComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ProductComponent,
    RegistrationComponent,
    UserComponent,
    ProductsComponent,
    UsersComponent,
    BillingAccountComponent,
    UserAccountComponent,
    HeaderComponent,
    SubscriptionsComponent,
    RegistrationBillingAccountComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthService, TokenStorage,
    {provide: HTTP_INTERCEPTORS,
     useClass: Interceptor,
     multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { } 
