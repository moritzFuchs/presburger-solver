package BA.Logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.tree.CommonTree;

import BA.Solver.Parser.PresburgerLexer;
import BA.Solver.Parser.PresburgerParser;

public class Formula {

	private Element op;
	
	private TreeMap<String,Integer> equ;
	
	private Integer bound;
	
	private Formula() {
		
	}
	
	public Formula(List<CommonTree> left , List<CommonTree> right , int type, Hashtable<String, Integer> dynMapping) throws UnknownDynamicVariable {
		make(left,right,type,dynMapping);	
	}
	
	public void negate() {
		
		if (this.op == Element.TRUE) {
			this.op = Element.FALSE;
			return;
		}
		
		if (this.op == Element.FALSE) {
			this.op = Element.TRUE;
			return;
		}
		
		if (this.op == Element.EQ) {
			this.op = Element.NEQ;
			return;
		}
		
		if (this.op == Element.NEQ) {
			this.op = Element.EQ;
			return;
		}
		
		for (String x:equ.keySet()) {
			this.equ.put(x, -1*this.equ.get(x));
		}
		
		this.bound *= -1;
		this.bound -= 1;
		
		simplify();
		
	}
	
	private void make(List<CommonTree> left , List<CommonTree> right , int type,Hashtable<String, Integer> dynMapping) throws UnknownDynamicVariable {
		
		String varName = null;
		Integer solution = 0;
		TreeMap<String,Integer> equation = new TreeMap<String,Integer>();
		
		int offset = 0;
		int mult = 1;
		
		switch(type) {
			case PresburgerParser.GEQ: {
				this.op = Element.LEQ;
				mult = -1;
				break;
			} 
			case PresburgerParser.GT: {
				this.op = Element.LEQ;
				mult = -1;
				offset = -1;
				break;
			}
			case PresburgerParser.LT: {
				this.op = Element.LEQ;
				offset = -1;
				break;
			}
			case PresburgerParser.LEQ: {
				this.op = Element.LEQ;
				break;
			}
			case PresburgerParser.EQ: {
				this.op = Element.EQ;
				break;
			}
			case PresburgerParser.NEQ: {
				this.op = Element.NEQ;
				break;
			}
		}

		
		for (CommonTree x:left) {
			Integer tmp;
			if (x.getType() == PresburgerLexer.MINUS) 
				tmp = -1;
			else
				tmp = 1;
			
			solution = makeVariable(dynMapping, solution, equation, x, tmp);
		}
		
		for (CommonTree x:right) {
			Integer tmp;
			if (x.getType() == PresburgerLexer.MINUS) 
				tmp = 1;
			else
				tmp = -1;
				
			solution = makeVariable(dynMapping, solution, equation, x, tmp);
		}

		solution *= mult;
		solution += offset;
		
		for (String var:equation.keySet()) {
			equation.put(var, equation.get(var)*mult);
		}
		
		
		bound = solution;
		
		int gcd = gcd(equation.values().toArray(new Integer[equation.size()]));
		gcd = gcd(gcd,bound);
		if (gcd >= 1) {
			
			for(String i:equation.keySet()) {
				equation.put(i,(Integer)(equation.get(i)/gcd));
			}
			
			bound = (Integer)(bound/gcd);
		}

		HashSet<String> rem = new HashSet<String>();
		for (String var:equation.keySet()) {
			if (equation.get(var) == 0)
				rem.add(var);				
		}
		
		for (String s:rem) {
			equation.remove(s);
		}
		
		if (this.op == Element.LEQ) {
			if (equation.isEmpty()) {
				if (0 <= solution)
					this.op = Element.TRUE;
				else
					this.op = Element.FALSE;
			}
		} 
		
		if (this.op == Element.EQ) {
			if (equation.isEmpty()) {
				if (0 == solution)
					this.op = Element.TRUE;
				else
					this.op = Element.FALSE;
			}
		} 
		
		if (this.op == Element.NEQ) {
			if (equation.isEmpty()) {
				if (0 != solution)
					this.op = Element.TRUE;
				else
					this.op = Element.FALSE;
			}
		}
		

		equ = equation;
	}

