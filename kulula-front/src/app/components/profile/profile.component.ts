import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import{ActivatedRoute} from '@angular/router';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  providers: [UserDataService]
})
export class ProfileComponent {
  firstName: String = '';
  lastName: String = '';
  emailAddress: String = '';
  gender: String = '';
  mobileNumber: String = '';
  dateOfBirth: Date;
  userName: String ='';
  password: String ='';

  constructor( private userDataService: UserDataService, private route: ActivatedRoute, private router: Router,
        private authService: AuthService) {


          localStorage.removeItem('cartDB');
          localStorage.removeItem('selectedFlight');
          localStorage.removeItem('traveller');
          localStorage.removeItem('extrasDB');
          localStorage.removeItem('faresDB');
          localStorage.removeItem('seatDB');
          localStorage.removeItem('userFlightDB');
          localStorage.removeItem('searchLogDateId');
          localStorage.removeItem('flightSearchForm');
          localStorage.removeItem('fares');


          console.log(localStorage.getItem('cartDB'));
          console.log(localStorage.getItem('selectedFlight'));
          console.log(localStorage.getItem('traveller'));
          console.log(localStorage.getItem('extrasDB'));
          console.log(localStorage.getItem('faresDB'));
          console.log(localStorage.getItem('seatDB'));
          console.log(localStorage.getItem('userFlightDB'));
          console.log(localStorage.getItem('searchLogDateId'));
          console.log(localStorage.getItem('flightSearchForm'));
          console.log(localStorage.getItem('fares'));




    this.userDataService.getUserProfile(this.route.snapshot.params.emailAddress).subscribe((user)=>{

    localStorage.setItem('currentUser', JSON.stringify(user));
    console.log(JSON.parse(localStorage.getItem('currentUser')));

    this.userName = user.userName;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.emailAddress = user.emailAddress;
    this.mobileNumber = user.mobileNumber;
    this.dateOfBirth = user.dateOfBirth;
    if(user.gender == true){ this.gender = 'Male';}else{this.gender = 'Female';}
  });
   }
   logout(): void {

     this.authService.logout();
     this.router.navigate(['login']);

    }

}
