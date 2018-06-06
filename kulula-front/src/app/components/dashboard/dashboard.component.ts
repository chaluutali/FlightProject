import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }
  }

}
