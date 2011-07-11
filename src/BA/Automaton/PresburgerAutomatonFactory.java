package BA.Automaton;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

public class PresburgerAutomatonFactory {

	private static BDDFactory factory = null;
	private Hashtable<String , BDD> variables = new Hashtable<String , BDD>();
	private SortedSet<String> completeVariableMapping;
	
	private static PresburgerAutomatonFactory singletonFactory;
	
	//TODO: Maybe reset to private
	public PresburgerAutomatonFactory(String[] variables) {


		SortedSet<String> list = new TreeSet<String>();
		for (String x:variables) {
			list.add(x);
		}
		
		this.variables.clear();
		this.completeVariableMapping = list;
		
		factory = BDDFactory.init("java",10000, 1000);
		if (variables.length > 0)
			factory.setVarNum(variables.length);
		else
			factory.setVarNum(1);
		
		Iterator<String> it = list.iterator();
		int j = 0;
		while (it.hasNext()) {
			this.variables.put(it.next() , factory.ithVar(j++));
		}

		
		
	}
	
	/**
	 * Get a PresburgerAutomatonFactory (Singleton)
	 * @param variables
	 * @return
	 */
	public static PresburgerAutomatonFactory init(String[] variables) {
		singletonFactory = new PresburgerAutomatonFactory(variables);
		
		return singletonFactory;
	}
	
	public static PresburgerAutomatonFactory getInstance() {
		return singletonFactory;
	}
	
	/**
	 * Returns an automaton for the active variables
	 * @param activeVariables
	 * @return
	 */
	public PresburgerAutomaton getAutomaton(String[] activeVariables) {
		SortedSet<String> list = new TreeSet<String>();
		for (int i=0; i<activeVariables.length; i++) {
			list.add(activeVariables[i]);
		}
		
		Iterator<String> it = list.iterator();
		int j = 0;
		BDD[] vars = new BDD[activeVariables.length];
		String[] varNames = new String[activeVariables.length];
		while (it.hasNext()) {
			varNames[j] = it.next();
			vars[j] = this.variables.get(varNames[j]);
			j++;
		}
		

		return new PresburgerAutomaton(vars , varNames,completeVariableMapping.toArray(new String[completeVariableMapping.size()]));
	}
	

	/**
	 * Returns the zero-BDD
	 * @return
	 */
	public static BDD getZero() {
		return factory.zero();
	}
	
	
	/**
	 * Returns the one-BDD
	 * @return
	 */
	public static BDD getOne() {
		return factory.one();
	}
	
	public SortedSet<String> getCompleteVariableMapping() {
		return this.completeVariableMapping;
	}
	
	public void freeBDDs() {
		factory = BDDFactory.init("java",10000, 1000);
		factory.setVarNum(this.variables.size());
	
	}
	
}
