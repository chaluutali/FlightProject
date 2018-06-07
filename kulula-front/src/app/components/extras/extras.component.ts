import { Component, OnInit } from '@angular/core';
import {Extras} from './extras';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-extras',
  templateUrl: './extras.component.html',
  styleUrls: ['./extras.component.css'],
  providers: [ScheduledFlightService]
})
export class ExtrasComponent implements OnInit {
  extraBagPrice: 0;
  travelCover: 0;
  slowXSLoungePrice: 0;
  passengerServiceCharge: number;
  numExtraBag: number = 0;
  numTravelCover: number = 0;
  numSlowXsLounge: number = 0;
  totalExtraBags: number = 0;
  totalTravelCover: number = 0;
  totalSlowXsLounge: number = 0;


  constructor(private scheduledFlightService: ScheduledFlightService, private _router: Router) { }

  ngOnInit() {
    console.log(localStorage.getItem('userFlightDB'));
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }


     this.scheduledFlightService.getExtras().subscribe((result)=>{

       this.extraBagPrice = result.extraBagPrice;
       this.travelCover = result.travelCover;
       this.slowXSLoungePrice = result.slowXSLoungePrice;
       this.passengerServiceCharge = result.passengerServiceCharge;
       this.totalExtraBags = result.totalExtraBags;
       this.totalTravelCover = result.totalTravelCover;
       this.totalSlowXsLounge = result.totalSlowXsLounge;



     });
  }

  addBagCover(){

    this.totalTravelCover = this.travelCover*this.numTravelCover;


  }
  addExtraBags(){

    this.totalExtraBags = this.extraBagPrice*this.numExtraBag;



  }
  addSlowXSlounge(){

    this.totalSlowXsLounge = this.slowXSLoungePrice*this.numSlowXsLounge;


  }
  submitExtras(){

if(this.totalTravelCover == null){ this.totalTravelCover = 0;}
if(this.totalSlowXsLounge == null){ this.totalSlowXsLounge = 0;}
if(this.totalExtraBags == null){ this.totalExtraBags = 0;}
console.log(this.totalSlowXsLounge);
console.log(this.totalExtraBags);
console.log(this.totalTravelCover);

    const extras = {

      numExtraBag: this.numExtraBag,
      numTravelCover: this.numTravelCover,
      numSlowXsLounge: this.numSlowXsLounge


    }
    const extrasLocal = {

      numExtraBag: this.numExtraBag,
      numTravelCover: this.numTravelCover,
      numSlowXsLounge: this.numSlowXsLounge,
      extraBagPrice: this.extraBagPrice,
      travelCover: this.travelCover,
      slowXSLoungePrice : this.slowXSLoungePrice,
      passengerServiceCharge : this.passengerServiceCharge,
      totalExtraBags: this.totalExtraBags,
      totalTravelCover : this.totalTravelCover,
      totalSlowXsLounge : this.totalSlowXsLounge


    }
      localStorage.setItem('extras', JSON.stringify(extrasLocal));
     this.scheduledFlightService.submitExtras(extras).subscribe((response)=>{
                this._router.navigate(['loading']);
                setTimeout( function  myFunction(){
                location.href= 'http://localhost:4200/cart'
              }, 1800);
     });


  }

}
