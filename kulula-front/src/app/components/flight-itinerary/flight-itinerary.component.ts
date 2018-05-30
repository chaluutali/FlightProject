import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flight-itinerary',
  templateUrl: './flight-itinerary.component.html',
  styleUrls: ['./flight-itinerary.component.css'],
  providers: [ScheduledFlightService]
})
export class FlightItineraryComponent implements OnInit {
  scheduledFlight :any;
  travellers: any;
  extras: any;
  fares: any;
  cart: any;
  seat: any;


  firstName: String = '';
  lastName: String = '';
  emailAddress: String = '';
  gender: boolean;
  mobileNumber: String = '';
  dateOfBirth: Date;

  flightNumber: number;
  carrierName: string;
  airCraftType: string;
  departureDate: Date;
  departureFrom: string;
  arrivalTime: Date;
  arrivalDestination: string;
  fare_Type: string;
  estimatedTimeOfArrival: Date;
  economyPriceStandard: number;
  economyPriceSemiFlex: number;
  economyPriceFullyFlex: number;
  businessPrice: number;




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
  seatPrices: any;




  constructor(private scheduledFlightService: ScheduledFlightService, private _router: Router) { }

  ngOnInit() {


    this.scheduledFlightService.getClientCart().subscribe((res)=>{

          localStorage.setItem('cartDB', JSON.stringify(res));

          this.cart = JSON.parse(localStorage.getItem('cartDB'));

    this.scheduledFlight = JSON.parse(localStorage.getItem('userFlightDB'));
    this.travellers = JSON.parse(localStorage.getItem('travellerList'));
    console.log(this.travellers);
    this.extras = JSON.parse(localStorage.getItem('extrasDB'));
    this.fares = JSON.parse(localStorage.getItem('faresDB'));
    this.seat = JSON.parse(localStorage.getItem('seatList'));
    this.seatPrices = JSON.parse(localStorage.getItem('seatPrices'));

    this.flightNumber = this.scheduledFlight.flightNumber;
    this.carrierName = this.scheduledFlight.carrierName;
    this.airCraftType = this.scheduledFlight.airCraftType;
    this.departureDate = this.scheduledFlight.departureDate;
    this.departureFrom = this.scheduledFlight.departureFrom;
    this.arrivalTime = this.scheduledFlight.arrivalTime;
    this.arrivalDestination = this.scheduledFlight.arrivalDestination;
    this.fare_Type = this.scheduledFlight.fare_Type;
    this.estimatedTimeOfArrival = this.scheduledFlight.estimatedTimeOfArrival;
    this.economyPriceStandard = this.scheduledFlight.economyPriceStandard;
    this.economyPriceSemiFlex = this.scheduledFlight.economyPriceSemiFlex;
    this.economyPriceFullyFlex = this.scheduledFlight.economyPriceFullyFlex;
    this.businessPrice = this.scheduledFlight.businessPrice;





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

    this.fareType = this.fares.fareType;
    this.numberOfTravellers = this.travellers.length;
    this.numberOfCheckedBaggage = this.fares.numberOfCheckedBaggage;
    this.preFlightCancellationFee = this.fares.preFlightCancellationFee;
    this.flightChangesFee = this.fares.flightChangesFee;
    this.fareTotal = this.fares.fareTotal;
    this.valueAddedTax = this.fares.valueAddedTax;
    this.passengerSafetyCharge =  this.fares.passengerSafetyCharge;
    this.passengerSecurityCharge = this.fares.passengerSecurityCharge;
    this.passengerServiceCharge2 = this.fares.passengerServiceCharge;
    this.fuelSurCharge = this.fares.fuelSurCharge;


    this.fRowPrice = this.seatPrices.frontRowPrice;
    this.frontPrice = this.seatPrices.standardFrontPrice;
    this.eRowPrice = this.seatPrices.exitRowPrice;
    this.sZonePrice = this.seatPrices.stretchZonePrice;
    this.backPrice = this.seatPrices.standardBackPrice;

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
  }
  submitReview(){
    var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
    const flightItinerary = {
      bookingReference:  _searchLogDateId,
      shoppingCart: this.cart
    }
    this.scheduledFlightService.saveItinerary(flightItinerary).subscribe((result)=>{

      this._router.navigate(['loading']);
      setTimeout( function  myFunction(){
      location.href= 'http://localhost:4200/payment'
    }, 1800);

    });


  }

}
