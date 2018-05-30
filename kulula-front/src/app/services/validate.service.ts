import { Injectable } from '@angular/core';

@Injectable()
export class ValidateService {

  constructor() { }
  validateRegister(user){
  if(user.firstName == '' || user.lastName == '' || user.emailAddress == '' || user.gender == '' || user.mobileNumber == '' || user.dateOfBirth == '' || user.userName == '' || user.password == ''){
    return false;
  } else {
    return true;
  }
}

validateEmailAddress(emailAddress){
  const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(emailAddress);
}
validateFirstName(firstName){
  const re = /^[A-Za-z]+$/
  return re.test(firstName);
}
validateLastName(lastName){
  const re = /^[A-Za-z]+$/
  return re.test(lastName);
}
validateMobileNumber(mobileNumber){
  const re = /^\d{10}$/
  return re.test(mobileNumber);
}
validateUserName(userName){
  const re = /^[A-Za-z]+$/
  return re.test(userName);
}



}
