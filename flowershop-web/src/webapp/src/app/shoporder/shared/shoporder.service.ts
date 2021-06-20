import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Category, ShopOrder} from "./shoporder.model";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";
import {Employee} from "../../employees/shared/employee.model";
import {BestEmployee} from "../../statistics/shared/bestemployee.model";

@Injectable()
export class ShopOrderService {
  private shopOrdersUrl = 'http://localhost:8080/api/shoporders';
  private bestEmployee = 'http://localhost:8080/api/bestEmployee';

  constructor(private httpClient: HttpClient) {

  }

  addOrder(date: string, category: Category, orderedProducts: Array<OrderedProduct>, employee : Employee  ): Observable<ShopOrder>
  {
    let shopOrder = {date, category, orderedProducts, employee};
    return this.httpClient.post<ShopOrder>(this.shopOrdersUrl, shopOrder)
  }

  updateOrder(shopOrder): Observable<ShopOrder> {
    const url = `${this.shopOrdersUrl}/${shopOrder.id}`;
    return this.httpClient.put<ShopOrder>(url, shopOrder);
  }


  deleteOrder(id: number) : Observable<ShopOrder> {
    const url  = `${this.shopOrdersUrl}/${id}`;
    return this.httpClient.delete<ShopOrder>(url);
  }

  findOne(id: number) : Observable<ShopOrder>{
    return this.getAllOrders().pipe(map(shopOrder => shopOrder.find(shopOrder => shopOrder.id === id)));
  }

  getAllOrders() : Observable<ShopOrder[]>{
    return this.httpClient.get<Array<ShopOrder>>(this.shopOrdersUrl);

  }

  getEmployeeOfTheMonth(month:string) : Observable<BestEmployee> {
    const url  = `${this.bestEmployee}/${month}`;
    return this.httpClient.get<BestEmployee>(url);
  }

}
