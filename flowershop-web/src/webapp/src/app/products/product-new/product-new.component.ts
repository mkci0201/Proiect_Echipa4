import { Component, OnInit } from '@angular/core';
import {ProductService} from "../shared/product.service";
import {Location} from '@angular/common';
import { PRODUCT_COLOR_TYPES } from '../shared/product.model';

@Component({
  moduleId: module.id,
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css']
})
export class ProductNewComponent {

  PRODUCT_COLOR_TYPES =   PRODUCT_COLOR_TYPES;


    constructor(private productService: ProductService,
              private location: Location) { }

  goBack(): void {
    this.location.back();
  }

  addProduct(name, description, color, price, stock): void {

    this.productService.addProduct(name, description, color, price, stock)
      .subscribe(_ => this.goBack());
  }

}
