import {Component, Input, OnInit, ViewChild} from '@angular/core';
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
import {TokenStorageService} from "../../login/shared/tokenstorage.service";


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
  stockError : any={errorActive:false, errorMessage:''};
  employeeId : number;
  isLoggedIn = false;


  @ViewChild('orderQuantity') orderQuantity;

  constructor(private shopOrderService: ShopOrderService, private productService : ProductService,
              private orderedProductsService : OrderedProductService,
              private employeeService : EmployeeService,
              private location: Location, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.getAllProducts();
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.employeeId = user.id;
      console.log(this.employeeId);
    }
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
    this.employeeService.findOne(this.employeeId)
      .subscribe(
        employee => this.employee = employee,
        error => this.errorMessage = <any>error
      );
  }

  goBack(): void {
    this.location.back();
  }


  placeOrder(date, category): void {
    console.log(this.employee);
    this.shopOrderService.addOrder(date, category, this.orderedProducts, this.employee).subscribe(v => this.orderPlacedSuccessfully(v));
  }

  orderPlacedSuccessfully(shopOrder) {

    for (let p of shopOrder.orderedProducts) {
      let product = p.product;
      product.stock -= p.quantity;
      this.productService.updateProduct(product).subscribe();
    }
    this.goBack();
  }

  addProduct(quantity) : void {
    var foundProduct = null;

    if (this.orderedProducts.length > 0)
     foundProduct = this.orderedProducts.find(p => p.product.id == this.selectedProduct.id);

    let quantityAsNumber : number = +quantity;

    if(foundProduct != null){
      if (foundProduct.quantity + quantityAsNumber > foundProduct.product.stock)
      {
        this.stockError.errorActive = true;
        this.stockError.errorMessage = 'There are not enough products on stock!';
      }
      else
      {
        foundProduct.quantity += quantityAsNumber;
        this.orderedProductsService.updateOrderedProduct(foundProduct);
      }
    } else {
      var orderedProduct: OrderedProduct = {id:0, product:this.selectedProduct, quantity: quantityAsNumber};
      this.orderedProductsService.addOrderedProduct(orderedProduct.product, orderedProduct.quantity).subscribe((value:OrderedProduct)=>this.orderedProducts.push(value));
    }
  }

  onChange(newValue) {
    this.selectedProduct = this.products.find(p => p.id == newValue);
    this.stockError.errorActive = false;
    if (this.orderQuantity)
      this.orderQuantity.nativeElement.value = '1';
  }

  get totalPrice(){
    let total : number = 0;
    this.orderedProducts.forEach(a => total += a.product.price * a.quantity);
    return total;
  }

  delete(orderedProduct : OrderedProduct) {
    this.stockError.errorActive = false;
    if (this.orderQuantity)
      this.orderQuantity.nativeElement.value = '1';
    var foundProduct = this.orderedProducts.find(p => p.product.id == orderedProduct.product.id);
    if (foundProduct) {
      this.orderedProductsService.deleteOrderedProduct(orderedProduct.id).subscribe();
      let index = this.orderedProducts.findIndex(obj => obj.id == orderedProduct.id);
      this.orderedProducts.splice(index, 1);
    }
  }

  onSelectedProductStock(stock : number, selectedStock) {
    if (+selectedStock > stock) {
      this.stockError.errorActive = true;
      this.stockError.errorMessage = 'There are not enough products on stock';
    }
    else
    {
      this.stockError.errorActive = false;
      this.stockError.errorMessage = '';
    }
  }
}
