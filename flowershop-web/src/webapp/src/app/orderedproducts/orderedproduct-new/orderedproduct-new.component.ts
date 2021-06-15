import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {OrderedProductService} from "../shared/ordered-product.service";
import {Product} from "../../products/shared/product.model";

@Component({
  selector: 'app-orderedproduct-new',
  templateUrl: './orderedproduct-new.component.html',
  styleUrls: ['./orderedproduct-new.component.css']
})
export class OrderedProductNewComponent {

  constructor(private orderedProductService: OrderedProductService, private location: Location) {}

  goBack(): void {
    this.location.back();
  }

  addOrderedProduct(product: Product, quantity): void {
    this.orderedProductService.addOrderedProduct(product, quantity).subscribe(_ => this.goBack());
  }
}
