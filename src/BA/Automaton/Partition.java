package BA.Automaton;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

public class Partition {

	private Integer id;
	private Set<State> states = new HashSet<State>();
	private Hashtable<State,Hashtable<State,BDD>> transitions = new Hashtable<State,Hashtable<State,BDD>>(); 
	private Hashtable<Integer, List<BDD>> groupTransitions = new Hashtable<Integer,List<BDD>>(); 
	
	private PresburgerAutomaton father;
	
	private static IdCounter idCounter = new IdCounter();
	private static Hashtable<State,Integer> partMap = new Hashtable<State,Integer>();
	
	public Partition(PresburgerAutomaton x) {
		this.father = x;
		this.id = this.idCounter.nextId();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addState(State s,Hashtable<State,BDD> transitions) {
		states.add(s);
		this.transitions.put(s,transitions);
		partMap.put(s, this.id);
	}
	
	public Set<State> getAllStates() {
		return states;
	}
	
	private void makeGroupTransitions() {
		Iterator<State> stateIt = states.iterator();
		while (stateIt.hasNext()) {
			State currentState = stateIt.next();
			Hashtable<Integer,Hashtable<State,BDD>> toAdd = new Hashtable<Integer,Hashtable<State,BDD>>();
			Enumeration<State> enumCurrentDestinations = transitions.get(currentState).keys();
			while (enumCurrentDestinations.hasMoreElements()) {
				State currentKey = enumCurrentDestinations.nextElement();
				if (toAdd.containsKey(partMap.get(currentKey))) {
					//FIXME: BAD!
					if (toAdd.get(partMap.get(currentKey)).containsKey(currentState)) {
						toAdd.get(partMap.get(currentKey)).put(
								currentState , 
								toAdd.get(partMap.get(currentKey)).get(currentState).apply(transitions.get(currentState).get(currentKey),BDDFactory.or));
					} else {
						toAdd.get(partMap.get(currentKey)).put(currentState, transitions.get(currentState).get(currentKey));
					}

				} else {
					toAdd.put(partMap.get(currentKey), new Hashtable<State,BDD>());
					toAdd.get(partMap.get(currentKey)).put(currentState, transitions.get(currentState).get(currentKey));
				}
			}
			
			Enumeration<Integer> enumToAdd = toAdd.keys();
			while (enumToAdd.hasMoreElements()) {
				Integer current = enumToAdd.nextElement();
				Enumeration<State> enumStateKeys = toAdd.get(current).keys(); 
				while (enumStateKeys.hasMoreElements()) {
					State currentStateKey = enumStateKeys.nextElement();
					
					if (!groupTransitions.containsKey(current))
						groupTransitions.put(current, new ArrayList<BDD>());
					
					groupTransitions.get(current).add(toAdd.get(current).get(currentStateKey));
				}

			}
		}

	}
	
	public Partition split() {
		
		if (states.size() > 1) {
			makeGroupTransitions();
			
			Enumeration<Integer> enumgroupKeys = groupTransitions.keys();
			BDD reason = null;
			Integer groupID = 0;
			while (enumgroupKeys.hasMoreElements() && (reason==null || groupID == 0)) {
				Integer currentGroupKey = enumgroupKeys.nextElement();
				if (groupTransitions.get(currentGroupKey).size() < states.size()) {
					reason = (BDD)groupTransitions.get(currentGroupKey).toArray()[0];
					groupID = currentGroupKey;
				} else {
					Iterator<BDD> iterGroupBDDs = groupTransitions.get(currentGroupKey).iterator();
					BDD before = null;
					BDD current;
					while (iterGroupBDDs.hasNext()) {
						current = iterGroupBDDs.next();
						if (before != null) {
							BDD res = current.apply(before, BDDFactory.and);
							if (!res.equals(current)) {
								//We have found a reason to split
								//First get the BDD with the letters
								BDD reason1 = current.apply(before.not() , BDDFactory.and);
								BDD reason2 = before.apply(current.not() , BDDFactory.and);
								reason = reason1.apply(reason2, BDDFactory.or);
								groupID = currentGroupKey;
								break;
							}
						}
						before = current;
					}
				}
			}
			
			//Just some Debug-prints
//			if (reason != null) {
//				System.out.print("Splitting with " + father.getAllSat(reason).get(0)[0] + " ");
//				Iterator<State> iterStates = states.iterator();
//				while (iterStates.hasNext()) {
//					System.out.print(iterStates.next().getName() + " ");
//				}
//				System.out.println(this.id + " " + groupID);
//			}

			if (reason != null) {
				// Now we have found a group and a letter to split
				// So let's split it!
				Partition newPart = new Partition(this.father);
				Iterator<State> iterAllStates = states.iterator();
				List<State> gone = new ArrayList<State>();
				while (iterAllStates.hasNext()) {
					State current = iterAllStates.next();
					Enumeration<State> enumDest = transitions.get(current).keys();
					//Go through all transitions
					while (enumDest.hasMoreElements()) {
						State currentDest = enumDest.nextElement();
						if (father.runBDD(transitions.get(current).get(currentDest), father.getAllSat(reason).get(0))) {
							
							//through out if not in right group
							if (partMap.get(currentDest) != groupID) {
								gone.add(current);
								break;
							}
						}
					}
				}
				
				//Remove gone states from list and add them to new Partition
				Iterator<State> iterGone = gone.iterator();
				while (iterGone.hasNext()) {
					State current = iterGone.next();
					newPart.addState(current, transitions.get(current));
					states.remove(current);
					transitions.remove(current);
				}
				return newPart;
			}
		}
		return null;
	}
	
	public boolean isFinal() {
		return ((State)states.toArray()[0]).isFinal();
	}
	
	public boolean containsInitial() {
		Iterator<State> iterStates = states.iterator();
		while (iterStates.hasNext()) {
			if (iterStates.next().isInitial())
				return true;
		}
		return false;
	}
	
	public static int getDestinationPartition(State s) {
		return partMap.get(s);
	}
	
	public static void reset() {
		idCounter = new IdCounter();
		partMap.clear();
	}
	
}
