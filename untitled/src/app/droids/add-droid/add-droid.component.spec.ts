import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDroidComponent } from './add-droid.component';

describe('AddDroidComponent', () => {
  let component: AddDroidComponent;
  let fixture: ComponentFixture<AddDroidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDroidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDroidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
