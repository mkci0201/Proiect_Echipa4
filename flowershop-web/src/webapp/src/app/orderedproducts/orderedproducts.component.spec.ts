import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedproductsComponent } from './orderedproducts.component';

describe('OrderedproductsComponent', () => {
  let component: OrderedproductsComponent;
  let fixture: ComponentFixture<OrderedproductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderedproductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
