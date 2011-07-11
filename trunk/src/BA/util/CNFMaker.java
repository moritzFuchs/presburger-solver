package BA.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import net.sf.javabdd.BDD;


/**
 * Takes a BDD and returns the CNF-Formula for it
 * @author moritzfuchs
 *
 */
public class CNFMaker {

	
	/**
	 * Returns the CNF-form of a BDD formula as a String representation.
	 */
	@SuppressWarnings("unchecked")
	public static String makeFormula(BDD x , BDD[] variables , String[] varNames, String[] completeVarNames) {
		
		Iterator<byte[]> it =  (Iterator<byte[]>) x.allsat().iterator();
		
		List<HashMap<String,Boolean>> cnf = new LinkedList<HashMap<String,Boolean>>(); 
		List<HashMap<String,Boolean>> pre_result = new LinkedList<HashMap<String,Boolean>>();
		
		while (it.hasNext()) {
			byte[] currentBytes = (byte[]) it.next();
			int compNum = 0;
			List<HashMap<String,Boolean>> cm = new LinkedList<HashMap<String,Boolean>>();
			HashMap<String,Boolean> c = new HashMap<String,Boolean>(); 
			cm.add(c);
			for (int i = 0;i<completeVarNames.length; i++) {
				if (compNum<varNames.length && varNames[compNum].compareTo(completeVarNames[i]) == 0) {
					if (currentBytes[i] == 1) {
						for (HashMap<String,Boolean> cmItem:cm) {
							c.put(varNames[compNum].toString(), true);
						}
					}
					else if (currentBytes[i] == 0) {
						for (HashMap<String,Boolean> cmItem:cm) {
							c.put(varNames[compNum].toString(), false);
						}
					} else {
						List<HashMap<String,Boolean>> cmItemCloneList = new LinkedList<HashMap<String,Boolean>>();
						for (HashMap<String,Boolean> cmItem:cm) {
							HashMap<String,Boolean> cmItemClone = (HashMap<String, Boolean>) cmItem.clone();
							cmItemClone.put(varNames[compNum].toString(), true);
							cmItemCloneList.add(cmItemClone);
							cmItem.put(varNames[compNum].toString(), false);
						}
						cm.addAll(cmItemCloneList);
					}
					compNum++;
				}
			}
			pre_result.addAll(cm);
		}
		

		//Go through every formula in DNF
		for (HashMap<String,Boolean> map:pre_result) {
			
			if (cnf.isEmpty()) {
				//Just save the first part of the DNF
				HashMap<String,Boolean> part;
				for (String key:map.keySet()) {
					part = new HashMap<String,Boolean>();
					if (map.get(key))
						part.put(key, true);
					else
						part.put(key, false);
					cnf.add(part);
				}
			} else {
				List<HashMap<String,Boolean>> newCNF = new LinkedList<HashMap<String,Boolean>>(); 
				for (HashMap<String,Boolean> currentMap:cnf) {
					//Add map to every component of the CNF
					for (String key:map.keySet()) {
						HashMap<String,Boolean> newCurrentMap = (HashMap<String, Boolean>) currentMap.clone();
						boolean take = true;
						if (newCurrentMap.containsKey(key)) {
							if (newCurrentMap.get(key)) {
								if (!map.get(key))
									take = false;
							} else {
								if (map.get(key))
									take = false;
							}
						} else {
							newCurrentMap.put(key, map.get(key));
						}
						
						if (take) {
							//CHeck if it's in the list already
							boolean found = false;
							for (HashMap<String,Boolean>inList:newCNF) {
								boolean thisIteration = true;
								for (String newVar:newCurrentMap.keySet()) {
									if (inList.containsKey(newVar)) {
										if (inList.get(newVar) == newCurrentMap.get(newVar)) {
											continue;
										} 
									}
									thisIteration = false;
									break;
								}
								found = thisIteration;
								
								if (found)
									break;
							}
							
							//If we can't find it it's not yet in the list!
							if (!found)
								newCNF.add(newCurrentMap);
							
						}
						
					}
					
				}

				cnf = newCNF;
			}
		}
		
		String result = "";
		
		if (cnf.size() > 0) {
			for (HashMap<String,Boolean> map:cnf) {
				if (map.keySet().size() > 0) {
					String preresult = "( ";
					for (String s:map.keySet()) {
						if (!map.get(s))
							preresult += "!";
						preresult += s + " v ";
					}
					preresult = preresult.substring(0 , preresult.length()-3);
					preresult+= " )";
					if (!result.matches(".*" + preresult +".*")) {
						result += preresult + " ^ ";
					}
				}
				
			}
			
			result = result.substring(0 , result.length()-3);
		} else {
			result = "true";
		}
		
		
		return result;
	}
}
