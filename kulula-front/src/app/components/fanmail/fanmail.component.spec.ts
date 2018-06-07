import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FanmailComponent } from './fanmail.component';

describe('FanmailComponent', () => {
  let component: FanmailComponent;
  let fixture: ComponentFixture<FanmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FanmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FanmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
