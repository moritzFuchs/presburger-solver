package BA.Solver;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import BA.Solver.Parser.PresburgerLexer;
import BA.Solver.Parser.PresburgerParser;

public class FormulaTester {

	public static int testInput(String formula) {
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
        	
        	for (RecognitionException e:parser.exceptions) {
        		return e.index;
        	}
    		
        } catch ( RecognitionException e) {
        	return -1;
        }
        

        return -1;
	}
	
	private static boolean checkTree(CommonTree ast) {
		boolean ret = true;
    	for (int i=0;i<ast.getChildCount();i++) {
    		 ret = ret && checkTree((CommonTree)ast.getChild(i));
    	}
    	
    	return ret;
	}
	
}
