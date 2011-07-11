package BA.Automaton;

public class IdCounter {

	private Integer id = 0;
	
	public Integer nextId() {
		return id++;
	}
	
}
