package BA.Automaton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

import BA.Automaton.Exceptions.DifferentVariableSetException;
import BA.Automaton.Exceptions.NotInListException;
import BA.util.BinaryOperator;
import BA.util.Worklist;
import BA.util.CNFMaker;

import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.BDD;

/**
 * Basic Automaton (NFA-Transducer) with some mapping abilities to follow the variables of a Presburger Formula. This automaton is optimized 
 * for low-memory-consumption. It uses BDDs for the transition-functions. If you are looking for the fastest automaton, you won't be happy with this one ;)
 * @author moritzfuchs
 *
 */
public class PresburgerAutomaton{

	//Decides which determinization-algorithm to use. 1 = Choose letter, 2 = Choose Powerset-Item
	private static final int DET_ALG = 1;
	//Decides whether the trash state(s) in an automaton are shown in the toString method or not
	private static final boolean SHOW_TRASH = true;

	private Hashtable<String,State> states = new Hashtable<String,State>();
	
	private BDD[] variables;
	private String[] varNames;
	private String[] completeVarNames;
	private Hashtable<State,Hashtable<State,BDD>> transitions = new Hashtable<State,Hashtable<State,BDD>>();
	private boolean isMinimal = false;
	
	public PresburgerAutomaton(BDD[] vars , String[] varNames , String[] completeVarNames) {
		
		this.variables = vars;
		this.varNames = varNames;
		this.completeVarNames = completeVarNames;

	}
	
	public Integer size() {
		return states.size();
	}
	
	/**
	 * Adds a new State to the automaton or returns the state if it already exists.
	 * @param name
	 * @return Generated State
	 */
	public State addState(String name) {
		if (this.states.containsKey(name)) {
			return this.states.get(name);
		}
		
		State newState = new State(name);
		Hashtable<State,BDD> newTransitions = new Hashtable<State,BDD>();
		this.states.put(name, newState);
		this.transitions.put(newState, newTransitions);
		
		return newState;
	}
	
	/**
	 * Checks if the given string is the name of a State
	 * @param name
	 * @return
	 */
	public boolean hasState(String name) {
		return states.containsKey(name);
	}
	
	/**
	 * Adds a transition to the Automaton, starting at state from, ending at state to. 
	 * @param from
	 * @param to
	 * @param transition
	 */
	public void addTransition(State from , State to , boolean[] transition) {
		
		if (transition.length == variables.length) {
			Hashtable<State,BDD> currentTransitions = this.transitions.get(from);
			if (currentTransitions.containsKey(to)) {
				BDD currentBDD = currentTransitions.get(to);
				
				BDD a = PresburgerAutomatonFactory.getOne();
				BDD x;
				for (int i=0;i<transition.length;i++) {
					if (transition[i])
						x = variables[i];
					else
						x = variables[i].not();

					a = a.apply(x,BDDFactory.and);
				}

				BDD newBDD = currentBDD.or(a);
				currentTransitions.remove(to);
				currentTransitions.put(to, newBDD);
				
			} else { //if (currentTransitions.contains(to)) {
				BDD a = PresburgerAutomatonFactory.getOne();
				BDD x;
				for (int i=0;i<transition.length;i++) {
					if (transition[i])
						x = variables[i];
					else
						x = variables[i].not();

					a = a.apply(x,BDDFactory.and);
				}
				currentTransitions.put(to, a);				
			}
		
		}
		
		
		
	}
	
	/**
	 * Wrapper for addTransition(State,State,Boolean[]) for more convenient use. Note, that all chars different from 1 are interpreted as 0.
	 * @param from
	 * @param to
	 * @param transition
	 */
	public void addTransition(State from, State to, String transition) {
		if (variables.length == transition.length()) {
			boolean[] realTransition = new boolean[variables.length];
			for (int i=0;i<transition.length();i++) {
				if (transition.charAt(i) == '1')
					realTransition[i] = true;
				else
					realTransition[i] = false;
			}
			addTransition(from,to,realTransition);
		}
	}
	
	/**
	 * Wrapper for addTransition(State,State,Boolean[]) for more convenient use. Note, that all chars different from 1 are interpreted as 0.
	 * @param from
	 * @param to
	 * @param transition
	 */
	public void addTransition(State from, State to, Character[] transition) {
		
		if (variables.length == transition.length) {
			boolean[] realTransition = new boolean[variables.length];
			for (int i=0;i<transition.length;i++) {
				if (transition[i] == '1')
					realTransition[i] = true;
				else
					realTransition[i] = false;
			}
			addTransition(from,to,realTransition);
		}
	}
	
	/**
	 * Wrapper for addTransition(State,State,Boolean[]) for more convenient use. Note, that all chars different from 1 are interpreted as 0.
	 * @param from
	 * @param to
	 * @param transition
	 */
	public void addTransition(State from, State to, Boolean[] transition) {
		
		if (variables.length == transition.length) {
			boolean[] realTransition = new boolean[variables.length];
			for (int i=0;i<transition.length;i++) {
				if (transition[i] == true)
					realTransition[i] = true;
				else
					realTransition[i] = false;
			}
			addTransition(from,to,realTransition);
		}
	}
	
	/**
	 * Wrapper for addTransition(State,State,Boolean[]) for more convenient use. Note, that all chars different from 1 are interpreted as 0.
	 * @param from
	 * @param to
	 * @param transition
	 */
	public void addTransition(State from, State to, char[] transition) {
		
		if (variables.length == transition.length) {
			boolean[] realTransition = new boolean[variables.length];
			for (int i=0;i<transition.length;i++) {
				if (transition[i] == '1')
					realTransition[i] = true;
				else
					realTransition[i] = false;
			}
			addTransition(from,to,realTransition);
		}
	}
	
	/**
	 * Runs the automaton from a State s with the given input
	 * @param start
	 * @param input
	 * @return True if automaton stops in final state, false else.
	 * @throws NotInListException 
	 */
	private boolean run(State start , Character[] input) throws NotInListException {
		
		if (!states.contains(start)) {
			throw new NotInListException("State not in List!");
		}
		
		List<State> currentStates = new ArrayList<State>();
		currentStates.add(start);
		if (input.length%variables.length != 0)
			return false;

		//Walk through the input
		for (int i=0;i<input.length/variables.length;i++) {
			List<State> nextCurrentStates = new ArrayList<State>();
			Character[] currentInput = new Character[variables.length]; 
			for (int j=0;j<variables.length;j++) {
				currentInput[j] = input[i*variables.length + j];
			}
			
			//walk through the states in the list
			Iterator<State> it = currentStates.iterator();
			while(it.hasNext()) {
				State s = it.next();
				Hashtable<State,BDD> currentTrans = transitions.get(s);
				
				//Check every transition
				Enumeration<State> currentDestination = currentTrans.keys();
				while (currentDestination.hasMoreElements()) {
					State currentKey = currentDestination.nextElement();
					BDD currentBDD = currentTrans.get(currentKey);
					
					if (runBDD(currentBDD , currentInput)) {
						nextCurrentStates.add(currentKey);
					}
					
				}
			}
			currentStates = nextCurrentStates;
		}
		

		
		Iterator<State> finalIt =  currentStates.iterator();
		while (finalIt.hasNext()) {
			State current = finalIt.next();
			if (current.isFinal())
				return true;
		}
		
		return false;
	}
	
	
	/**
	 * Wrapper for run(State,Character[]) for more convenient use.
	 * @param start
	 * @param input
	 * @return True if automaton stops in final state, false else.
	 * @throws NotInListException 
	 */
	private boolean run(State start, String input) throws NotInListException {
		char[] chars = input.toCharArray();
		Character[] realInput = new Character[chars.length];
		for (int i=0;i<chars.length;i++) {
			realInput[i] = Character.valueOf(chars[i]);
		}
		
		return run(start,realInput);
	}
	
	/**
	 * Tries to find the initial state and runs the automaton from that state with the given input
	 * @param input
	 * @return True if automaton stops in final state, false else.
	 */
	public boolean run(Character[] input) {
		Enumeration<State> allStates = states.elements();
		while(allStates.hasMoreElements()) {
			State current = allStates.nextElement();
			if (current.isInitial()) {
				try {
					return run(current,input);
				}catch (NotInListException e) {
					System.err.println("State was not in node list.");
					//TODO Add some proper Logging here
				}
			}
				
		}
		return false;
	}
	
	/**
	 * Wrapper for run(Character[]) for more convenient usage.
	 * @param input
	 * @return True if automaton stops in final state, false else.
	 */
	public boolean run(String input) {
		char[] chars = input.toCharArray();
		Character[] realInput = new Character[chars.length];
		for (int i=0;i<chars.length;i++) {
			realInput[i] = Character.valueOf(chars[i]);
		}
		
		return run(realInput);
	}
	
