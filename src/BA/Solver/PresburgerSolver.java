package BA.Solver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import BA.Automaton.PresburgerAutomaton;
import BA.Automaton.PresburgerAutomatonFactory;
import BA.Automaton.State;
import BA.Logic.ArgumentMismatchException;
import BA.Logic.Element;
import BA.Logic.LogicTree;
import BA.Logic.UnknownDynamicVariable;
import BA.Logic.UnknownMacroException;
import BA.Server.SolverRequest;
import BA.Solver.Exceptions.InvalidFormulaException;
import BA.Solver.Exceptions.TooManyVariablesException;
import BA.Solver.Parser.PresburgerLexer;
import BA.Solver.Parser.PresburgerParser;
import BA.util.LetterIterable;
import BA.util.Worklist;

//TODO: Add functionality for Benchmarking like no minimize!

public class PresburgerSolver {

	private Integer limit = 10;
	private Integer varLimit = 20;
	
	private boolean benchmark = false;
	private boolean minimize = true;
	
	private PresburgerAutomatonFactory factory;
	
	/**
	 * Creates a solver with the according number of variables. If limit = 0 the limit will be set to 26
	 * @param limit
	 */
	public PresburgerSolver(int limit) {
		if (limit != 0)
			varLimit = limit;

	}

	/**
	 * Creates a solver with the according number of variables. If limit = 0 the limit will be set to 26
	 * @param limit
	 */
	public PresburgerSolver(int limit , boolean benchmark , boolean minimize) {
		if (limit != 0)
			varLimit = limit;

		this.benchmark = benchmark;
		this.minimize = minimize;
	}
	
