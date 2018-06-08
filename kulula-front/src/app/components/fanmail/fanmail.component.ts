import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';

@Component({
  selector: 'app-fanmail',
  templateUrl: './fanmail.component.html',
  styleUrls: ['./fanmail.component.css']
})
export class FanmailComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }
  back(){

  var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this._router.navigate(['profile/'+ _currentUser.emailAddress]);

  }

}
