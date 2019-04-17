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
import { UsersComponent } from './modules/administration/accounts/users.component';
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
  {path: 'admin/products',component:ProductsComponent},
  {path: 'admin/users',component:UsersComponent},
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
    UsersComponent,
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
