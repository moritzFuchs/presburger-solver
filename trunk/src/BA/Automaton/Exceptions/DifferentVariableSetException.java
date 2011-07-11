package BA.Automaton.Exceptions;

@SuppressWarnings("serial")
public class DifferentVariableSetException extends Exception {

	public DifferentVariableSetException() {
		  super();
	  }
	  
	  public DifferentVariableSetException(String err) {
		  super(err);
	  }
	
}
