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
  public page: number = 0;
  public size: number = 2;
  public totalPages: Array<number>;

  constructor(
    private homeService: HomeService
  ) { }

  ngOnInit() {
    this.loadAllProducts();
  }

  public loadAllProducts():void{
    this.homeService.getAllProducts(this.page, this.size).subscribe(data => {
      this.products = data['content'];
      this.totalPages = new Array<number>(data['totalPages']);
    })
  }

  public setPage(page: number):void{
    this.page = page;
    this.loadAllProducts();
  }

  public setSize(size: number):void{
    this.size = size;
    this.loadAllProducts();
  }
}
