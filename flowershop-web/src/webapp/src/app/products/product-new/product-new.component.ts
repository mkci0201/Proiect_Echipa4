import { Component, OnInit } from '@angular/core';
import {ProductService} from "../shared/product.service";
import {Location} from '@angular/common';

@Component({
  moduleId: module.id,
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css']
})
export class ProductNewComponent {

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
