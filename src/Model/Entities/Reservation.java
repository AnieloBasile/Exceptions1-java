package Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class Reservation {

	private Integer roomNumber;
	private Date    checkIn;
	private Date    checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		//super();
		this.roomNumber = roomNumber;
		this.checkIn    = checkIn;
		this.checkOut   = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	// irei porque as datas não podem ser alteradas arbitrariamente
	//public void setCheckIn(Date checkIn) {
	//	this.checkIn = checkIn;
	//}

	public Date getCheckOut() {
		return checkOut;
	}

	// irei porque as datas não podem ser alteradas arbitrariamente
	//public void setCheckOut(Date checkOut) {
	//	this.checkOut = checkOut;
	//}

	public long duration() {
		//getTime retorna a data em milessegundo
		long lonDiff = checkOut.getTime() - checkIn.getTime();
		//transforma milissegundos em dias
		return TimeUnit.DAYS.convert(lonDiff, TimeUnit.MILLISECONDS);
	}
	
	//muda de void string
	public String updateDates (Date dteCheckIn, Date dteCheckOut) {
		
		Date dteNow = new Date();
		
		if (dteCheckIn.before(dteNow) || dteCheckOut.before(dteNow) ) {
			return "Reservation dates for update must be future dates !" ;  
		}
		
		if (!dteCheckOut.after(dteCheckIn)) {
			return "Check-out date must be after check-in date !";  
		}

		this.checkIn  = dteCheckIn;
		this.checkOut = dteCheckOut;
		return null; //para quando não der erro
	}
	
	@Override
	public String toString() {
		return "Room number : "
			+ roomNumber 
			+ ", Check-In: "
			+ sdf.format(checkIn)
			+ ", Check-Out: "
			+ sdf.format(checkOut)
			+ ", Duration: "
			+ duration()
			+ " night(s)";
			
	}
	
}
