import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "./models/product.model";
import {ProductService} from "./product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public product :Product;

  constructor(
    private productService: ProductService,
    private activateRoute: ActivatedRoute
  ) { }



  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];

    this.productService.getProductsById(id).subscribe((value:Product) => {
      this.product = value
    })
  }

}
