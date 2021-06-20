import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  private productPopularityUrl = 'http://localhost:8080/api/productsPopularity';

  constructor(private httpClient: HttpClient) {

  }

  getBestSellingProducts() : Observable<Array<OrderedProduct>> {
       return this.httpClient.get<Array<OrderedProduct>>(this.productPopularityUrl);
  }
}
