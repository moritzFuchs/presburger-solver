package BA.Solver.Exceptions;

@SuppressWarnings("serial")
public class TooManyVariablesException extends Exception {

	public TooManyVariablesException() {
		  super();
	  }
	  
	  public TooManyVariablesException(String err) {
		  super(err);
	  }
	
}