	private Integer makeVariable(Hashtable<String, Integer> dynMapping,
			Integer solution, TreeMap<String, Integer> equation, CommonTree x,
			Integer tmp) throws UnknownDynamicVariable {
		String varName;
		if (x.getChild(0).getType() == PresburgerLexer.INT) {
			Integer currentValue = Integer.valueOf(x.getChild(0).getText());
			//This could be a Variable or a constant.
			if (x.getChild(1) != null) {
				
				if (x.getChild(2) != null) {
					//VAR VAR => First VAR has to be a dynMapping-VAR
					String dynVarName = x.getChild(1).getText();
					varName = x.getChild(2).getText();
					
					if (!dynMapping.containsKey(dynVarName)) {
						throw new UnknownDynamicVariable("The dynamic variable " + dynVarName + " is unknown. Please make sure, you instantiated it using either &&[] or ||[]");
					} else {
						System.out.println("test "+ dynMapping.get(dynVarName));
						currentValue *= dynMapping.get(dynVarName); 
					}
					
				} else {
					//This is a normal VAR
					varName = x.getChild(1).getText();
				}
				

				boolean found = false;
				for (String var:dynMapping.keySet()) {
					System.out.println(var + " <--> " + varName);
					if (varName.equals(var)) {
						solution -= tmp*currentValue*dynMapping.get(var);
						found = true;
						break;
					}
					//Just change the varName, not the value itself
					varName = varName.replace("["+var+"]" , "["+dynMapping.get(var)+"]");
					
					Pattern p = Pattern.compile("\\[" + var + "\\+" + "\\d+" + "\\]");
					Matcher m = p.matcher(varName);
					while(m.find()) {
						String match = m.group();
						String num = match.substring(3,match.length()-1);
						Integer realNum = Integer.valueOf(num);
						varName = varName.replace(match , "["+(dynMapping.get(var)+realNum)+"]");
					}
				}
				
				if (!found) {
					if (equation.containsKey(varName))
						equation.put(varName , equation.get(varName)+tmp*currentValue);
					else
						equation.put(varName , tmp*currentValue);
				}
				
				
			} else {
				solution -= tmp*currentValue;
			}
				
		} else { //VAR
			//TODO: Cover this case.
		}
		return solution;
	}
	
	private static int gcd(Integer[] input) {
		int result = 0;
		for (Integer i:input) {
			if (result == 0) {
				result = i;
			} else {
				result = gcd(result,i);
			}
		}
		
		return result;
	}
	
	public static int gcd(int c, int d) {
		int a = c;
		int b = d;
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		
		   if (b==0) 
		     return a;
		   else
		     return gcd(b, a % b);
		 } 
	
	public Integer eval(Boolean[] nextBits) {
		
		
		if (nextBits.length == equ.size()) {
			Integer result = 0;
			int num = 0;
			for(String i:equ.keySet()) {
				if (nextBits[num++])
					result += equ.get(i);
			}
			return result;
		}
		return -1;
	}
	
	public String[] getVarNames() {
		return this.equ.keySet().toArray(new String[equ.size()]);
	}
	
	public Integer getBound() {
		return this.bound;
	}
	
	public String toString() {
		String result = "";
		for(String i:equ.keySet()) {
			result += " +" + equ.get(i) + i;
		}
		
		result += this.op.toString() + bound;
		
		return result;
	}
	
