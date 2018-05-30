import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfTravellersComponent } from './list-of-travellers.component';

describe('ListOfTravellersComponent', () => {
  let component: ListOfTravellersComponent;
  let fixture: ComponentFixture<ListOfTravellersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfTravellersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfTravellersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
