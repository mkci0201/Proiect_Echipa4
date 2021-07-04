import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";
import {CATEGORY_TYPES, ShopOrder} from "../shared/shoporder.model";
import {ShopOrderService} from "../shared/shoporder.service";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";
import {OrderedProductService} from "../../orderedproducts/shared/ordered-product.service";

@Component({
  selector: 'app-shoporder-details',
  templateUrl: './shoporder-details.component.html',
  styleUrls: ['./shoporder-details.component.css']
})
export class ShoporderDetailsComponent implements OnInit {


  @Input() shopOrder : ShopOrder;
  CATEGORY_TYPES = CATEGORY_TYPES;
  constructor(private shopOrderService: ShopOrderService,
              private orderedProductsService : OrderedProductService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.shopOrderService.findOne(+params['id'])))
      .subscribe(shopOrder => this.shopOrder = shopOrder);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.shopOrderService.updateOrder(this.shopOrder)
      .subscribe(_ => this.goBack());
  }

  get totalPrice(){
    let total : number = 0;
    this.shopOrder.orderedProducts.forEach(a => total += a.product.price * a.quantity);
    return total;
  }

  delete(orderedProduct : OrderedProduct) {

    var foundProduct = this.shopOrder.orderedProducts.find(p => p.product.id == orderedProduct.product.id);
    if (foundProduct) {
      this.orderedProductsService.deleteOrderedProduct(orderedProduct.id).subscribe();
      let index = this.shopOrder.orderedProducts.findIndex(obj => obj.id == orderedProduct.id);
      this.shopOrder.orderedProducts.splice(index, 1);
    }
  }

}
