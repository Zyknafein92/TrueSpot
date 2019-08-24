import { TestBed } from '@angular/core/testing';

import { UsermessageService } from './usermessage.service';

describe('UsermessageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsermessageService = TestBed.get(UsermessageService);
    expect(service).toBeTruthy();
  });
});
