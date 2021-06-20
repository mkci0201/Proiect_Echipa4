import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product, ProductColor} from "./product.model";
import {map} from "rxjs/operators";

@Injectable()
export class ProductService{
  private productsUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) {

  }

  addProduct(name: string, description: string, color: ProductColor,
             price: number, stock: number): Observable<Product>
  {
    let product = {name, description, color, price, stock};
    return this.httpClient.post<Product>(this.productsUrl, product)
  }

  updateProduct(product): Observable<Product> {
    const url = `${this.productsUrl}/${product.id}`;
    return this.httpClient.put<Product>(url, product);
  }

  deleteProduct(id: number) : Observable<Product> {
    const url  = `${this.productsUrl}/${id}`;
    return this.httpClient.delete<Product>(url);
  }

  findOne(id: number) : Observable<Product>{
    return this.getAllProducts().pipe(map(products => products.find(product => product.id === id)));
  }

  getAllProducts() : Observable<Product[]>{
    return this.httpClient.get<Array<Product>>(this.productsUrl);
  }
}
