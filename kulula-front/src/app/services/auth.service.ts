import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders, HttpResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Injectable()
export class AuthService {
  public token: string;

  constructor(private httpClient: HttpClient) {


   }
   login(loginUser): Observable<any> {
     let headers = new HttpHeaders({'Content-Type': 'application/json'});
        return this.httpClient.post('http://localhost:8080/login',JSON.stringify(loginUser),{headers: headers})
    }
    logout(): void {
        localStorage.removeItem('currentUser');

    }
//     getUserProfile(emailAddress):Observable<any>{
//       let headers = new HttpHeaders({'Content-Type': 'application/json'});
//        //headers.append({}
// // );
//       return this.httpClient.get('http://localhost:8080/user/'+emailAddress, {headers: headers})
//     }
}
// 'Content-Type':'application/json'
//{Authorization: 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjaGFsdUBtZW1haWwuY29tIiwicGFzc3dvcmQiOiIxMjM0In0.YXhfMmZiC5Qk9eRhUeNIrKvtlCEOA1Pi-KZhusN32uUjIcYYuzaGq8f_gBUmqgsMyVW6CCi72mSwNZVxHFOQXQ'}
