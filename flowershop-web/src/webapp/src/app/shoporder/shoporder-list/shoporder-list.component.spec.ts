import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoporderListComponent } from './shoporder-list.component';

describe('ShoporderListComponent', () => {
  let component: ShoporderListComponent;
  let fixture: ComponentFixture<ShoporderListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoporderListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoporderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
