// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g 2011-06-13 16:49:29

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class testLexer extends Lexer {
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

    public testLexer() {;} 
    public testLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public testLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:3:7: ( ')' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:3:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "QUANT"
    public final void mQUANT() throws RecognitionException {
        try {
            int _type = QUANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:14:6: ( 'A' ( VAR )+ ':' | 'E' ( VAR )+ ':' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='A') ) {
                alt3=1;
            }
            else if ( (LA3_0=='E') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:14:8: 'A' ( VAR )+ ':'
                    {
                    match('A'); 
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:14:11: ( VAR )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:14:11: VAR
                    	    {
                    	    mVAR(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    match(':'); 

                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:15:8: 'E' ( VAR )+ ':'
                    {
                    match('E'); 
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:15:11: ( VAR )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:15:11: VAR
                    	    {
                    	    mVAR(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    match(':'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUANT"

    // $ANTLR start "MACRO"
    public final void mMACRO() throws RecognitionException {
        try {
            int _type = MACRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:8: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' )* '(' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:11: ( 'A' .. 'Z' ) ( 'a' .. 'z' )* '('
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:11: ( 'A' .. 'Z' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:12: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:21: ( 'a' .. 'z' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:18:22: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MACRO"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:6: ( ( 'a' .. 'z' ) ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )* )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:9: ( 'a' .. 'z' ) ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )*
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:9: ( 'a' .. 'z' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:10: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:19: ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='[') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:20: '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']'
            	    {
            	    match('['); 
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:24: ( ( 'a' .. 'z' ) ( '+' INT )? | INT )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( ((LA6_0>='a' && LA6_0<='z')) ) {
            	        alt6=1;
            	    }
            	    else if ( ((LA6_0>='0' && LA6_0<='9')) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:25: ( 'a' .. 'z' ) ( '+' INT )?
            	            {
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:25: ( 'a' .. 'z' )
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:26: 'a' .. 'z'
            	            {
            	            matchRange('a','z'); 

            	            }

            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:35: ( '+' INT )?
            	            int alt5=2;
            	            int LA5_0 = input.LA(1);

            	            if ( (LA5_0=='+') ) {
            	                alt5=1;
            	            }
            	            switch (alt5) {
            	                case 1 :
            	                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:36: '+' INT
            	                    {
            	                    match('+'); 
            	                    mINT(); 

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:20:48: INT
            	            {
            	            mINT(); 

            	            }
            	            break;

            	    }

            	    match(']'); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:22:5: ( ( '0' .. '9' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:22:7: ( '0' .. '9' )+
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:22:7: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:22:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:24:4: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:24:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:24:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:8: ( T__11 | QUANT | MACRO | VAR | INT | WS )
        int alt10=6;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:16: QUANT
                {
                mQUANT(); 

                }
                break;
            case 3 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:22: MACRO
                {
                mMACRO(); 

                }
                break;
            case 4 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:28: VAR
                {
                mVAR(); 

                }
                break;
            case 5 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:32: INT
                {
                mINT(); 

                }
                break;
            case 6 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/test.g:1:36: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\1\11\1\uffff\2\50\4\uffff\2\50\1\uffff";
    static final String DFA10_maxS =
        "\1\172\1\uffff\2\172\4\uffff\2\172\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\6\2\uffff\1\2";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\7\2\uffff\1\7\22\uffff\1\7\10\uffff\1\1\6\uffff\12\6\7\uffff"+
            "\1\2\3\4\1\3\25\4\6\uffff\32\5",
            "",
            "\1\4\70\uffff\32\10",
            "\1\4\70\uffff\32\11",
            "",
            "",
            "",
            "",
            "\1\4\21\uffff\1\12\40\uffff\1\12\5\uffff\32\10",
            "\1\4\21\uffff\1\12\40\uffff\1\12\5\uffff\32\11",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | QUANT | MACRO | VAR | INT | WS );";
        }
    }
 

}