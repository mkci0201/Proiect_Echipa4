import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";
import {ShopOrder} from "../../shoporder/shared/shoporder.model";
import {start} from "repl";

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  private productPopularityUrl = 'http://localhost:8080/api/productsPopularity';
  private shopOrderForPeriodUrl = 'http://localhost:8080/api/shopordersPeriod';

  constructor(private httpClient: HttpClient) {

  }

  getBestSellingProducts() : Observable<Array<OrderedProduct>> {
       return this.httpClient.get<Array<OrderedProduct>>(this.productPopularityUrl);
  }

  getShopOrdersForPeriod(startDate : string, endDate : string) : Observable<Array<ShopOrder>> {
    const url  = `${this.shopOrderForPeriodUrl}/${startDate}/${endDate}`;
    return this.httpClient.get<Array<ShopOrder>>(url);
  }

}
