import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoporderComponent } from './shoporder.component';

describe('ShoporderComponent', () => {
  let component: ShoporderComponent;
  let fixture: ComponentFixture<ShoporderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoporderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoporderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
