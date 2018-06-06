import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css'],
  providers: [ScheduledFlightService]
})
export class ShoppingCartComponent implements OnInit {
  extras: any;
  seat:any;
  fares: any;
  travellers: any;

  extraBagPrice: number;
  travelCover: number;
  slowXSLoungePrice: number;
  passengerServiceCharge: number;
  numExtraBag: number;
  numTravelCover: number;
  numSlowXsLounge: number;
  totalExtraBags: number;
  totalTravelCover: number;
  totalSlowXsLounge: number;

  fareType: string;
  numberOfTravellers: number;
  numberOfCheckedBaggage: number;
  preFlightCancellationFee: number;
  flightChangesFee: number;
  fareTotal: number;
  valueAddedTax: number;
  passengerSafetyCharge: number;
  passengerSecurityCharge: number;
  passengerServiceCharge2: number;
  fuelSurCharge: number;

  totalSeat: number;
  seatType: string;
  seatId: number;
  seatPrice: number = 0;
  fRowPrice: any;
  frontPrice: any;
  sZonePrice: any;
  eRowPrice: any;
  backPrice: any;


  constructor(private scheduledFlightService: ScheduledFlightService,  private _router: Router) { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }


    this.travellers = JSON.parse(localStorage.getItem('travellerList'));
    this.seat = JSON.parse(localStorage.getItem('seatList'));

    this.scheduledFlightService.getClientExtras().subscribe((res)=>{

    localStorage.setItem('extrasDB', JSON.stringify(res));
    console.log(localStorage.getItem('extrasDB'));

    this.extras = JSON.parse(localStorage.getItem('extrasDB'));



        this.extraBagPrice =   this.extras.extraBagPrice;
        this.travelCover =   this.extras.travelCover;
        this.slowXSLoungePrice =   this.extras.slowXSLoungePrice;
        this.passengerServiceCharge =   this.extras.passengerServiceCharge;
        this.numExtraBag =   this.extras.numExtraBag;
        this.numTravelCover = this.extras.numTravelCover;
        this.numSlowXsLounge = this.extras.numSlowXsLounge;
        this.totalExtraBags =   this.extras.totalExtraBag;
        this.totalTravelCover =   this.extras.totalTravelCover;
        this.totalSlowXsLounge =   this.extras.totalSlowXsLounge;
        this.scheduledFlightService.getClientFares().subscribe((result)=>{

          localStorage.setItem('faresDB', JSON.stringify(result));
              console.log(localStorage.getItem('faresDB'));

          this.fares = JSON.parse(localStorage.getItem('faresDB'));



        this.fareType = this.fares.fareType;
        this.numberOfCheckedBaggage = this.fares.numberOfCheckedBaggage;
        this.numberOfTravellers = this.travellers.length;
        this.preFlightCancellationFee = this.fares.preFlightCancellationFee;
        this.flightChangesFee = this.fares.flightChangesFee;
        this.fareTotal = this.fares.fareTotal;
        this.valueAddedTax = this.fares.valueAddedTax;
        this.passengerSafetyCharge =  this.fares.passengerSafetyCharge;
        this.passengerSecurityCharge = this.fares.passengerSecurityCharge;
        this.passengerServiceCharge2 = this.fares.passengerServiceCharge;
        this.fuelSurCharge = this.fares.fuelSurCharge;

        this.scheduledFlightService.getSeatById(1).subscribe((response2)=>{

          localStorage.setItem('seatPrices', JSON.stringify(response2));
          this.fRowPrice = response2.frontRowPrice;
          this.frontPrice = response2.standardFrontPrice;
          this.eRowPrice = response2.exitRowPrice;
          this.sZonePrice = response2.stretchZonePrice;
          this.backPrice = response2.standardBackPrice;
          console.log(response2);
          var i;
          for (i = 0; i < this.seat.length; i++)
          {
            if (this.seat[i].seatType === "Back")
              {
                this.seat[i].seatType = "Standard (Back)";
                this.seatPrice = this.seatPrice + this.backPrice;

              }
              if (this.seat[i].seatType === "eRow")
                {
                  this.seat[i].seatType = "Exit Row (Extra Legroom)";
                  this.seatPrice = this.seatPrice + this.eRowPrice;

                }
                if (this.seat[i].seatType === "sZone")
                  {
                    this.seat[i].seatType = "Stretch Zone (Extra Legroom)";
                    this.seatPrice = this.seatPrice + this.sZonePrice;

                  }
                  if (this.seat[i].seatType === "Front")
                    {
                      this.seat[i].seatType = "Standard (Front)";
                      this.seatPrice = this.seatPrice + this.frontPrice;

                    }
                    if (this.seat[i].seatType === "fRow")
                      {
                        this.seat[i].seatType = "Front Row (Extra Legroom)";
                        this.seatPrice = this.seatPrice +this.fRowPrice;

                      }
            }
        });



      });

});
  }
  back(){

    var grandTotal = (this.totalSlowXsLounge + this.totalTravelCover + this.totalExtraBags + this.seatPrice + (this.fareTotal * this.numberOfTravellers));
    const cart = {
      extras: this.extras,
      perPersonFares: this.fares,
      seatSelectionLog: this.seat.seatSelectionId,
      cartTotal: grandTotal

    }
      this.scheduledFlightService.saveCart(cart).subscribe((response)=>{


               this._router.navigate(['loading']);
               setTimeout( function  myFunction(){
               location.href= 'http://localhost:4200/itinerary'
             }, 1800);


      });

  }




}
