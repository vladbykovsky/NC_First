import {Component, OnInit, Output} from '@angular/core';
import {HomeService} from "./home.service";
import {Product} from "../product/models/product.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products :Product[];

  constructor(
    private homeService: HomeService
  ) { }

  ngOnInit() {
    this.homeService.getAllProducts().subscribe((value:Product[]) => {
      this.products = value
    })
  }
}
