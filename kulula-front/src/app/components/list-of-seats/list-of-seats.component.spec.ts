import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfSeatsComponent } from './list-of-seats.component';

describe('ListOfSeatsComponent', () => {
  let component: ListOfSeatsComponent;
  let fixture: ComponentFixture<ListOfSeatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfSeatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfSeatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