	/**
	 * Exist-quantor over var.
	 * @param var
	 * @return
	 */
	public PresburgerAutomaton existQuant(String var) {
		isMinimal = false;

		int num = 0;
		boolean found = false;
		for (String x:varNames) {
			if (x.compareTo(var) == 0)
				found= true;
		}
		
		if (!found)
			return this;
		
		for (int i=0;i<variables.length;i++) {
			if (varNames[i].compareTo(var) == 0) {
				num = i;
				break;
			}
		}
		
		Enumeration<State> topLevelKeys = transitions.keys();
		while (topLevelKeys.hasMoreElements()) {
			State currentTopLevelKey = topLevelKeys.nextElement();
			
			Enumeration<State> keys = transitions.get(currentTopLevelKey).keys();
			while (keys.hasMoreElements()) {
				State currentState = keys.nextElement();
				BDD currentBDD = transitions.get(currentTopLevelKey).get(currentState);
				currentBDD = currentBDD.exist(variables[num]);
				transitions.get(currentTopLevelKey).remove(currentState);
				transitions.get(currentTopLevelKey).put(currentState,currentBDD);
			}
		}

		BDD[] newVariables = new BDD[variables.length-1];
		String[] newVarNames= new String[variables.length-1];
		int count = 0;
		for (int i=0;i<variables.length;i++) {
			if (i!=num) {
				newVariables[count] = variables[i];
				newVarNames[count] = varNames[i];
				count++;
			}
		}
		this.variables = newVariables;
		this.varNames = newVarNames;
		
		//If there are no more variables we can just determinize
		if (this.variables.length == 0) {
			if (containsFinalState(states.values()))
				return oneAutomaton();
			else
				return zeroAutomaton();
		}
			
		
		PadClosure();

		return this;
		
	}
	
	/**
	 * Allquantor over var.
	 * @param var
	 * @return
	 */
	public PresburgerAutomaton allQuant(String var) {
		isMinimal = false;
		
		PresburgerAutomaton ret = this.not();
		ret.existQuant(var);
		return ret.not();
	}
	
	//TODO: See if we can make this a sideeffect-method
	/**
	 * Deprecated, just in there for testing-purposes
	 */
	public PresburgerAutomaton determinizeOld() {
		//First, find the initial state
		
		Enumeration<State> allStates = states.elements();
		State initial = null;
		while (allStates.hasMoreElements()) {
			State current = allStates.nextElement();
			if (current.isInitial()) {
				initial = current;
				break;
			}
		}
		
		//Only determinize if initial state is set!
		if (initial != null) {
			
			PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.getInstance();
			String[] newVarNames = new String[varNames.length];
			for (int i=0;i<varNames.length;i++) {
				newVarNames[i] = varNames[i];
			}
			
			
			PresburgerAutomaton a = factory.getAutomaton(newVarNames);
			State s = a.addState(initial.getName());
			s.setInitial(true);
			
			HashSet<String> newStates = new HashSet<String>();
			Hashtable<State,Hashtable<Set<State>,List<Character[]>>> newTransitions = new Hashtable<State,Hashtable<Set<State>,List<Character[]>>>();
			
			List<Set<State>> todo = new ArrayList<Set<State>>();
			
			Set<State> currentNewState = new HashSet<State>();
			currentNewState.add(initial);
			
			todo.add(currentNewState);
			//Do the PowerSet-dance!
			boolean done = false;
			Character[][] alphabet = getAllCharacterCombinations(variables.length);
			while (!done) {
				List<Set<State>> nextTodo = new ArrayList<Set<State>>();
				Iterator<Set<State>> it = todo.iterator();
				while(it.hasNext()) {
					currentNewState = it.next();
					String name = makeNewStateName(currentNewState);
					if (!newStates.contains(name)) {
						State newRealState = a.addState(name);
						
						newStates.add(name);
						
						Iterator<State> finalSearchIt = currentNewState.iterator();
						while (finalSearchIt.hasNext()) {
							if (finalSearchIt.next().isFinal()) {
								newRealState.setFinal(true);
								break;
							}
						}

						//Check Go through all Letters in Alphabet
						for (int i=0;i<alphabet.length;i++) {
							Set<State> newDiscoveredState = new HashSet<State>();
							Iterator<State> currentStateIt = currentNewState.iterator();
							
							//Go through all States in current set
							while (currentStateIt.hasNext()) {
								State currentStart = currentStateIt.next();
								Enumeration<State> currentStateTransitionKeys = transitions.get(currentStart).keys();
								//Go through every transition of every state in the set
								while (currentStateTransitionKeys.hasMoreElements()) {
									State currentDestination = currentStateTransitionKeys.nextElement();
									//Only check if the destination of the transition is not yet in our list.
									if (!newDiscoveredState.contains(currentDestination)) {
										BDD currentTransition = transitions.get(currentStart).get(currentDestination);
										if (runBDD(currentTransition,alphabet[i])) {
											newDiscoveredState.add(currentDestination);
										}
									}
								}
							}
							
							nextTodo.add(newDiscoveredState);
							a.addTransition(newRealState,a.addState(makeNewStateName(newDiscoveredState)),alphabet[i]);
							
						}
	
					}
				}
				if (nextTodo.isEmpty())
					done = true;
				todo = nextTodo;

			}
		
			return a;

			}
		
		
		return this;
	}
	
	
	public PresburgerAutomaton determinize() {
				
		if (this.DET_ALG == 1)
			return determinize2();
		else
			return determinize3();
		
	}
	
	/**
	 * 2nd determinize-try, uses letter-guess-method
	 * @return
	 */
	public PresburgerAutomaton determinize2() {
		
		if (isDFA())
			return this;
		
		State initial = getInitialState();
		
		Worklist<Set<State>> w = new Worklist<Set<State>>();
		Set<State> start = new HashSet<State>();
		start.add(initial);
		w.add(start);
		
		Hashtable<String,State> newStates = new Hashtable<String,State>();
		String initialName = makeNewStateName(initial);
		State init = new State(initialName);
		init.setInitial(true);
		init.setFinal(initial.isFinal());
		newStates.put(initialName, init);
		
		Hashtable<State,Hashtable<State,BDD>> newTransitions = new Hashtable<State,Hashtable<State,BDD>>();
		
		while (!w.isEmpty()) {
			Set<State> currentSet = w.get();
			
			String currentSetName = makeNewStateName(currentSet);
			if (!newStates.containsKey(currentSetName)) {
				State s = new State(currentSetName);
				s.setInitial(true);
				s.setFinal(initial.isFinal());
				newStates.put(currentSetName, s);
			}
			
			BDD currentAll = PresburgerAutomatonFactory.getOne();
			while (!currentAll.isZero()) {
				
				char[] letter = getOneSat(currentAll);
				
				if (letter == null)
					continue;
				
				Set<State> newSet = new HashSet<State>();
				Iterator<State> iter = currentSet.iterator();
				while (iter.hasNext()) {
					State currentState = iter.next();
					newSet.addAll(getNextState(currentState,letter));
				}
				
				
				// we got the Powerset for one letter, let's build the BDD for the powerset!
				
				//Go Through all states in the destination set
				Iterator<State> iterNewSet = newSet.iterator();
				BDD transitionBDD = PresburgerAutomatonFactory.getOne();
				while (iterNewSet.hasNext()) {
					// Get the first destination
					State currentDestination = iterNewSet.next();
					BDD currentStateBDD = PresburgerAutomatonFactory.getZero();
					BDD constrainBDD = PresburgerAutomatonFactory.getOne();
					Iterator<State> iterCurrentSet = currentSet.iterator();
					while (iterCurrentSet.hasNext()) {
						State currentStart = iterCurrentSet.next();
						//Check all transitions and remove them if destination is not in newSet.
						Enumeration<State> enumCurrentStateAllTransitionKeys = transitions.get(currentStart).keys();
						while (enumCurrentStateAllTransitionKeys.hasMoreElements()) {
							State currentDestCheck = enumCurrentStateAllTransitionKeys.nextElement();
							
							if (!newSet.contains(currentDestCheck)) {
								constrainBDD = constrainBDD.apply(transitions.get(currentStart).get(currentDestCheck).not(), BDDFactory.and);
							} else {
								if (transitions.get(currentStart).containsKey(currentDestination)) {
									//We found a transition that leads to a certain state in the destination set
									currentStateBDD = currentStateBDD.apply(transitions.get(currentStart).get(currentDestination), BDDFactory.or);
								}
							}	
						}
					}
					currentStateBDD = currentStateBDD.apply(constrainBDD,BDDFactory.and);
					transitionBDD = transitionBDD.apply(currentStateBDD,BDDFactory.and);
				}
				//Make sure there are only transitions that we did not use yet (can happen when newSet is empty)
				transitionBDD = transitionBDD.apply(currentAll,BDDFactory.and);
				
				String name = makeNewStateName(newSet);
				if (!newStates.containsKey(name)) {
					//Add the new transition and the new state to the Automaton
					State s = new State(name);
					s.setFinal(containsFinalState(newSet));
					newStates.put(s.getName(), s);
					if (!newTransitions.containsKey(newStates.get(currentSetName)))
						newTransitions.put(newStates.get(currentSetName), new Hashtable<State,BDD>());
					
					newTransitions.get(newStates.get(currentSetName)).put(s,transitionBDD);
					w.add(newSet);
//					System.out.println("Adding " + currentSetName + " --" + transitionBDD  + "--> " + name +"A " + transitionBDD.isOne());
				} else {
					State s  = newStates.get(name);
					if (!newTransitions.containsKey(newStates.get(currentSetName)))
						newTransitions.put(newStates.get(currentSetName), new Hashtable<State,BDD>());
					
					newTransitions.get(newStates.get(currentSetName)).put(s,transitionBDD);
//					System.out.println("Adding " + currentSetName + " --" + transitionBDD  + "--> " + name + "B " + transitionBDD.isOne());
				}
				
				currentAll = currentAll.apply(transitionBDD.not(), BDDFactory.and);
			}
			
		}
		
		states = newStates;
		transitions = newTransitions;

		PadClosure();
		
		return this;
	}
	
