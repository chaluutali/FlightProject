import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
@Injectable()
export class AuthGuardService implements CanActivate {

  constructor() { }
  canActivate() {
      //return this.authService.isLoggedIn();
      //if (localStorage.getItem('currentUser') == null) {
            // logged in so return true
          //  this.router.navigate(['login']);
             return true;
          }

            //return false;
    }