	/**
	 * Gets a formula f and a Element e, from the propagation algorithm and tries to 'learn' from them. E.g. if this is x+y<=4 , f is x==4 and e = AND, the result is y <= 0
	 * @param f
	 * @return true, if the whole subtree has do be deleted
	 */
	public void getPropagationAndAct(Formula f , Element e) {
		
		if (this == f)
			return;
		
		//First, check if everything from f is in here, too.
		
		boolean equalPrefixes = true;
		boolean fAllOne = true;
		boolean negEqualPrefixes = true;
		for (String x:f.equ.keySet()) {
			if (!this.equ.containsKey(x)) {
				return ;
			} else {
				fAllOne = fAllOne && f.equ.get(x) == 1;
				equalPrefixes = equalPrefixes && (f.equ.get(x) == this.equ.get(x)) ; 
				negEqualPrefixes = negEqualPrefixes && (f.equ.get(x) == (-1)*this.equ.get(x)) ;
			}
		}
		
		//Now we're sure, every variable from f is in here, too
		if (e == Element.AND) {
			
			
			if (f.op == Element.EQ && f.equ.size() == 1 && fAllOne) {
				String var = f.equ.keySet().toArray(new String[1])[0];
				this.bound = this.bound - this.equ.get(var) * f.bound;
				this.equ.remove(var);
				checkBounds();
			}
			
			if (f.op == Element.EQ && equalPrefixes) {
				//In this case we can just put in the bound of f instead of the left hand side of f in here.
				for (String x:f.equ.keySet()) {
					this.equ.remove(x);
				}
				this.bound = this.bound - f.bound;
				if (this.equ.size() == 0) {
					checkBounds();
				return;
				}	
			}
			
			if (this.equ.size() == f.equ.size()) {

				if (this.op == Element.EQ && f.op == Element.EQ) {
					if (this.bound != f.bound) {
						this.op = Element.FALSE;
					} else {
						//MAKE SURE THIS CASE IS TRUE
						this.op = Element.TRUE;
					}
				}
				
				if (this.bound == f.bound && (this.op == Element.EQ && f.op == Element.NEQ) || (this.op == Element.NEQ && f.op == Element.EQ)) {
					this.op = Element.FALSE;
				}
				
				if (this.op == Element.LEQ && f.op == Element.LEQ) {
					if (negEqualPrefixes && this.bound == (-1)*f.bound) {
						this.op = Element.EQ;
						return;
					} else {
						if (this.bound > f.bound) {
							this.op = Element.TRUE;
							return;
						}
					}
				}
			}
			
		} else {
			//That means we're in the OR-Case
			
			
		}

		simplify();
	}
	
	public void getPropagationAndAct2(Formula f,Element e) {
		
		//Check if the variable set is equal
		boolean sameVarSetF = true;
		boolean equalPrefixesF = true;
		boolean NEqualPrefixesF = true;
		for (String k:this.equ.keySet()) {
			if (!f.equ.containsKey(k)) {
				sameVarSetF = false;
				break;
			}
			equalPrefixesF = equalPrefixesF && (f.equ.get(k) == this.equ.get(k)) ;
			NEqualPrefixesF = NEqualPrefixesF && (f.equ.get(k) == (-1)*this.equ.get(k)) ;
		}
		
		boolean sameVarSetThis = true;
		boolean equalPrefixesThis = true;
		boolean NEqualPrefixesThis = true;
		for (String k:f.equ.keySet()) {
			if (!this.equ.containsKey(k)) {
				sameVarSetThis = false;
				break;
			}
			equalPrefixesThis = equalPrefixesThis && (f.equ.get(k) == this.equ.get(k)) ;
			NEqualPrefixesThis = NEqualPrefixesThis && (f.equ.get(k) == (-1)*this.equ.get(k)) ;
		}
		
		if (e == Element.AND) {
			//9 Cases
			
			if (this.op == Element.EQ && f.op == Element.EQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound != f.bound) {
						this.op = Element.FALSE;
					} else {
						this.op = Element.TRUE;
					}
				} else {
					if (sameVarSetThis) {
						//Check if we can insert f into this
						int multi = 0;
						boolean possible = true;
						for(String k:f.equ.keySet()) {
							if (multi == 0) {
								multi = this.equ.get(k) / f.equ.get(k);
								System.out.println(f.equ.get(k) + "/" + this.equ.get(k) + " = " + ((double)f.equ.get(k))/(double)this.equ.get(k));
								if (f.bound%(((double)f.equ.get(k))/(double)this.equ.get(k)) != 0) {
									possible = false;
									break;
								}
							} else {
								int tmpmulti = this.equ.get(k) / f.equ.get(k);
								if (tmpmulti != multi) {
									possible = false;
									break;
								}
							}
						}
						
						if (possible) {
							this.bound = this.bound - (multi)*f.bound;
							for(String k:f.equ.keySet()) {
								this.equ.remove(k);
							}
							
							if (this.equ.size() == 0) {
								if (this.bound != 0) {
									this.op = Element.FALSE;
								} else {
									this.op = Element.DELETE;
								}
							} else {
								if (!this.satisfyable()) {
									this.op = Element.FALSE;
								}
							}
						}
					}
				}
				
				return;
			}
			
