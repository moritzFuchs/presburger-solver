import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import BA.Solver.Parser.PresburgerLexer;
import BA.Solver.Parser.PresburgerParser;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        PresburgerLexer lex = new PresburgerLexer(new ANTLRFileStream("/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        PresburgerParser g = new PresburgerParser(tokens, 49100, null);
        try {
            g.f();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}