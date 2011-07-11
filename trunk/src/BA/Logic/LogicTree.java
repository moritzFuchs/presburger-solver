package BA.Logic;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.tree.CommonTree;

import BA.Solver.Macro;
import BA.Solver.MacroManager;
import BA.Solver.Parser.PresburgerLexer;

public class LogicTree {
	
	private boolean isFormula = false;
	private boolean isNode = false;
	
	private boolean delete = false;
	
	private Element op;
	private String var;
	
	private List<LogicTree> children = new LinkedList<LogicTree>();
	private LogicTree father = null;
	private Formula formula;
	
	private HashSet<String> addedVars = new HashSet<String>();
	
	private MacroManager m = null;
	
	public LogicTree(LogicTree from) {
		this.father = from;
	}
	
	public LogicTree(CommonTree ast) throws UnknownDynamicVariable, UnknownMacroException, ArgumentMismatchException {
		Hashtable<String,Integer> dynMapping = new Hashtable<String,Integer>();
		init(ast,null,dynMapping);
	}
	
	public LogicTree(CommonTree ast,MacroManager m) throws UnknownDynamicVariable, UnknownMacroException, ArgumentMismatchException {
		Hashtable<String,Integer> dynMapping = new Hashtable<String,Integer>();
		this.m = m;
		init(ast,null,dynMapping);
	}
	
	private LogicTree() {
		
	}
	
	public LogicTree(CommonTree ast , LogicTree from) throws UnknownDynamicVariable, UnknownMacroException, ArgumentMismatchException {
		Hashtable<String,Integer> dynMapping = new Hashtable<String,Integer>();
		init(ast,from,dynMapping);
	}
	
	public void putMacroManager(MacroManager m) {
		this.m = m;
	} 
	
	/**
	 * Makes a normal logicTree from the ast, but replace all occurences of the mappings with the number (also in array-indices)
	 * @param ast
	 * @param from
	 * @param mapping
	 * @throws UnknownDynamicVariable 
	 * @throws UnknownMacroException 
	 */
	public LogicTree(CommonTree ast , LogicTree from , Hashtable<String,Integer> mapping,MacroManager m) throws UnknownDynamicVariable, UnknownMacroException, ArgumentMismatchException {
		this.m = m;
		init(ast,from,mapping);
	}
	
