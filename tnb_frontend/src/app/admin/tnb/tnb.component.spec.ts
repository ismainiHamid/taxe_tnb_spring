import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TnbComponent } from './tnb.component';

describe('TnbComponent', () => {
  let component: TnbComponent;
  let fixture: ComponentFixture<TnbComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TnbComponent]
    });
    fixture = TestBed.createComponent(TnbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
