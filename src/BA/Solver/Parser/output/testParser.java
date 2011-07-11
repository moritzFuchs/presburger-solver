// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g 2011-06-13 16:49:29

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
public class testParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "EX", "QUANT", "MACRO", "VAR", "INT", "WS", "')'"
    };
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int ALL=4;
    public static final int EX=5;
    public static final int QUANT=6;
    public static final int MACRO=7;
    public static final int VAR=8;
    public static final int INT=9;
    public static final int WS=10;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "test"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
        false
    };

     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public testParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public testParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, null);
            setDebugListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
        }
    public testParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return testParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g"; }



    // $ANTLR start "test"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:10:1: test : ( QUANT | MACRO ')' );
    public final void test() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "test");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(10, 1);

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:10:6: ( QUANT | MACRO ')' )
            int alt1=2;
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==QUANT) ) {
                alt1=1;
            }
            else if ( (LA1_0==MACRO) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:10:8: QUANT
                    {
                    dbg.location(10,8);
                    match(input,QUANT,FOLLOW_QUANT_in_test23); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:11:4: MACRO ')'
                    {
                    dbg.location(11,4);
                    match(input,MACRO,FOLLOW_MACRO_in_test29); 
                    dbg.location(11,10);
                    match(input,11,FOLLOW_11_in_test31); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(11, 13);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "test");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "test"

    // Delegated rules


 

    public static final BitSet FOLLOW_QUANT_in_test23 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_test29 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_test31 = new BitSet(new long[]{0x0000000000000002L});

}