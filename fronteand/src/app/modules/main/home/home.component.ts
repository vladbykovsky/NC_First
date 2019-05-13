import {Component, OnInit, Output} from '@angular/core';
import {HomeService} from "./home.service";
import {Product} from "../product/models/product.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products: Product[];
  public product: Product;
  public page: number = 0;
  public size: number = 4;
  public sort: string = "productId";
  public order: string = "high";
  public totalPages: Array<number>;
  public searchName: string;

  constructor(
    private homeService: HomeService
  ) { }

  ngOnInit() {
    this.loadProducts();
  }

  public loadProducts():void{
    this.homeService.getAllProducts(this.page, this.size, this.sort, this.order).subscribe(data => {
      this.products = data['content'];
      this.totalPages = new Array<number>(data['totalPages']);
    })
  }

  public goPage(page: number):void{
    this.page = page;
    this.loadProducts();
  }

  public goNext(page: number):void{
    if(page == this.totalPages.length-1){
      this.page = page;
    }else if(page < this.totalPages.length-1){
      this.page = page + 1;
    }
    this.loadProducts();
  }

  public goPrev(page: number):void{
    if(page == 0){
      this.page = page;
    }else if(page > 0){
      this.page = page - 1;
    }
    this.loadProducts();
  }
  
  public setSize(size: number):void{
    this.size = size;
    this.loadProducts();
  }

  public setSort(sort: string):void{
    this.sort = sort;
    this.loadProducts();
  }

  public setOrder(order: string):void{
    this.order = order;
    this.loadProducts();
  }

  public searchProduct():void{
    this.homeService.getProductByName(this.searchName).subscribe((value:Product)=>{
      this.products = [];
      this.products[0] = value;
    })
  }

  public rebootProduct():void{
    this.page = 0;
    this.size = 4;
    this.sort = "productId";
    this.order = "high";
    this.loadProducts()
  }
}
