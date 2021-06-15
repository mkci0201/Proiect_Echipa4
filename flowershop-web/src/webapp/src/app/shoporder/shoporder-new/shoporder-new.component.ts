import {Component, Input, OnInit} from '@angular/core';
import {Category, CATEGORY_TYPES} from "../shared/shoporder.model";
import {Location} from '@angular/common';
import {ShopOrderService} from "../shared/shoporder.service";
import {Product} from "../../products/shared/product.model";
import {ProductService} from "../../products/shared/product.service";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";


@Component({
  moduleId: module.id,
  selector: 'app-shoporder-new',
  templateUrl: './shoporder-new.component.html',
  styleUrls: ['./shoporder-new.component.css']
})
export class ShoporderNewComponent {

  CATEGORY_TYPES = CATEGORY_TYPES;
  products: Array<Product>;
  orderedProducts: Array<OrderedProduct>;
  errorMessage: string;

  constructor(private shopOrderService: ShopOrderService, private productService : ProductService,
              private location: Location) {
  }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getAllProducts()
      .subscribe(
        products => this.products = products,
        error => this.errorMessage = <any>error
      );
  }

  goBack(): void {
    this.location.back();
  }

  addOrder(date, category): void {

    this.shopOrderService.addOrder(date, category, this.orderedProducts).subscribe(_=>this.goBack());
    }

    addProduct(product) : void {
    var foundProduct = this.orderedProducts.find(p => p.product.id == product.id);

      if(foundProduct != null){
        foundProduct.quantity += 1;
      }else{
        var orderedProduct: OrderedProduct = {id:0, product:product, quantity:1 };
        this.orderedProducts.push(orderedProduct);
      }
    }
}
