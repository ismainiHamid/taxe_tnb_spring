import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveLandComponent } from './save-land.component';

describe('SaveLandComponent', () => {
  let component: SaveLandComponent;
  let fixture: ComponentFixture<SaveLandComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SaveLandComponent]
    });
    fixture = TestBed.createComponent(SaveLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
