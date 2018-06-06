import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-list-of-seats',
  templateUrl: './list-of-seats.component.html',
  styleUrls: ['./list-of-seats.component.css']
})
export class ListOfSeatsComponent implements OnInit {
    @Input() listOfSeats;
    @Output() messageEvent = new EventEmitter<any>();
    reduceCount: number = 0;
    message: any;
    travellers: any;
    listOfSeats2: any;


  constructor() { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }

      var listOfTravellers = JSON.parse(localStorage.getItem('travellerList'));
          this.travellers = listOfTravellers;


  }
  onChange(i){
    this.listOfSeats2 = JSON.parse(localStorage.getItem('seatList2'));
    this.reduceCount = 1;
    console.log(i);
    localStorage.setItem('currentSeat', JSON.stringify(this.listOfSeats2[i].seatId));
    this.listOfSeats2.splice(i,1);
    console.log(this.listOfSeats2);
    localStorage.setItem('seatList', JSON.stringify(this.listOfSeats2));
    this.messageEvent.emit(this.listOfSeats2);
  }

}
