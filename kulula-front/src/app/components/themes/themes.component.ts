import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.css']
})
export class ThemesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
    pulse(){

      document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/pulse/bootstrap.min.css");

    }
    simplex(){

        document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/simplex/bootstrap.min.css");

      }
      sketchy(){

          document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/sketchy/bootstrap.min.css");

        }
        literia(){

            document.getElementById("theme").setAttribute("href", "https://bootswatch.com/4/litera/bootstrap.min.css");

          }

}
