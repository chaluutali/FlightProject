import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }
  }

}
