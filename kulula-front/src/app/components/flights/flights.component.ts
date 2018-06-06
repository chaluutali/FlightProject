import { Component, OnInit } from '@angular/core';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import {ScheduledFlight} from './scheduled-flight';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.css'],
  providers: [ScheduledFlightService]
})
export class FlightsComponent implements OnInit {
  private scheduledFlights: ScheduledFlight[];
  tripType: string;

  userFlight: any;
  id: number;

  departureDate: Date;
  returnDate: Date;

  td: any;
  constructor(private scheduledFlightService: ScheduledFlightService, private _router: Router) { }

  ngOnInit() {
     var theme = JSON.parse(localStorage.getItem('currentTheme'));
     if(theme != null){
       document.getElementById("theme").setAttribute("href", theme);
     }

     var d = new Date(),
     month = '' + (d.getMonth() + 1),
     day = '' + d.getDate(),
     year = d.getFullYear();
     if (month.length < 2) month = '0' + month;
     if (day.length < 2) day = '0' + day;
     var today = [year, month, day].join('-')
     this.td = today;
     document.getElementById("datefield").setAttribute("min", today);

    localStorage.removeItem('cartDB');
    localStorage.removeItem('selectedFlight');
    localStorage.removeItem('traveller');
    localStorage.removeItem('extrasDB');
    localStorage.removeItem('faresDB');
    localStorage.removeItem('seatDB');
    localStorage.removeItem('userFlightDB');

    console.log(localStorage.getItem('cartDB'));
    console.log(localStorage.getItem('selectedFlight'));
    console.log(localStorage.getItem('traveller'));
    console.log(localStorage.getItem('extrasDB'));
    console.log(localStorage.getItem('faresDB'));
    console.log(localStorage.getItem('seatDB'));
    console.log(localStorage.getItem('userFlightDB'));
    console.log(localStorage.getItem('currentUser'));
    console.log(localStorage.getItem('searchLogDateId'));
    console.log(localStorage.getItem('flightSearchForm'));
    var _searchForm = JSON.parse(localStorage.getItem('flightSearchForm'));

   this.scheduledFlightService.getAllFlightsBySearch(_searchForm).subscribe((scheduledFlightsResult)=>{

   this.scheduledFlights = scheduledFlightsResult;

   });



  }

  showReturnDate() {

        document.getElementById("returnDate").setAttribute("style", "display:block");


}

  standardSelected(id){
    this.scheduledFlightService.getFlight(id).subscribe((result)=>{


      const selectedFlight = {
        carrierName: result.carrierName,
        flightNumber: result.flightNumber,
        airCraftType: result.airCraftType,
        departureDate: result.departureDate,
        departureFrom: result.departureFrom,
        arrivalTime: result.arrivalTime,
        arrivalDestination: result.arrivalDestination,
        fare_Type: "Standard",
        estimatedTimeOfArrival: result.estimatedTimeOfArrival,
        economyPriceStandard: result.economyPriceStandard,
        economyPriceSemiFlex: 0,
        economyPriceFullyFlex: 0,
        businessPrice: 0

      }
          this.scheduledFlightService.selectFlight(selectedFlight).subscribe((res)=>{
          this.scheduledFlightService.getFlightBySearchLog().subscribe((response2)=>{

          this.userFlight = response2;
          localStorage.setItem('userFlightDB', JSON.stringify(this.userFlight));

          this.scheduledFlightService.getFare(1).subscribe((response)=>{

            const fares = {

              fareType: "Standard",
              scheduledFlight: this.userFlight
                          }
                          const faresLocal = {

                              fareType: "Standard",
                              scheduledFlight: this.userFlight,
                              numberOfCheckedBaggage: response.numberOfCheckedBaggage,
                              preFlightCancellationFee: response.preFlightCancellationFee,
                              flightChangesFee: response.flightChangesFee,
                              fareTotal: response.fareTotal,
                              valueAddedTax: response.valueAddedTax,
                              passengerSafetyCharge: response.passengerSafetyCharge,
                              passengerSecurityCharge: response.passengerSecurityCharge,
                              passengerServiceCharge: response.passengerServiceCharge,
                              fuelSurCharge: response.fuelSurCharge


                            }
                  localStorage.setItem('fares', JSON.stringify(faresLocal));
                  this.scheduledFlightService.addPerPersonFares(fares).subscribe((res)=>{

                    this._router.navigate(['loading']);
                    setTimeout( function  myFunction(){
                    location.href= 'http://localhost:4200/traveller'
                  }, 1800);


          });
      });
    });
  });
});
}

