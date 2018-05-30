import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import { Router } from '@angular/router';
import{FlashMessagesService}from 'angular2-flash-messages';


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  nameOnCard: string;
	expirationDate: Date;
	cvv: string;
	billingAddress: string;
	country: string;
	city: string;
	zipCode: string;
	cardNumber: number;

  constructor(private scheduledFlightService: ScheduledFlightService, private _router: Router, private flashMessagesService: FlashMessagesService) { }

  ngOnInit() {

    var d = new Date(),
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var today = [year, month, day].join('-')
    document.getElementById("datefield").setAttribute("min", today);

  }
  makePayment(){

    const card = {

      nameOnCard: this.nameOnCard,
      expirationDate: this.expirationDate,
      cvv: this.cvv,
      billingAddress: this.billingAddress,
      country: this.country,
      city: this.city,
      zipCode: this.zipCode,
      cardNumber: this.cardNumber

    }

    this.scheduledFlightService.payForFlight(card).subscribe((result)=>{

      this._router.navigate(['loading']);
      setTimeout( function  myFunction(){
      location.href= 'http://localhost:4200/flightmanager'
    }, 1800);


    });

  }

}
