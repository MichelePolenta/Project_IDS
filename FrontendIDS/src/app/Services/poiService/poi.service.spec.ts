import { TestBed } from '@angular/core/testing';

import { PoiService } from './poi.service';

describe('PoiServiceService', () => {
  let service: PoiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PoiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
