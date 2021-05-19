import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDroidsComponent } from './update-droids.component';

describe('UpdateDroidsComponent', () => {
  let component: UpdateDroidsComponent;
  let fixture: ComponentFixture<UpdateDroidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDroidsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDroidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