	/**
	 * 3rd determinize-try, uses powerset-construction of reachable states.
	 * @return
	 */
	public PresburgerAutomaton determinize3() {
		
		if (isDFA())
			return this;
		
		State initial = getInitialState();
		
		Worklist<Set<State>> w = new Worklist<Set<State>>();
		Set<State> start = new HashSet<State>();
		start.add(initial);
		w.add(start);
		
		Hashtable<String,State> newStates = new Hashtable<String,State>();
		String initialName = makeNewStateName(initial);
		State init = new State(initialName);
		init.setInitial(true);
		init.setFinal(initial.isFinal());
		newStates.put(initialName, init);
		
		Hashtable<State,Hashtable<State,BDD>> newTransitions = new Hashtable<State,Hashtable<State,BDD>>();
		
		while (!w.isEmpty()) {
			Set<State> currentSet = w.get();
			
			State currentNewState = newStates.get(makeNewStateName(currentSet));
			
			Set<State> reachable = getNextReachableStates(currentSet);
			PowerSet<State> powerset = new PowerSet<State>(reachable);
			BDD restrict = null;
			//Go through all sets of the powerset
			for(Set<State> currentReachableSet:powerset) {
				Hashtable<State,BDD> tempTransitions = new Hashtable<State,BDD>();
				for(State currentReachableState:currentReachableSet) {
					for (State currentStart:currentSet) {
						//OR the transitions leading to the same state.
						if (transitions.get(currentStart).containsKey(currentReachableState)) {
							if (!tempTransitions.containsKey(currentReachableState))
								tempTransitions.put(currentReachableState, transitions.get(currentStart).get(currentReachableState));
							else
								tempTransitions.put(currentReachableState, 
										tempTransitions.get(currentReachableState).apply(transitions.get(currentStart).get(currentReachableState), BDDFactory.or));
							
						}
					}
				}
				
				BDD transition = PresburgerAutomatonFactory.getOne();
				for (BDD next:tempTransitions.values()) {
					if (transition == null)
						transition = next;
					else
						transition = transition.apply(next,BDDFactory.and);
				}
				if (restrict != null)
					transition = transition.apply(restrict.not(),BDDFactory.and);
				
				
				if (!transition.isZero()) {
					if (restrict == null)
						restrict = transition;
					else
						restrict = restrict.apply(transition,BDDFactory.or);
					
					String name = makeNewStateName(currentReachableSet);
					State newState;
					if (!newStates.containsKey(name)) {
						newState = new State(name);
						newState.setFinal(containsFinalState(currentReachableSet));
						newStates.put(newState.getName(),newState);
						w.add(currentReachableSet);
					} else {
						newState = newStates.get(name);
					}
					
					if (!newTransitions.containsKey(currentNewState)) {
						newTransitions.put(currentNewState,new Hashtable<State,BDD>());
						newTransitions.get(currentNewState).put(newState, transition);
					} else {
						newTransitions.get(currentNewState).put(newState, transition);
					}
					
					
				}
				
				//When we restrict everything, we can quit the current powerset.
				if (restrict != null && restrict.isOne())
					break;
				
	        } // END for(Set<State> currentReachableSet:powerset) {


		}
		
		states = newStates;
		transitions = newTransitions;

		PadClosure();
		
		return this;
	}
	
	/**
	 * Checks if the Automaton is a DFA
	 * @return
	 */
	public boolean isDFA() {
		
		for (State s:states.values()) {
			if (!isDFAState(s))
				return false;
		}
		
		return true;
	}
	

	/**
	 * Minimize-Algorithm using the method by Hopcroft
	 * @return
	 */
	public PresburgerAutomaton minimize() {
		
		if (isMinimal)
			return this;
		
		if (!isDFA()) {
			determinize();
		}
		
		PadClosure();
		
		Queue<Pair<Set<State> , Character[]>> worklist = new LinkedList<Pair<Set<State>,Character[]>>();
		
		HashSet<State> finalStates = new HashSet<State>();
		HashSet<State> nonFinalStates = new HashSet<State>();

		//Get the first two classes and see which is smaller
		for (State s:states.values()) {
			if (s.isFinal())
				finalStates.add(s);
			else
				nonFinalStates.add(s);
		}
		
		if (finalStates.size() == states.size()) {
			return oneAutomaton();
		}
		
		if (nonFinalStates.size() == states.size()) {
			return zeroAutomaton();
		}
		
		HashSet<Set<State>> partition = new HashSet<Set<State>>();
		
		partition.add(finalStates);
		partition.add(nonFinalStates);
		
		HashSet<State> min;
		if (finalStates.size() < nonFinalStates.size())
			min = finalStates;
		else
			min = nonFinalStates;
		
		//Pushing all possible split sets to worklist
		Character[][] alphabet = getAllCharacterCombinations(variables.length);
		for (Character[] letter:alphabet) {
			Pair<Set<State>,Character[]> np = new Pair<Set<State>,Character[]>();
			np.setFirst(min);
			np.setSecond(letter);
			worklist.add(np);
		}

		int i=0;
		//Preparation done, let's get going.
		while(!worklist.isEmpty() && partition.size() != this.size()) {
			Pair<Set<State>,Character[]> currentPair = worklist.remove();
			
			//Clone the partition to deal with ConcurrentModificationException
			HashSet<Set<State>> tmpPartition = new HashSet<Set<State>>();
			for (Set<State> current:partition) {
				HashSet<State> set = new HashSet<State>();
				for (State s:current) {
					set.add(s);
				}
				tmpPartition.add(set);
			}
			
			for (Set<State> currentClass:tmpPartition) {				
				
				
				//See if we can split this Class by currentPair
				if (isSplittable(currentClass,currentPair.getFirst(),currentPair.getSecond())) {
					
					
					Pair<Set<State>,Set<State>> split = split(currentClass , currentPair.getFirst(), currentPair.getSecond());
					
					partition.remove(currentClass);
					partition.add(split.getFirst());
					partition.add(split.getSecond());
					
					//See which one is smaller ...
					Set<State> currentMin;
					if (split.getFirst().size() < split.getSecond().size())
						currentMin = split.getFirst();
					else
						currentMin = split.getSecond();
					
					// ... and add it to the worklist / replace the old class
					HashSet<Character[]> done = new HashSet<Character[]>();
					Set<Pair<Set<State>,Character[]>> remove = new HashSet<Pair<Set<State>,Character[]>>();
					Set<Pair<Set<State>,Character[]>> add = new HashSet<Pair<Set<State>,Character[]>>();
					
					for (Pair<Set<State>,Character[]> x:worklist) {
						if (x.getFirst().containsAll(currentClass)) {
							Pair<Set<State>,Character[]> newWork1 = new Pair<Set<State>,Character[]>();
							Pair<Set<State>,Character[]> newWork2 = new Pair<Set<State>,Character[]>();
							
							newWork1.setFirst(split.getFirst());
							newWork2.setFirst(split.getSecond());
							
							newWork1.setSecond(x.getSecond());
							newWork2.setSecond(x.getSecond());

							remove.add(x);
							add.add(newWork1);
							add.add(newWork2);
							
							done.add(x.getSecond());
						}
					}
					for (Pair<Set<State>,Character[]> item:remove) {
						worklist.remove(item);
					}
					for (Pair<Set<State>,Character[]> item:add) {
						worklist.add(item);
					}

					for (Character[] letter:alphabet) {
						if (!done.contains(letter)) {
							
							Pair<Set<State>,Character[]> newWork = new Pair<Set<State>,Character[]>();
							
							newWork.setFirst(currentMin);
							newWork.setSecond(letter);
							
							worklist.add(newWork);
						}
					}
				}
				
			}
		}
		
		
		
		//Algorithm done, so lets make the new states and transitions!
		Hashtable<String,State> newStates = makeStates(partition);
		Hashtable<State,Hashtable<State,BDD>> newTransitions = makeTransitions(partition , newStates);
		
		states = newStates;
		transitions = newTransitions;
		
		isMinimal = true;
		
		return this;
	}
	
