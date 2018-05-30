import { Component, OnInit} from '@angular/core';
import {UserDataService} from '../../services/user-data.service';
import {ValidateService} from '../../services/validate.service';
import{FlashMessagesService}from 'angular2-flash-messages';
import{Router} from '@angular/router';
@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css'],
  providers: [UserDataService]
})
export class ProfileEditorComponent {

  firstName: String = '';
  lastName: String = '';
  emailAddress: String = '';
  mobileNumber: String = '';
  dateOfBirth: Date;
  userName: String = '';
  gender: String = '';
  password: String ='';

    back(){

    var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
      this._router.navigate(['profile/'+ _currentUser.emailAddress]);

    }

    onSubmit(){
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
        this.userDataService.updateUser(user)
        .subscribe(user => {
          console.log(user);
        });
        this._router.navigate(['profile/'+ user.emailAddress]);

      }
  constructor(private validateService: ValidateService, private flashMessagesService: FlashMessagesService, private userDataService: UserDataService, private _router: Router) {

    var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this.userDataService.getUserProfile(_currentUser.emailAddress).subscribe((user)=>{
    this.userName = user.userName;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.emailAddress = user.emailAddress;
    this.mobileNumber = user.mobileNumber;
    this.dateOfBirth = user.dateOfBirth;
  });


}

}
