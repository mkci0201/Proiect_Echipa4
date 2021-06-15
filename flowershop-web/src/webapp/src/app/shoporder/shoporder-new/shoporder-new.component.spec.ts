import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoporderNewComponent } from './shoporder-new.component';

describe('ShoporderNewComponent', () => {
  let component: ShoporderNewComponent;
  let fixture: ComponentFixture<ShoporderNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoporderNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoporderNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
