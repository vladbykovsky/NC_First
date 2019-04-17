import { Component, OnInit } from '@angular/core';
import {HomeProduct} from "./models/product.model";
import {HomeService} from "./home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products :HomeProduct[];

  constructor(
    private homeService: HomeService
  ) { }

  ngOnInit() {
    this.homeService.getAllProducts().subscribe((value:HomeProduct[]) => {
      this.products = value
    })
  }
}
