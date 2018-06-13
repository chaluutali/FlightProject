import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';

@Component({
  selector: 'app-travelbank',
  templateUrl: './travelbank.component.html',
  styleUrls: ['./travelbank.component.css']
})
export class TravelbankComponent implements OnInit {
  currentBalance: number;



  travellers: any;
  extras: any;
  fares: any;
  cart: any;
  seat: any;
  cards = [];
  itineraries = [];





showHistory: boolean = false;
showAddFunds: boolean = false;
showCards: boolean = false;
numberOfCards: number;
numberOfItineraries: number;

fund: number = 0;

  constructor(private _router: Router, private scheduledFlightService: ScheduledFlightService) { }

  ngOnInit() {

    this.scheduledFlightService.getTravelBankByUserEmail().subscribe((res)=>{
      this.currentBalance = res.currentBalance;


      this.scheduledFlightService.getCards().subscribe((result)=>{

        this.cards = result;
        this.numberOfCards = this.cards.length;
        console.log(this.cards);

        this.scheduledFlightService.getItinerarys().subscribe((response)=>{

          this.itineraries = response;

          this.numberOfItineraries = this.itineraries.length;
          console.log(this.itineraries);

        });



      });
    });

  }
  back(){

  var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this._router.navigate(['profile/'+ _currentUser.emailAddress]);

  }
  viewHistory(){
  this.showHistory = true;
  this.showCards = false;
  this.showAddFunds = false;

  }
  viewCard(){

    this.showHistory = false;
    this.showCards = true;
    this.showAddFunds = false;

  }
  viewFunds(){
    this.showAddFunds = true;
    this.showCards = false;
    this.showHistory = false;
  }
  purchaseCredit(){

          const travelbank = {
            currentBalance: this.fund,
          }

    this.scheduledFlightService.addFundsToTravelBank(travelbank).subscribe((res)=>{

      this.scheduledFlightService.getTravelBankByUserEmail().subscribe((result)=>{

        this.currentBalance = result.currentBalance;
        this.showAddFunds = false;
        this.showCards = false;
        this.showHistory = false;
        this.fund = 0;

        });

    });



  }

}
