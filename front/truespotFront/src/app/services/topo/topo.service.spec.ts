import { TestBed } from '@angular/core/testing';

import { TopoService } from './topo.service';

describe('TopoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TopoService = TestBed.get(TopoService);
    expect(service).toBeTruthy();
  });
});
