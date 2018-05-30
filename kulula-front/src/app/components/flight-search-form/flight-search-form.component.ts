import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import {FlightSearchForm} from './flight-search-form';
import{Router} from '@angular/router';


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


  constructor(private userDataService: UserDataService, private _router: Router
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

       console.log(today);



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


}