  semiSelected(id){
  this.scheduledFlightService.getFlight(id).subscribe((result)=>{


    const selectedFlight = {
      carrierName: result.carrierName,
      flightNumber: result.flightNumber,
      airCraftType: result.airCraftType,
      departureDate: result.departureDate,
      departureFrom: result.departureFrom,
      arrivalTime: result.arrivalTime,
      arrivalDestination: result.arrivalDestination,
      fare_Type: "Semi Flex",
      estimatedTimeOfArrival: result.estimatedTimeOfArrival,
      economyPriceStandard: 0,
      economyPriceSemiFlex: result.economyPriceSemiFlex,
      economyPriceFullyFlex: 0,
      businessPrice: 0

    }
        this.scheduledFlightService.selectFlight(selectedFlight).subscribe((res)=>{
        this.scheduledFlightService.getFlightBySearchLog().subscribe((response2)=>{

        this.userFlight = response2;
        localStorage.setItem('userFlightDB', JSON.stringify(this.userFlight));
        this.scheduledFlightService.getFare(2).subscribe((response)=>{

          const fares = {

            fareType: "Semi Flex",
            scheduledFlight: this.userFlight
                        }
                        const faresLocal = {

                            fareType: "Semi Flex",
                            scheduledFlight: this.userFlight,
                            numberOfCheckedBaggage: response.numberOfCheckedBaggage,
                            preFlightCancellationFee: response.preFlightCancellationFee,
                            flightChangesFee: response.flightChangesFee,
                            fareTotal: response.fareTotal,
                            valueAddedTax: response.valueAddedTax,
                            passengerSafetyCharge: response.passengerSafetyCharge,
                            passengerSecurityCharge: response.passengerSecurityCharge,
                            passengerServiceCharge: response.passengerServiceCharge,
                            fuelSurCharge: response.fuelSurCharge


                          }
                localStorage.setItem('fares', JSON.stringify(faresLocal));
                this.scheduledFlightService.addPerPersonFares(fares).subscribe((res)=>{

                  this._router.navigate(['loading']);
                  setTimeout( function  myFunction(){
                  location.href= 'http://localhost:4200/traveller'
                }, 1800);


        });
    });
  });
});
});
}

fullySelected(id){
this.scheduledFlightService.getFlight(id).subscribe((result)=>{


  const selectedFlight = {
    carrierName: result.carrierName,
    flightNumber: result.flightNumber,
    airCraftType: result.airCraftType,
    departureDate: result.departureDate,
    departureFrom: result.departureFrom,
    arrivalTime: result.arrivalTime,
    arrivalDestination: result.arrivalDestination,
    fare_Type: "Fully Flex",
    estimatedTimeOfArrival: result.estimatedTimeOfArrival,
    economyPriceStandard: 0,
    economyPriceSemiFlex: 0,
    economyPriceFullyFlex: result.economyPriceFullyFlex,
    businessPrice: 0

  }
      this.scheduledFlightService.selectFlight(selectedFlight).subscribe((res)=>{
      this.scheduledFlightService.getFlightBySearchLog().subscribe((response2)=>{

      this.userFlight = response2;
      localStorage.setItem('userFlightDB', JSON.stringify(this.userFlight));
      this.scheduledFlightService.getFare(3).subscribe((response)=>{

        const fares = {

          fareType: "Fully Flex",
          scheduledFlight: this.userFlight
                      }
                      const faresLocal = {

                          fareType: "Fully Flex",
                          scheduledFlight: this.userFlight,
                          numberOfCheckedBaggage: response.numberOfCheckedBaggage,
                          preFlightCancellationFee: response.preFlightCancellationFee,
                          flightChangesFee: response.flightChangesFee,
                          fareTotal: response.fareTotal,
                          valueAddedTax: response.valueAddedTax,
                          passengerSafetyCharge: response.passengerSafetyCharge,
                          passengerSecurityCharge: response.passengerSecurityCharge,
                          passengerServiceCharge: response.passengerServiceCharge,
                          fuelSurCharge: response.fuelSurCharge


                        }
              localStorage.setItem('fares', JSON.stringify(faresLocal));
              this.scheduledFlightService.addPerPersonFares(fares).subscribe((res)=>{

                this._router.navigate(['loading']);
                setTimeout( function  myFunction(){
                location.href= 'http://localhost:4200/traveller'
              }, 1800);


      });
  });
});
});
});
}

businessSelected(id){
this.scheduledFlightService.getFlight(id).subscribe((result)=>{


  const selectedFlight = {
    carrierName: result.carrierName,
    flightNumber: result.flightNumber,
    airCraftType: result.airCraftType,
    departureDate: result.departureDate,
    departureFrom: result.departureFrom,
    arrivalTime: result.arrivalTime,
    arrivalDestination: result.arrivalDestination,
    fare_Type: "Business",
    estimatedTimeOfArrival: result.estimatedTimeOfArrival,
    economyPriceStandard: 0,
    economyPriceSemiFlex: 0,
    economyPriceFullyFlex: 0,
    businessPrice: result.businessPrice

  }
      this.scheduledFlightService.selectFlight(selectedFlight).subscribe((res)=>{
      this.scheduledFlightService.getFlightBySearchLog().subscribe((response2)=>{

      this.userFlight = response2;
      localStorage.setItem('userFlightDB', JSON.stringify(this.userFlight));
      this.scheduledFlightService.getFare(4).subscribe((response)=>{

        const fares = {

          fareType: "Business",
          scheduledFlight: this.userFlight
                      }
                      const faresLocal = {

                          fareType: "Business",
                          scheduledFlight: this.userFlight,
                          numberOfCheckedBaggage: response.numberOfCheckedBaggage,
                          preFlightCancellationFee: response.preFlightCancellationFee,
                          flightChangesFee: response.flightChangesFee,
                          fareTotal: response.fareTotal,
                          valueAddedTax: response.valueAddedTax,
                          passengerSafetyCharge: response.passengerSafetyCharge,
                          passengerSecurityCharge: response.passengerSecurityCharge,
                          passengerServiceCharge: response.passengerServiceCharge,
                          fuelSurCharge: response.fuelSurCharge


                        }
              localStorage.setItem('fares', JSON.stringify(faresLocal));
              this.scheduledFlightService.addPerPersonFares(fares).subscribe((res)=>{

                this._router.navigate(['loading']);
                setTimeout( function  myFunction(){
                location.href= 'http://localhost:4200/traveller'
              }, 1800);


      });
  });
});
});
});
}

onUpdate(){

  const searchlog = {

    departureDate: this.departureDate,
    returnDate: this.returnDate

  }
  this.scheduledFlightService.getAllFlightsBySearchUpdate(searchlog).subscribe((res)=>{

    this.scheduledFlights = res;

  });

}



}
