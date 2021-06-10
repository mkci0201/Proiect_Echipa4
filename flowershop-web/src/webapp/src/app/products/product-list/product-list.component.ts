import { Component, OnInit } from '@angular/core';
import {Product} from "../shared/product.model";
import {ProductService} from "../shared/product.service";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  errorMessage: string;
  products: Array<Product>;
  selectedProduct: Product;

  constructor(private productService: ProductService,
              private router: Router) { }

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

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  gotoDetail(): void {
    this.router.navigate(['/product/detail', this.selectedProduct.id]);
  }

  delete(product: Product): void {
    this.productService.deleteProduct(product.id)
      .subscribe(_ => {
        this.products = this.products.filter(s => s !== product);
        if (this.selectedProduct === product) {
          this.selectedProduct = null;
        }
      });
  }

}
