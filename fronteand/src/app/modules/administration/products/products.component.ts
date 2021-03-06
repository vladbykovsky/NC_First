import { Component, OnInit } from '@angular/core';
import {Product} from "./models/product.model";
import {ProductService} from "./product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public products :Product[];

  constructor(
    private productService: ProductService
  ) { }

  ngOnInit() {
    this.productService.getAllProducts().subscribe((value:Product[]) => {
      this.products = value
    })
  }

}
