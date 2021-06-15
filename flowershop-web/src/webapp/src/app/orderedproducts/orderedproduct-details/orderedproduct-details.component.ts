import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";
import {OrderedProductService} from "../shared/ordered-product.service";
import {OrderedProduct} from "../shared/orderedproduct.model";

@Component({
  selector: 'app-orderedproduct-details',
  templateUrl: './orderedproduct-details.component.html',
  styleUrls: ['./orderedproduct-details.component.css']
})
export class OrderedProductDetailsComponent implements OnInit {

  @Input() orderedProduct: OrderedProduct;
  constructor(private orderedProductService: OrderedProductService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    // this.route.params()
    //   .pipe(switchMap((params: Params) => this.orderedProductService.findOne(+params['id'])))
    //   .subscribe(op => this.orderedProduct = op);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.orderedProductService.updateOrderedProduct(this.orderedProduct)
      .subscribe(_ => this.goBack());
  }
}
