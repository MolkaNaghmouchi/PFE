import { TestBed } from '@angular/core/testing';

import { ConnectpointService } from './connectpoint.service';

describe('ConnectpointService', () => {
  let service: ConnectpointService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectpointService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
