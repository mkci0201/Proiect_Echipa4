import { Component } from '@angular/core';
import {ProductService} from "./shared/product.service";
import {TokenStorageService} from "../login/shared/tokenstorage.service";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  role: string;

  constructor(private tokenStorageService: TokenStorageService) {

    this.role = this.tokenStorageService.getUser().roles[0];

  }
}
