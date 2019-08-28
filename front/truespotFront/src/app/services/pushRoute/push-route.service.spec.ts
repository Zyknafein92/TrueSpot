import {TestBed} from '@angular/core/testing';

import {PushRouteService} from './push-route.service';

describe('PushRouteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PushRouteService = TestBed.get(PushRouteService);
    expect(service).toBeTruthy();
  });
});
