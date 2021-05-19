import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiptShowComponent } from './receipt-show.component';

describe('ReceiptShowComponent', () => {
  let component: ReceiptShowComponent;
  let fixture: ComponentFixture<ReceiptShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceiptShowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiptShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
