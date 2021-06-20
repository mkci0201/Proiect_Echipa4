import {Component, Input, OnInit} from '@angular/core';
import {Category, CATEGORY_TYPES} from "../shared/shoporder.model";
import {Location} from '@angular/common';
import {ShopOrderService} from "../shared/shoporder.service";
import {Product} from "../../products/shared/product.model";
import {ProductService} from "../../products/shared/product.service";
import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";
import {OrderedProductService} from "../../orderedproducts/shared/ordered-product.service";
import {Observable} from "rxjs";
import {summaryFileName} from "@angular/compiler/src/aot/util";
import {Employee} from "../../employees/shared/employee.model";
import {EmployeeService} from "../../employees/shared/employee.service";


@Component({
  moduleId: module.id,
  selector: 'app-shoporder-new',
  templateUrl: './shoporder-new.component.html',
  styleUrls: ['./shoporder-new.component.css']
})
export class ShoporderNewComponent {

  CATEGORY_TYPES = CATEGORY_TYPES;
  products: Array<Product>;
  orderedProducts = new Array<OrderedProduct>();
  errorMessage: string;
  selectedProduct : Product;
  employee: Employee;

  constructor(private shopOrderService: ShopOrderService, private productService : ProductService,
              private orderedProductsService : OrderedProductService,
              private employeeService : EmployeeService,
              private location: Location) {
  }

  ngOnInit(): void {
    this.getAllProducts();
    this.getEmployee();
  }

  getAllProducts() {
    this.productService.getAllProducts()
      .subscribe(
        products => this.products = products,
        error => this.errorMessage = <any>error
      );
  }

  getEmployee() {
    this.employeeService.findOne(1)
      .subscribe(
        employee => this.employee = employee,
        error => this.errorMessage = <any>error
      );
  }

  goBack(): void {
    this.location.back();
  }


  placeOrder(date, category): void {
    this.shopOrderService.addOrder(date, category, this.orderedProducts, this.employee).subscribe(_=>this.goBack());
  }

  addProduct(quantity) : void {
    var foundProduct = null;

    if (this.orderedProducts.length > 0)
     foundProduct = this.orderedProducts.find(p => p.product.id == this.selectedProduct.id);

    let quantityAsNumber : number = +quantity;

    if(foundProduct != null){
      foundProduct.quantity += quantityAsNumber;
      this.orderedProductsService.updateOrderedProduct(foundProduct);
    } else {
      var orderedProduct: OrderedProduct = {id:0, product:this.selectedProduct, quantity: quantityAsNumber};
      this.orderedProductsService.addOrderedProduct(orderedProduct.product, orderedProduct.quantity).subscribe((value:OrderedProduct)=>this.orderedProducts.push(value));
    }
  }



  onChange(newValue) {
    this.selectedProduct = this.products.find(p => p.id == newValue);
  }

  get totalPrice(){
    let total : number = 0;
    this.orderedProducts.forEach(a => total += a.product.price * a.quantity);
    return total;
  }
}
