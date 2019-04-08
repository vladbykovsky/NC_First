import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './modules/main/home/home.component';
import { LoginComponent } from './modules/main/login/login.component';
import { ProductComponent } from './modules/main/product/product.component';
import { RegistrationComponent } from './modules/main/registration/registration.component';
import { UserComponent } from './modules/administration/user/user.component';
import { ProductsComponent } from './modules/administration/products/products.component';
import { AccountsComponent } from './modules/administration/accounts/accounts.component';
import { BillingAccountComponent } from './modules/accounts/billing-account/billing-account.component';
import { UserAccountComponent } from './modules/accounts/user-account/user-account.component';
import { HeaderComponent } from './modules/header/header.component';

const appRoutes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'header', component:HeaderComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'product', component:ProductComponent},
  {path: 'user-account',component:UserAccountComponent},
  {path: 'billing-account',component:BillingAccountComponent},
  {path: 'products',component:ProductsComponent},
  {path: 'accounts',component:AccountsComponent},
  {path: 'user',component:UserComponent}
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
    AccountsComponent,
    BillingAccountComponent,
    UserAccountComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { } 
