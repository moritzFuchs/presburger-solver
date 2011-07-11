package BA.Automaton;

public interface Automaton {

	/**
	 * Adds a new State to the automaton or returns the state if it already exists.
	 * @param name
	 * @return
	 */
	public abstract State addState(String name);

	/**
	 * Adds a transition to the automaton 
	 * @param from
	 * @param to
	 * @param transition
	 */
	public abstract void addTransition(State from, State to, String transition);

	/**
	 * Runs the automaton starting from the State start, even if it's not a initial state.
	 * @param start
	 * @param input
	 * @return
	 */
	public abstract boolean run(State start, String input);

	/**
	 * Runs the automaton on the given input starting from the initial state (the first one that is found)
	 * @param input
	 * @return
	 */
	public abstract boolean run(String input);

	/**
	 * Runs a existential quantification on the given variable.
	 * @param variable
	 */
	public abstract void existQuant(Character variable);
	
	/**
	 * Runs a all-quantification on the given variable
	 * @param variable
	 */
	public abstract void allQuant(Character variable);
	
	/**
	 * Runs and on the two automata
	 * 
	 * @param auto
	 */
	public abstract Automaton and(Automaton auto);
	
	/**
	 * Runs or on the two automata
	 * 
	 * @param auto
	 */
	public abstract Automaton or(Automaton auto);
	
	
}