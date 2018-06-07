import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelbankComponent } from './travelbank.component';

describe('TravelbankComponent', () => {
  let component: TravelbankComponent;
  let fixture: ComponentFixture<TravelbankComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelbankComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelbankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