	/**
	 * Calculates the union of the two automata.
	 * @param x
	 * @return
	 */
	public PresburgerAutomaton union(PresburgerAutomaton x) {
		
		isMinimal = false;
		
		if (this.isDFA() && x.isDFA()) {
			try {
				return this.pairing(BinaryOperator.OR, x);
			} catch (DifferentVariableSetException e) {
				//TODO: Add some proper logging here
				System.err.println(e.getMessage());
			}
		}
		
		//In case we have a NFA, just add a new initial state and run the automata side by side
		
		//First merge states and transitions
		
		Hashtable<String,State> newStates = new Hashtable<String,State>(); 
		
		for (State s:this.states.values()) {
			State newS = new State(s.getName() + "A");
			newS.setFinal(s.isFinal());
			newStates.put(newS.getName(), newS);
		}
		
		for (State s:x.states.values()) {
			State newS = new State(s.getName() + "B");
			newS.setFinal(s.isFinal());
			newStates.put(newS.getName(), newS);
		}
		
		Hashtable<State,Hashtable<State,BDD>> newTransitions = new Hashtable<State,Hashtable<State,BDD>>(); 
		
		for (State start:this.transitions.keySet()) {
			for (State dest:this.transitions.get(start).keySet()) {
				if (!newTransitions.containsKey(newStates.get(start.getName()+"A"))) {
					Hashtable<State,BDD> newTrans = new Hashtable<State,BDD>();
					newTransitions.put(newStates.get(start.getName()+"A"), newTrans);
				}
				newTransitions.get(newStates.get(start.getName()+"A")).put(newStates.get(dest.getName()+"A"), this.transitions.get(start).get(dest));
				
			}
		}
		
		for (State start:x.transitions.keySet()) {
			for (State dest:x.transitions.get(start).keySet()) {
				if (!newTransitions.containsKey(newStates.get(start.getName()+"B"))) {
					Hashtable<State,BDD> newTrans = new Hashtable<State,BDD>();
					newTransitions.put(newStates.get(start.getName()+"B"), newTrans);
				}
				newTransitions.get(newStates.get(start.getName()+"B")).put(newStates.get(dest.getName()+"B"), x.transitions.get(start).get(dest));
			}
		}
		
		//Get Name for the new initial state that doesn't exist yet
		String name = "";
		int i=0;
		while (name == "") {
			if (i == 0) {
				if (!states.containsKey("Start")) {
					name = "Start";
				}
			} else {
				if (!states.containsKey("Start"+i)) {
					name = "Start"+i;
				}
			}
			i++;
		}
		
		State initA = this.getInitialState();
		State initB = x.getInitialState();
		
		State newInitial = new State(name);
		newInitial.setInitial(true);
		newInitial.setFinal(initA.isFinal() && initB.isFinal());
		newStates.put(name,newInitial);
		
		Hashtable<State,BDD> trans = new Hashtable<State,BDD>(); 
		
		

		for (State dest:this.transitions.get(initA).keySet()) {
			trans.put(newStates.get(dest.getName()+"A"), transitions.get(initA).get(dest));
		}
		
		for (State dest:x.transitions.get(initB).keySet()) {
			trans.put(newStates.get(dest.getName()+"B"), x.transitions.get(initB).get(dest));
		}
		
		newTransitions.put(newInitial, trans);
		
		states = newStates;
		transitions = newTransitions;
		
		return this;
	}
	
	/**
	 * Returns a automaton recognizing the intersection of the two.
	 * @param x
	 * @return
	 */
	public PresburgerAutomaton intersection(PresburgerAutomaton x) {
		
		isMinimal = false;
		
			try {
				return this.pairing(BinaryOperator.AND, x);
			} catch (DifferentVariableSetException e) {
				System.err.println(e.getMessage());
			}
		return null;
	}
	
	public PresburgerAutomaton not() {
		isMinimal = false;
		
		PresburgerAutomaton returnAut = this;
		
		
		if (!isDFA())
			returnAut =  this.determinize();
		
		
		Enumeration<State> enumAllStates = returnAut.states.elements();
		while (enumAllStates.hasMoreElements()) {
			State current = enumAllStates.nextElement();
			current.setFinal(!current.isFinal());
		}
		
		returnAut.PadClosure();
		
		return returnAut;
	}
	
	/**
	 * Gets the number of solutions of the automaton. -1 stands for an infinit number of solutions.
	 */
	public Integer getSatCount() {
		Set<State> finalStates = new HashSet<State>();
		Hashtable<State,Hashtable<State,BDD>> incomingTransitions = new Hashtable<State,Hashtable<State,BDD>>();

		for (State s:states.values()) {
			if (s.isFinal())
				finalStates.add(s);
		} 
		
		if (finalStates.size() == 0) {
			return 0;
		} else {
			if (this.hasLoops()) {
				return -1;
			}
			//Let's calculate the incoming transitions for all states.
			for (State from:transitions.keySet()) {
				for (State to:transitions.get(from).keySet()) {
					if (!incomingTransitions.containsKey(to)) {
						incomingTransitions.put(to,new Hashtable<State,BDD>());
					}
					incomingTransitions.get(to).put(from, transitions.get(from).get(to));
				}
			}
			
			Hashtable<State,Pair<Integer,Integer>> calculated = new Hashtable<State,Pair<Integer,Integer>>();
			
			Integer result = 0;
			for(State s:finalStates) {
				int pre = getStateSatCount(s, incomingTransitions, calculated).getFirst();
				if (pre >= 0) {
					result += pre;
				} else {
					return -1;
				}
			}
			
			return result;
		}

	}
	
	/**
	 * Checks if the automaton has any loops, ignores the trash state.
	 * @return
	 */
	private boolean hasLoops() {
		
		Set<State> ignore = new HashSet<State>();
		//Search for the trash-states
		for (State s:states.values()) {
			if (transitions.get(s).size() == 1 && !s.isFinal() && !s.isInitial()) {
				if (transitions.get(s).keySet().toArray(new State[1])[0] == s) {
					ignore.add(s);
				}
			}
		}
		
		
		for (State x:states.values()) {
			for (State x2:transitions.get(x).keySet()) {
				if (x == x2 && !BDDHelper.isZeroTransition(transitions.get(x).get(x2),varNames,completeVarNames) && x.isFinal())
					return true;
			}
		}
		
		State init = getInitialState();
		LinkedList<State> dfs = new LinkedList<State>();
		return findLoop(dfs,init,ignore);
	}
	
	private boolean findLoop(LinkedList<State> x , State next,Set<State> ignore) {
		if (x.contains(next)) {
			return true;
		} else {
			for (State s:transitions.get(next).keySet()) {
				
				if (!ignore.contains(s)) {
					LinkedList<State> current = (LinkedList<State>) x.clone();
					current.add(next);
					
					boolean zero = BDDHelper.isZeroTransition(transitions.get(next).get(s),varNames,completeVarNames);
					
					if (!zero && s == next && s.isFinal())
						return true;
					
					if (findLoop(current,s,ignore) && !zero) {
						return true;
					}

				}
			}
		}
		return false;
		
	}
	
	private Pair<Integer,Integer> getStateSatCount(State s , Hashtable<State,Hashtable<State,BDD>> incoming , Hashtable<State,Pair<Integer,Integer>> calculated) {
		
		if (calculated.containsKey(s)) {
			return calculated.get(s);
		}
		
		if (s.isInitial()) {
			Pair<Integer,Integer> p = new Pair<Integer,Integer>();
			p.setFirst(1);
			p.setSecond(1);
			calculated.put(s, p);
			return p;
		}
		
		Integer resultStopHere = 0;
		Integer resultGoOn = 0;
		boolean selftrans = false;
		for (State from:incoming.get(s).keySet()) {
			if (s != from) {
			
				if (!calculated.containsKey(from)) {
					Pair<Integer,Integer> pre;
					
					pre = getStateSatCount(from, incoming, calculated);
					calculated.put(from, pre);
				}
				
				Pair<Integer,Integer> pre = calculated.get(from);

				int multStopHere;
				int multGoOn;
				if (s.isFinal() && from.isFinal()) {
					multStopHere = BDDHelper.getSatCount(incoming.get(s).get(from), varNames, completeVarNames,false);
					multGoOn = BDDHelper.getSatCount(incoming.get(s).get(from), varNames, completeVarNames,true);
				} else {
					multStopHere = BDDHelper.getSatCount(incoming.get(s).get(from), varNames, completeVarNames,true);
					multGoOn = multStopHere;
				}

				resultStopHere += multStopHere * pre.getSecond();
				if (pre.getSecond() >= 0)
					resultGoOn += multGoOn * pre.getSecond();
				
			} else {
				selftrans = true;
			}
		}
		
		Pair<Integer,Integer> p = new Pair<Integer,Integer>();
		p.setFirst(resultStopHere);
		if (!selftrans)
			p.setSecond(resultGoOn);
		else
			p.setSecond(-1);

		calculated.put(s, p);
		
		return p;
	}
	
	public Integer[] getOneSat() {
		return this.getOneSat(0);
	}
	
