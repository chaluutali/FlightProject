import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailAddress: string = '';
  password: string ='';

  constructor(private router: Router,
        private authService: AuthService) {
        //  var currentUser = JSON.parse(localStorage.getItem('currentUser'));
         }

  ngOnInit() {
    // reset login status
        this.authService.logout();
  }
  login2() {
    const loginUser = {
      emailAddress: this.emailAddress,
      password: this.password

    }

        this.authService.login(loginUser)
            .subscribe(result => {
               if (result == null){


                  this.router.navigate(['login']);
               }

                    this.router.navigate(['loading']);
                    // localStorage.setItem('currentUser', result);
                    setTimeout( function  myFunction(){
                    location.href= 'http://localhost:4200/profile/'+ loginUser.emailAddress
                  }, 1800);


            });
    }




}