import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";
import {CATEGORY_TYPES, ShopOrder} from "../shared/shoporder.model";
import {ShopOrderService} from "../shared/shoporder.service";

@Component({
  selector: 'app-shoporder-details',
  templateUrl: './shoporder-details.component.html',
  styleUrls: ['./shoporder-details.component.css']
})
export class ShoporderDetailsComponent implements OnInit {


  @Input() shopOrder : ShopOrder;
  CATEGORY_TYPES = CATEGORY_TYPES;
  constructor(private shopOrderService: ShopOrderService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.shopOrderService.findOne(+params['id'])))
      .subscribe(shopOrder => this.shopOrder = shopOrder);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.shopOrderService.updateOrder(this.shopOrder)
      .subscribe(_ => this.goBack());
  }

}
