import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,FormBuilder } from '@angular/forms';
import {RouterModule, Routes, ActivatedRoute} from '@angular/router';


import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import {AuthGuardService} from './services/auth-guard.service';
import {AuthService} from './services/auth.service';
import {ValidateService} from './services/validate.service';
import {UserDataService} from './services/user-data.service';
import {ScheduledFlightService} from './services/scheduled-flight.service';
import{FlashMessagesModule} from 'angular2-flash-messages';
import{HttpModule} from '@angular/http';
import { ProfileEditorComponent } from './components/profile-editor/profile-editor.component';
import { HttpClientModule } from '@angular/common/http';
import { FlightSearchFormComponent } from './components/flight-search-form/flight-search-form.component';
import { FlightsComponent } from './components/flights/flights.component';
import { TravellerFormComponent } from './components/traveller-form/traveller-form.component';
import { SeatSelectionLogComponent } from './components/seat-selection-log/seat-selection-log.component';
import { ExtrasComponent } from './components/extras/extras.component';
import { FlightItineraryComponent } from './components/flight-itinerary/flight-itinerary.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { CardComponent } from './components/card/card.component';
import { FlightManagerComponent } from './components/flight-manager/flight-manager.component';
import { LoaderComponent } from './components/loader/loader.component';
import { ItinerarySearchComponent } from './components/itinerary-search/itinerary-search.component';
import { Loader2Component } from './components/loader2/loader2.component';
import { FooterComponent } from './components/footer/footer.component';
import { ListOfTravellersComponent } from './components/list-of-travellers/list-of-travellers.component';
import { ListOfSeatsComponent } from './components/list-of-seats/list-of-seats.component';



const appRoutes: Routes =[
  {path: '', component: HomeComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'profile/:emailAddress', component: ProfileComponent, canActivate: [AuthGuardService]},
  {path: 'profileEditor', component: ProfileEditorComponent},
  {path: 'flightSearchForm', component: FlightSearchFormComponent},
  {path: 'flights', component: FlightsComponent},
  {path: 'traveller', component: TravellerFormComponent},
  {path: 'seat', component: SeatSelectionLogComponent},
  {path: 'extras', component: ExtrasComponent},
  {path: 'cart', component: ShoppingCartComponent },
  {path: 'itinerary', component: FlightItineraryComponent },
  {path: 'payment', component: CardComponent },
  {path: 'flightmanager', component: FlightManagerComponent },
  {path: 'loading', component: LoaderComponent },
  {path: 'manageflightitinerary', component: ItinerarySearchComponent },
  {path: 'loading2', component: Loader2Component }


]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    DashboardComponent,
    ProfileComponent,
    ProfileEditorComponent,
    FlightSearchFormComponent,
    FlightsComponent,
    TravellerFormComponent,
    SeatSelectionLogComponent,
    ExtrasComponent,
    FlightItineraryComponent,
    ShoppingCartComponent,
    CardComponent,
    FlightManagerComponent,
    LoaderComponent,
    ItinerarySearchComponent,
    Loader2Component,
    FooterComponent,
    ListOfTravellersComponent,
    ListOfSeatsComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FlashMessagesModule.forRoot()

  ],
  providers: [ValidateService, UserDataService, AuthGuardService, AuthService, ScheduledFlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