	/**
	 * Returns the solution to the formula
	 * 
	 * @param formula
	 * @return String array with the solution automaton as well as the solutionspace.
	 * @throws TooManyVariablesException 
	 * @throws InvalidFormulaException 
	 */
	public void solve(SolverRequest request) throws TooManyVariablesException, InvalidFormulaException {
		
		String formula = request.getEquation();
		int numberOfSolutions = request.getNumSol(); 
		String optimize = request.getSolTerm();
		String type = request.getSolType();
		MacroManager m = request.getMacroManager();
		
		CharStream input = new ANTLRStringStream(formula);
		
		// Generate a lexer for reading the formula `input'
        PresburgerLexer lex = new PresburgerLexer(input);
        // Generate from the lexer a token stream to be fed to the parser
		CommonTokenStream tokens = new CommonTokenStream(lex);
        // Generate the parser analyzing the token stream
        PresburgerParser parser = new PresburgerParser(tokens);
        
        // Finally parse the input and generate the tree
        PresburgerParser.f_return r;
        
		try {
			r = parser.f();
		} catch (RecognitionException e) {
			request.setException("Error while Parsing!");
			return;
		}             

        //get the AST encapsuled in r
        org.antlr.runtime.tree.CommonTree ast = (org.antlr.runtime.tree.CommonTree)r.getTree();

        //Optimize Formula	
        LogicTree t = null;
		try {
			t = new LogicTree(ast , m);
		} catch (UnknownDynamicVariable e) {
			request.setException(e.getMessage());
			return ;
		} catch (UnknownMacroException e) {
			request.setException(e.getMessage());
			return ;
		} catch (ArgumentMismatchException e) {
			request.setException(e.getMessage());
			return ;
		}

        System.out.println("Starting optimization of " + t);
        t = t.pushNegations();
        t = t.checkFormulas();
        t.mergeSubTrees();
        System.out.println("Optimization done: " + t);

        String[] varNames = t.getAllFreeVarNames();
        
        String newVar = "";
        if (type.equals("Max") || type.equals("Min")) {

    		for (String s:varNames) {
    			if (s.length() > newVar.length())
    			newVar = s;
    		}
    		
    		if (newVar.length() == 0)
    			newVar = "z";
    		else
    			newVar += "[1]";
        	
    		String[] newVarNames = new String[varNames.length+1];
    		int i=0;
    		for (String s:varNames) {
    			newVarNames[i++] = s;
    		}
    		newVarNames[i] = newVar;
    		varNames = newVarNames;
        }
        
        //Get the automaton
        if (varNames.length <= this.varLimit) {	

        	factory = PresburgerAutomatonFactory.init(varNames);
        	PresburgerAutomaton result;
        	
        	if (t.getOperator() == Element.TRUE) {
            	result = getOneAutomaton();
            } else {
            	if (t.getOperator() == Element.FALSE) {
	            	result = getZeroAutomaton();
            	} else {
            		
            		if (!benchmark) {
            			result = walkTree(t);
	        	        result = result.determinize();
	        	        result = result.minimize();
	        	        result.makeNiceNames();
            		} else {
            			long before = System.currentTimeMillis();
            			result = walkTree(t);
            			if (minimize)
            				result = result.minimize();
            			long after = System.currentTimeMillis();
            			System.out.println("Time for computing the automaton: " + (after-before) + "ms");
            			System.out.println("Automaton-size: " + result.size() + " states");
            		}
            	}
            }
        	
        	if (benchmark) {
        		return;
        	}

        	List<Integer[]> solutions = new LinkedList<Integer[]>();
        	Integer numSol = result.getSatCount();
        	System.out.println("Number of Solutions: " + numSol);
        		
        	if ((type.equals("Min") || type.equals("Max")) && numSol != 0) {

        		if (numSol == -1 && type.equals("Max")) {
        			//There is a infinite number of solutions, so we can't optimize here (in some cases we can, but there would be a fair chance to crash the whole server.)
	        		solutions.add(new Integer[]{-1});
	        		request.setSolutionSpace(solutions);
	        		request.setOptimizedSolution(-1);
        		} else {
            		String[] newVars = new String[varNames.length+1];
            		int i=0;
            		for (String s:varNames) {
            			newVars[i++] = s;
            		}
            		newVars[i] = newVar;
            		varNames = newVars;
        			
            		input = new ANTLRStringStream(optimize+"-" + newVar + " == 0");
                    lex = new PresburgerLexer(input);
            		tokens = new CommonTokenStream(lex);
                    parser = new PresburgerParser(tokens);
            		
            		PresburgerParser.linearpred_return opt;
            		try {
            			opt = parser.linearpred();
            		} catch (RecognitionException e) {
            			request.setException("Error while Parsing!");
            			return;
            		}
                    ast = (org.antlr.runtime.tree.CommonTree)opt.getTree();
            		
            		try {
						t = new LogicTree(ast);
            		} catch (UnknownDynamicVariable e) {
            			request.setException(e.getMessage());
            			return ;
            		} catch (UnknownMacroException e) {
            			request.setException(e.getMessage());
            			return;
            		} catch (ArgumentMismatchException e) {
            			request.setException(e.getMessage());
            			return;
            		}
            		
            		//Check if all Variables from the term are in the automaton already!
            		String[] termVarNames = t.getAllFreeVarNames();
            		boolean found = false;
            		String error = "";
            		for (String var:termVarNames) {
            			found = false;
            			for (String s:varNames) {
            				if (s.equals(var)) {
            					found = true;
            					break;
            				}
            			}
            			if (!found) {
            				error = var;
            				break;
            			}
            		}
            		
            		if (!found) {
        				request.setException("The variable " + error + "from your term is not a free variable in the above formula. Therefore we could not optimize your solution.");
            		} else {
	            		
	            		
	            		PresburgerAutomaton optRest = walkTree(t);
	            		
	            		String[] varSetResult = result.getVarNames();
	            		String[] varSetRest = optRest.getVarNames();
	            		
	            		boolean varSetOk = true;
	            		for (String s:varSetRest) {
	            			boolean done = false;
	            			for (String x:varSetResult) {
	            				if (s.equals(x)) {
	            					done = true;
	            					break;
	            				}
	            			}
	            			if (!done && !s.equals(newVar)) {
	            				varSetOk = false;
	            				request.setException("The variable " + s + " from your term is not a free variable in your formula. Therefore we could not optimize your solution.");
	            			}
	            		}
	            		
	    	        	if (varSetOk) {
	    	        		PresburgerAutomaton resultClone = result.clone();
	    	
	    	        		resultClone = resultClone.intersection(optRest);
	    	        		resultClone = resultClone.determinize();
	    	        		resultClone = resultClone.minimize();
	    	        		resultClone.makeNiceNames();
	    	        		PresburgerAutomaton resultAndRest = resultClone.clone();
	    	        		        		
	    	        		for (String e:varNames) {
	    	        			if (!e.equals(newVar)) {
	    	        				resultClone = resultClone.existQuant(e);
	    	        			}
	    	        		}
	    	
	    	        		resultClone = resultClone.determinize();
	    	        		resultClone = resultClone.minimize();
	    	        		
	    	        		resultClone.makeNiceNames();
	    	        		System.out.println(resultClone);
	    	        		Integer value = -1;
	    	        		if (type.equals("Max"))
	    	        			value = resultClone.getMaxValue();
	    	        		if (type.equals("Min"))
	    	        			value = resultClone.getMinValue();
	    	        		

	    	        		if (value != -1) {
	    	        			request.setSolutionSpace(resultAndRest.getValuesFor(newVar , value));
	    	        			request.setOptimizedSolution(value);
	    	        		} else {
	    	        			solutions.add(new Integer[]{-1});
	    	        			request.setSolutionSpace(solutions);
	    	        			request.setOptimizedSolution(-1);
	    	        		}
	    	        		System.out.println("Done MAX/MIN " + value);
	    	        	} else {
	    	        		solutions.add(new Integer[]{-1});
	    	        		
	    	        		request.setSolutionSpace(solutions);
		        			request.setOptimizedSolution(-1);
	    	        	}
            		}
        		}
        	}

            if ((type.equals("All")) && numSol > 0) {
            	solutions = result.getAllSat();
            	request.setSolutionSpace(solutions);
            }
            
            if (type.equals("All") && numSol == -1) {
            	solutions = new LinkedList<Integer[]>();
            	Integer[] solution = result.getOneSat();
            	solutions.add(solution);
            	request.setSolutionSpace(solutions);
            }
            
            if (type.equals("One") && numSol != 0) {
    			solutions = result.getNSat(1);
            	request.setSolutionSpace(solutions);

            }

            if (type.equals("N")) {
            	if (numSol >= numberOfSolutions || numSol == -1)
            		solutions = result.getNSat(numberOfSolutions);
            	else
            		solutions = result.getNSat(numSol);
            	request.setSolutionSpace(solutions);
            }
            
            
            request.setVarNum(result.countVariables());
        	request.setVarNames(result.getVarNames());
        	request.setAutomaton(result.toString());
        	request.setJSONAutomaton(result.toString("json"));
        	request.setNumberOfSolutions(numSol);
        	
        } else {
        	throw new TooManyVariablesException("There where too many variables in this formula. We currently only support up to " + this.varLimit + " variables.");
        }
	}
	
