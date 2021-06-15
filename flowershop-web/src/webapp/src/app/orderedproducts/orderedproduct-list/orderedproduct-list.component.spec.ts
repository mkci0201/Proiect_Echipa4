import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedProductListComponent } from './orderedproduct-list.component';

describe('OrderedProductListComponent', () => {
  let component: OrderedProductListComponent;
  let fixture: ComponentFixture<OrderedProductListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderedProductListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
