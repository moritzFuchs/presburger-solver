package BA.Solver;

import java.util.HashSet;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import BA.Logic.LogicTree;
import BA.Solver.Parser.PresburgerLexer;
import BA.Solver.Parser.PresburgerParser;

public class Macro {

	private String name;
	private String[] arguments;
	private LogicTree t;
	
	private Integer id;
	
	private String[] boundVarNames;
	private String[] varNames;
	
	private String macro;
	
	public Macro(String macro,Integer id,MacroManager m) throws Exception {
		
		System.out.println(macro);
		
		this.id = id;
		
		this.macro = macro;

		String[] split = macro.split(":=");
		if (split.length > 2) {
			throw new Exception("Additional := found. Please use only one of there in a Macro definition. The valid Syntax is MACRO(var,..) := formula");
		}
		
		if (split.length < 2) {
			throw new Exception("No := found. Please use := to define your macro. The valid Syntax is MACRO(var,..) := formula");
		}
		
		String[] nameAndArguments = split[0].split("\\("); 
		if (nameAndArguments.length > 2) {
			throw new Exception("Additional ( found on the left hand side. Please use only one of there in a Macro definition. The valid Syntax is MACRO(var,..) := formula");
		}
		
		name = nameAndArguments[0];
		String[] argumentStrings = nameAndArguments[1].split("\\)");
		arguments = argumentStrings[0].split(",");
		
		CharStream input = new ANTLRStringStream(split[1]);
		
		// Generate a lexer for reading the formula `input'
        PresburgerLexer lex = new PresburgerLexer(input);
        // Generate from the lexer a token stream to be fed to the parser
		CommonTokenStream tokens = new CommonTokenStream(lex);
        // Generate the parser analyzing the token stream
        PresburgerParser parser = new PresburgerParser(tokens);
        
        // Finally parse the input and generate the tree
        PresburgerParser.f_return r = null;
        
		try {
			r = parser.f();
		} catch (RecognitionException e) {
			System.err.println("Error while Parsing!");
		}             
		
		for (RecognitionException e:parser.exceptions) {
			if (e.charPositionInLine != -1) {
				throw new Exception("Your formula could not be parsed: There was no viable alternative at position " + e.charPositionInLine + " (Character " + split[1].substring(e.charPositionInLine-1 , e.charPositionInLine) + ").");
			}
		}
		
        //get the AST encapsuled in r
        org.antlr.runtime.tree.CommonTree ast = (org.antlr.runtime.tree.CommonTree)r.getTree();

        this.t = new LogicTree(ast,m);
        this.t.pushNegations();
        this.t.checkFormulas();
        System.out.println(this.t);
        
        this.boundVarNames = t.getAllBoundVarNames();
        this.varNames = t.getAllVarNames();
        
        
        for (String s:arguments) {
        	boolean found = false;
        	for (String comp:boundVarNames) {
        		if (s.equals(comp))
        			found = true;
        	}
        	if (found)
        		throw new Exception("The variable " + s + " is not a free variable in your formula.");
        	found = false;
        	for (String comp:varNames) {
        		if (s.equals(comp))
        			found = true;
        	}
        	if (!found)
        		throw new Exception("The variable " + s + " does not show up in your formula.");
        	
        }
        
        for (String comp:varNames) {
        	boolean found = false;
        	for (String s:boundVarNames) {
        		if (s.equals(comp)) {
        			found = true;
        			break;
        		}
        	}
        	if (!found) {
        		for (String s:arguments) {
            		if (s.equals(comp)) {
            			found = true;
            			break;
            		}
            	}
        	}
        	
        	if (!found) {
        		throw new Exception("The variable " + comp + " is a free variable, but doesn't show up in the arguments of your macro.");
        	}
        }
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns a copy of the logic tree for this macro
	 * @return
	 */
	public LogicTree getLogicTree() {
		return this.t.clone();
	}	
	

	public String[] getArguments() {
		return this.arguments;
	}

	public boolean isBoundVar(String s) {
		for (String comp:boundVarNames) {
			if (s.equals(comp))
				return true;
		}
		return false;
	}
	
	public String getText() {
		return this.macro;
	}
	
	public Integer getId() {
		return this.id;
	}
	
}
