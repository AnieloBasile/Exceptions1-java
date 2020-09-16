package Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.Exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date    checkIn;
	private Date    checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		//super();
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date !"); 
		}

		Date dteNow = new Date();

		if (checkIn.before(dteNow) || checkOut.before(dteNow) ) {
			throw new DomainException("To add a reservation the dates must be future !");  
		}

		
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
	
	public void updateDates (Date dteCheckIn, Date dteCheckOut) throws DomainException {
		
		Date dteNow = new Date();
		
		if (dteCheckIn.before(dteNow) || dteCheckOut.before(dteNow) ) {
			// lança uma exceção , usando/instanciando um tipo de exceção já existe no Java para quando uma classe recebe 
			// parametros(argumentos) imvalidos
			//throw new IllegalArgumentException("Reservation dates for update must be future dates !");  
			
			//usando uma exceção personalizada
			throw new DomainException("Reservation dates for update must be future dates !");  
		}
		
		if (!dteCheckOut.after(dteCheckIn)) {
			//return "Check-out date must be after check-in date !";  
			//throw new IllegalArgumentException("Check-out date must be after check-in date !"); 
			
			//usando uma exceção personalizada
			throw new DomainException("Check-out date must be after check-in date !"); 
		}

		this.checkIn  = dteCheckIn;
		this.checkOut = dteCheckOut;
		//não precisa mais do null, pois não é mais string r voltou a ser void
		//return null; //para quando não der erro
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
