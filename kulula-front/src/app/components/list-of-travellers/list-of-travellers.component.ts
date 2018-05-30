import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-list-of-travellers',
  templateUrl: './list-of-travellers.component.html',
  styleUrls: ['./list-of-travellers.component.css']
})
export class ListOfTravellersComponent implements OnInit {
  @Input() listLength;
  reduceCount: number = 0;
  constructor() { }

  ngOnInit() {
  }
  onEdit(i){
    this.reduceCount = 1;
    this.listLength.splice(i,1);
  }

}
