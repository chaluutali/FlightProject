import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';

@Component({
  selector: 'app-fanmail',
  templateUrl: './fanmail.component.html',
  styleUrls: ['./fanmail.component.css']
})
export class FanmailComponent implements OnInit {


  messages = [];
  user = [];
  currentView: string;

  showInbox: boolean = true;
  showComposer: boolean = false;


  receiver: string;
  subject: string;
  message: string;
  constructor(private _router: Router, private scheduledFlightService: ScheduledFlightService) { }

  ngOnInit() {

    this.currentView = "Inbox";
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.user);



    this.scheduledFlightService.getAllMail().subscribe((res)=>{

      this.messages = res;

      console.log(this.messages);



    });



  }
  back(){

  var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this._router.navigate(['profile/'+ _currentUser.emailAddress]);

  }
  compose(){
this.currentView = "Compose"
this.showInbox = false;
this.showComposer = true;

  }
  viewInbox(){

    this.currentView = "Inbox";
    this.showInbox = true;
    this.showComposer = false;

  }
  onSend(){

    


  }

}
