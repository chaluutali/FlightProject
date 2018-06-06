import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.css']
})
export class ThemesComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
    console.log(localStorage.getItem('currentUser'));
    document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/lumen/bootstrap.min.css");
    var theme = "https://bootswatch.com/4/lumen/bootstrap.min.css";
    localStorage.setItem('currentTheme', JSON.stringify(theme));
  }
    pulse(){

      document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/pulse/bootstrap.min.css");
      var theme = "https://bootswatch.com/4/pulse/bootstrap.min.css";
      localStorage.setItem('currentTheme', JSON.stringify(theme));
      console.log(theme);

    }
    simplex(){

        document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/simplex/bootstrap.min.css");
        var theme = "https://bootswatch.com/4/simplex/bootstrap.min.css";
        localStorage.setItem('currentTheme', JSON.stringify(theme));
        console.log(theme);
      }
      sketchy(){

          document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/sketchy/bootstrap.min.css");
          var theme = "https://bootswatch.com/4/sketchy/bootstrap.min.css";
          localStorage.setItem('currentTheme', JSON.stringify(theme));
          console.log(theme);
        }
        literia(){


            document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/litera/bootstrap.min.css");
            var theme = "https://bootswatch.com/4/litera/bootstrap.min.css";
            localStorage.setItem('currentTheme', JSON.stringify(theme));
            console.log(theme);

          }
          back(){

          var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
            this._router.navigate(['profile/'+ _currentUser.emailAddress]);

          }

}
