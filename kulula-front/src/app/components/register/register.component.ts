import {ValidateService} from '../../services/validate.service';
import{FlashMessagesService}from 'angular2-flash-messages';
import { Component, OnInit } from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [UserDataService]
})
export class RegisterComponent implements OnInit {

  firstName: String = '';
  lastName: String = '';
  emailAddress: String = '';
  gender: boolean;
  mobileNumber: String = '';
  dateOfBirth: Date;
  userName: String ='';
  password: String ='';



  constructor(private validateService: ValidateService, private flashMessagesService: FlashMessagesService, private userDataService: UserDataService, private _router: Router ) {

   }

  ngOnInit() {


  }

  back(){
    this._router.navigate(['login']);
  }

  onRegisterSubmit(){

    const user = {
      firstName: this.firstName,
      lastName: this.lastName,
      emailAddress: this.emailAddress,
      gender: this.gender,
      mobileNumber: this.mobileNumber,
      dateOfBirth: this.dateOfBirth,
      userName: this.userName,
      password: this.password

    }

  //  Required fields
    if(!this.validateService.validateRegister(user)){
    this.flashMessagesService.show('please fill in all fields!', {cssClass: 'alert-danger', timeout: 3000});
    return false;
  }

  if(!this.validateService.validateFirstName(user.firstName)){
    this.flashMessagesService.show('please fill in a valid First Name!', {cssClass: 'alert-danger', timeout: 3000});
    return false;

    }
    if(!this.validateService.validateLastName(user.lastName)){
      this.flashMessagesService.show('please fill in a valid Last Name!', {cssClass: 'alert-danger', timeout: 3000});
      return false;
    }

    if(!this.validateService.validateMobileNumber(user.mobileNumber)){
      this.flashMessagesService.show('please fill in a valid Mobile Number!', {cssClass: 'alert-danger', timeout: 3000});
      return false;

    }
    if(!this.validateService.validateUserName(user.userName)){
        this.flashMessagesService.show('please fill in a valid User Name!', {cssClass: 'alert-danger', timeout: 3000});
        return false;
    }
    //submitdetail
    this.userDataService.registerUser(user)
    .subscribe(user => {
        this.flashMessagesService.show('Congratulations You have successfully registered your User Account!', {cssClass: 'alert-success', timeout: 5000});

    });

    this._router.navigate(['login']);


  }



}
