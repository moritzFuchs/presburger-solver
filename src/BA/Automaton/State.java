package BA.Automaton;

public class State implements Comparable{

	private String name = "";
	private boolean isFinal = false;
	private boolean isInitial = false;
	
	public State(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	protected State setName(String name) {
		this.name = name;
		return this;
	}
	
	public void setFinal(boolean value) {
		this.isFinal = value;
	}
	
	public void setInitial(boolean value) {
		this.isInitial = value;
	}
	
	public boolean isFinal() {
		return this.isFinal;
	}
	
	public boolean isInitial() {
		return this.isInitial;
	}

	public String toString() {
		return this.name;
	}
	
	@Override
	public int compareTo(Object s) {
		State x = (State) s;
		return this.name.compareTo(x.getName());
	}
	
	public State clone() {
		State clone = new State(this.name);
		clone.isFinal = this.isFinal;
		clone.isInitial = this.isInitial;
		return clone;
	}
	
}
