import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatSelectionLogComponent } from './seat-selection-log.component';

describe('SeatSelectionLogComponent', () => {
  let component: SeatSelectionLogComponent;
  let fixture: ComponentFixture<SeatSelectionLogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeatSelectionLogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatSelectionLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