	public PresburgerAutomaton solveAutomaton(String formula){
		 
		CharStream input = new ANTLRStringStream(formula);
		
		// Generate a lexer for reading the formula `input'
        PresburgerLexer lex = new PresburgerLexer(input);
        // Generate from the lexer a token stream to be fed to the parser
		CommonTokenStream tokens = new CommonTokenStream(lex);
        // Generate the parser analyzing the token stream
        PresburgerParser parser = new PresburgerParser(tokens);
        
        // Finally parse the input and generate the tree
        PresburgerParser.f_return r;
        
		try {
			r = parser.f();
		} catch (RecognitionException e) {
			System.err.println("Error while Parsing!");
			return null;
		}             
		
        //get the AST encapsuled in r
        org.antlr.runtime.tree.CommonTree ast = (org.antlr.runtime.tree.CommonTree)r.getTree();
        
        //Optimize Formula	
        LogicTree t = null;
		try {
			t = new LogicTree(ast);
		} catch (UnknownDynamicVariable e) {
			//FIXME: ERROR MESSAGE
		} catch (UnknownMacroException e) {
			//FIXME: ERROR MESSAGE
		} catch (ArgumentMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        t = t.pushNegations();
        t = t.checkFormulas();
                
        //Get the automaton
        String[] varNames = t.getAllFreeVarNames();
        if (varNames.length <= this.varLimit) {	
        	
        	factory = PresburgerAutomatonFactory.init(varNames);
        	
        	if (t.getOperator() == Element.TRUE) {
            	PresburgerAutomaton result = getOneAutomaton();
            	return result;
            }
            
            if (t.getOperator() == Element.FALSE) {
            	PresburgerAutomaton result = getZeroAutomaton();
            	return result;
            }
        	
	        PresburgerAutomaton result = walkTree(t);
	         
	        result = result.determinize();
	        result = result.minimize();
	        result.makeNiceNames();

	        factory.freeBDDs();
	        
			return result;
        } else {
//        	throw new TooManyVariablesException("There where too many variables in this formula. We currently only support up to " + this.varLimit + " variables.");
        	return null;
        }
	}
	
	
	private PresburgerAutomaton walkTree(LogicTree input) {
		 
		PresburgerAutomaton a = null;
		PresburgerAutomaton b = null;

        //quantifiers
        //nodes have two children
        //child 0 is the variable
        //child 1 is the subformula
        if (input.getOperator() == Element.EX) {
        	System.out.println("EX");
        	a = walkTree(input.getChild(0)).existQuant(input.getVar());
       	 	System.out.println("EX done");
       	 	
       	 	return returnCheckRoutine(a);
        }
        	
         	
        //binary logical operators
        //nodes have two children
        //child 0 is the left subformula
        //child 1 is the right subformula
        if (input.getOperator() == Element.AND) {
        	System.out.println("AND");
        	List<LogicTree> list = input.getChildren();
        	
        	
        	List<BA.Logic.Formula> multi = new LinkedList<BA.Logic.Formula>();
        	
        	for (LogicTree l:list) {
        		if (l.isFormula())
        			multi.add(l.getFormula());
        	}
        	
        	if (multi.size() >= 1) {
        		BA.Logic.Formula[] tmp = new BA.Logic.Formula[multi.size()];
	        	a = multiplePredAutomaton(multi.toArray(tmp) , "AND");
        	}
        	
        	for(LogicTree l:list) {
        		if (!l.isFormula()) {
        			if (a == null) {
            			a = walkTree(l);
            		} else {
            			a = a.intersection(walkTree(l));
            		}	
        		}
        	}
        	
//        	for(LogicTree l:list) {
//        			if (a == null) {
//            			a = walkTree(l);
//            		} else {
//            			a = a.intersection(walkTree(l));
//            		}	
//        	}
        	
        	return returnCheckRoutine(a);

        }
        	
        if (input.getOperator() == Element.OR) {
        	System.out.println("OR");
        	List<LogicTree> list = input.getChildren();
        	
        	List<BA.Logic.Formula> multi = new LinkedList<BA.Logic.Formula>();
        	
        	for (LogicTree l:list) {
        		if (l.isFormula())
        			multi.add(l.getFormula());
        	}
        	
        	if (multi.size() >= 1) {
        		BA.Logic.Formula[] tmp = new BA.Logic.Formula[multi.size()];
	        	a = multiplePredAutomaton(multi.toArray(tmp) , "OR");
        	}
        	
        	for(LogicTree l:list) {
        		if (!l.isFormula()) {
        			if (a == null) {
            			a = walkTree(l);
            		} else {
            			a = a.union(walkTree(l));
            		}	
        		}
        	}
        	
        	
//        	for(LogicTree l:list) {
//    			if (a == null) {
//        			a = walkTree(l);
//        		} else {
//        			a = a.union(walkTree(l));
//        		}	
//        	}
        	
        	return returnCheckRoutine(a);
        }
        
        	
        //unary logical operators
        //have a single child
        //child 0 is the subformula
        if (input.getOperator() == Element.NEG) {
        	System.out.println("NEG");
        	return returnCheckRoutine(walkTree(input.getChild(0)).not());
        }

        if (input.getOperator() == Element.TRUE || (input.isFormula() && input.getFormula().getOP() == Element.TRUE)) {
        	return getOneAutomaton();
        }
        
        if (input.getOperator() == Element.FALSE || (input.isFormula() && input.getFormula().getOP() == Element.FALSE)) {
        	return getZeroAutomaton();
        }

        //integer relations: a x + b y + ... R c
        // have at least two children
        // child 0 represents the constant c
        // children 1 .. represent the linear term
        // all children should be of tokentype PLUS/MINUS
        if (input.isFormula()) {
        	BA.Logic.Formula f = input.getFormula();
        	if (f.getOP() == Element.EQ) {
        		return singleLinearpredEQ(f , false);
        	}
        	if (f.getOP() == Element.NEQ) {
        		return singleLinearpredEQ(f , true);
        	}

        	
        	return singleLinearpredGEQ(f );
        }

		return null;
	}


	/**
	 *Checks the size of an automaton and decides if it should be minimized or not
	 *
	 * @param a
	 * @return
	 */
	private PresburgerAutomaton returnCheckRoutine(PresburgerAutomaton a) {				
		if (a.size() > this.limit && minimize && !benchmark)
			return a.minimize();
		else
			return a;
	}
	
	private PresburgerAutomaton getOneAutomaton() {
		PresburgerAutomaton ret = factory.getAutomaton(new String[]{});
		
		State s = ret.addState("0");
		s.setInitial(true);
		s.setFinal(true);
		ret.addTransition(s, s, "");
		
		return ret;
		
	}
	
	private PresburgerAutomaton getZeroAutomaton() {
		PresburgerAutomaton ret = factory.getAutomaton(new String[]{});
		
		State s = ret.addState("1");
		s.setInitial(true);
		ret.addTransition(s, s, "");
		
		return ret;
	}
	

	/**
	 * Calculates an automaton for inequations
	 * @param ast
	 * @return
	 */
	private PresburgerAutomaton singleLinearpredGEQ(BA.Logic.Formula f) {
		
		HashSet<State> done = new HashSet<State>();
		Boolean[][] alphabet = getAllBooleanCombinations(f.getVarNames().length);

    	PresburgerAutomaton x = factory.getAutomaton(f.getVarNames());
    	
    	State start = x.addState(f.getBound().toString());
    	start.setInitial(true);
    	if (f.getBound() >= 0)
			start.setFinal(true);
    	Worklist<State> w = new Worklist<State>();
    	w.add(start);
    	
    	//Let's build the solution automaton for the formula!
    	//For a explanation of the algorithm see Script by Prof. Esparza in chapter 10 about Presburger Arithmetics
    	while (!w.isEmpty()) {
    		State currentState = w.get();
    		Integer currentNum = Integer.valueOf(currentState.getName());
    		for (Boolean[] letter:alphabet) {
    			Integer j = (int) Math.floor(0.5 * (currentNum - f.eval(letter)));
    			State currentDestination = x.addState(j.toString());
    			if (j >= 0)
    				currentDestination.setFinal(true);
    			x.addTransition(currentState, currentDestination, letter);
    			
    			if (!done.contains(currentDestination) && currentDestination != currentState && !w.contains(currentDestination))
    				w.add(currentDestination);
    		}
    		done.add(currentState);
    	}

		return x;
	}
	

	/**
	 * Calculates a automaton for equations
	 * @param ast
	 * @return
	 */
	private PresburgerAutomaton singleLinearpredEQ(BA.Logic.Formula f, boolean isNEQ) {
		

		HashSet<State> done = new HashSet<State>();
		
		Boolean[][] alphabet = getAllBooleanCombinations(f.getVarNames().length);
		
    	PresburgerAutomaton x = factory.getAutomaton(f.getVarNames());
    	
    	State start = x.addState(f.getBound().toString());
    	start.setInitial(true);
    	
    	if (f.getBound() == 0 ^ isNEQ)
			start.setFinal(true);
    	
    	Worklist<State> w = new Worklist<State>();
    	w.add(start);
    	
    	boolean trashMade = false;
    	//Let's build the solution automaton for the formula!
    	while (!w.isEmpty()) {
    		State currentState = w.get();
    		Integer currentNum = Integer.valueOf(currentState.getName());
    		for (Boolean[] letter:alphabet) {
    			int tmp = currentNum - f.eval(letter);
    			if (tmp%2 == 0) {
    				Integer j = (int) (0.5 * tmp);
    				
	    			State currentDestination = x.addState(j.toString());
	    			if (j == 0 ^ isNEQ)
	    				currentDestination.setFinal(true);
	    			x.addTransition(currentState, currentDestination, letter);
	    			
	    			if (!done.contains(currentDestination) && currentDestination != currentState && !w.contains(currentDestination))
	    				w.add(currentDestination);
    			} else {
    				if (!trashMade) {
    					State trash = makeTrashState(x , f.getVarNames().length);
    					trash.setFinal(isNEQ);
    				}
    				
    				State currentDestination = x.addState("Trash");
	    			x.addTransition(currentState, currentDestination, letter);
    			}
    		}
    		done.add(currentState);
    	}

		return x;
	}
	
	/**
	 * Takes multiple Formulas and computes the automaton for them. (The AND-Case)
	 * 
	 * @param f
	 * @return
	 */
	private PresburgerAutomaton multiplePredAutomaton(BA.Logic.Formula[] f , String operation) {
		
		HashSet<State> done = new HashSet<State>();
				
		Set<String> tmpAllVarNames = new TreeSet<String>();

		for (BA.Logic.Formula x:f) {
			for (String s : x.getVarNames()) {
				if (!tmpAllVarNames.contains(s))
					tmpAllVarNames.add(s);
			}
		}
		
		List<String> allVarNames = new LinkedList<String>();
		allVarNames.addAll(tmpAllVarNames);
		
		Boolean[][] alphabet = getAllBooleanCombinations(allVarNames.size());
		String[] tmpArr = new String[allVarNames.size()];
    	PresburgerAutomaton x = factory.getAutomaton(allVarNames.toArray(tmpArr));
    	
    	String startLabel = "";
    	for (BA.Logic.Formula currentFormula:f) {
    		startLabel += currentFormula.getBound().toString() + ";";
    	}
    	startLabel = startLabel.substring(0,startLabel.length()-1);
    	
    	
    	State start = x.addState(startLabel);
    	start.setInitial(true);
    	
    	start.setFinal(multipleIsFinal(f , operation));
    	
    	Worklist<State> w = new Worklist<State>();
    	w.add(start);
    	
    	boolean trashMade = false;
    	boolean finalMade = false;
    	//Let's build the solution automaton for the formula!
    	while (!w.isEmpty()) {
    		State currentState = w.get();
    		
    		Integer[] currentNum = new Integer[f.length];
    		int counter = 0;
    		List<Integer> skip = new LinkedList<Integer>();
    		for (String s : currentState.getName().split(";")) {
    			if (s.equals("X")) {
    				skip.add(counter++);
    				continue;
    			}
    			currentNum[counter++] = Integer.valueOf(s);
    		}
    	
    		for (Boolean[] letter:alphabet) {
    			String nextState = "";
    			boolean isFinal = true;
    			boolean isFinalComplete = false;
    			if (operation.equals("OR"))
    				isFinal = false;
    			boolean toTrash = false;
    			int count = 0;
    			boolean atLeastOne = false;
    			for (BA.Logic.Formula currentFormula :f) {
    				//First get all letters for that formula.
    				Boolean[] currentLetter = new Boolean[currentFormula.getVarNames().length];
    				int countLetter = 0;
    				for (String curVar : currentFormula.getVarNames()) {
    					currentLetter[countLetter++] = letter[allVarNames.indexOf(curVar)];
    				}
    				
    				if (skip.contains(count)) {
    					nextState += "X;";
    					if (operation.equals("OR") && currentFormula.getOP() == Element.NEQ) {
    						isFinal = true;
    					}
    					count++;
    					continue;
    				}
    				
    				int tmp = currentNum[count] - currentFormula.eval(currentLetter);
    				System.out.println("NUM" + (int) Math.floor(0.5 * tmp));
    				count++;
    				if (operation.equals("AND")) {
	    				if (currentFormula.getOP() == Element.LEQ) {
	    					Integer j = (int) Math.floor(0.5 * tmp);
	    					nextState += j.toString() + ";";
	    	    			if (j < 0)
	    	    				isFinal = isFinal && false;
	    	    			continue;
	    				}
	
	    				if (currentFormula.getOP() == Element.NEQ) {
	    					Integer j = (int) Math.floor(0.5 * tmp);
	    					nextState += j.toString() + ";";
        					if (j == 0)
        						isFinal = isFinal && false;
        					continue;
        				}
	    				
	    				if (tmp%2 == 0) {
	        				Integer j = (int) (0.5 * tmp);
	        				nextState += j.toString() + ";";
	    	    			
	
	        				if (currentFormula.getOP() == Element.EQ && j != 0) {
	        					isFinal = isFinal && false;
	        				}
	    	    			
	        			} else
	        				toTrash = true;
    				}

    				if (operation.equals("OR")) {
	    				if (currentFormula.getOP() == Element.LEQ) {
	    					atLeastOne = true;
	    					Integer j = (int) Math.floor(0.5 * tmp);
	    					nextState += j.toString() + ";";
	    	    			if (j >= 0)
	    	    				isFinal = isFinal || true;
	    	    			continue;
	    				}
	
	    				if (tmp%2 == 0) {
	    					atLeastOne = true;
	        				Integer j = (int) (0.5 * tmp);
	        				nextState += j.toString() + ";";
	    	    			
	        				if (currentFormula.getOP() == Element.NEQ && j != 0) {
	        					isFinal = isFinal || true;
	        				}
	
	        				if (currentFormula.getOP() == Element.EQ && j == 0) {
	        					isFinal = isFinal || true;
	        				}
	        			} else {
	        				nextState += "X;";
	        				if (currentFormula.getOP() == Element.NEQ) {
	        					atLeastOne = true;
	        					isFinal = true;
	        					isFinalComplete = true;
	        				}
	        			}
    				}
    			}
    			
    			System.out.println(nextState);
    			if (operation.equals("OR") && !atLeastOne)
    				toTrash = true;
    			
    			if (toTrash) {
    				if (!trashMade) {
    					State trash = makeTrashState(x , allVarNames.size());
    				}
    				State currentDestination = x.addState("Trash");
	    			x.addTransition(currentState, currentDestination, letter);
    			} else {
    				if (isFinalComplete) {
    					if (!finalMade) {
    						State finalState = x.addState("Final");
    						finalState.setFinal(true);
    						for (Boolean[] l:alphabet) {
    							x.addTransition(finalState, finalState, l);
    						}
    					}
    					State currentDestination = x.addState("Final");
    					x.addTransition(currentState, currentDestination, letter);
    				} else {
    					State currentDestination = x.addState(nextState);
        				currentDestination.setFinal(isFinal);
    	    			x.addTransition(currentState, currentDestination, letter);
    	    			
    	    			if (!done.contains(currentDestination) && currentDestination != currentState && !w.contains(currentDestination))
    	    				w.add(currentDestination);
    				}
    			}

    		}
    		done.add(currentState);
    	}

		return x;
	}

	private boolean multipleIsFinal(BA.Logic.Formula[] f, String operation) {
		boolean isFinal = false;
		if (operation.equals("AND"))
			 isFinal = true;
		
		if (operation.equals("OR"))
			isFinal = false;
		
    	for (BA.Logic.Formula currentFormula : f) {
    		
    		if (currentFormula.getOP() == Element.LEQ) {
    			if (currentFormula.getBound() < 0 && operation.equals("AND")) {
    				isFinal = false;
    				break;
    			}
    			if (currentFormula.getBound() >= 0 && operation.equals("OR")) {
    				isFinal = true;
    				break;
    			}
    			
    			continue;
    		}
    		
    		if (currentFormula.getOP() == Element.EQ) {
    			if (currentFormula.getBound() != 0 && operation.equals("AND")) {
    				isFinal = false;
    				break;
    			}
    			
    			if (currentFormula.getBound() == 0 && operation.equals("OR")) {
    				isFinal = true;
    				break;
    			}
    			continue;
    		}
    		
    		if (currentFormula.getOP() == Element.NEQ) {
    			if (currentFormula.getBound() == 0 && operation.equals("AND")) {
    				isFinal = false;
    				break;
    			}
    			
    			if (currentFormula.getBound() != 0 && operation.equals("OR")) {
    				isFinal = true;
    				break;
    			}
    			continue;
    		}
    	}
    	
		return isFinal;
	}
	
	/**
	 * Adds a trash-state to the system
	 * @param x
	 * @param n
	 * @return
	 */
	private State makeTrashState(PresburgerAutomaton x , int n) {
		State trash = x.addState("Trash");
		Boolean[][] alph = getAllBooleanCombinations(n);
		for (Boolean[] letter:alph) {
			x.addTransition(trash, trash, letter);
		}
		return trash;
	}
	
	private Formula makeFormula(CommonTree ast) {
		Integer vorzeichen = 0;
		Character varName = null;
		
		SortedMap<Character,Integer> equation = new TreeMap<Character,Integer>();
		
		int token = ast.getToken().getType();
		
		int offset = 0;
		int mult = 1;


		//Find out which kind of formula we have and convert it to a <=-Formula
		switch(token) {
			case PresburgerParser.GEQ: {
				mult = -1;
				break;
			} 
			
			case PresburgerParser.GT: {
				mult = -1;
				offset = -1;
				break;
			}

			case PresburgerParser.LT: {
				offset = -1;
				break;
			}

		}
		
		for (int i=0;i<ast.getChildCount()-1;i++) {
    		
    		vorzeichen = Integer.valueOf(ast.getChild(i).getChild(0).getText());
    		varName = ast.getChild(i).getChild(1).getText().charAt(0);
    		if (((org.antlr.runtime.tree.CommonTree)ast.getChild(i)).getToken().getType() == PresburgerParser.MINUS) {
    			vorzeichen *= -1;
    		}
    		vorzeichen*=mult;
    		
    		equation.put(varName , vorzeichen);
    	}
		
		Integer solution = Integer.valueOf((String)ast.getChild(ast.getChildCount()-1).getChild(0).getText());
		if (((org.antlr.runtime.tree.CommonTree)ast.getChild(ast.getChildCount()-1)).getToken().getType() == PresburgerParser.MINUS)
			solution *= -1;
    	
		solution *= mult;
		solution += offset;
		Formula f;
		
		f = new Formula(equation.values().toArray(new Integer[equation.values().size()]),
				equation.keySet().toArray(new Character[equation.keySet().size()]),solution);
		
    	return f;
	}
	
//	private PresburgerAutomaton linearpredSwarm(CommonTree ast) {
//		
//		Formula[] f = new Formula[ast.getChildCount()];
//		for (int i=0;i<ast.getChildCount();i++) {
//			f[i] = makeFormula((CommonTree) ast.getChild(i));
//		}
//		
//		HashSet<State> done = new HashSet<State>();
//		
//		
//		SortedSet<String> tmpVarNames = new TreeSet<String>();
//		
//		for (int i=0;i<f.length;i++) {
//			for (String x:f[i].getVarNames()) {
//				tmpVarNames.add(x);
//			}
//		}
//		
//		String[] varNames = tmpVarNames.toArray(new String[tmpVarNames.size()]);
//		
//		Boolean[][] alphabet = getAllBooleanCombinations(varNames.length);
//		
//    	PresburgerAutomaton x = factory.getAutomaton(varNames);
//    	
//    	State start = x.addState(makeNameFromFormulas(f));
//    	start.setInitial(true);
//    	
//    	Boolean isFinal = true;
//    	for (Formula current:f) {
//    		if (current.getBound() != 0) {
//    			isFinal = false;
//    			break;
//    		}
//    	}
//    	start.setFinal(isFinal);
//    	
//    	Worklist<State> w = new Worklist<State>();
//    	w.add(start);
//		
//    	boolean trashMade = false;
//    	
//    	while (!w.isEmpty()) {
//    		
//    		State current = w.get();
//    		
//    		Integer[] currentNum = makeIntFromState(current);
//    		if (done.contains(current))
//    			continue;
//    		done.add(current);
//    		
//    		for (Boolean[] letter:alphabet) {
//    			Integer[] newInts = new Integer[f.length];
//    			for (int i=0;i<f.length;i++) {
//    				//Get the letter for the equation
//    				Character[] currentVarNames = f[i].getVarNames();
//    				Boolean[] realLetter = new Boolean[currentVarNames.length];
//    				int currentIndex = 0;
//    				for (int j=0;j<varNames.length;j++) {
//    					if (currentIndex < currentVarNames.length && varNames[j] == currentVarNames[currentIndex]) {
//    						realLetter[currentIndex] = letter[j];
//    						currentIndex++;
//    					}
//    				}
//    				
//    				newInts[i] = f[i].eval(realLetter);
//    			}
//    			
//				int l=0;
//				boolean trashTransition = false;
//				for (Integer k:currentNum) {
//					newInts[l] = k-newInts[l];
//					if (newInts[l]%2 != 0) {
//						
//						if (!trashMade) {
//	    					State trash = makeTrashState(x , varNames.length);
//	    					trash.setFinal(false);
//	    				}
//	    				
//	    				State currentDestination = x.addState("Trash");
//	    				
//		    			x.addTransition(current, currentDestination, letter);
//		    			trashTransition = true;
//		    			break;
//					}
//					l++;
//				}
//				
//				if (!trashTransition) {
//					String newName = "";
//					isFinal = true; 
//					for (Integer q:newInts) {
//						if (q != 0)
//							isFinal = false;
//    					newName += ((Integer)(q/2)).toString() + " ";
//    				}
//					
//    				State s = x.addState(newName);
//    				s.setFinal(isFinal);
//    				x.addTransition(current,s,letter);
//    				if (!done.contains(s))
//    					w.add(s);
//    			}
//    		}
//    	}
//		
//		return x;
//	}

	
	/*************** HELPER METHODS ******************/
	
	private char[] getAllVarNames(CommonTree ast) {
		
		SortedSet<Character> result = new TreeSet<Character>();
		
		Worklist<CommonTree> w = new Worklist<CommonTree>();
		w.add(ast);
		while (!w.isEmpty()) {
			CommonTree current = w.get();
			
			Integer token = current.getToken().getType();
			switch( token ) {
	        //quantifiers
	        //nodes have two children
	        //child 0 is the variable
	        //child 1 is the subformula
	        case PresburgerParser.ALL:
	        	result.add(current.getChild(0).getText().charAt(0));
	        	w.add((org.antlr.runtime.tree.CommonTree)current.getChild(1));
	        	break;
	            
	         case PresburgerParser.EX:
	        	result.add(current.getChild(0).getText().charAt(0));
	        	
		        w.add((org.antlr.runtime.tree.CommonTree)current.getChild(1));
		        break;

	        //binary logical operators
	        //nodes have two children
	        //child 0 is the left subformula
	        //child 1 is the right subformula
	        case PresburgerParser.AND:
	        	for (int i=0;i<current.getChildCount();i++) {
	        		w.add((org.antlr.runtime.tree.CommonTree)current.getChild(i));
	        	}
	        	break;
	        		            
	        case PresburgerParser.IMP:
	        	for (int i=0;i<current.getChildCount();i++) {
	        		w.add((org.antlr.runtime.tree.CommonTree)current.getChild(i));
	        	}
	        	break;

	        case PresburgerParser.OR:
	        	for (int i=0;i<current.getChildCount();i++) {
	        		w.add((org.antlr.runtime.tree.CommonTree)current.getChild(i));
	        	}
	        	break;
	        	
	        //unary logical operators
	        //have a single child
	        //child 0 is the subformula
	        case PresburgerParser.NEG:
	        	w.add((org.antlr.runtime.tree.CommonTree)current.getChild(0));
	        	break;
	            
	        //integer relations: a x + b y + ... R c
	        // have at lecurrent two children
	        // child 0 represents the constant c
	        // children 1 .. represent the linear term
	        // all children should be of tokentype PLUS/MINUS
	        case PresburgerParser.EQ:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;
	        	
	        case PresburgerParser.GEQ:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;
	        	
	        case PresburgerParser.GT:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;
	            
	        case PresburgerParser.LEQ:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;
	        	
	        case PresburgerParser.LT:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;
	            
	        case PresburgerParser.NEQ:
	        	for (int i=0;i<current.getChildCount()-1;i++) {
	        		result.add(current.getChild(i).getChild(1).getText().charAt(0));
	        	}
	        	break;

			}
		}
		
		char[] varNames = new char[result.size()];
		int i=0;
		for (Character x:result) {
			varNames[i++] = x;
		}
		
		return varNames;
		
		
	}
	
	private String makeNameFromFormulas(Formula[] f) {
		String result = "";
		for (Formula x:f) {
			result += x.getBound().toString()+" ";
		}
		
		return result;
	}
	
	private Integer[] makeIntFromState(State s) {
		String name = s.getName();
		String[] ints = name.split(" ");
		Integer[] result = new Integer[ints.length];
		int i = 0;
		for (String x:ints) {
			result[i++] = Integer.valueOf(x);
		}
		
		return result;
	}
	
	private Boolean[][] getAllBooleanCombinations(int n) {
		Boolean[][]result  = null;
		if (n >=1) {
			result = new Boolean[][]{{true},{false}};
			while(result.length < Math.pow(2,n)) {
				Boolean[][] newResult = new Boolean[2*result.length][result[0].length+1];
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

}
