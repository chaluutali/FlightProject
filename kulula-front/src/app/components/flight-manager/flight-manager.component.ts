import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flight-manager',
  templateUrl: './flight-manager.component.html',
  styleUrls: ['./flight-manager.component.css']
})
export class FlightManagerComponent implements OnInit {
  scheduledFlight :any;
  traveller: any;
  extras: any;
  fares: any;
  cart: any;
  seat: any;


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


  firstName: string;
  lastName: string;
  emailAddress: string;
  gender: boolean;
  mobileNumber: string;
  dateOfBirth: Date;

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

  reference: any;

  constructor(private scheduledFlightService: ScheduledFlightService, private _router: Router) { }

  ngOnInit() {
      console.log(localStorage.getItem('userFlightDB'));

    this.scheduledFlightService.getClientCart().subscribe((res)=>{

          localStorage.setItem('cartDB', JSON.stringify(res));

          this.cart = JSON.parse(localStorage.getItem('cartDB'));
    this.reference = JSON.parse(localStorage.getItem('searchLogDateId'));
    this.scheduledFlight = JSON.parse(localStorage.getItem('userFlightDB'));
    this.traveller = JSON.parse(localStorage.getItem('traveller'));
    this.extras = JSON.parse(localStorage.getItem('extrasDB'));
    this.fares = JSON.parse(localStorage.getItem('faresDB'));
    this.seat = JSON.parse(localStorage.getItem('seatDB'));

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


    this.firstName = this.traveller.firstName;
    this.lastName = this.traveller.lastName;
    this.emailAddress = this.traveller.emailAddress;
    this.gender = this.traveller.gender;
    this.mobileNumber = this.traveller.mobileNumber;
    this.dateOfBirth = this.traveller.dateOfBirth;


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
    this.numberOfCheckedBaggage = this.fares.numberOfCheckedBaggage;
    this.preFlightCancellationFee = this.fares.preFlightCancellationFee;
    this.flightChangesFee = this.fares.flightChangesFee;
    this.fareTotal = this.fares.fareTotal;
    this.valueAddedTax = this.fares.valueAddedTax;
    this.passengerSafetyCharge =  this.fares.passengerSafetyCharge;
    this.passengerSecurityCharge = this.fares.passengerSecurityCharge;
    this.passengerServiceCharge2 = this.fares.passengerServiceCharge;
    this.fuelSurCharge = this.fares.fuelSurCharge;

    if (this.seat.seatType === "Back")
    {
      this.seatType = "Back (Standard)";
      this.totalSeat = this.seat.standardBackPrice;
      this.seatId = this.seat.seatId;
    }
    if (this.seat.seatType === "eRow")
    {
      this.seatType = "Exit Row (Extra legroom)";
      this.totalSeat = this.seat.exitRowPrice;
      this.seatId = this.seat.seatId;
    }
    if (this.seat.seatType === "sZone")
    {
      this.seatType = "Stretch Zone (Extra legroom)";
      this.totalSeat = this.seat.stretchZonePrice;
      this.seatId = this.seat.seatId;
    }
    if (this.seat.seatType === "Front")
    {
      this.seatType = "Front (Standard)";
      this.totalSeat = this.seat.standardFrontPrice;
      this.seatId = this.seat.seatId;
    }
    if (this.seat.seatType === "fRow")
    {
      this.seatType = "Front Row (Extra legroom)";
      this.totalSeat = this.seat.frontRowPrice;
      this.seatId = this.seat.seatId;
    }

    });

  }



}
