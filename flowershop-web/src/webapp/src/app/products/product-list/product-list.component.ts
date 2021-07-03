import { Component, OnInit } from '@angular/core';
import {Product} from "../shared/product.model";
import {ProductService} from "../shared/product.service";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../login/shared/tokenstorage.service";

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
  role: string;

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllProducts();
    this.role = this.tokenStorageService.getUser().roles[0];
  }

  getAllProducts() {
    this.productService.getAllProducts()
      .subscribe(
        products => this.products = products,
        error => this.errorMessage = <any>error
      );
  }

  gotoDetail(product): void {
    this.router.navigate(['/product/detail', product.id]);
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
