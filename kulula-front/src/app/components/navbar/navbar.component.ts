import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],

})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    var theme = JSON.parse(localStorage.getItem('currentTheme'));
    if(theme != null){
      document.getElementById("theme").setAttribute("href", theme);
    }
  }
  onProfile(){


          var user = JSON.parse(localStorage.getItem('currentUser'));
          if(user.emailAddress != "default@default.com")
          {

            this.router.navigate(['loading']);
            setTimeout( function  myFunction(){
            location.href= 'http://localhost:4200/profile/'+ user.emailAddress
          }, 1800);


          }
          else
          {
            this.router.navigate(['login']);

          }

  }

}
