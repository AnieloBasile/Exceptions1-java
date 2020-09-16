package Model.Exceptions;

//extends Exception : obriga a tratar a exce��o na class que esta usando (ex. ParseException na class "program")
//extends runtimeException : n�o obriga a tratar a exce��o na class que esta usando
//o Exception � uma class  serializable, obriga a vercionar 
public class DomainException extends Exception {

	/* vercionamento da class */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
