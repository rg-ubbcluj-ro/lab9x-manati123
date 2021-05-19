import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDroidComponent } from './delete-droid.component';

describe('DeleteDroidComponent', () => {
  let component: DeleteDroidComponent;
  let fixture: ComponentFixture<DeleteDroidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteDroidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteDroidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
