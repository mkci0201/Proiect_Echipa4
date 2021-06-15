import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedProductNewComponent } from './orderedproduct-new.component';

describe('OrderedProductNewComponent', () => {
  let component: OrderedProductNewComponent;
  let fixture: ComponentFixture<OrderedProductNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderedProductNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedProductNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
