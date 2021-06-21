import { Component, OnInit } from '@angular/core';
import {ShopOrder} from "../shared/shoporder.model";
import {ShopOrderService} from "../shared/shoporder.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shoporder-list',
  templateUrl: './shoporder-list.component.html',
  styleUrls: ['./shoporder-list.component.css']
})
export class ShoporderListComponent implements OnInit {
  errorMessage: string;
  shopOrders: Array<ShopOrder>;
  selectedShopOrder: ShopOrder;

  constructor(private shopOrderService: ShopOrderService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllShopOrders();
  }

  getAllShopOrders() {
    this.shopOrderService.getAllOrders()
      .subscribe(
        shopOrders => this.shopOrders = shopOrders,
        error => this.errorMessage = <any>error
      );
  }

  gotoDetail(shopOrder): void {
    this.router.navigate(['orders/detail', shopOrder.id]);
  }

  delete(order: ShopOrder): void {
    this.shopOrderService.deleteOrder(order.id)
      .subscribe(_ => {
        this.shopOrders = this.shopOrders.filter(o => o !== order);
        if (this.selectedShopOrder === order) {
          this.selectedShopOrder = null;
        }
      });
  }

  totalPrice(shopOrder:ShopOrder):number{
    let total : number = 0;
    shopOrder.orderedProducts.forEach(a => total += a.product.price * a.quantity);
    return total;
  }

}
