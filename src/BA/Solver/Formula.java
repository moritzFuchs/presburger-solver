package BA.Solver;

public class Formula {

	private Integer[] prefix;
	private Character[] varNames;
	private Integer bound;
	
	public Formula(Integer[] prefix ,Character[] varNames, Integer bound) {
		this.prefix = prefix;
		this.varNames = varNames;
		this.bound = bound;		
	}
	
	
	public Integer eval(Boolean[] nextBits) {
		if (nextBits.length == prefix.length) {
			Integer result = 0;
			for (int i=0;i<prefix.length;i++) {
				if (nextBits[i])
					result += prefix[i];
			}
			return result;
		}
		return -1;
	}
	
	public Character[] getVarNames() {
		return this.varNames;
	}
	
	public Integer getBound() {
		return this.bound;
	}
	
	public String toString() {
		String result = "";
		for (int i=0;i<varNames.length;i++) {
			result += " "+prefix[i]+varNames[i];
		}
		
		result += " <= " + bound;
		
		return result;
	}
	
	
}
