import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'seatType'
})
export class SeatTypePipe implements PipeTransform {

  transform(value: any, args?: any): any {

    if (value === "Back")
      {
        return "Standard (Back)";


      }
    if (value === "eRow")
      {
        return "Exit Row (Extra Legroom)";


      }
    if (value === "sZone")
        {
        return "Stretch Zone (Extra Legroom)";


        }
    if (value === "Front")
        {
        return "Standard (Front)";

        }
    if (value === "fRow")
        {
         return "Front Row (Extra Legroom)";

        }


    return null;
  }

}
