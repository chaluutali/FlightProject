import {ValidateService} from '../../services/validate.service';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import{FlashMessagesService}from 'angular2-flash-messages';
import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-traveller-form',
  templateUrl: './traveller-form.component.html',
  styleUrls: ['./traveller-form.component.css'],
  providers: [ScheduledFlightService]
})
export class TravellerFormComponent implements OnInit {

  firstName: String = '';
  lastName: String = '';
  emailAddress: String = '';
  gender: boolean;
  mobileNumber: String = '';
  dateOfBirth: Date;
  traveller2: any;
  travellerList = [];
  travellerCount: number = 0;
  showContinue: boolean = false;
  showSubmit: boolean = true;

  currentTravelEmail: String;

  constructor(private validateService: ValidateService,private scheduledFlightService: ScheduledFlightService, private flashMessagesService: FlashMessagesService, private userDataService: UserDataService, private _router: Router) { }

  ngOnInit() {

           document.getElementById("myDiv").style.display = "block";

           var d = new Date(),
           month = '' + (d.getMonth() + 1),
           day = '' + d.getDate(),
           year = d.getFullYear();
           if (month.length < 2) month = '0' + month;
           if (day.length < 2) day = '0' + day;
           var today = [year, month, day].join('-')
           document.getElementById("datefield").setAttribute("max", today);


    console.log(localStorage.getItem('cartDB'));
    console.log(localStorage.getItem('traveller'));
    console.log(localStorage.getItem('extrasDB'));
    console.log(localStorage.getItem('seatDB'));
    console.log(localStorage.getItem('userFlightDB'));
    console.log(localStorage.getItem('flightSearchForm'));






  }

  onSubmit(){
    var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
    this.currentTravelEmail = (this.emailAddress + _searchLogDateId);
    localStorage.setItem('currentTravelEmail', JSON.stringify(this.currentTravelEmail));
    const traveller = {
      firstName: this.firstName,
      lastName: this.lastName,
      emailAddress: this.emailAddress,
      gender: this.gender,
      mobileNumber: this.mobileNumber,
      dateOfBirth: this.dateOfBirth,

    }

  //  Required fields
    if(!this.validateService.validateRegister(traveller)){
    this.flashMessagesService.show('please fill in all fields!', {cssClass: 'alert-danger', timeout: 3000});
    return false;
  }

  if(!this.validateService.validateFirstName(traveller.firstName)){
    this.flashMessagesService.show('please fill in a valid First Name!', {cssClass: 'alert-danger', timeout: 3000});
    return false;

    }
    if(!this.validateService.validateLastName(traveller.lastName)){
      this.flashMessagesService.show('please fill in a valid Last Name!', {cssClass: 'alert-danger', timeout: 3000});
      return false;
    }

    if(!this.validateService.validateMobileNumber(traveller.mobileNumber)){
      this.flashMessagesService.show('please fill in a valid Mobile Number!', {cssClass: 'alert-danger', timeout: 3000});
      return false;

    }



    //submitdetail
    var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));
    if(_searchForm.numberOfAdults == null){_searchForm.numberOfAdults = 0;}
    console.log(_searchForm.numberOfAdults);
    if(_searchForm.numberOfInfants == null){_searchForm.numberOfInfants = 0;}
    console.log(_searchForm.numberOfInfants);
    if(_searchForm.numberOfChildren == null){_searchForm.numberOfChildren = 0;}
    console.log(_searchForm.numberOfChildren);
    var totalTravellers = _searchForm.numberOfAdults + _searchForm.numberOfInfants + _searchForm.numberOfChildren;
    console.log(totalTravellers);
    if(this.travellerCount != totalTravellers)
    {
      this.userDataService.submitTravellerDetails(traveller).subscribe(result=>{


              this.travellerList.push(traveller);
              this.firstName = '';
              this.lastName = '';
              this.emailAddress = '';
              this.gender = false;
              this.mobileNumber = '';
              this.dateOfBirth = null;
              console.log(this.travellerList);
              this.travellerCount = this.travellerCount + 1;
              if(this.travellerCount === totalTravellers)
              {
              document.getElementById("myDiv").style.display = "none";
              this.showSubmit = false;
              this.showContinue = true;
              localStorage.setItem('travellerList', JSON.stringify(this.travellerList));
              }

      });

    }
  }
  onContinue(){
    var payment = JSON.parse(localStorage.getItem('paid'));
    
    if(payment == null)
    {

          this._router.navigate(['loading']);
            setTimeout( function  myFunction(){
            location.href= 'http://localhost:4200/seat'
          }, 1800);
    }
    else
    {
            this._router.navigate(['loading']);
            setTimeout( function  myFunction(){
            location.href= 'http://localhost:4200/flightmanager'
          }, 1800);



    }




  }
  receiveMessage($event){

    this.travellerList = $event;
    this.travellerCount = this.travellerCount - 1;
    document.getElementById("myDiv").style.display = "block";
    this.showSubmit = true;
    this.showContinue = false;
    var deletedTraveller = JSON.parse(localStorage.getItem('currentTravelEmail'));
    this.userDataService.removeTravel(deletedTraveller).subscribe((res)=>{

    });


  }




}
