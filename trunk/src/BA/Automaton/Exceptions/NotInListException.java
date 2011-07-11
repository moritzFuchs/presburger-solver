package BA.Automaton.Exceptions;

@SuppressWarnings("serial")
public class NotInListException extends Exception {

	  public NotInListException() {
		  super();
	  }
	  
	  public NotInListException(String err) {
		  super(err);
	  }
	
}
