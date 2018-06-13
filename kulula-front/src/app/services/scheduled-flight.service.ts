import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders, HttpResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Injectable()
export class ScheduledFlightService {

  constructor(private httpClient: HttpClient) { }


  getAllFlights(): Observable<any> {
    var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
       return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+ _searchLogDateId +'/flight/all',{headers: headers})

}
getAllFlightsBySearch(searchlog): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+ _searchLogDateId +'/search', JSON.stringify(searchlog),{headers: headers})

}

getFlight(id): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+id,{headers: headers})

}
getFlightBySearchLog(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight',{headers: headers})

}

selectFlight(scheduledFlight): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/selection', JSON.stringify(scheduledFlight),{headers: headers})

}
getExtras(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/extras/1',{headers: headers})

}


submitExtras(extras): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/extras', JSON.stringify(extras),{headers: headers})

}
addPerPersonFares(fares): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/fares',  JSON.stringify(fares),{headers: headers})

}
getFare(id): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/fares/' + id ,{headers: headers})

}
getClientExtras(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/extras',{headers: headers})

}
getClientFares(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/fares',{headers: headers})

}
deleteItinerary(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.delete('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/flightItinerary/'+_searchLogDateId,{headers: headers})

}
getItinerarys(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/flightitinerary/byemail',{headers: headers})


}

saveItinerary(Itinerary): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/flightitinerary', JSON.stringify(Itinerary),{headers: headers})

}
saveCart(cart): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/cart', JSON.stringify(cart),{headers: headers})

}
getClientCart(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/cart',{headers: headers})

}
deleteClientCart(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.delete('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/cart/bysearchlog',{headers: headers})

}
getCards(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/cards',{headers: headers})


}
payForFlight(card): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/flightItinerary/'+_searchLogDateId+'/card', JSON.stringify(card),{headers: headers})

}
saveTravelBank(travelbank): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/flightItinerary/'+_searchLogDateId+'/travelbank', JSON.stringify(travelbank),{headers: headers})

}
getTravelBank(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/flightitinerary/'+_searchLogDateId+'/travelbank',{headers: headers})


}
getTravelBankByUserEmail(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/byemail',{headers: headers})


}
addFundsToTravelBank(travelbank): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/travelbank',JSON.stringify(travelbank),{headers: headers})


}
getSeatLog(): Observable<any> {
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/aircraft/1',{headers: headers})

}
submitSeat(seat): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/seatselectionlog', JSON.stringify(seat),{headers: headers})

}
getSeatByLogDate(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/seatselectionlog',{headers: headers})

}
getSeatById(id): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/seatselectionlog/'+id,{headers: headers})

}
removeSeat(): Observable<any>{
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.delete('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/seatselectionlog/bysearchlogdate',{headers: headers})
}
getAllAirports(): Observable<any> {
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.httpClient.get('http://localhost:8080/airport',{headers: headers})

}
getAllFlightsBySearchUpdate(searchlog): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+ _searchLogDateId +'/searchbyreturn', JSON.stringify(searchlog),{headers: headers})

}
removeExtras(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var _searchLogDateId = JSON.parse(localStorage.getItem('searchLogDateId'));
  var _userFlight = JSON.parse(localStorage.getItem('userFlightDB'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.delete('http://localhost:8080/user/'+_currentUser.emailAddress+'/searchlog/'+_searchLogDateId+'/flight/'+_userFlight.scheduledFlightId+'/extras/bysearchlog',{headers: headers})

}
getAllMail(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/fanmail',{headers: headers})


}
getAllMails(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/fanmails',{headers: headers})


}
getAllMailSent(): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.get('http://localhost:8080/user/'+_currentUser.emailAddress+'/fanmail/sent',{headers: headers})


}
sendMail(fanmail): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.post('http://localhost:8080/user/'+_currentUser.emailAddress+'/fanmail',JSON.stringify(fanmail),{headers: headers})


}
updateMail(fanmail): Observable<any> {
  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  let headers = new HttpHeaders({'Content-Type': 'application/json'});
     return this.httpClient.put('http://localhost:8080/user/'+_currentUser.emailAddress+'/fanmail/'+fanmail.fanmailId,JSON.stringify(fanmail),{headers: headers})


}

}
