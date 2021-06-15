import { Component, OnInit } from '@angular/core';
import {OrderedProduct} from "../shared/orderedproduct.model";
import {OrderedProductService} from "../shared/ordered-product.service";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'app-orderedproduct-list',
  templateUrl: './orderedproduct-list.component.html',
  styleUrls: ['./orderedproduct-list.component.css']
})
export class OrderedProductListComponent implements OnInit {

  errorMessage: string;
  orderedProducts: OrderedProduct[];
  selectedOrderedProduct: OrderedProduct;

  constructor(private orderedPoductService: OrderedProductService, private router: Router) { }

  ngOnInit(): void {
    this.getAllOrderedProducts();
  }

  getAllOrderedProducts() {
    this.orderedPoductService.findAllOrderedProducts().subscribe(
      p => this.orderedProducts = p,
      err => this.errorMessage = <any>err
    )
  }

  onSelect(orderedProduct: OrderedProduct): void {
    this.selectedOrderedProduct = orderedProduct;
  }

  gotoDetail(): void {
    this.router.navigate(['order/detail', this.selectedOrderedProduct.id]);
  }

  deleteOrderedProduct(orderedProduct: OrderedProduct): void {
    this.orderedPoductService.deleteOrderedProduct(orderedProduct.id)
      .subscribe(_ => {
        this.orderedProducts = this.orderedProducts.filter(s => s !== orderedProduct)
        if (this.selectedOrderedProduct === orderedProduct) {
          this.selectedOrderedProduct = null;
        }
      })
  }
}