	private void init(CommonTree ast , LogicTree from , Hashtable<String,Integer> dynMapping) throws UnknownDynamicVariable, UnknownMacroException, ArgumentMismatchException  {
		father = from;

		int token = ast.getToken().getType();
		
		
		switch (token) {
			case PresburgerLexer.QUANT : {
				
				String complete = ast.getText();
				String type = complete.substring(0,1); 
				complete = complete.substring(1,complete.length());
				complete = complete.substring(0,complete.length()-1);
				
				List<String> names = new LinkedList<String>();
				Pattern pat = Pattern.compile("[a-z](\\[([a-z]|[0-9]+)\\])*");
				Matcher mat = pat.matcher(complete);
				while(mat.find())
				{
					names.add(mat.group(0));
				}
				
				if(type.equals("E")) {
					//Exists-Quantifier
					op = Element.EX;
					LogicTree current = this;
					boolean first = true;
					for (String var:names) {
						if (!first) {
							LogicTree old = current;
							current = new LogicTree();
							old.children.add(current);
							current.father = current;
							current.op = Element.EX;
						}
						current.var = var;
						for (String mapVar:dynMapping.keySet()) {
							current.var = current.var.replace("["+mapVar+"]" , "["+dynMapping.get(mapVar)+"]");
						}
						first = false;
					}
					
					current.children.add(new LogicTree((CommonTree)ast.getChild(0) , this,dynMapping,this.m));
					current.isNode = true;
					
					
				} else {
					//All-Quantifier
					op = Element.NEG;
					
					LogicTree l = new LogicTree(this);
					l.m = this.m;
					l.op = Element.EX;
					
					LogicTree current = l;
					boolean first = true;
					for (String var:names) {
						if (!first) {
							LogicTree old = current;
							current = new LogicTree();
							current.m = this.m;
							old.children.add(current);
							current.father = current;
							current.op = Element.EX;
						}
						current.var = var;
						for (String mapVar:dynMapping.keySet()) {
							current.var = current.var.replace("["+mapVar+"]" , "["+dynMapping.get(mapVar)+"]");
						}
						current.isNode = true;
						first=false;
					}
					
					children.add(l);
					
					LogicTree l2 = new LogicTree(current);
					l2.m = this.m;
					l2.op = Element.NEG;
					l2.isNode = true;
					current.children.add(l2);
					
					l2.children.add(new LogicTree((CommonTree)ast.getChild(ast.getChildCount()-1) , this, dynMapping,this.m));
					
					isNode = true;
					
				}
				
				break;
			}
		
			/*********** OUTDATED ********************/
			case PresburgerLexer.ALL : {
				op = Element.NEG;
				
				LogicTree l = new LogicTree(this);
				l.m = this.m;
				l.op = Element.EX;
				
				LogicTree current = l;
				for (int i=0;i<=ast.getChildCount()-2;i++) {
					if (i != 0) {
						LogicTree old = current;
						current = new LogicTree();
						current.m = this.m;
						old.children.add(current);
						current.father = current;
						current.op = Element.EX;
					}
					current.var = ast.getChild(i).getText();
					for (String var:dynMapping.keySet()) {
						current.var = current.var.replace("["+var+"]" , "["+dynMapping.get(var)+"]");
					}
					current.isNode = true;
				}
				
				children.add(l);
				
				LogicTree l2 = new LogicTree(current);
				l2.m = this.m;
				l2.op = Element.NEG;
				l2.isNode = true;
				current.children.add(l2);
				
				l2.children.add(new LogicTree((CommonTree)ast.getChild(ast.getChildCount()-1) , this, dynMapping,this.m));
				
				isNode = true;
				break;
			}
			case PresburgerLexer.EX : {
				op = Element.EX;
				LogicTree current = this;
				for (int i=0;i<=ast.getChildCount()-2;i++) {
					if (i != 0) {
						LogicTree old = current;
						current = new LogicTree();
						old.children.add(current);
						current.father = current;
						current.op = Element.EX;
					}
					current.var = ast.getChild(i).getText();
					for (String var:dynMapping.keySet()) {
						current.var = current.var.replace("["+var+"]" , "["+dynMapping.get(var)+"]");
					}
				}
				
				current.children.add(new LogicTree((CommonTree)ast.getChild(ast.getChildCount()-1) , this,dynMapping,this.m));
				current.isNode = true;
				break;
			}
			
			/*********** END OUTDATED ********************/
			
			case PresburgerLexer.AND : {
				op = Element.AND;
				for (int i=0;i<ast.getChildCount();i++) {
					children.add(new LogicTree((CommonTree)ast.getChild(i) , this,dynMapping,this.m));
				}
				isNode = true;
				break;
			}
			case PresburgerLexer.OR : {
				op = Element.OR;
				for (int i=0;i<ast.getChildCount();i++) {
					children.add(new LogicTree((CommonTree)ast.getChild(i), this,dynMapping,this.m));
				}
				isNode = true;
				break;
			}
			case PresburgerLexer.IMP : {
				op = Element.OR;
				LogicTree l = new LogicTree(this);
				l.op = Element.NEG;
				l.isNode = true;
				children.add(l);
				
				l.children.add(new LogicTree((CommonTree)ast.getChild(0), l,dynMapping,this.m));
				
				children.add(new LogicTree((CommonTree)ast.getChild(1), this,dynMapping,this.m));
				isNode = true;
				break;
			}
			
			case PresburgerLexer.BIIMP : {
				op = Element.AND;
				
				LogicTree l = new LogicTree(this);
				l.op = Element.OR;
				l.isNode = true;
				children.add(l);
				
				LogicTree ll = new LogicTree(l);
				ll.op = Element.NEG;
				ll.isNode = true;
				l.children.add(ll);
				
				ll.children.add(new LogicTree((CommonTree)ast.getChild(0), ll,dynMapping,this.m));
				
				l.children.add(new LogicTree((CommonTree)ast.getChild(1), l,dynMapping,this.m));
				
				
				LogicTree r = new LogicTree(this);
				r.op = Element.OR;
				r.isNode = true;
				children.add(r);
				
				LogicTree rl = new LogicTree(r);
				rl.op = Element.NEG;
				rl.isNode = true;
				r.children.add(rl);
				
				rl.children.add(new LogicTree((CommonTree)ast.getChild(1), rl,dynMapping,this.m));
				
				r.children.add(new LogicTree((CommonTree)ast.getChild(0), r,dynMapping,this.m));
				
				isNode = true;
				break;
			}
			
			case PresburgerLexer.NEG : {
				op = Element.NEG;
				children.add(new LogicTree((CommonTree)ast.getChild(0), this,dynMapping,this.m));
				isNode = true;
				break;
			}
			//Formula of the form A comp B comp C
			case PresburgerLexer.PRED : {
				List<Formula> result = new LinkedList<Formula>();
				List<CommonTree> left = new LinkedList<CommonTree>();
				List<CommonTree> right = new LinkedList<CommonTree>();
				
				boolean ready = false;
				int lastToken = 0;
				for (int i=0;i<ast.getChildCount();i++) {
					if (ast.getChild(i).getType() == PresburgerLexer.MINUS || ast.getChild(i).getType() == PresburgerLexer.PLUS) {
						if (!ready)
							left.add((CommonTree)ast.getChild(i));
						else
							right.add((CommonTree)ast.getChild(i));
					} else {
						if (ready) {
							Formula f = new Formula(left,right,lastToken,dynMapping);
							result.add(f);
							left = right;
							right = new LinkedList<CommonTree>();
							lastToken = ast.getChild(i).getType();
							ready = true;
						} else {
							ready = true;
							lastToken = ast.getChild(i).getType();
						}
					}
				}
				Formula f = null;
				if (lastToken != 0)
					f = new Formula(left,right,lastToken,dynMapping);
				else {
					//TODO: Make up a nice Exception name for this :)
				}
				
				result.add(f);
				
				if (result.size() > 1) {
					//Make this a AND
					op = Element.AND;
					isNode = true;
					for (Formula x:result) {
						LogicTree add = new LogicTree();
						add.isFormula = true;
						add.formula = x;
						if (x.getOP() == Element.FALSE)
							this.op = Element.FALSE;
						if (x.getOP() == Element.TRUE)
							this.op = Element.TRUE;
						children.add(add);
						add.father = this;
					}
				} else {
					isFormula = true;
					formula = result.get(0);
				}

				break;
			}
			
			case PresburgerLexer.FORAND:
			case PresburgerLexer.FOROR:{
				if (token == PresburgerLexer.FORAND)
					this.op = Element.AND;
				else
					this.op = Element.OR;
				
				String[] variables = new String[(Integer)(ast.getChildCount()-1)/3];
				Integer[] currentCount = new Integer[(Integer)(ast.getChildCount()-1)/3];
				Integer[] currentBound = new Integer[(Integer)(ast.getChildCount()-1)/3];
				
				Hashtable<String,String> dynamicCounts = new Hashtable<String,String>();
				Hashtable<String,String> dynamicBounds = new Hashtable<String,String>();
				
				Hashtable<String,Integer> variableMapping = new Hashtable<String,Integer>(); 
				
				int j = 0;
				for(int i=0;i<ast.getChildCount()-1;i+=3) {
					variables[j] = ast.getChild(i).getText();
					variableMapping.put(variables[j] ,j);
					String start = ast.getChild(i+1).getText();
					if (isInteger(start)) {
						currentCount[j] = Integer.valueOf(start);
						dynMapping.put(variables[j], currentCount[j]);
					} else {
						if (variableMapping.containsKey(start) || dynMapping.containsKey(start)) {
							dynamicCounts.put(variables[j] , start);
							currentCount[j] = dynMapping.get(start);
						}else
							throw new UnknownDynamicVariable("The dynamic variable " + start + " is unknown.");
					}
					
					String end = ast.getChild(i+2).getText();
					
					if (isInteger(end)) {
						currentBound[j] = Integer.valueOf(end);
					} else {
						if (variableMapping.containsKey(end) || dynMapping.containsKey(end)) {
							currentBound[j] = dynMapping.get(end);
							dynamicBounds.put(variables[j] , end);
						} else
							throw new UnknownDynamicVariable("The dynamic variable " + end + " is unknown.");
					}
					j++;
				}
				
				
				for (int i=0;i<variables.length;i++) {
					String s = variables[i];
					System.out.println(s + " " + currentCount[i] + currentBound[i]);
				}
				
				LinkedList<LinkedList<Integer>> combination = getAllCombinations(currentCount, currentBound,dynamicCounts,dynamicBounds,variables,variableMapping);
				
				for (LinkedList<Integer> l:combination) {
					int i = 0;
					int sum =0;
					for (Integer x:l) {
						dynMapping.put(variables[i] , x);
						i++;
						sum += x;
					}
					children.add(new LogicTree((CommonTree)ast.getChild(ast.getChildCount()-1), this,dynMapping,this.m));
				}
				
				break;
			}
			
			case PresburgerLexer.MACRO: {
				if (this.m == null) {
					throw new UnknownMacroException("The Macro " + ast.getText() + " is unknown.");
				} else {
					
					String name = ast.getText();
					name = name.substring(0,name.length()-1);
					Macro macro = this.m.getMacro(name);
					if (macro == null)
						throw new UnknownMacroException("The Macro " + name + " is unknown.");
					LogicTree l = macro.getLogicTree();
					this.isFormula = l.isFormula;
					this.isNode = l.isNode;
					this.var = l.var;
					this.children = l.children;
					for (LogicTree ch:l.children)
						ch.father = this;
					this.addedVars = l.addedVars;
					this.delete = l.delete;
					this.op = l.op;
					this.formula = l.formula;

					List<Hashtable<String,Integer>> list = new LinkedList<Hashtable<String,Integer>>();
					Hashtable<String,Integer> current = null;
					String[] arguments = macro.getArguments();
					
					Hashtable<String,String> substituteBound = new Hashtable<String,String>();
					
					//Get the list of variables to substitute
					//For every predicate in the argument list we put one entry to list
					try {
						Integer bound = 0;
						for (int i=0;i<ast.getChildCount();i++) {
							if(ast.getChild(i).getType() == PresburgerLexer.PRED) {
								current = new Hashtable<String,Integer>();
								list.add(current);
							} else {
								if (!current.containsKey("bound"))
									current.put("bound", bound);
								bound = var2Table(current,(CommonTree)ast.getChild(i),dynMapping);
								current.put("bound", current.get("bound") + bound);
							}
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					for (Hashtable<String,Integer> cl:list) {
						for (String s:cl.keySet()) {
							if (macro.isBoundVar(s)) {
								substituteBound.put(s,s+"1");
							}
						}
					}

					if (list.size() != arguments.length)
						throw new ArgumentMismatchException("The arguments for " + name + " do not match with the macro.");

					this.substituteAll(substituteBound);
					this.substitute(arguments, list);
					//FIXME: Examine!
					if (this.formula != null) {
						if (this.formula.getOP() == Element.TRUE)
							this.op = Element.TRUE;
						if (this.formula.getOP() == Element.FALSE)
							this.op = Element.FALSE;
					}
					
				}
				break;
			}
			
		}		
	}
	
	/**
	 * Reads variables and puts them to the list.
	 * @param table
	 * @param var
	 * @throws UnknownDynamicVariable 
	 */
	private Integer var2Table(Hashtable<String,Integer> table, CommonTree var,Hashtable<String,Integer> dynMapping) throws UnknownDynamicVariable {
		//In case we have a plain int in our formula
		Integer retNum = 0;
		
		Integer num = 1;
		boolean minus = false;
		if (var.getType() == PresburgerLexer.MINUS) {
			minus = true;
		}
		if (var.getChild(0).getType() == PresburgerLexer.INT) {
			num = Integer.valueOf(var.getChild(0).getText());
			
			String varName = null;
			if (var.getChild(2) != null) {
				//VAR VAR => First VAR has to be a dynMapping-VAR
				String dynVarName = var.getChild(1).getText();
				varName = var.getChild(2).getText();
				
				if (!dynMapping.containsKey(dynVarName)) {
					throw new UnknownDynamicVariable("The dynamic variable " + dynVarName + " is unknown. Please make sure, you instantiated it using either &&[] or ||[]");
				} else {
					num *= dynMapping.get(dynVarName); 
				}

			} else {
				if (var.getChild(1) != null)
					varName = var.getChild(1).getText();
				else
					retNum += num;
			}
			if (varName != null) {
				for (String s:dynMapping.keySet()) {
					varName = varName.replace("[" + s + "]", "[" + dynMapping.get(s) + "]");
					
					Pattern p = Pattern.compile("\\[" + var + "\\+" + "\\d+" + "\\]");
					Matcher m = p.matcher(varName);
					while(m.find()) {
						String match = m.group();
						String numS = match.substring(3,match.length()-1);
						Integer realNum = Integer.valueOf(numS);
						varName = varName.replace(match , "["+(dynMapping.get(var)+realNum)+"]");
					}
				}
				
				table.put(varName, (minus) ? -1*num : num);
			} 
		}
		return retNum;
	}
	
	private void substitute(String[] arguments , List<Hashtable<String, Integer>> list) {
		if (this.isFormula)
			formula.substitute(arguments,list);
		else {
			for (LogicTree l:children) {
				l.substitute(arguments, list);
			}
		}
		
	}
	
	private void substituteAll(Hashtable<String,String> subst) {
		if (this.isFormula)
			formula.substituteAll(subst);
		else {
			if (var != null) {
				if (subst.containsKey(var))
					var = subst.get(var);
			}
			
			for (LogicTree l:children) {
				l.substituteAll(subst);
			}
		}
	}
	
	private LinkedList<LinkedList<Integer>> getAllCombinations( 
			Integer[] start, 
			Integer[] bound ,
			Hashtable<String,String> dynamicCounts,
			Hashtable<String,String> dynamicBounds , 
			String[] variables,
			Hashtable<String,Integer> mapping) {
		
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> add = new LinkedList<Integer>();
		result.add(add);
		
		if (start.length != bound.length)
			return null;
		
		for (int i=0;i<start.length;i++) {
			LinkedList<LinkedList<Integer>> newResult = new LinkedList<LinkedList<Integer>>();
			String var = variables[i];
			if (dynamicCounts.containsKey(var) || dynamicBounds.containsKey(var)) {
				Integer currentCount = 0;
				Integer currentBound = 0;
				
				Integer currentCountIndex = -1;
				Integer currentBoundIndex = -1;
				
				String countVar = dynamicCounts.get(var);
				if (countVar == null) {
					currentCount = start[i];
				} else{
					currentCountIndex = mapping.get(countVar);
				}
				
				String boundVar = dynamicBounds.get(var);
				if (boundVar == null) {
					currentBound = bound[i];
				} else{
					currentBoundIndex = mapping.get(countVar);
				}
				
				for(LinkedList<Integer> list:result) {
					if (currentCountIndex != -1)
						currentCount = list.get(currentCountIndex);
					if (currentBoundIndex != -1)
						currentBound = list.get(currentBoundIndex);
					
					System.out.println("Bounds: " + currentCount+ " " + currentBound);
					
					
					for (Integer x:list) {
						System.out.print(x + " ");
					}

					for (Integer k:getSingleArray(currentCount, currentBound)) {
						LinkedList<Integer> clone = (LinkedList<Integer>)list.clone();
						clone.add(k);
						newResult.add(clone);
						System.out.print(" Add " + k);
					}
					System.out.println("");
				}
				
				
			} else {
				for (Integer k:getSingleArray(start[i] , bound[i])) {
					for(LinkedList<Integer> list:result) {
						LinkedList<Integer> clone = (LinkedList<Integer>)list.clone();
						clone.add(k);
						newResult.add(clone);
					}
				}
			}
			
			result = newResult;
		}
		
		return result;
	}
	
	private Integer[] getSingleArray(Integer start , Integer end) {
		Integer[] result = new Integer[end-start+1];
		for (int i=0;i<end-start+1;i++) {
			result[i] = start+i;
		}
		
		return result;     

	}
	
	/**
	 * Checks if a String can be converted to a Integer
	 * @param input
	 * @return
	 */
	private boolean isInteger( String input )  
	{  
	   try  
	   {  
	      Integer.parseInt( input );  
	      return true;  
	   }  
	   catch( Exception e)  
	   {  
	      return false;  
	   }  
	} 
	
	public boolean isFormula() {
		return this.isFormula;
	}
	
	public boolean isNode() {
		return this.isNode;
	}
	
	public LogicTree negate() {
		
		if (isFormula) {
			if (this.isFormula){
				this.formula.negate();
				return this;
			} 
		} else {

			if (this.op == Element.TRUE) {
				this.op = Element.FALSE;
				return this;
			}
			
			if (this.op == Element.FALSE) {
				this.op = Element.TRUE;
				return this;
			}
			
			if (this.op == Element.AND) {
				this.op = Element.OR;
	
				LogicTree[] list = children.toArray(new LogicTree[children.size()]);
				
				for (LogicTree l:list) {
					l.negate();
				}
				return this;
			}
			
			if (this.op == Element.OR) {
				this.op = Element.AND;
				LogicTree[] list = children.toArray(new LogicTree[children.size()]);
				
				for (LogicTree l:list) {
					l.negate();
				}
				return this;
			}
			
			if (this.op == Element.IMPL) {
				this.op = Element.AND;
				children.get(0).negate();
				children.get(1).negate();
				return this.pushNegations();
			}
			
			if (this.op == Element.NEG) {
				this.father.children.addAll(this.children);
				this.father.children.remove(this);
				
				this.children.get(0).pushNegations();
				
				return this.children.get(0); 
			}
			
			if (this.op == Element.EX) {
				LogicTree l = new LogicTree(this.father);
				l.isNode = true;
				l.op = Element.NEG;
				l.children.add(this);
				this.father.children.remove(this);
				this.father.children.add(l);
				this.father = l;
				
				this.pushNegations();
				
				return l;
			}
		} 
		return null;
	}
	
	/**
	 * Pushes Negations down as far as possible (that is either cancel them out or push them in front of a quantifier)
	 * @return
	 */
	public LogicTree pushNegations() {
		
		LogicTree ret = null;
		
		if (this.op == Element.NEG) {
			LogicTree x = this.children.get(0).negate();
						
			if (this.father == null) {
				ret = x;
			} else {
				
				ret = this.father;
				this.father.children.add(x);
				this.father.children.remove(this);
				x.father = ret;
				for (LogicTree i:x.children) {
					i.father = x;
				}
			}
			
			
		} else {
			ret = this;
			LogicTree[] x = children.toArray(new LogicTree[children.size()]);
			for (LogicTree t:x) {
				if (t.isNode)
					t.pushNegations();
			}
		}
		
		return ret;
	}
	
	
	/**
	 * Checks if we can delete/merge parts of the tree
	 * 
	 * @return
	 */
	public LogicTree checkFormulas() {
		
		System.out.println("START " + this);
		
		if (this.isFormula)
			return this;
		boolean change = true;
		while (change) {
			change = false;
			HashSet<LogicTree> done = new HashSet<LogicTree>();
			LogicTree current = searchFormula(this,done);
	
			while (current != null) {
				if (current.getOperator() == Element.TRUE || current.getOperator() == Element.FALSE) {
					current.propagateChange();
				} else {
					List<LogicTree> toDelete = new LinkedList<LogicTree>();
					List<LogicTree> doneLocal = new LinkedList<LogicTree>();
					current.propagateFormula(current , toDelete , doneLocal);
					
					LogicTree[] list = toDelete.toArray(new LogicTree[toDelete.size()]);
					for (LogicTree x:list) {
						x.propagateChange();
						change = true;
					}

				}
				done.add(current);
				current = searchFormula(this,done);
			}
			System.out.println("IN " + this);
		}

		LogicTree ret = this;
		while (ret.children.size() == 1 && ret.op != Element.EX && ret.op != Element.NEG) {
			ret = ret.children.get(0);
		}
		
		
		return ret;
	}
	
	private void propagateChange() {
	
		if (this.father != null) {
			if (this.op == Element.DELETE) {
				this.father.children.remove(this);
				this.father.propagateChange();
			}
			
			if (this.op == Element.FALSE) {
				if (this.father.op == Element.AND || this.father.op == Element.EX) {
					this.father.op = Element.FALSE;
					this.father.children.clear();
					this.father.propagateChange();
				} else if (this.father.op == Element.NEG){
					this.father.op = Element.TRUE;
					this.father.children.clear();
					this.father.propagateChange();
				} else {
					//That's OR
					this.father.children.remove(this);
					this.father.propagateChange();	
				}
				return;
			}
			
			if (this.op == Element.TRUE) {
				if (this.father.op == Element.OR || this.father.op == Element.EX) {
					this.father.op = Element.TRUE;
					this.father.children.clear();
					this.father.propagateChange();
				} else if (this.father.op == Element.NEG){
					//This is NEG
					this.father.op = Element.FALSE;
					this.father.children.clear();
					this.father.propagateChange();
				} else {
					//That's AND
					this.father.children.remove(this);
					this.father.propagateChange();
				}
				return;
				
			}
			
		}
		
		//TODO: Maybe move this back into the big if
		if (this.children.size() == 1) {
			if (this.father != null) {
				this.father.children.add(this.children.get(0));
				this.father.children.remove(this);
				this.children.get(0).father = this.father;					
			}
		}
		
	}
	
	
	/**
	 * Searches a Formula in the tree that has not yet been propagated
	 * @param logicTree
	 * @param done
	 * @return
	 */
	private static LogicTree searchFormula(LogicTree l, HashSet<LogicTree> done) {	
		
		if (l.isFormula)
			return l;
		
		for (LogicTree x:l.children) {
			if (!done.contains(x)) {
				LogicTree ret = searchFormula(x,done);
				if (ret != null)
					return ret;
			}
		}
		
		return null;
	}

	
	/**
	 * Takes a formula and tries to push it up as far as possible, while telling the subtrees about the formula.
	 * @param f
	 */
	public void propagateFormula(LogicTree f , List<LogicTree> del , List<LogicTree> done) {
		
		if (this == f) {
			if (this.father != null) {
				this.father.propagateFormula(f , del , done);
			}
		}
		
		if (this.op == Element.OR) {
			pushFormula(f,Element.OR,del,done);
			return;
		}
		
		//Can't be a NEG since they are all in front of a EX
		if (this.father != null && this.op == Element.AND && this.father.op != Element.EX) {
			pushFormula(f,Element.AND,del,done);
			this.father.propagateFormula(f , del ,done);
		} else {
			
			if (this.op == Element.AND) {
				pushFormula(f,Element.AND,del,done);
			}
			
			
		}
	}
	
	public void pushFormula(LogicTree f , Element op , List<LogicTree> del,List<LogicTree> done) {
		if (done.contains(this))
			return;
		
		
		if (this.isFormula && this != f) {
			done.add(this);

			this.formula.getPropagationAndAct2(f.formula, op);
			
			if (this.formula.getOP() == Element.TRUE || this.formula.getOP() == Element.FALSE || this.formula.getOP() == Element.DELETE ) {
				if(this.formula.getOP() == Element.TRUE)
					this.op = Element.TRUE;
				
				if(this.formula.getOP() == Element.FALSE)
					this.op = Element.FALSE;
				
				if(this.formula.getOP() == Element.DELETE)
					this.op = Element.DELETE;
				
				del.add(this);
			}
			
		} else {
			if (this.op == Element.AND || this.op == Element.OR) {
				done.add(this);
				for (LogicTree l:children) {
					l.pushFormula(f , op , del,done);
				}
			}
		}
	}
	
	/**
	 * Gets the root of a tree
	 * @return
	 */
	public LogicTree getRoot() {
		if (this.father == null) {
			return this;
		} else {
			return this.father.getRoot();
		}
	}
	
	
	public String toString() {
		
		if (isFormula) {
			return formula.toString();
		} else {
			
			String result = "";
			if (this.op == Element.ALL) {
				result += "A" + this.var;
				for (LogicTree l:children) {
					result += l.toString();
				}
			} 
			
			if (this.op == Element.EX) {
				result += "E" + this.var;
				for (LogicTree l:children) {
					result += l.toString();
				}
			}
			
			if (this.op == Element.AND) {
				result += "(";
				for (LogicTree l:children) {
					if (result.compareTo("(") == 0) {
						result += l.toString();
					} else {
						result += " && " + l.toString();
					}
				}
				result += ")";
			}
			
			if (this.op == Element.OR) {
				result += "(";
				for (LogicTree l:children) {
					if (result.compareTo("(") == 0) {
						result += l.toString();
					} else {
						result += " || " + l.toString();
					}
				}
				result += ")";
			}
			
			if (this.op == Element.IMPL) {
				for (LogicTree l:children) {
					if (result.compareTo("") == 0) {
						result += l.toString();
					} else {
						result += " => " + l.toString();
					}
				}
			}
			
			if (this.op == Element.NEG) {
				result ="! (";
				for (LogicTree l:children) {
					result += l.toString();

				}
				result +=")";
			}
			
			if (result.compareTo("") == 0)
				result = this.op.toString();
			
			return result;
		}
	}
	
	public static LogicTree remove(LogicTree x) {
		if (x.father == null) {
			LogicTree l = new LogicTree();
			l.op = Element.FALSE;
			return l;
		} else {
			x.father.children.remove(x);
			if (x.father.children.size() == 1 && (x.father.op == Element.AND || x.father.op == Element.OR)) {
				if (x.father.father != null) {
					x.father.father.children.add(x.father.children.get(0));
					x.father.father.children.remove(x.father);
					return x.father.father;
				} else {
					return x.father.children.get(0);
				}
			} else {
				return x.father;
			}
		}
	}

	public Element getOperator() {
		return this.op;
	}
	
	public LogicTree getChild(int index) {
		return children.get(index);
	}
	
	public List<LogicTree> getChildren() {
		return this.children;
	}
	
	public String getVar() {
		return this.var;
	}
	
	public Formula getFormula() {
		return this.formula;
	}

	public void addVar(String var) {
		addedVars.add(var);
	}
	
	/**
	 * Gets all free variables in this formula
	 * @return
	 */
	public String[] getAllFreeVarNames() {
		HashSet<String> vars = new HashSet<String>();
		searchVars(vars);
		vars.addAll(addedVars);
		return vars.toArray(new String[vars.size()]);
	}
	
	/**
	 * Gets all bound variables in this formula => All variables that are after a E/A-quantifier
	 * @return
	 */
	public String[] getAllBoundVarNames() {
		HashSet<String> vars = new HashSet<String>();
		searchBoundVars(vars);
		vars.addAll(addedVars);
		return vars.toArray(new String[vars.size()]);
	}
	
	public String[] getAllVarNames() {
		HashSet<String> vars = new HashSet<String>();
		searchAllVars(vars);
		vars.addAll(addedVars);
		return vars.toArray(new String[vars.size()]);
	}
	
	private void searchAllVars(HashSet<String> vars) {
		if (this.isFormula) {
			for (String x:this.formula.getVarNames())
				vars.add(x);
		} else {
			if (this.op == Element.ALL || this.op == Element.EX )
				vars.add(this.var);
			
			for (LogicTree x:children) {
				x.searchAllVars(vars);
			}
		}
	}
	
	private void searchBoundVars(HashSet<String> vars) {
		if (!this.isFormula) {
			if (this.op == Element.ALL || this.op == Element.EX )
				vars.add(this.var);
			
			for (LogicTree x:children) {
				x.searchBoundVars(vars);
			}
		}
	}

	private void searchVars(HashSet<String> vars) {
		if (this.isFormula) {
			for (String x:this.formula.getVarNames())
				vars.add(x);
		} else {
			for (LogicTree x:children) {
				x.searchVars(vars);
			}
		}
	}
	
	/**
	 * Returns a clone of this tree.
	 */
	public LogicTree clone() {
		LogicTree ret = new LogicTree();
		ret.isFormula = this.isFormula;
		ret.isNode = this.isNode;
		ret.addedVars = (HashSet<String>)this.addedVars.clone();
		ret.var = this.var;
		ret.op = this.op;
		ret.delete = this.delete;
		ret.m = this.m;

		if (this.formula != null)
			ret.formula = this.formula.clone();
		
		for (LogicTree l:this.children) {
			LogicTree lClone = l.clone();
			ret.children.add(lClone);
			lClone.father = ret;
		}
			
		
		return ret;
	}
	
	/**
	 * Merge successive AND/OR Subtrees
	 */
	public void mergeSubTrees() {
		
		boolean found = true;
		while (found) {
			found = false;
			if (this.op == Element.AND || this.op == Element.OR) {
				HashSet<LogicTree> add = new HashSet<LogicTree>();
				//Get all Children
				for (LogicTree child:children) {
					if (child.op == this.op) {
						add.addAll(child.children);
						found = true;
					}
				}
				
				//Add Children to current Tree
				for (LogicTree tree:add) {
					this.children.remove(tree.father);
					this.children.add(tree);
					tree.father = this;
				}
				
			}
		}
		
		for (LogicTree child:children) {
			child.mergeSubTrees();
		}
	}
	
	
	
}
