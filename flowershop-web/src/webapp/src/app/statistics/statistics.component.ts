import { Component, OnInit } from '@angular/core';
import {OrderedProduct} from "../orderedproducts/shared/orderedproduct.model";
import {OrderedProductService} from "../orderedproducts/shared/ordered-product.service";
import {Router} from "@angular/router";
import {StatisticsService} from "./shared/statistics.service";
import {ShopOrder} from "../shoporder/shared/shoporder.model";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  errorMessage: string;
  orderedProducts: OrderedProduct[];


  constructor( private statisticService : StatisticsService, private router : Router) { }

  ngOnInit(): void {

    this.getBestSellingProducts();
  }

  getBestSellingProducts() {

    this.statisticService.getBestSellingProducts().subscribe(
      p => this.orderedProducts = p
        .sort((a, b) =>
             (a.quantity > b.quantity ? -1 : 1)),
      err => this.errorMessage = <any>err
    )
  }

  totalPricePerProduct(orderedProduct:OrderedProduct):number{
    return orderedProduct.quantity * orderedProduct.product.price;
  }

}
