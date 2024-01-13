import { TestBed } from '@angular/core/testing';

import { TnbService } from './tnb.service';

describe('TnbService', () => {
  let service: TnbService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TnbService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
