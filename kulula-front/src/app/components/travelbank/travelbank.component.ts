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

  constructor(private _router: Router, private scheduledFlightService: ScheduledFlightService) { }

  ngOnInit() {

    this.scheduledFlightService.getTravelBank().subscribe((res)=>{
      this.currentBalance = res[0].currentBalance;
      console.log(res);

    });

  }
  back(){

  var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this._router.navigate(['profile/'+ _currentUser.emailAddress]);

  }

}
