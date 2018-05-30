import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-list-of-seats',
  templateUrl: './list-of-seats.component.html',
  styleUrls: ['./list-of-seats.component.css']
})
export class ListOfSeatsComponent implements OnInit {
    @Input() listOfSeats;
    travellers: any;


  constructor() { }

  ngOnInit() {

      var listOfTravellers = JSON.parse(localStorage.getItem('travellerList'));
          this.travellers = listOfTravellers;
        

  }

}
