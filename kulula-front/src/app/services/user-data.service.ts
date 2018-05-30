import { Injectable } from '@angular/core';
import{Http, Response, Headers} from '@angular/http';
import'rxjs/add/operator/map';
import { AuthService } from './auth.service';


@Injectable()
export class UserDataService {


  constructor(private http: Http, private authService: AuthService) {



   }

  registerUser(user){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/user', JSON.stringify(user), {headers: headers})

  }

  getUserProfile(emailAddress){
    let headers = new Headers();
    headers.append('Content-Type','application/json');
    return this.http.get('http://localhost:8080/user/'+emailAddress, {headers: headers}).map((response: Response)=> response.json())
  }

  updateUser(user){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:8080/user/'+ user.emailAddress, JSON.stringify(user), {headers: headers})
  }

submitSearch(flightSearchForm){
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new Headers();
  headers.append('Content-Type', 'application/json');
  return this.http.post('http://localhost:8080/user/'+_currentUser.emailAddress +'/searchlog', JSON.stringify(flightSearchForm), {headers: headers})


}
submitTravellerDetails(traveller){
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new Headers();
  headers.append('Content-Type', 'application/json');
  return this.http.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/traveller', JSON.stringify(traveller), {headers: headers})


}


}
