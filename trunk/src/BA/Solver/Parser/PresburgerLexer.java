package BA.Solver.Parser;
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g 2011-06-17 10:57:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PresburgerLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int PLUS=4;
    public static final int MINUS=5;
    public static final int NEG=6;
    public static final int AND=7;
    public static final int OR=8;
    public static final int IMP=9;
    public static final int BIIMP=10;
    public static final int ALL=11;
    public static final int EX=12;
    public static final int EQ=13;
    public static final int NEQ=14;
    public static final int GEQ=15;
    public static final int LEQ=16;
    public static final int GT=17;
    public static final int LT=18;
    public static final int L=19;
    public static final int R=20;
    public static final int PRED=21;
    public static final int FORAND=22;
    public static final int FOROR=23;
    public static final int CONSTNUM=24;
    public static final int MACRO=25;
    public static final int VAR=26;
    public static final int QUANT=27;
    public static final int INT=28;
    public static final int WS=29;

    // delegates
    // delegators

    public PresburgerLexer() {;} 
    public PresburgerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PresburgerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g"; }

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:3:7: ( '!' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:3:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:4:7: ( '&&' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:4:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:5:7: ( '[' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:5:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:6:7: ( '=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:6:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:7:7: ( '.' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:7:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:8:7: ( ']' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:8:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:9:7: ( '||' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:9:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:10:7: ( ',' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:10:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:11:7: ( ')' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:11:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:12:7: ( '->' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:12:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:13:7: ( '<->' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:13:9: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:14:7: ( '(' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:15:7: ( '+' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:15:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:16:7: ( '-' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:16:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:17:7: ( '==' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:17:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:18:7: ( '!=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:18:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:19:7: ( '>=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:19:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:20:7: ( '<=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:20:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:21:7: ( '>' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:21:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:22:7: ( '<' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:22:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "QUANT"
    public final void mQUANT() throws RecognitionException {
        try {
            int _type = QUANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:103:6: ( 'A' ( VAR )+ ':' | 'E' ( VAR )+ ':' )
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
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:103:8: 'A' ( VAR )+ ':'
                    {
                    match('A'); 
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:103:11: ( VAR )+
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
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:103:11: VAR
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
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:104:8: 'E' ( VAR )+ ':'
                    {
                    match('E'); 
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:104:11: ( VAR )+
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
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:104:11: VAR
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
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:8: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' )* '(' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:11: ( 'A' .. 'Z' ) ( 'a' .. 'z' )* '('
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:11: ( 'A' .. 'Z' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:12: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:21: ( 'a' .. 'z' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:107:22: 'a' .. 'z'
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
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:6: ( ( 'a' .. 'z' ) ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )* )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:9: ( 'a' .. 'z' ) ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )*
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:9: ( 'a' .. 'z' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:10: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:19: ( '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='[') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:20: '[' ( ( 'a' .. 'z' ) ( '+' INT )? | INT ) ']'
            	    {
            	    match('['); 
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:24: ( ( 'a' .. 'z' ) ( '+' INT )? | INT )
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
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:25: ( 'a' .. 'z' ) ( '+' INT )?
            	            {
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:25: ( 'a' .. 'z' )
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:26: 'a' .. 'z'
            	            {
            	            matchRange('a','z'); 

            	            }

            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:35: ( '+' INT )?
            	            int alt5=2;
            	            int LA5_0 = input.LA(1);

            	            if ( (LA5_0=='+') ) {
            	                alt5=1;
            	            }
            	            switch (alt5) {
            	                case 1 :
            	                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:36: '+' INT
            	                    {
            	                    match('+'); 
            	                    mINT(); 

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:109:48: INT
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
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:111:5: ( ( '0' .. '9' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:111:7: ( '0' .. '9' )+
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:111:7: ( '0' .. '9' )+
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
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:111:8: '0' .. '9'
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
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:113:4: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:113:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:113:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
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
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:
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
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:8: ( T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | QUANT | MACRO | VAR | INT | WS )
        int alt10=25;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:10: T__30
                {
                mT__30(); 

                }
                break;
            case 2 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:16: T__31
                {
                mT__31(); 

                }
                break;
            case 3 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:22: T__32
                {
                mT__32(); 

                }
                break;
            case 4 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:28: T__33
                {
                mT__33(); 

                }
                break;
            case 5 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:34: T__34
                {
                mT__34(); 

                }
                break;
            case 6 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:40: T__35
                {
                mT__35(); 

                }
                break;
            case 7 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:46: T__36
                {
                mT__36(); 

                }
                break;
            case 8 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:52: T__37
                {
                mT__37(); 

                }
                break;
            case 9 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:58: T__38
                {
                mT__38(); 

                }
                break;
            case 10 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:64: T__39
                {
                mT__39(); 

                }
                break;
            case 11 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:70: T__40
                {
                mT__40(); 

                }
                break;
            case 12 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:76: T__41
                {
                mT__41(); 

                }
                break;
            case 13 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:82: T__42
                {
                mT__42(); 

                }
                break;
            case 14 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:88: T__43
                {
                mT__43(); 

                }
                break;
            case 15 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:94: T__44
                {
                mT__44(); 

                }
                break;
            case 16 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:100: T__45
                {
                mT__45(); 

                }
                break;
            case 17 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:106: T__46
                {
                mT__46(); 

                }
                break;
            case 18 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:112: T__47
                {
                mT__47(); 

                }
                break;
            case 19 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:118: T__48
                {
                mT__48(); 

                }
                break;
            case 20 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:124: T__49
                {
                mT__49(); 

                }
                break;
            case 21 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:130: QUANT
                {
                mQUANT(); 

                }
                break;
            case 22 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:136: MACRO
                {
                mMACRO(); 

                }
                break;
            case 23 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:142: VAR
                {
                mVAR(); 

                }
                break;
            case 24 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:146: INT
                {
                mINT(); 

                }
                break;
            case 25 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:150: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\26\2\uffff\1\30\5\uffff\1\32\1\35\2\uffff\1\37\24\uffff";
    static final String DFA10_eofS =
        "\43\uffff";
    static final String DFA10_minS =
        "\1\11\1\75\2\uffff\1\75\5\uffff\1\76\1\55\2\uffff\1\75\2\50\17\uffff"+
        "\2\50\1\uffff";
    static final String DFA10_maxS =
        "\1\174\1\75\2\uffff\1\75\5\uffff\1\76\1\75\2\uffff\1\75\2\172\17"+
        "\uffff\2\172\1\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\14\1\15"+
        "\3\uffff\1\26\1\27\1\30\1\31\1\20\1\1\1\17\1\4\1\12\1\16\1\13\1"+
        "\22\1\24\1\21\1\23\2\uffff\1\25";
    static final String DFA10_specialS =
        "\43\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\24\2\uffff\1\24\22\uffff\1\24\1\1\4\uffff\1\2\1\uffff\1\14"+
            "\1\11\1\uffff\1\15\1\10\1\12\1\5\1\uffff\12\23\2\uffff\1\13"+
            "\1\4\1\16\2\uffff\1\17\3\21\1\20\25\21\1\3\1\uffff\1\6\3\uffff"+
            "\32\22\1\uffff\1\7",
            "\1\25",
            "",
            "",
            "\1\27",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\33\17\uffff\1\34",
            "",
            "",
            "\1\36",
            "\1\21\70\uffff\32\40",
            "\1\21\70\uffff\32\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\21\21\uffff\1\42\40\uffff\1\42\5\uffff\32\40",
            "\1\21\21\uffff\1\42\40\uffff\1\42\5\uffff\32\41",
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
            return "1:1: Tokens : ( T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | QUANT | MACRO | VAR | INT | WS );";
        }
    }
 

}