package BA.Solver;

import java.util.Collection;
import java.util.Hashtable;

public class MacroManager {

	private Integer idcount = 1;
	
	public Hashtable<String,Macro> macros = new Hashtable<String,Macro>();
	public Hashtable<Integer,Macro> macrosById = new Hashtable<Integer,Macro>();
	
	public Integer addMacro(String macro) throws Exception {
		Macro add = new Macro(macro , idcount++,this);
		macros.put(add.getName() , add);
		macrosById.put(add.getId() , add);
		return add.getId();
	}
	
	public Macro getMacroById(Integer id) {
		return macrosById.get(id);
	}
	
	public boolean macroExists(String name){
		
		if (macros.containsKey(name))
			return true;
		
		return false;
	}
	
	/**
	 * Returns the id of an existing Macro (or -1 if it doesn't exist)
	 * @param macro
	 * @return
	 */
	public Integer exists(String macro) {
		if (macro == null)
			return -1;
		String[] parts = macro.split("\\(");
		Macro a = macros.get(parts[0]);
		if (a != null)
			return a.getId();
		else
			return -1;
	}
	
	public Collection<Macro> getAllMacros() {
		return macros.values();
	}
	
	public void deleteId(Integer id) {
		Macro m = macrosById.get(id);
		if (m != null) {
			macrosById.remove(m.getId());
			Macro m2 = macros.get(m.getName());
			if (m == m2)
				macros.remove(m.getName());
		}
	}
	
	public Macro getMacro(String name) {

		if (macros.containsKey(name)) {
			return macros.get(name);
		}
		return null;
	}
	
	public String toString() {
		String res = "";
		for (String s:macros.keySet()) {
			res += s + " ";
		}
		return res;
	}
	
	public Integer size() {
		return macros.size();
	}
	
	public void clear() {
		macros.clear();
		macrosById.clear();
	}
	
}
