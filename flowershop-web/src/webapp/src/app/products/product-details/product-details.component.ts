import { Component, Input, OnInit } from '@angular/core';
import {Product, PRODUCT_COLOR_TYPES} from "../shared/product.model";
import {ProductService} from "../shared/product.service";
import {ActivatedRoute, Params} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {Location} from '@angular/common';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  @Input() product: Product;
  PRODUCT_COLOR_TYPES =   PRODUCT_COLOR_TYPES;

  constructor(private productService: ProductService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.productService.findOne(+params['id'])))
      .subscribe(product => this.product = product);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.productService.updateProduct(this.product)
      .subscribe(_ => this.goBack());
  }

}
