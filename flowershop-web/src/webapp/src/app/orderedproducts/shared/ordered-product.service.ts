import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Product} from "../../products/shared/product.model";
import {Observable} from "rxjs";
import {OrderedProduct} from "./orderedproduct.model";
import {map} from "rxjs/operators";

@Injectable()
export class OrderedProductService {

  private orderedProductsUrl = 'http://localhost:8080/api/orderedProducts';

  constructor(private httpClient: HttpClient) {

  }

  addOrderedProduct(product: Product, quantity: number) : Observable<OrderedProduct> {
    let orderedProduct = {product, quantity};

    return this.httpClient.post<OrderedProduct>(this.orderedProductsUrl, orderedProduct);
  }

  updateOrderedProduct(orderedproduct): Observable<OrderedProduct> {
    const url = `${this.orderedProductsUrl}/${orderedproduct.id}`;
    return this.httpClient.put<OrderedProduct>(url, orderedproduct);
  }

  deleteOrderedProduct(id: number): Observable<OrderedProduct> {
    const url = `${this.orderedProductsUrl}/${id}`;
    return this.httpClient.delete<OrderedProduct>(url);
  }

  findOne(id: number): Observable<OrderedProduct> {
    return this.findAllOrderedProducts().pipe(map(ops => ops.find(op => op.id === id)));
  }

  findAllOrderedProducts(): Observable<Array<OrderedProduct>> {
    return this.httpClient.get<Array<OrderedProduct>>(this.orderedProductsUrl);
  }
}
