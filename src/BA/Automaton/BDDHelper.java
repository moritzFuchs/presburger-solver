package BA.Automaton;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

public class BDDHelper {

	private static Hashtable<String,Boolean> cachedRunBDD = new Hashtable<String,Boolean>();
	
	
	/**
	 * Runs a given BDD on the input and gives result.
	 * @param toTry
	 * @param input
	 * @return True if BDD accepts the input, false if not.
	 */
	protected static boolean runBDD(BDD toTry , Character[] input , BDD[] variables) {
		
		
		if (input.length != variables.length || variables.length == 0) {
			boolean ret = toTry.isOne(); 
			return ret;
		}
		
		BDD restr = PresburgerAutomatonFactory.getOne();
		BDD x;
		BDD y;
		
		if (input.length > 1) {
		
			for (int i = 0; i<variables.length-1;i++) {
				if (input[i] == '1')
					x = variables[i];
				else
					x = variables[i].not();
				
				
				if (input[i+1] == '1')
					y = variables[i+1];
				else
					y = variables[i+1].not();
				
				BDD u = x.apply(y,BDDFactory.and);
				restr.andWith(u);
			}
		} else {
			if (input[0] == '1')
				restr = variables[0];
			else
				restr = variables[0].not();
		}
		
		BDD output = toTry.restrict(restr);
		
		boolean ret = output.isOne();
		return ret;
	}
	
	protected static Integer getSatCount(BDD b , String[] varNames, String[] completeVarNames , boolean zeros) {

		Integer result = 0;
		Integer mult = 1;

		boolean hasZero = false;
		
		Iterator<byte[]> it =  (Iterator<byte[]>) b.allsat().iterator();
		
		while (it.hasNext()) {
			mult = 1;
			byte[] currentBytes = (byte[]) it.next();
			int compNum = 0;
			boolean hz = true;
			for (int i = 0;i<completeVarNames.length; i++) {
				if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
					if (currentBytes[i] == 1) {
						hz = false;
					}
					else if (currentBytes[i] == 0) {
						
					} else {
						mult *= 2;
					}
					compNum++;
				}
			}
			result+=mult;
			if (hz)
				hasZero = true;
		}

		if (!zeros && hasZero)
			return result-1;
		
		return result;

	}

	protected static List<boolean[]> getAllSat(BDD b , String[] varNames, String[] completeVarNames) {
		
		List<boolean[]> result = new LinkedList<boolean[]>();
		
		
		Iterator<byte[]> it =  (Iterator<byte[]>) b.allsat().iterator();
		
		while (it.hasNext()) {
			byte[] currentBytes = (byte[]) it.next();
			int compNum = 0;
			List<boolean[]> pre_result = new LinkedList<boolean[]>();
			boolean[] start = new boolean[varNames.length];
			pre_result.add(start);
			
			for (int i = 0;i<completeVarNames.length; i++) {
				
				if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
					if (currentBytes[i] == 1) {
						for (boolean[] r:pre_result) {
							r[compNum] = true;
						}
					} else {
						if (currentBytes[i] == 0) {
							for (boolean[] r:pre_result) {
								r[compNum] = false;
							}
						} else {
							//Double the result
							List<boolean[]> newList = new LinkedList<boolean[]>();
							for (boolean[] r:pre_result) {
								boolean[] newArray = duplicateArray(r,varNames.length);
								r[compNum] = true;
								newArray[compNum] = false;
								newList.add(r);
								newList.add(newArray);
							}
							pre_result = newList;
						}
					}
					compNum++;
				}
			}
			result.addAll(pre_result);
		}
		
		
		return result;
	}

	private static boolean[] duplicateArray(boolean[] array , Integer l) {
		boolean[] ret = new boolean[l];
		int i=0;
		for (boolean b:array) {
			ret[i++] = b;
		}
		return ret;
	}
	
	
	protected static boolean isZeroTransition(BDD b, String[] varNames, String[] completeVarNames) {
		
		if (b.isOne())
			return false;
		
		boolean zero = true;
		boolean once = true;

		Iterator<byte[]> it =  (Iterator<byte[]>) b.allsat().iterator();
		
		int g=0;
		while (it.hasNext()) {
			if (g == 0)
				g++;
			else
				once = false;
			
			byte[] currentBytes = (byte[]) it.next();
			int compNum = 0;
			List<HashMap<String,Boolean>> cm = new LinkedList<HashMap<String,Boolean>>();
			HashMap<String,Boolean> c = new HashMap<String,Boolean>(); 
			cm.add(c);
			for (int i = 0;i<completeVarNames.length; i++) {
				if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
					if (currentBytes[i] != 0) {
						return false;
					}
					
					compNum++;
				}
			}
		}
		
		return once && zero;
	}

	public static boolean hasElementWith(BDD bdd, String varName, int val , String[] completeVarNames) {
		
		Iterator<byte[]> it =  (Iterator<byte[]>) bdd.allsat().iterator();
		
		while (it.hasNext()) {
			byte[] currentBytes = (byte[]) it.next();

			for (int i = 0;i<completeVarNames.length; i++) {
				if (varName.compareTo(completeVarNames[i]) == 0) {
					if (currentBytes[i] == val) {
						return true;
					} 
				}
			}
		}
		
		return false;
	}
	
	
	
}
