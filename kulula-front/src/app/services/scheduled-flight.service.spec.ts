import { TestBed, inject } from '@angular/core/testing';

import { ScheduledFlightService } from './scheduled-flight.service';

describe('ScheduledFlightService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ScheduledFlightService]
    });
  });

  it('should be created', inject([ScheduledFlightService], (service: ScheduledFlightService) => {
    expect(service).toBeTruthy();
  }));
});
