import { Component, OnInit } from '@angular/core';
import {OrderedProduct} from "../orderedproducts/shared/orderedproduct.model";
import {OrderedProductService} from "../orderedproducts/shared/ordered-product.service";
import {Router} from "@angular/router";
import {StatisticsService} from "./shared/statistics.service";
import {ShopOrder} from "../shoporder/shared/shoporder.model";
import {ShopOrderService} from "../shoporder/shared/shoporder.service";
import {Employee} from "../employees/shared/employee.model";
import {BestEmployee} from "./shared/bestemployee.model";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  errorMessage: string;
  orderedProducts: OrderedProduct[];
  shopOrders : ShopOrder[];

  bestEmployee : BestEmployee;
  updatedDate : boolean = false;

  constructor( private statisticService : StatisticsService, private shopOrderService:ShopOrderService,
               private router : Router) { }

  ngOnInit(): void {

    this.getBestSellingProducts();
    this.getAllShopOrders();
  }

  getBestSellingProducts() {

    this.statisticService.getBestSellingProducts().subscribe(
      p => this.orderedProducts = p
        .sort((a, b) =>
             (a.quantity > b.quantity ? -1 : 1)),
      err => this.errorMessage = <any>err
    )
  }

  getAllShopOrders() {
    this.shopOrderService.getAllOrders().subscribe(p => this.shopOrders = p);
  }

  totalPricePerProduct(orderedProduct:OrderedProduct):number{
    return orderedProduct.quantity * orderedProduct.product.price;
  }

  monthChanged(month:string) {
    this.updatedDate = true;
    this.shopOrderService.getEmployeeOfTheMonth(month).subscribe(e => this.bestEmployee = e);

  }


}
