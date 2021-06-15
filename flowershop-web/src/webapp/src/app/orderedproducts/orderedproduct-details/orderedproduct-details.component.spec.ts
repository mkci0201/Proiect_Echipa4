import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedProductDetailsComponent } from './orderedproduct-details.component';

describe('OrderedproductDetailsComponent', () => {
  let component: OrderedProductDetailsComponent;
  let fixture: ComponentFixture<OrderedProductDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderedProductDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedProductDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
