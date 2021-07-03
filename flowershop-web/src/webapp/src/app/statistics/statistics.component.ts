import { Component, OnInit } from '@angular/core';
import {OrderedProduct} from "../orderedproducts/shared/orderedproduct.model";
import {OrderedProductService} from "../orderedproducts/shared/ordered-product.service";
import {Router} from "@angular/router";
import {StatisticsService} from "./shared/statistics.service";
import {ShopOrder} from "../shoporder/shared/shoporder.model";
import {ShopOrderService} from "../shoporder/shared/shoporder.service";
import {Employee} from "../employees/shared/employee.model";
import {BestEmployee} from "./shared/bestemployee.model";
import {map} from "rxjs/operators";
declare let Chartist: any;
import {TokenStorageService} from "../login/shared/tokenstorage.service";


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

  shopOrdersByDate : ShopOrder[];
  updatedPeriodDate : boolean = false;
  role: string;

  error : any={errorActive:false, errorMessage:''};

  constructor( private statisticService : StatisticsService, private shopOrderService:ShopOrderService,
               private router : Router, private tokenStorageService: TokenStorageService ) { }

  ngOnInit(): void {

    this.getBestSellingProducts();
    this.getAllShopOrders();
    let pieLabels = [];
    let pieSeries =[];

    let barLabels = [];
    let barSeries = [];

    this.statisticService.getBestSellingProducts().subscribe((response: any) => {
      console.log(response);
      response.map(x => {
        pieLabels.push(`${x.product.name}`);
        pieSeries.push( x.product.price *  x.quantity);
      });
    });
    setTimeout(function() {
      let data = {
        labels: pieLabels,
        series: pieSeries
      };
      // console.log(pieLabels);
      // console.log(pieSeries);

      let chart = new Chartist.Pie('#best_selling', data);
    },200)

    this.role = this.tokenStorageService.getUser().roles[0];
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

  totalPricePerOrderedProducts(orderedProducts : Array<OrderedProduct>) : number {
    let totalValue : number = 0;
    for (let o of orderedProducts) {
      totalValue += this.totalPricePerProduct(o);
    }
    return totalValue;
  }

  monthChanged(month:string) {
    this.updatedDate = true;
    this.shopOrderService.getEmployeeOfTheMonth(month).subscribe(e => this.bestEmployee = e);

  }

  dateChanged(startDate : string, endDate : string) {
    if (startDate && endDate) {
      let barLabels = [];
      let barSeries = [];
      this.statisticService.getShopOrdersForPeriod(startDate, endDate).subscribe(o => {
        this.shopOrdersByDate = o;
        console.log(o);
        o.map(order => {
          barLabels.push(order.date);
          let totalPrice = 0;
          order.orderedProducts.map(z => {
            totalPrice += (z.quantity * z.product.price)
          })
          barSeries.push(totalPrice)
        })
      });

      setTimeout(function() {
        let data = {
          labels: barLabels,
          series: [barSeries]
        };
        let chart = new Chartist.Line('#period', data);
      },200)

      this.updatedPeriodDate = true;
      let startDateAsDate = new Date(startDate);
      let endDateAsDate = new Date(endDate);
      if (startDateAsDate >= endDateAsDate) {
        this.error.errorActive = true;
        this.error.errorMessage = 'The start date must be before the end date!';
      }
      else {
        this.error.errorActive = false;
      }

    }
  }

}
