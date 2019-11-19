import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../product/models/product.model";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor( private http: HttpClient ) { }

  public getAllProducts(page: number, size: number, sort: string, order: string){
    return this.http.get("/api?page=" + page + "&size=" + size + "&sort=" + sort + "&order=" + order);
  }

  // public getAllProducts(page: number, sort: string, order: string){
  //   return this.http.get("/api?page=" + page + "&sort=" + sort + "&order=" + order);
  // }

  public getProductByName(name: string){
    return this.http.get("/api/search/"+name);
  }

}