			if (this.op == Element.EQ && f.op == Element.NEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound == f.bound) {
						this.op = Element.FALSE;
					}
				}
				return;
			}

			if (this.op == Element.EQ && f.op == Element.LEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound > f.bound) {
						this.op = Element.FALSE;
					}
				}
				return;
			}
			
			if (this.op == Element.NEQ && f.op == Element.EQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound == f.bound) {
						this.op = Element.FALSE;
					} else {
						this.op = Element.DELETE;
					}
				} else {
					if (sameVarSetThis) {
						//Check if we can insert f into this
						int multi = 0;
						boolean possible = true;
						for(String k:f.equ.keySet()) {
							if (multi == 0) {
								multi = this.equ.get(k) / f.equ.get(k);
								System.out.println(f.equ.get(k) + "/" + this.equ.get(k) + " = " + ((double)f.equ.get(k))/(double)this.equ.get(k));
								if (f.bound%(((double)f.equ.get(k))/(double)this.equ.get(k)) != 0) {
									possible = false;
									break;
								}
							} else {
								int tmpmulti = this.equ.get(k) / f.equ.get(k);
								if (tmpmulti != multi) {
									possible = false;
									break;
								}
							}
						}
						if (possible) {
							this.bound = this.bound - (multi)*f.bound;
							for(String k:f.equ.keySet()) {
								this.equ.remove(k);
							}
							
							if (this.equ.size() == 0) {
								if (this.bound != 0) {
									this.op = Element.TRUE;
								} else {
									this.op = Element.FALSE;
								}
							} else {
								if (!this.satisfyable()) {
									this.op = Element.FALSE;
								}
							}
						}
					}
				}
				return;
			}
			

			if (this.op == Element.NEQ && f.op == Element.LEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound > f.bound) {
						this.op = Element.TRUE;
					}
				}
				return;
			}
			
			if (this.op == Element.LEQ && f.op == Element.EQ) {
				
				
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound >= f.bound) {
						this.op = Element.TRUE;
					} else {
						this.op = Element.FALSE;
					}
				} else {
					if (sameVarSetThis) {
						//Check if we can insert f into this
						int multi = 0;
						boolean possible = true;
						for(String k:f.equ.keySet()) {
							if (multi == 0) {
								multi = this.equ.get(k) / f.equ.get(k);
								System.out.println(f.equ.get(k) + "/" + this.equ.get(k) + " = " + ((double)f.equ.get(k))/(double)this.equ.get(k));
								if (f.bound%(((double)f.equ.get(k))/(double)this.equ.get(k)) != 0) {
									possible = false;
									break;
								}
							} else {
								int tmpmulti = this.equ.get(k) / f.equ.get(k);
								if (tmpmulti != multi) {
									possible = false;
									break;
								}
							}
						}
						
						if (possible) {
							this.bound = this.bound - (multi)*f.bound;
							for(String k:f.equ.keySet()) {
								this.equ.remove(k);
							}
							if (this.equ.size() == 0) {
								if (this.bound >= 0) {
									this.op = Element.TRUE;
								} else {
									this.op = Element.FALSE;
								}
							} else {
								if (!this.satisfyable()) {
									this.op = Element.FALSE;
								}
							}
						}
					}
				}
				return;
			}
			

			if (this.op == Element.LEQ && f.op == Element.LEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					
					if (this.bound >= f.bound) {
						this.op = Element.DELETE;
					}
				}
				
				if (sameVarSetThis && sameVarSetF && NEqualPrefixesThis && NEqualPrefixesF) {
					if (this.bound == (-1)*f.bound) {
						this.op = Element.EQ;
					}
					
					if (this.bound < (-1)*f.bound) {
						this.op = Element.FALSE;
					}
					
				}
				simplify();
				
				return;
			}
		} else {
			//Thats OR with 4 cases
			if (this.op == Element.EQ && f.op == Element.LEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound == f.bound) {
						this.op = Element.DELETE;
					}
				}
				return;
			}
			
			if (this.op == Element.LEQ && f.op == Element.LEQ) {
				if (sameVarSetThis && sameVarSetF && equalPrefixesThis && equalPrefixesF) {
					if (this.bound <= f.bound) {
						this.op = Element.DELETE;
					}
				}
				if (sameVarSetThis && sameVarSetF && NEqualPrefixesThis && NEqualPrefixesF) {
					if (this.bound == (-1)*f.bound) {
						this.op = Element.TRUE;
					}
				}
				return;
			}
		}
		
			
		
	}
	
	private void checkBounds() {
		if (this.equ.size() == 0) {
			if (this.op == Element.NEQ) {
				//left hand side != right hand side, so we're fine
				if (this.bound != 0) {
					this.op = Element.TRUE;
				} else {
					this.op = Element.FALSE;	
				}
			} else {
				if (this.op == Element.EQ) {
					if (this.bound == 0)
						this.op = Element.TRUE;
					else {
						this.op = Element.FALSE;
					}
					return;
				} else {
					if (this.op == Element.LEQ) {
						if (this.bound >= 0)
							this.op = Element.TRUE;
						else {
							this.op = Element.FALSE;
						}
						return;
					}
				}
			}
			
			this.op = Element.TRUE;
		}
		
	}
	
	public Element getOP() {
		return this.op;
	}
	
	/**
	 * Checks if the current formula is satisfyable
	 * @return
	 */
	private boolean satisfyable() {
		boolean allNegative = true;
		boolean allPositive = true;
		for (Integer i:equ.values()) {
			allPositive = allPositive && (i>=0);
			allNegative = allNegative && (i<=0);
		}
		
		if (allNegative && this.bound > 0 && this.op == Element.EQ)
			return false;
		if (allPositive && this.bound < 0 && this.op == Element.EQ)
			return false;
		
		return true;
	}
	
	public void simplify() {
		boolean allNegative = true;
		for (Integer i:equ.values()) {
			allNegative = allNegative && (i <= 0);
		}
		allNegative = allNegative && (bound <= 0);
		
		if(allNegative && (this.op == Element.EQ || this.op == Element.NEQ)) {
			for (String s:equ.keySet()) {
				equ.put(s, (-1)*equ.get(s));
			}
			bound = bound*(-1);
			allNegative = allNegative && (bound <= 0);
		}

	}
	
	public Formula clone() {
		Formula clone = new Formula();
		clone.op = this.op;
		clone.equ = (TreeMap<String, Integer>) this.equ.clone();
		clone.bound = this.bound;
		return clone;
	}
	
	public void substitute(String[] arguments , List<Hashtable<String, Integer>> list) {
		
		TreeMap<String,Integer> newEqu = new TreeMap<String,Integer>();
		
		
		for (String key:equ.keySet()) {
			boolean found = false;
			for (int i=0;i<arguments.length;i++) {
				if (key.equals(arguments[i])) {
					found = true;
					for (String keyNew:list.get(i).keySet()) {
						if (keyNew == "bound") {
							this.bound -= list.get(i).get(keyNew);
							continue;
						}
						if (!newEqu.containsKey(keyNew))
							newEqu.put(keyNew, equ.get(key)*list.get(i).get(keyNew));
						else
							newEqu.put(keyNew, list.get(i).get(keyNew) + equ.get(key)*newEqu.get(keyNew));
						
						if (newEqu.get(keyNew) == 0)
							newEqu.remove(keyNew);
					}
					break;
				}
			}
			if (!found) {
				newEqu.put(key, equ.get(key));
			}
		}
		equ = newEqu;
		if (newEqu.isEmpty()) {
			if ((this.op == Element.EQ || this.op == Element.LEQ) && this.bound == 0)
				this.op = Element.TRUE;
			else
				this.op = Element.FALSE;
		}
	}

	public void substituteAll(Hashtable<String, String> subst) {
		for (String s:subst.keySet()) {
			if (equ.containsKey(s)) {
				equ.put(subst.get(s),equ.get(s));
				equ.remove(s);
			}
		}
	}
	
	
}

