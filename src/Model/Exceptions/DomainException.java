package Model.Exceptions;

//extends Exception : obriga a tratar a exceção na class que esta usando (ex. ParseException na class "program")
//extends runtimeException : não obriga a tratar a exceção na class que esta usando
//o Exception é uma class  serializable, obriga a vercionar 
public class DomainException extends Exception {

	/* vercionamento da class */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
