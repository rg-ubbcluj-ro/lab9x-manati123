import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDroidsComponent } from './show-droids.component';

describe('ShowDroidsComponent', () => {
  let component: ShowDroidsComponent;
  let fixture: ComponentFixture<ShowDroidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowDroidsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowDroidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
