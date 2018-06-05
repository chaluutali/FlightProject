import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import {FlightSearchForm} from './flight-search-form';
import{Router} from '@angular/router';
import {Airport} from './airport';


@Component({
  selector: 'app-flight-search-form',
  templateUrl: './flight-search-form.component.html',
  styleUrls: ['./flight-search-form.component.css'],
  providers: [UserDataService]
})
export class FlightSearchFormComponent implements OnInit {

  tripType: string;
  destinationFrom: string;
  destinationTo: string;
  preferredClass: string;
  departureDate: Date;
  returnDate: Date;
  numberOfAdults: number;
  numberOfInfants: number;
  numberOfChildren: number;
  currentDate: Date;
  td: any;

  airports: Airport[];
  airports2 = [];
  constructor(private userDataService: UserDataService, private _router: Router, private scheduledFlightService: ScheduledFlightService
   ) { }

  ngOnInit() {


       var d = new Date(),
       month = '' + (d.getMonth() + 1),
       day = '' + d.getDate(),
       year = d.getFullYear();
       if (month.length < 2) month = '0' + month;
       if (day.length < 2) day = '0' + day;
       var today = [year, month, day].join('-')
       this.td = today;
       document.getElementById("datefield").setAttribute("min", today);


    localStorage.removeItem('cartDB');
    localStorage.removeItem('selectedFlight');
    localStorage.removeItem('traveller');
    localStorage.removeItem('extrasDB');
    localStorage.removeItem('faresDB');
    localStorage.removeItem('seatDB');
    localStorage.removeItem('userFlightDB');
    localStorage.removeItem('searchLogDateId');
    localStorage.removeItem('flightSearchForm');
    localStorage.removeItem('fares');
    localStorage.removeItem('paid');

    console.log(localStorage.getItem('cartDB'));
    console.log(localStorage.getItem('selectedFlight'));
    console.log(localStorage.getItem('traveller'));
    console.log(localStorage.getItem('extrasDB'));
    console.log(localStorage.getItem('faresDB'));
    console.log(localStorage.getItem('seatDB'));
    console.log(localStorage.getItem('userFlightDB'));
    console.log(localStorage.getItem('searchLogDateId'));
    console.log(localStorage.getItem('flightSearchForm'));
    console.log(localStorage.getItem('fares'));
    console.log(localStorage.getItem('currentUser'));
    this.scheduledFlightService.getAllAirports().subscribe((response)=>{

       this.airports = response;
      console.log(this.airports);

    });


  }

onSearch(){
  const _flightSearchForm = {
    tripType: this.tripType,
    destinationFrom: this.destinationFrom,
    destinationTo: this.destinationTo,
    preferredClass: this.preferredClass,
    departureDate: this.departureDate,
    returnDate: this.returnDate,
    numberOfAdults: this.numberOfAdults,
    numberOfInfants: this.numberOfInfants,
    numberOfChildren: this.numberOfChildren,
    searchLogDateId: Date.now().toString()


  }
  localStorage.setItem('searchLogDateId', JSON.stringify(_flightSearchForm.searchLogDateId));
  localStorage.setItem('flightSearchForm', JSON.stringify(_flightSearchForm));
  console.log(localStorage.getItem('flightSearchForm'));


  this.userDataService.submitSearch(_flightSearchForm)
  .subscribe(result => {


  });

this._router.navigate(['loading']);

setTimeout( function  myFunction(){
location.href= 'http://localhost:4200/flights'
}, 1800);

}
omitAirport(){

    this.airports2 = [];
  for (var i = 0; i < this.airports.length; i++) {
    if(this.airports[i].airportName != this.destinationFrom){
    this.airports2.push(this.airports[i]);
  }

}

  console.log(this.airports2);
}



}
