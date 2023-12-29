import { TestBed } from '@angular/core/testing';

import { CurrentComponentService } from './current-component.service';

describe('CurrentComponentService', () => {
  let service: CurrentComponentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentComponentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
