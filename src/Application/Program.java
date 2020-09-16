package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Model.Entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner          sc  = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//-----------------------------------------------------------------------------------------
		//  Variables 
		//-----------------------------------------------------------------------------------------
		Calendar cal = Calendar.getInstance(); //assign current time to decide settlement
		int  intHORA = cal.get(Calendar.HOUR);
		int  intMINU = cal.get(Calendar.HOUR);
		int  intAMPM = cal.get(Calendar.AM_PM);
		//-----------------------------------------------------------------------------------------

		
		//-----------------------------------------------------------------------------------------
		//  print screen 
		//-----------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("*******************************************************************************");
		System.out.println("*                                                                             *");
		
		if (intAMPM == 0) {

			if ((intHORA >= 1 && intHORA <= 5 ) || (intHORA == 12 && intMINU < 60)) {
				System.out.println("*                      GOOD NIGHT  !!!!                                       *");
			} else if (intHORA > 5 && intHORA <= 11 ) {
				System.out.println("*                      GOOD MORNING  !!!!                                     *");
			}
		} else if (intAMPM == 1) {
			if ((intHORA >= 1 && intHORA <= 5 ) || (intHORA == 12 && intMINU < 60)) {
				System.out.println("*                      GOOD AFTERNOON  !!!!                                   *");
			} else if (intHORA > 5 && intHORA <= 11 ) {
				System.out.println("*                      GOOD EVENING  !!!!                                     *");
			}

		}
		 
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
		System.out.println("*                                                                             *");
		System.out.println("*                   REGISTRATION OF RESERVATION                               *");
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
		System.out.println("*                                                                             *");
		System.out.println("*                                                                             *");
		System.out.println("*  -- Enter reservation data                                                  *");  

		System.out.print(  "*     Room number................ : ");   
		int intRoomNumber = sc.nextInt();

		System.out.print(  "*     Check-in  date (dd/MM/yyyy) : ");   
		Date dteCheckIn   = sdf.parse(sc.next());

		System.out.print(  "*     Check-out date (dd/MM/yyyy) : ");   
		Date dteCheckOut  = sdf.parse(sc.next());

		if (!dteCheckOut.after(dteCheckIn)) {
			System.out.println("*                                                                             *");
			System.out.println("*   Error in reservation: Check-out date must be after check-in date !        *");  
		}
		else {
			Reservation reservation = new Reservation(intRoomNumber, dteCheckIn, dteCheckOut);
			System.out.println("*                                                                             *");
			System.out.println("*  -- Booking confirmation                                                    *");  
			System.out.println("*     " + reservation);  
			System.out.println("*                                                                             *");
			//System.out.println("*  Would you like to change your booking dates ? (y/n) : ");  

			System.out.println("*  -- Enter new reservation dates                                             *");  
			System.out.print(  "*     New check-in  date (dd/MM/yyyy) : ");   
			dteCheckIn   = sdf.parse(sc.next());

			System.out.print(  "*     New check-out date (dd/MM/yyyy) : ");   
			dteCheckOut  = sdf.parse(sc.next());

			Date dteNow = new Date();
	
			if (dteCheckIn.before(dteNow) || dteCheckOut.before(dteNow) ) {
				System.out.println("*                                                                             *");
				System.out.println("*   Error in reservation: Reservation dates for update must be future dates ! *");  
			}
			else {
				if (!dteCheckOut.after(dteCheckIn)) {
					System.out.println("*                                                                             *");
					System.out.println("*   Error in reservation: Check-out date must be after check-in date !        *");  
				}
				else {
					reservation.updateDates(dteCheckIn, dteCheckOut);

					System.out.println("*                                                                             *");
					System.out.println("*  -- Booking confirmation                                                    *");
					System.out.println("*     " + reservation);
					System.out.println("*                                                                             *");
				}
			}



		}
		
		
		/*
		Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
		Enter data to update the reservation:
		Check-in date (dd/MM/yyyy): 24/09/2019
		Check-out date (dd/MM/yyyy): 29/09/2019
		Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights
		
		Error in reservation: Check-out date must be after check-in date*/
		
		sc.close();
	}

}
