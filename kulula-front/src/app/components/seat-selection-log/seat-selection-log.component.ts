import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import {AirCraft} from './air-craft';
import{Router} from '@angular/router';

@Component({
  selector: 'app-seat-selection-log',
  templateUrl: './seat-selection-log.component.html',
  styleUrls: ['./seat-selection-log.component.css'],
  providers: [ScheduledFlightService]
})
export class SeatSelectionLogComponent implements OnInit {
  private aircraft: AirCraft;
  seatNumber: number;
  i: number;

  fRowPrice: any;
  frontPrice: any;
  sZonePrice: any;
  eRowPrice: any;
  backPrice: any;

  SeatList= [];
  SeatList2 = [];
  travellerCount: number = 0;
  showContinue: boolean = false;
  showSeats: boolean = true;

  currentSeat: number;


  constructor(private scheduledFlightService: ScheduledFlightService,  private _router: Router) { }
  ngOnInit() {

    localStorage.removeItem('cartDB');
    localStorage.removeItem('extrasDB');
     this.scheduledFlightService.getSeatLog().subscribe((result)=>{
       this.aircraft = result;
       this.fRowPrice = this.aircraft.fRowPrice;
       this.frontPrice = this.aircraft.frontPrice;
       this.sZonePrice = this.aircraft.sZonePrice;
       this.eRowPrice = this.aircraft.eRowPrice;
       this.backPrice = this.aircraft.backPrice;

       console.log(localStorage.getItem('userFlightDB'));

     });
}


backSelected(i){
  this.currentSeat = i;
  localStorage.setItem('currentSeat', JSON.stringify(this.currentSeat));
  var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
  if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
  console.log(_searchForm.numberOfAdults);
  if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
  console.log(_searchForm.numberOfInfants);
  if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
  console.log(_searchForm.numberOfChildren);
  var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
  var _selectedFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  const seatSelection = {

    seatId: i,
   seatType: "Back",
   seatSelected: true,
    craftName: _selectedFlight.flightNumber
  }
  this.scheduledFlightService.submitSeat(seatSelection).subscribe((result)=>{
    this.SeatList.push(seatSelection);
    this.travellerCount = this.travellerCount + 1;

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount === totalTravellers)
    {
      this.showSeats = false;
      this.showContinue = true;
      localStorage.setItem('seatList', JSON.stringify(this.SeatList));

    }

  });

}
eRowSelected(i){
  this.currentSeat = i;
  localStorage.setItem('currentSeat', JSON.stringify(this.currentSeat));
  var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
  if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
  console.log(_searchForm.numberOfAdults);
  if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
  console.log(_searchForm.numberOfInfants);
  if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
  console.log(_searchForm.numberOfChildren);
  var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
  var _selectedFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  const seatSelection = {

    seatId: i,
   seatType: "eRow",
   seatSelected: true,
    craftName: _selectedFlight.flightNumber
  }
  this.scheduledFlightService.submitSeat(seatSelection).subscribe((result)=>{
    this.SeatList.push(seatSelection);
    this.travellerCount = this.travellerCount + 1;

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount === totalTravellers)
    {
      this.showSeats = false;
      this.showContinue = true;
      localStorage.setItem('seatList', JSON.stringify(this.SeatList));

    }
  });

}
sZoneSelected(i){
  this.currentSeat = i;
  localStorage.setItem('currentSeat', JSON.stringify(this.currentSeat));
  var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
  if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
  console.log(_searchForm.numberOfAdults);
  if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
  console.log(_searchForm.numberOfInfants);
  if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
  console.log(_searchForm.numberOfChildren);
  var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
  var _selectedFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  const seatSelection = {

    seatId: i,
   seatType: "sZone",
   seatSelected: true,
    craftName: _selectedFlight.flightNumber
  }
  this.scheduledFlightService.submitSeat(seatSelection).subscribe((result)=>{
    this.SeatList.push(seatSelection);
    this.travellerCount = this.travellerCount + 1;

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount === totalTravellers)
    {
      this.showSeats = false;
      this.showContinue = true;
      localStorage.setItem('seatList', JSON.stringify(this.SeatList));

    }
  });

}
frontSelected(i){
  this.currentSeat = i;
  localStorage.setItem('currentSeat', JSON.stringify(this.currentSeat));
  var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
  if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
  console.log(_searchForm.numberOfAdults);
  if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
  console.log(_searchForm.numberOfInfants);
  if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
  console.log(_searchForm.numberOfChildren);
  var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
  var _selectedFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  const seatSelection = {

    seatId: i,
   seatType: "Front",
   seatSelected: true,
    craftName: _selectedFlight.flightNumber
  }
  this.scheduledFlightService.submitSeat(seatSelection).subscribe((result)=>{
    this.SeatList.push(seatSelection);
    this.travellerCount = this.travellerCount + 1;

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount === totalTravellers)
    {
      this.showSeats = false;
      this.showContinue = true;
      localStorage.setItem('seatList', JSON.stringify(this.SeatList));

    }
  });

}
fRSelected(i){
  this.currentSeat = i;
  localStorage.setItem('currentSeat', JSON.stringify(this.currentSeat));
  var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
  if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
  console.log(_searchForm.numberOfAdults);
  if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
  console.log(_searchForm.numberOfInfants);
  if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
  console.log(_searchForm.numberOfChildren);
  var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
var _selectedFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  const seatSelection = {

    seatId: i,
   seatType: "fRow",
   seatSelected: true,
    craftName: _selectedFlight.flightNumber
  }
  this.scheduledFlightService.submitSeat(seatSelection).subscribe((result)=>{
    this.SeatList.push(seatSelection);
    this.travellerCount = this.travellerCount + 1;

    if(this.travellerCount != totalTravellers){
      this.SeatList2.push(seatSelection);
      localStorage.setItem('seatList2', JSON.stringify(this.SeatList2));
      console.log(this.SeatList2);
    }

    if(this.travellerCount === totalTravellers)
    {
      this.showSeats = false;
      this.showContinue = true;
      localStorage.setItem('seatList', JSON.stringify(this.SeatList));

    }
  });

}
onContinue(){

      this._router.navigate(['loading']);

      setTimeout( function  myFunction(){
      location.href= 'http://localhost:4200/extras'
    }, 1800);

}
receiveMessage($event){

  this.SeatList = $event;
  this.travellerCount = this.travellerCount - 1;
  this.showSeats = true;
  this.showContinue = false;
  var deletedSeat = JSON.parse(localStorage.getItem('currentSeat'));
  this.scheduledFlightService.removeSeat(deletedSeat).subscribe((res)=>{

  });


}

}
