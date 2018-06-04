import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userDataService: UserDataService) { }

  ngOnInit() {
    console.log(localStorage.getItem('cartDB'));
    console.log(localStorage.getItem('selectedFlight'));
    console.log(localStorage.getItem('traveller'));
    console.log(localStorage.getItem('extrasDB'));
    console.log(localStorage.getItem('faresDB'));
    console.log(localStorage.getItem('seatDB'));
    console.log(localStorage.getItem('userFlightDB'));
    console.log(localStorage.getItem('searchLogDateId'));
    console.log(localStorage.getItem('flightSearchForm'));



      var user = JSON.parse(localStorage.getItem('currentUser'));
      if(user.emailAddress != "default@default.com")
      {


        console.log(localStorage.getItem('currentUser'));
      }
      else
      {

        this.userDataService.getUserProfile("default@default.com").subscribe((result)=>{

        localStorage.setItem('currentUser', JSON.stringify(result));
        console.log(JSON.parse(localStorage.getItem('currentUser')));

      });


      }




  }

}