	public Integer[] getOneSat(int loop) {
		
		if (!containsFinalState(states.values()))
			return new Integer[]{};
		
		State current = getInitialState();
		Set<State> trash = getTrashStates();
		List<State> trace = new LinkedList<State>();
		
		trace.add(current);
		
		boolean loops = this.hasLoops();
		
		Integer[] result = new Integer[varNames.length];
		for (int i=0;i<varNames.length;i++) {
			result[i] = 0;
		}
		int curAdd = 1; 
		while (!current.isFinal() || (loops && loop>0)) {
			
			if (transitions.get(current).containsKey(current) && loop != 0) {
				Iterator<byte[]> it =  (Iterator<byte[]>) transitions.get(current).get(current).allsat().iterator();
				
				boolean addedValue = false;
				while (it.hasNext()) {
					byte[] currentBytes = (byte[]) it.next();
					int compNum = 0; 
					Integer[] add = new Integer[result.length];
					boolean oneSeen = false;
					for (int i = 0;i<completeVarNames.length; i++) {
						if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
							
							if (currentBytes[i] == 1) {
								add[compNum] =  curAdd;
								oneSeen = true;
							} else {
								add[compNum] = 0;
							} 
								
			
							compNum++;
						}
					}
					
					if (oneSeen) {
						for (int i=0;i<add.length;i++) {
							result[i] += add[i];
						}
						addedValue = true;
						break;
					}
				}
				if (!addedValue)
					break;
				curAdd *= 2;
				trace.add(current);
				loop--;
				continue;
			}
			
			if (current.isFinal())
				loop--;
			
			for (State to:transitions.get(current).keySet()) {
				if (!trash.contains(to) && !trace.contains(to) && loop == 0) {
					
					Iterator<byte[]> it =  (Iterator<byte[]>) transitions.get(current).get(to).allsat().iterator();
					
					while (it.hasNext()) {
						byte[] currentBytes = (byte[]) it.next();
						int compNum = 0; 
						for (int i = 0;i<completeVarNames.length; i++) {
							if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
								
								if (currentBytes[i] == 1)
									result[compNum] +=  curAdd;
				
								compNum++;
							}
						}
						break;
					}
					curAdd *= 2;
					current = to;
					trace.add(current);
					break;
				}
				
				if (!trash.contains(to) && trace.contains(to) && loop != 0) {
					
					Iterator<byte[]> it =  (Iterator<byte[]>) transitions.get(current).get(to).allsat().iterator();
					
					while (it.hasNext()) {
						byte[] currentBytes = (byte[]) it.next();
						int compNum = 0; 
						for (int i = 0;i<completeVarNames.length; i++) {
							if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
								
								if (currentBytes[i] == 1)
									result[compNum] +=  curAdd;
				
								compNum++;
							}
						}
						break;
					}
					
					curAdd *= 2;
					current = to;
					loop--;
					break;
				}
				
			}
		} // END WHILE

		System.out.println(loop);
		
		return result;
	}
	
	/**
	 * Returns n solutions of an automaton.
	 * @return
	 */
	public List<Integer[]> getNSat(int n) {
		
		State current = getInitialState();
		Set<State> trash = getTrashStates();
		
		List<Integer[]> solutions = new LinkedList<Integer[]>();
		if (!containsFinalState(states.values()))
			return solutions;
		
		Integer[] sol = new Integer[varNames.length];
		for (int i=0;i<varNames.length;i++) {
			sol[i] = 0; 
		}
		LinkedList<Pair<State,Pair<Integer,Integer[]>>> w = new LinkedList<Pair<State,Pair<Integer,Integer[]>>>(); 
		Pair<State,Pair<Integer,Integer[]>> p = new Pair<State,Pair<Integer,Integer[]>>();
		p.setFirst(current);
		Pair<Integer,Integer[]> item = new Pair<Integer,Integer[]>();
		item.setFirst(1);
		item.setSecond(sol);
		p.setSecond(item);
		
		w.add(p);

		//Keeps running until we have enough solutions
		while (!w.isEmpty() && solutions.size() < n) {
			Pair<State,Pair<Integer,Integer[]>> currentPair = w.pop();
			
			//if this is a final state, we found a solution
			if (currentPair.getFirst().isFinal()) {
				addIfNotContained(solutions, currentPair.getSecond().getSecond());
			}
			if (w.size() < n) {
				//follow all transitions and see if they lead to a final state.
				for (State to:transitions.get(currentPair.getFirst()).keySet()) {
					if (!trash.contains(to)) {
						List<boolean[]> allSatList = BDDHelper.getAllSat(transitions.get(currentPair.getFirst()).get(to), varNames, completeVarNames);
						for (boolean[] allSat : allSatList) {
							Integer[] result = currentPair.getSecond().getSecond().clone();
							Integer curAdd = currentPair.getSecond().getFirst();
							int compNum = 0; 
							
							for (boolean i : allSat) {
								if (i)
									result[compNum] +=  curAdd;
								compNum++;
							}
		
							p = new Pair<State,Pair<Integer,Integer[]>>();
							p.setFirst(to);
							item = new Pair<Integer,Integer[]>();
							item.setFirst(curAdd*2);
							item.setSecond(result);
							p.setSecond(item);
							w.addLast(p);
						}
					}
				}
			}
		}

		return solutions;
		
	}
	

	

	/**
	 * Returns all solutions of an automaton. The returned lists can be quiet big, so be careful!
	 * @return
	 */
	public List<Integer[]> getAllSat() {
		
		if (hasLoops())
			return null;
		
		State current = getInitialState();
		Set<State> trash = getTrashStates();
		
		List<Integer[]> solutions = new LinkedList<Integer[]>();
		if (!containsFinalState(states.values()))
			return solutions;
		Integer[] sol = new Integer[varNames.length];
		for (int i=0;i<varNames.length;i++) {
			sol[i] = 0; 
		}
		
		solutions.add(sol);
		
		List<Integer[]> pre_result = allSatWalk(current , 1 , trash, solutions);
		List<Integer[]> result = new LinkedList<Integer[]>();
		
		HashSet<String> contained = new HashSet<String>();
		int num=0;
		for (Integer[] x:pre_result) {
			String s = "";
			for (Integer i:x) {
				s += i+";";
			}
			if (!contained.contains(s)) {
				result.add(x);
				contained.add(s);
			}
		}
		
		return result;
		
	}
	
	/**
	 * Gets all solutions out of the automaton.
	 * @param start
	 * @param currentAdd
	 * @param ignore
	 * @param solutions
	 * @return
	 */
	private List<Integer[]> allSatWalk(State start , Integer currentAdd , Set<State> ignore, List<Integer[]> solutions) {

		List<Integer[]> result = new LinkedList<Integer[]>();
		for (State s:transitions.get(start).keySet()) {
			if (!ignore.contains(s) && s != start) {
				List<Integer[]> newList = new LinkedList<Integer[]>();
				for (boolean[] x:BDDHelper.getAllSat(transitions.get(start).get(s), varNames, completeVarNames)) {
					for (Integer[] current:solutions) {
						int i=0;
						Integer[] newCurrent = duplicateArray(current, varNames.length);
						boolean allzero = true;
						for (boolean b:x) {
							newCurrent[i++] += currentAdd * (b ? 1:0);
						}
						//Used to be addIfNotContained(newList,newCurrent) , change back if problems occur, eats up a lot of time and memory though..
						newList.add(newCurrent);
					}
				}
				result.addAll(allSatWalk(s,currentAdd*2,ignore,newList));
			}
		}
		
		if (start.isFinal())
			result.addAll(solutions);
		
		return result;
	}
	
	private boolean addIfNotContained(List<Integer[]> list , Integer[] a) {
		for (Integer[] current:list) {
			if (isEqual(current,a))
				return false;
		}
		list.add(a);
		return true;
	}
	
	private boolean isEqual(Integer[] a, Integer[] b) {
		if (a.length != b.length)
			return false;
		for (int i=0;i<a.length;i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
	
	/**
	 * Duplicates an Integer Array.
	 * @param copy
	 * @param length
	 * @return
	 */
	private Integer[] duplicateArray(Integer[] copy , Integer length) {
		Integer[] result = new Integer[length];
		int num = 0;
		for (Integer i:copy) {
			result[num++] = i;
		}
		return result;
	}
	
	/**
	 * Gets the maximal value of a automaton with exactly one variable.
	 * @return
	 */
	public Integer getMaxValue() {
		
		if (hasLoops() || varNames.length == 0 || !containsFinalState(states.values()))
			return -1;
		
		Set<State> ignore = getTrashStates();
		Hashtable<State,Integer> calculated = new Hashtable<State,Integer>();
		Integer result = getDFS(getInitialState(),calculated,ignore,"max");
		return result;
	}
	
	public Integer getMinValue() {
		
		if (varNames.length == 0 || !containsFinalState(states.values()))
			return -1;
		
		Set<State> ignore = getTrashStates();
		Hashtable<State,Integer> calculated = new Hashtable<State,Integer>();
		Integer result = getDFS(getInitialState(),calculated,ignore,"min");
				
		
		return result;
	}
	
	/**
	 * Gets the min/max value of a automaton (depends on type, "min" gets min, "max" gehts max)
	 * @param start
	 * @param calculated
	 * @param ignore
	 * @param type
	 * @return
	 */
	private Integer getDFS(State start , Hashtable<State,Integer> calculated, Set<State> ignore , String type) {
		if (calculated.containsKey(this))
			return calculated.get(this);
		
		//Else we will have to calculate it... *sigh*
		List<Pair<State,Integer>> toGo = new LinkedList<Pair<State,Integer>>();

		if (start.isFinal() && type.equals("min")) {
			calculated.put(start, 0);
			return 0;
		}
		
		for (State s:transitions.get(start).keySet()) {
			//This is a self transition, which means we HAVE to stop in this state since it has to be a 0-transition.
			if (s == start) {
				if (start.isFinal()) {
					calculated.put(start, 0);
					return 0;					
				} else {
					if (type.equals("min"))
						continue;
					
					calculated.put(start, -1);
					return -1;
				}
			}
			
			if (!ignore.contains(s)) {
				Pair<State,Integer> p = new Pair<State,Integer>();
				boolean done = false;
				for (boolean[] x:BDDHelper.getAllSat(transitions.get(start).get(s), varNames, completeVarNames)) {
					if (type.equals("max")) {
						if (!x[0] && !done) {
							p.setFirst(s);
							p.setSecond(0);
						} else {
							p.setFirst(s);
							p.setSecond(1);
							break;
						}
					}
					
					if (type.equals("min")) {
						if (x[0] && !done) {
							p.setFirst(s);
							p.setSecond(1);
						} else {
							p.setFirst(s);
							p.setSecond(0);
							break;
						}
					}
					
				}
				toGo.add(p);

			} 
		}
		
		Integer current = null;
		//Lets go through the other states and see which one is the biggest
		for (Pair<State,Integer> go:toGo) {
			
			Integer next = getDFS(go.getFirst(),calculated,ignore,type);
			if (next == -1) {
				calculated.put(start, -1);
				return -1;
			}
			Integer tmp  = go.getSecond()+ 2*next;
			if (type.equals("max")) {
				if (current == null)
					current = tmp;
				if (tmp > current) {
					current = tmp;
				}
			}
			
			if (type.equals("min")) {
				if (current == null)
					current = tmp;
				if (tmp < current) {
					current = tmp;
				}
			}
			
		}
		
		calculated.put(start, current);		
		return current;

	}
	
	/**
	 * Outputs the automaton in the dotty-Format (for use in e.g. GraphViz)
	 */
	public String toString() {
		State initial = getInitialState();

		Hashtable<State,Integer> stateNumbers = new Hashtable<State,Integer>();
		Enumeration<State> doIt = states.elements();
		Integer num = 0;
		while (doIt.hasMoreElements()) {
			State current = doIt.nextElement();
			stateNumbers.put(current, num++);
		}
		
		
		Set<State> dontShow = new HashSet<State>();
		if (!SHOW_TRASH) {
			dontShow = getTrashStates();
		}
			
		
		String result = "digraph G {\n";
		String addition = "";
		Enumeration<State> allStatesEnum = states.elements();
		while (allStatesEnum.hasMoreElements()) {
			State current = allStatesEnum.nextElement();
			if (!dontShow.contains(current)) {
				if (current.isFinal()) {
					addition += stateNumbers.get(current) + "[peripheries=2];;\n";
				}
				if (current.isInitial()) {
					addition += stateNumbers.get(current) + "[shape=\"diamond\"];\n";
				}
				Enumeration<State> destKeysEnum = transitions.get(current).keys();
				while (destKeysEnum.hasMoreElements()) {
					State currentKey = destKeysEnum.nextElement();
					if (!dontShow.contains(currentKey)) {
						result += stateNumbers.get(current) + " -> " + stateNumbers.get(currentKey) + "[label=\"" + CNFMaker.makeFormula(transitions.get(current).get(currentKey), variables, varNames, completeVarNames) + "\"];\n";
//						result += stateNumbers.get(current) + " -> " + stateNumbers.get(currentKey) + "[label=\"" + transitions.get(current).get(currentKey) + "\"];\n";
					}
				}
			}
		}
		result+= addition;
		result += "}";
		

		return result;
	}
	
	public String toString(String x) {
		if (x.compareTo("Debug") == 0) {
			State initial = getInitialState();
	
			Hashtable<State,Integer> stateNumbers = new Hashtable<State,Integer>();
			Enumeration<State> doIt = states.elements();
			Integer num = 0;
			while (doIt.hasMoreElements()) {
				State current = doIt.nextElement();
				stateNumbers.put(current, num++);
			}
			
			String result = "digraph G {\n";
			String addition = "";
			Enumeration<State> allStatesEnum = states.elements();
			while (allStatesEnum.hasMoreElements()) {
				State current = allStatesEnum.nextElement();
				if (current.isFinal()) {
					addition += current + "[shape=\"diamond\"];\n";
				}
				if (current.isInitial()) {
					addition += current + "[shape=\"square\"];\n";
				}
				
				Enumeration<State> destKeysEnum = transitions.get(current).keys();
				while (destKeysEnum.hasMoreElements()) {
					State currentKey = destKeysEnum.nextElement();
					String label = transitions.get(current).get(currentKey).toString();
					result += current + " -> " + currentKey + "[label=\"" + label + "\"];\n";
				}
			}
			result+= addition;
			result += "}";
			
			return result;
		} else {
			if (x.compareTo("json") == 0) {
				makeNiceNames();
				
				State initial = getInitialState();

				Hashtable<State,Integer> stateNumbers = new Hashtable<State,Integer>();
				Enumeration<State> doIt = states.elements();
				Integer num = 0;
				while (doIt.hasMoreElements()) {
					State current = doIt.nextElement();
					stateNumbers.put(current, num++);
				}
				
				
				Set<State> dontShow = new HashSet<State>();
				if (!SHOW_TRASH) {
					//Search for the trash-states
					for (State s:states.values()) {
						if (transitions.get(s).size() == 1 && !s.isFinal() && !s.isInitial()) {
							if (transitions.get(s).keySet().toArray(new State[1])[0] == s) {
								dontShow.add(s);
							}
						}
					}
				}
					
				
				String states = "";
				
				int i=0;
				for (State s:this.states.values()) {
					if (!dontShow.contains(s)) 
						states += "\"" + i++ + "\" : {\"Name\" : \"" + s.getName() + "\", \"Initial\" : " + s.isInitial() + ", \"Final\" : " + s.isFinal() + "},";
				}
				states = states.substring(0, states.length()-1);
				
				String result = "{\"States\" : {" + states + "},";
				String transitions = "";
				Enumeration<State> allStatesEnum = this.states.elements();
				i = 0;
				while (allStatesEnum.hasMoreElements()) {
					State current = allStatesEnum.nextElement();
					if (!dontShow.contains(current)) {
						Enumeration<State> destKeysEnum = this.transitions.get(current).keys();
						while (destKeysEnum.hasMoreElements()) {
							State currentKey = destKeysEnum.nextElement();
							if (!dontShow.contains(currentKey)) {
								transitions += "\"" + i++ +"\" : {\"From\" : \"" + current.getName() + "\", " +
												"\"Label\": \"" + CNFMaker.makeFormula(this.transitions.get(current).get(currentKey), variables, completeVarNames, completeVarNames) + "\"," +
												"\"To\" : \"" + currentKey.getName() + "\"},"; 
							}
						}
					}
				}
				
				transitions = transitions.substring(0, transitions.length()-1);
				result+= "\"Transitions\" : {" + transitions + "}}";
				
				return result;
			}
		}
		return "";
	}
	
	public void makeNiceNames() {
		int i = 0;
		Hashtable<String,State> newStates = new Hashtable<String,State>(); 
		for (String name:states.keySet()) {
			newStates.put(String.valueOf(i),states.get(name).setName(String.valueOf(i)));
			i++;
		}
		
		states = newStates;
	}
	
	//################################### HELPER METHODS ###################################
	
	/**
	 * Returns the trash-states (most of the times there will be only 1) 
	 */
	private Set<State> getTrashStates() {
		Set<State> trash = new HashSet<State>();
		//Search for the trash-states
		for (State s:states.values()) {
			if (transitions.get(s).size() == 1 && !s.isFinal() && !s.isInitial()) {
				if (transitions.get(s).keySet().toArray(new State[1])[0] == s) {
					trash.add(s);
				}
			}
		}
		return trash;
	}

	private PresburgerAutomaton oneAutomaton() {
		
		State newState = new State("End");
		newState.setFinal(true);
		newState.setInitial(true);
		states.clear();
		states.put(newState.getName(), newState);
		transitions.clear();
		transitions.put(newState, new Hashtable<State,BDD>());
		transitions.get(newState).put(newState, PresburgerAutomatonFactory.getOne());
		return this;

	}
	
	private PresburgerAutomaton zeroAutomaton() {
		State newState = new State("End");
		newState.setInitial(true);
		states.clear();
		states.put(newState.getName(), newState);
		transitions.clear();
		transitions.put(newState, new Hashtable<State,BDD>());
		transitions.get(newState).put(newState, PresburgerAutomatonFactory.getOne());
		return this;
	}
	
	
	/**
	 * Does the pairing operation for a given operator. Please make sure the automaton is deterministic before using this.
	 * @param op
	 * @return
	 * @throws DifferentVariableSetException 
	 */
	private PresburgerAutomaton pairing(BinaryOperator op , PresburgerAutomaton b) throws DifferentVariableSetException {
		
		//Let's make some pairs..
		if (!isDFA())
			determinize();
		
		if (!b.isDFA())
			b.determinize();
		
		//First, merge the variable sets
		HashSet<String> tmp = new HashSet<String>();
		for (String i:this.varNames) {
			tmp.add(i);
		}
		for (String i:b.varNames) {
			tmp.add(i);
		}
		

		//make the resulting automaton
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.getInstance();
		PresburgerAutomaton result = factory.getAutomaton(tmp.toArray(new String[tmp.size()]));
		
		
		Pair<State,State> initial = new Pair<State,State>();
		
		//Then get the initial states of the automata
		
		initial.setFirst(this.getInitialState());
		initial.setSecond(b.getInitialState());
		
		//Then make the initial Worklist
		Worklist<Pair<State,State>> worklist = new Worklist<Pair<State,State>>();
		worklist.add(initial);
		
		State init = result.addState("1"+initial.getFirst().getName()+"2"+initial.getSecond().getName());
		init.setInitial(true);
		
		if (op.apply(initial.getFirst().isFinal() , initial.getSecond().isFinal())) {
			init.setFinal(true);
		}
		
		//Go through the worklist until it is empty, which is when the pairing is done
		while (!worklist.isEmpty()) {
			Pair<State,State> currentPair = worklist.get();
	
			State currentResultState = result.addState("1"+currentPair.getFirst().getName()+"2"+currentPair.getSecond().getName());
			
			Enumeration<State> firstDestinationEnum = this.transitions.get(currentPair.getFirst()).keys();
			while (firstDestinationEnum.hasMoreElements()) {
				State currentFirstDestination = firstDestinationEnum.nextElement();
				Enumeration<State> secondDestinationEnum = b.transitions.get(currentPair.getSecond()).keys();
				while(secondDestinationEnum.hasMoreElements()) {
					State currentSecondDestination = secondDestinationEnum.nextElement();
					BDD newTransition = this.transitions.get(currentPair.getFirst()).get(currentFirstDestination).apply(
							b.transitions.get(currentPair.getSecond()).get(currentSecondDestination), BDDFactory.and);
					
					
//					System.out.print(b.transitions.get(currentPair.getSecond()).get(currentSecondDestination) + " ");
//					System.out.println(newTransition);
					
					if (!newTransition.isZero()) {
						//Add the new transition to the transitiontable of the new automaton
						
						if (!result.hasState("1"+currentFirstDestination.getName() + "2"+currentSecondDestination.getName())) {
							Pair<State,State> newPair = new Pair<State,State>();
							newPair.setFirst(currentFirstDestination);
							newPair.setSecond(currentSecondDestination);
							worklist.add(newPair);
						}
						
						State currentResultDestinationState = result.addState("1"+currentFirstDestination.getName() + "2"+currentSecondDestination.getName());
						if (op.apply(currentFirstDestination.isFinal() , currentSecondDestination.isFinal())) {
							currentResultDestinationState.setFinal(true);
						}
//						System.out.println(currentResultState.getName() + "--" + newTransition.toString() +"-->" + currentResultDestinationState.getName());
						result.transitions.get(currentResultState).put(currentResultDestinationState, newTransition);
					}
				}
			}
			
		}
		

		return result;
	}
	
	
	
	/**
	 * Checks if a given class is splittable by another Class and a given letter
	 * @param start
	 * @param destination
	 * @param letter
	 * @return
	 */
	private boolean isSplittable(Set<State> start , Set<State> destination , Character[] letter) {
				
		if (start.size() == 1)
			return false;
		
		boolean in = false;
		boolean out = false;
		
		for (State currentStart:start){
			Set<State> dest = transitions.get(currentStart).keySet();
			for (State currentDestination:dest) {
				if (runBDD(transitions.get(currentStart).get(currentDestination),letter)) {
					if (destination.contains(currentDestination)) {
						in = true;
						break;
					} else {
						out = true;
						break;
					}
				}
				
				if (in && out) {
					return true;
				}
			}
		}
		if (in && out) {
			return true;
		}
		return false;
	}
	
	/**
	 * Splits a class by another class and a letter to refine a partition
	 * @param start
	 * @param destination
	 * @param letter
	 * @return
	 */
	private Pair<Set<State>,Set<State>> split(Set<State> start , Set<State> destination , Character[] letter) {
		
		Pair<Set<State>,Set<State>> p = new Pair<Set<State>,Set<State>>();
		
		HashSet<State> in = new HashSet<State>();
		HashSet<State> out = new HashSet<State>();
		
		for (State currentStart:start){
			for (State currentDestination:transitions.get(currentStart).keySet()) {
				if (runBDD(transitions.get(currentStart).get(currentDestination),letter)) {
					if (destination.contains(currentDestination)) {
						in.add(currentStart);
						break;
					} else {
						out.add(currentStart);
						break;
					}
				}
			}
		}
		
		p.setFirst(in);
		p.setSecond(out);
		
		return p;
	}
	
	/**
	 * Makes the new states for the minimize-algorithm.
	 * @param set
	 * @return
	 */
	private Hashtable<String,State> makeStates(Set<Set<State>> set) {
		
		Hashtable<String,State> result = new Hashtable<String,State>();
		
		for (Set<State> item:set) {
			String name = makeNewStateName(item);
			State s = new State(name);
			s.setFinal(containsFinalState(item));
			s.setInitial(containsInitialState(item));
			
			result.put(name,s);
		}
		
		return result;
	} 
	
	/**
	 * Make the new transitions after partitioning the automaton for minimize algorithm
	 * @param set
	 * @param states
	 * @return
	 */
	private Hashtable<State, Hashtable<State, BDD>> makeTransitions(Set<Set<State>> partition , Hashtable<String,State> states) {
		Hashtable<State,Hashtable<State,BDD>> result = new Hashtable<State,Hashtable<State,BDD>>();
		
		HashMap<State,State> partMap = new HashMap<State,State>();
		//let's first make a map, to see which state belongs to which partition-state
		for (Set<State> item:partition) {
			String name = makeNewStateName(item);
			//can't be null since we just made these exact states.
			State partState = states.get(name);
			for (State s:item) {
				partMap.put(s,partState);
			}
		}
		
		
		for (Set<State> current:partition) {
			
			//can't be null since we just made these exact states.
			State s = states.get(makeNewStateName(current));
			State old = null;
			//TODO: Try to find nicer way for that!
			for(State x:current) {
				old = x;
				break;
			}
			
			for (State dest:transitions.get(old).keySet()) {
				if (result.containsKey(s)) {
					if (result.get(s).containsKey(partMap.get(dest))) {
						result.get(s).put(partMap.get(dest) , result.get(s).get(partMap.get(dest)).apply(transitions.get(old).get(dest) , BDDFactory.or));
					} else {
						result.get(s).put(partMap.get(dest) , transitions.get(old).get(dest));
					}
				} else {
					result.put(s,new Hashtable<State,BDD>());
					result.get(s).put(partMap.get(dest) , transitions.get(old).get(dest));
				}
			}
		}
		
		return result;
		
	}
	
	/**
	 * Makes the automaton total, so for every letter there is at least a transition in every state
	 */
	private void makeTotal() {
		BDD zero = PresburgerAutomatonFactory.getZero();
		for (State s:states.values()) {
			for (BDD x:transitions.get(s).values()) {
				zero = zero.apply(x,BDDFactory.or);
			}
			if (!zero.isOne()) {
				BDD one = PresburgerAutomatonFactory.getOne();
				one = one.apply(zero.not(),BDDFactory.and);
				
				//Build a trash-state if it doesn't exist yet.
				if (!states.containsKey("Trash")) {
					State trash = new State("Trash");
					states.put("Trash", trash);
					Hashtable<State,BDD> to = new Hashtable<State,BDD>();
					to.put(trash , PresburgerAutomatonFactory.getOne());
					transitions.put(trash, to);
				}
				State trash = states.get("Trash");
				transitions.get(s).put(trash, one);
			}
		}
	}
	
	private boolean containsFinalState(Collection<State> collection) {
		Iterator<State> iter = collection.iterator();
		while (iter.hasNext()) {
			if (iter.next().isFinal())
				return true;
		}
		return false;
	}
	
	private boolean containsInitialState(Set<State> set) {
		Iterator<State> iter = set.iterator();
		while (iter.hasNext()) {
			if (iter.next().isInitial())
				return true;
		}
		return false;
	}

	private Set<State> getFinalStates() {
		HashSet<State> set = new HashSet<State>();
		for (State s:states.values()) {
			if (s.isFinal())
				set.add(s);
		}
		return set;
	}
	
	private void PadClosure() {
		Character[] padding = new Character[variables.length];
		for (int i=0;i<variables.length;i++) {
			padding[i] = '0';
		}
		
		//Build a Graph of the transitions with the padding-letter
		Hashtable<State,Set<State>> incoming = new Hashtable<State,Set<State>>();
		for (State currentStart:transitions.keySet()) {
			for (State currentDest:transitions.get(currentStart).keySet()) {
				if (runBDD(transitions.get(currentStart).get(currentDest) , padding)) {
					if (!incoming.containsKey(currentDest)) 
						incoming.put(currentDest,new HashSet<State>());
					
					incoming.get(currentDest).add(currentStart);
				}
			}
		}
		
		HashSet<State> done = new HashSet<State>();
		Worklist<State> w = new Worklist<State>();
		w.addAll(getFinalStates());
		while (!w.isEmpty()) {
			State f = w.get();
			if (!done.contains(f) && incoming.containsKey(f)){
				for (State makeFinal:incoming.get(f)) {
					makeFinal.setFinal(true);
					w.add(makeFinal);
				}
			}
			done.add(f);
		}
		
	} 

	private Set<State> getNextReachableStates(Set<State> set) {
		Set<State> result = new HashSet<State>();
		
		Iterator<State> iter = set.iterator();
		while (iter.hasNext()) {
			State current = iter.next();
			result.addAll(transitions.get(current).keySet());
		}
		
		return result;
	}
	
	/**
	 * Gets the next state when applying the letter in the State s.
	 * 
	 * @param s
	 * @param letter
	 * @return
	 */
	private Set<State> getNextState(State s , char[] letter) {
		Enumeration<State> enumDest = transitions.get(s).keys();
		Set<State> result = new HashSet<State>();
//		System.out.print(letter[0] + " : ");
		while (enumDest.hasMoreElements()) {
			State currentDest = enumDest.nextElement();
			if (runBDD(transitions.get(s).get(currentDest) , letter)) {
//				System.out.print(currentDest);
				result.add(currentDest);
			}
		}
//		System.out.println("");
		return result;
	}
	
	private State getInitialState() {
		Enumeration<State> enumState = this.states.elements();
		while (enumState.hasMoreElements()) {
			State current = enumState.nextElement();
			if (current.isInitial()){
				return current;
			}
		}
		return null;
	}
	
	
	/**
	 * Checks if a given state is deterministic
	 */
	private boolean isDFAState(State s) {
				
		if (transitions.get(s).values().size() == 1) {
			return ((BDD)transitions.get(s).values().toArray()[0]).isOne();
		}
		
		Iterator<BDD> enumBDD = transitions.get(s).values().iterator();
		BDD and = null;
		BDD or = PresburgerAutomatonFactory.getZero();
		BDD current;
		int count = 0;
		while (enumBDD.hasNext()) {
			current = enumBDD.next();
			count += (int)current.satCount();
			if (and == null)
				and = current;
			else {
				and = and.apply(current,BDDFactory.and);
				if (!and.isZero()) {
					System.out.println("false");
					return false;
				}
				
				and = current;
			}
			or = or.apply(current,BDDFactory.or);
		}
		
		return or.isOne() && count == Math.pow(2, this.variables.length);
	}
	
	/**
	 * Returns all possible boolean combinations with n digits.
	 * @param n
	 * @return
	 */
	private boolean[][] getAllBinaryCombinations(int n) {
		boolean[][]result  = null;
		if (n >=1) {
			result = new boolean[][]{{true},{false}};
			while(result.length < Math.pow(2,n)) {
				boolean[][] newResult = new boolean[2*result.length][result[0].length+1];
				for (int i=0;i<result.length;i++) {
					
					for (int j=0;j<result[i].length;j++) {
						newResult[i][j] = result[i][j];
						newResult[i+result.length][j] = result[i][j];
					}
					
					newResult[i][result[i].length] = true;
					newResult[i+result.length][result[i].length] = false;
				}
				result = newResult;
			}
			
		}
		return result;
	}
	
	/**
	 * Returns all possible character combinations consisting of 0 and 1, with n digits.
	 * @param n
	 * @return
	 */
	private Character[][] getAllCharacterCombinations(int n) {
		Character[][]result  = null;
		if (n >=1) {
			result = new Character[][]{{'1'},{'0'}};
			while(result.length < Math.pow(2,n)) {
				Character[][] newResult = new Character[2*result.length][result[0].length+1];
				for (int i=0;i<result.length;i++) {
					
					for (int j=0;j<result[i].length;j++) {
						newResult[i][j] = result[i][j];
						newResult[i+result.length][j] = result[i][j];
					}
					
					newResult[i][result[i].length] = '1';
					newResult[i+result.length][result[i].length] = '0';
				}
				result = newResult;
			}
			
		}
		return result;
	}

	private String makeNewStateName(State s) {
		Set<State> x = new HashSet<State>();
		x.add(s);
		return makeNewStateName(x);
	}
	
	private String makeNewStateName(Set<State> currentNewState) {
		TreeSet<State> ordered = new TreeSet<State>();
		ordered.addAll(currentNewState);
		
		String output = "";
		Iterator<State> it = ordered.iterator();
		
		while (it.hasNext()) {
			output += it.next().getName()+"X";
		
		}
		
		return output;
	}
	
	/**
	 * Runs a given BDD on the input and gives result.
	 * @param toTry
	 * @param input
	 * @return True if BDD accepts the input, false if not.
	 */
	protected boolean runBDD(BDD toTry , Character[] input) {
		return BDDHelper.runBDD(toTry, input, variables);
	}
	
	protected boolean runBDD(BDD toTry , char[] input) {
		Character[] newList = new Character[input.length];
		for (int i=0;i<input.length;i++) {
			newList[i] = input[i];
		}
		
		return BDDHelper.runBDD(toTry, newList, variables);
	}
	
	/**
	 * Gets all satisfying inputs of the given bdd.
	 * @param bdd
	 * @return List of all solutions to a BDD
	 */
	protected List<char[]> getAllSat(BDD bdd) {
			
		@SuppressWarnings("unchecked")
		Iterator<byte[]> it =  (Iterator<byte[]>) bdd.allsat().iterator();
		List<char[]> result = new ArrayList<char[]>();
			
		while (it.hasNext()) {
			char[] pre_res = new char[variables.length];
			byte[] x = (byte[]) it.next();
			int compNum = 0;
			for (int i = 0;i<completeVarNames.length; i++) {
				if (compNum<varNames.length && varNames[compNum].equals(completeVarNames[i])) {
					if (x[i] == 1)
						pre_res[compNum++] = '1';
					else if (x[i] == 0)
						pre_res[compNum++] = '0';
					else
						pre_res[compNum++] = 'x';
				}
			}
			List<char[]> list = new ArrayList<char[]>();
			list.add(pre_res);
			result.addAll(replaceX(list));
		}
		

		return result;
	}
	
	protected char[] getOneSat(BDD bdd) {
		if (bdd.isZero()) {
			char[] res = new char[variables.length];
			for (int i=0;i<variables.length;i++) {
				res[i] = '0';
			}
			return res;
		}
		
		Iterator<byte[]> it = (Iterator<byte[]>) bdd.satOne().allsat().iterator();
		while (it.hasNext()) {
			byte[] x = it.next();
			int compNum = 0;
			char[] res = new char[variables.length];
			for (int i = 0;i<completeVarNames.length; i++) {
				if (compNum<varNames.length && varNames[compNum].equals(completeVarNames[i])) {
					if (x[i] == 1)
						res[compNum++] = '1';
					else
						res[compNum++] = '0';
				}
			}
			return res;
		}
		
		return null;
	}
	
	/**
	 * Replaces all x by 2 arrays with 0/1.
	 * 
	 * @param input
	 * @return
	 */
	private List<char[]> replaceX(List<char[]> input) {
		List<char[]> output = new ArrayList<char[]>();
		
		Iterator<char[]> it = input.iterator();
		boolean foundAny = false;
		while (it.hasNext()) {
			char[] current = it.next();
			boolean found = false;
			for (int i = 0;i<current.length;i++) {
				if (current[i] == 'x') {
					char[] newItem = current.clone();
					current[i] = '1';
					newItem[i] = '0';
					output.add(current);
					output.add(newItem);
					found = true;
					foundAny = true;
					break;
				}
			}
			if (!found)
				output.add(current);
		}
		
		if (foundAny)
			return replaceX(output);
		
		return output;
	}
	
	/**
	 * Prints all satisfying inputs.
	 * @param bdd
	 */
	private void printBDDallSat(BDD bdd) {
		List<char[]> allSat = getAllSat(bdd);
		Iterator<char[]> itSat = allSat.iterator();
		
		while (itSat.hasNext()) {
			char[] chars = itSat.next();
			for (int i = 0; i<chars.length;i++) {
				System.out.print(chars[i]);
			}
			System.out.print(",");
		}
		System.out.println("####");
		
	}
	
	public void finalize() {
		for (Hashtable<State,BDD> x:transitions.values()) {
			for (BDD y:x.values()) {
				y.free();
			}
		}
	}

	public String[] getVarNames() {
		return this.varNames;
	}
	
	/**
	 * Returns a exact copy of this automaton.
	 */
	public PresburgerAutomaton clone() {
		
		PresburgerAutomaton clone = new PresburgerAutomaton(this.variables , this.varNames , this.completeVarNames);
		
		for (State s:this.states.values()) {
			State sClone = s.clone();
			clone.states.put(sClone.getName() , sClone);
		}
		
		for (State from:transitions.keySet()) {
			for (State to:transitions.get(from).keySet()) {
				if (!clone.transitions.containsKey(clone.states.get(from.getName()))) {
					clone.transitions.put(clone.states.get(from.getName()), new Hashtable<State,BDD>());
				}
				clone.transitions.get(clone.states.get(from.getName())).put(clone.states.get(to.getName()), transitions.get(from).get(to).id());
			}
		}
		
		return clone;
	}

	/**
	 * Gets all values of the variables != varName where varName = val
	 * @param newVar
	 * @param max
	 * @return
	 */
	public List<Integer[]> getValuesFor(String varName, Integer val) {
		

		State init = getInitialState();
		List<Integer[]> sol = new LinkedList<Integer[]>();
		Integer[] t = new Integer[varNames.length];
		for (int i=0;i<varNames.length-1;i++) {
			t[i] = 0;
		}
		sol.add(t);

		sol = getValuesFor(init , varName, val, 1, sol , getTrashStates());

		return sol;
	}
	
	private List<Integer[]> getValuesFor(State start , String varName , Integer val, Integer currentAdd, List<Integer[]> solutions,Set<State> ignore) {
		
		if (val == 0 && start.isFinal()) {
			return solutions;
		}
		
		List<Integer[]> result = new LinkedList<Integer[]>();
		
		int j=0;
		for (String s:varNames) {
			if (varName.equals(varNames[j]))
				break;
			j++;
		}
		
		int num = j;
		
		for (State to:transitions.get(start).keySet()) {
			if (start != to && !ignore.contains(to)) {
				List<Integer[]> newList = new LinkedList<Integer[]>();
				if (BDDHelper.hasElementWith(transitions.get(start).get(to),varName , val%2 ,completeVarNames)) {
					List <boolean[]> list = BDDHelper.getAllSat(transitions.get(start).get(to), varNames, completeVarNames);
					for (boolean[] x:list) {
						for (Integer[] current:solutions) {
							if (x[num] == (val%2 == 1)) {
								int i=0;
								Integer[] newCurrent = duplicateArray(current, current.length);
								int count = 0;
								for (boolean b:x) {
									if (i+1<newCurrent.length && count != num)
										newCurrent[i++] += currentAdd * (b ? 1:0);
									count++;
								}
									
								addIfNotContained(newList ,newCurrent);
							}
						}
						
					}
					if (newList.size() > 0) 
						result.addAll(getValuesFor(to,varName,((val-(val%2))/2),currentAdd*2,newList,ignore));

				}
				
			}
		}
		
		return result;
	}

	public Integer countVariables() {
		return variables.length;
	}
	
}
