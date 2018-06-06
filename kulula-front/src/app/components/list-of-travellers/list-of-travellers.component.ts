import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-list-of-travellers',
  templateUrl: './list-of-travellers.component.html',
  styleUrls: ['./list-of-travellers.component.css']
})
export class ListOfTravellersComponent implements OnInit {
  @Input() listLength;
  @Output() messageEvent = new EventEmitter<any>();
  reduceCount: number = 0;
  message: any;
  constructor() { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }
  }
  onEdit(i){
    this.reduceCount = 1;
    console.log(this.listLength[i].emailAddress);
    localStorage.setItem('currentTravelEmail', JSON.stringify(this.listLength[i].emailAddress));
    this.listLength.splice(i,1);
    console.log(this.listLength);
    localStorage.setItem('travellerList', JSON.stringify(this.listLength));
    this.messageEvent.emit(this.listLength);
  }

}
