import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveRateComponent } from './save-rate.component';

describe('SaveRateComponent', () => {
  let component: SaveRateComponent;
  let fixture: ComponentFixture<SaveRateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SaveRateComponent]
    });
    fixture = TestBed.createComponent(SaveRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
