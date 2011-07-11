package BA.Solver.Exceptions;

@SuppressWarnings("serial")
public class InvalidFormulaException extends Exception {

	public InvalidFormulaException() {
		  super();
	  }
	  
	  public InvalidFormulaException(String err) {
		  super(err);
	  }
	
}
