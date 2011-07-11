// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g 2011-06-17 10:57:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class PresburgerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "NEG", "AND", "OR", "IMP", "BIIMP", "ALL", "EX", "EQ", "NEQ", "GEQ", "LEQ", "GT", "LT", "L", "R", "PRED", "FORAND", "FOROR", "CONSTNUM", "MACRO", "VAR", "QUANT", "INT", "WS", "'!'", "'&&'", "'['", "'='", "'.'", "']'", "'||'", "','", "')'", "'->'", "'<->'", "'('", "'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'"
    };
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


        public PresburgerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PresburgerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[61+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PresburgerParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g"; }


    public static class formula_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formula"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:36:1: formula : ( linearpred | '!' expr -> ^( NEG[\"not\"] expr ) | '&&' ( '[' VAR '=' num '.' '.' num ']' )+ expr -> ^( FORAND ( VAR num num )+ expr ) | '||' ( '[' VAR '=' num '.' '.' num ']' )+ expr -> ^( FOROR ( VAR num num )+ expr ) | QUANT expr -> ^( QUANT expr ) | MACRO linearterm ( ',' linearterm )* ')' -> ^( MACRO ( PRED linearterm )+ ) );
    public final PresburgerParser.formula_return formula() throws RecognitionException {
        PresburgerParser.formula_return retval = new PresburgerParser.formula_return();
        retval.start = input.LT(1);
        int formula_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal2=null;
        Token string_literal4=null;
        Token char_literal5=null;
        Token VAR6=null;
        Token char_literal7=null;
        Token char_literal9=null;
        Token char_literal10=null;
        Token char_literal12=null;
        Token string_literal14=null;
        Token char_literal15=null;
        Token VAR16=null;
        Token char_literal17=null;
        Token char_literal19=null;
        Token char_literal20=null;
        Token char_literal22=null;
        Token QUANT24=null;
        Token MACRO26=null;
        Token char_literal28=null;
        Token char_literal30=null;
        PresburgerParser.linearpred_return linearpred1 = null;

        PresburgerParser.expr_return expr3 = null;

        PresburgerParser.num_return num8 = null;

        PresburgerParser.num_return num11 = null;

        PresburgerParser.expr_return expr13 = null;

        PresburgerParser.num_return num18 = null;

        PresburgerParser.num_return num21 = null;

        PresburgerParser.expr_return expr23 = null;

        PresburgerParser.expr_return expr25 = null;

        PresburgerParser.linearterm_return linearterm27 = null;

        PresburgerParser.linearterm_return linearterm29 = null;


        Object char_literal2_tree=null;
        Object string_literal4_tree=null;
        Object char_literal5_tree=null;
        Object VAR6_tree=null;
        Object char_literal7_tree=null;
        Object char_literal9_tree=null;
        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        Object string_literal14_tree=null;
        Object char_literal15_tree=null;
        Object VAR16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        Object char_literal20_tree=null;
        Object char_literal22_tree=null;
        Object QUANT24_tree=null;
        Object MACRO26_tree=null;
        Object char_literal28_tree=null;
        Object char_literal30_tree=null;
        RewriteRuleTokenStream stream_QUANT=new RewriteRuleTokenStream(adaptor,"token QUANT");
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_MACRO=new RewriteRuleTokenStream(adaptor,"token MACRO");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_num=new RewriteRuleSubtreeStream(adaptor,"rule num");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_linearterm=new RewriteRuleSubtreeStream(adaptor,"rule linearterm");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:37:4: ( linearpred | '!' expr -> ^( NEG[\"not\"] expr ) | '&&' ( '[' VAR '=' num '.' '.' num ']' )+ expr -> ^( FORAND ( VAR num num )+ expr ) | '||' ( '[' VAR '=' num '.' '.' num ']' )+ expr -> ^( FOROR ( VAR num num )+ expr ) | QUANT expr -> ^( QUANT expr ) | MACRO linearterm ( ',' linearterm )* ')' -> ^( MACRO ( PRED linearterm )+ ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case VAR:
            case INT:
            case 42:
            case 43:
                {
                alt4=1;
                }
                break;
            case 30:
                {
                alt4=2;
                }
                break;
            case 31:
                {
                alt4=3;
                }
                break;
            case 36:
                {
                alt4=4;
                }
                break;
            case QUANT:
                {
                alt4=5;
                }
                break;
            case MACRO:
                {
                alt4=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:37:8: linearpred
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_linearpred_in_formula153);
                    linearpred1=linearpred();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, linearpred1.getTree());

                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:38:6: '!' expr
                    {
                    char_literal2=(Token)match(input,30,FOLLOW_30_in_formula161); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_30.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_formula163);
                    expr3=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr3.getTree());


                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 38:16: -> ^( NEG[\"not\"] expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:38:19: ^( NEG[\"not\"] expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "not"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:39:6: '&&' ( '[' VAR '=' num '.' '.' num ']' )+ expr
                    {
                    string_literal4=(Token)match(input,31,FOLLOW_31_in_formula181); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_31.add(string_literal4);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:39:11: ( '[' VAR '=' num '.' '.' num ']' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==32) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:39:12: '[' VAR '=' num '.' '.' num ']'
                    	    {
                    	    char_literal5=(Token)match(input,32,FOLLOW_32_in_formula184); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_32.add(char_literal5);

                    	    VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_formula186); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_VAR.add(VAR6);

                    	    char_literal7=(Token)match(input,33,FOLLOW_33_in_formula188); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_33.add(char_literal7);

                    	    pushFollow(FOLLOW_num_in_formula190);
                    	    num8=num();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_num.add(num8.getTree());
                    	    char_literal9=(Token)match(input,34,FOLLOW_34_in_formula192); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_34.add(char_literal9);

                    	    char_literal10=(Token)match(input,34,FOLLOW_34_in_formula194); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_34.add(char_literal10);

                    	    pushFollow(FOLLOW_num_in_formula196);
                    	    num11=num();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_num.add(num11.getTree());
                    	    char_literal12=(Token)match(input,35,FOLLOW_35_in_formula198); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_35.add(char_literal12);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    pushFollow(FOLLOW_expr_in_formula202);
                    expr13=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr13.getTree());


                    // AST REWRITE
                    // elements: VAR, num, expr, num
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 39:51: -> ^( FORAND ( VAR num num )+ expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:39:54: ^( FORAND ( VAR num num )+ expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORAND, "FORAND"), root_1);

                        if ( !(stream_VAR.hasNext()||stream_num.hasNext()||stream_num.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_VAR.hasNext()||stream_num.hasNext()||stream_num.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());
                            adaptor.addChild(root_1, stream_num.nextTree());
                            adaptor.addChild(root_1, stream_num.nextTree());

                        }
                        stream_VAR.reset();
                        stream_num.reset();
                        stream_num.reset();
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:40:6: '||' ( '[' VAR '=' num '.' '.' num ']' )+ expr
                    {
                    string_literal14=(Token)match(input,36,FOLLOW_36_in_formula227); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(string_literal14);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:40:11: ( '[' VAR '=' num '.' '.' num ']' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==32) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:40:12: '[' VAR '=' num '.' '.' num ']'
                    	    {
                    	    char_literal15=(Token)match(input,32,FOLLOW_32_in_formula230); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_32.add(char_literal15);

                    	    VAR16=(Token)match(input,VAR,FOLLOW_VAR_in_formula232); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_VAR.add(VAR16);

                    	    char_literal17=(Token)match(input,33,FOLLOW_33_in_formula234); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_33.add(char_literal17);

                    	    pushFollow(FOLLOW_num_in_formula236);
                    	    num18=num();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_num.add(num18.getTree());
                    	    char_literal19=(Token)match(input,34,FOLLOW_34_in_formula238); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_34.add(char_literal19);

                    	    char_literal20=(Token)match(input,34,FOLLOW_34_in_formula240); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_34.add(char_literal20);

                    	    pushFollow(FOLLOW_num_in_formula242);
                    	    num21=num();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_num.add(num21.getTree());
                    	    char_literal22=(Token)match(input,35,FOLLOW_35_in_formula244); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_35.add(char_literal22);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    pushFollow(FOLLOW_expr_in_formula248);
                    expr23=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr23.getTree());


                    // AST REWRITE
                    // elements: expr, num, num, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 40:51: -> ^( FOROR ( VAR num num )+ expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:40:54: ^( FOROR ( VAR num num )+ expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOROR, "FOROR"), root_1);

                        if ( !(stream_num.hasNext()||stream_num.hasNext()||stream_VAR.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_num.hasNext()||stream_num.hasNext()||stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());
                            adaptor.addChild(root_1, stream_num.nextTree());
                            adaptor.addChild(root_1, stream_num.nextTree());

                        }
                        stream_num.reset();
                        stream_num.reset();
                        stream_VAR.reset();
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:6: QUANT expr
                    {
                    QUANT24=(Token)match(input,QUANT,FOLLOW_QUANT_in_formula273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUANT.add(QUANT24);

                    pushFollow(FOLLOW_expr_in_formula275);
                    expr25=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr25.getTree());


                    // AST REWRITE
                    // elements: QUANT, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 41:27: -> ^( QUANT expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:30: ^( QUANT expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_QUANT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:42:6: MACRO linearterm ( ',' linearterm )* ')'
                    {
                    MACRO26=(Token)match(input,MACRO,FOLLOW_MACRO_in_formula302); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MACRO.add(MACRO26);

                    pushFollow(FOLLOW_linearterm_in_formula304);
                    linearterm27=linearterm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_linearterm.add(linearterm27.getTree());
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:42:23: ( ',' linearterm )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==37) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:42:24: ',' linearterm
                    	    {
                    	    char_literal28=(Token)match(input,37,FOLLOW_37_in_formula307); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_37.add(char_literal28);

                    	    pushFollow(FOLLOW_linearterm_in_formula309);
                    	    linearterm29=linearterm();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_linearterm.add(linearterm29.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    char_literal30=(Token)match(input,38,FOLLOW_38_in_formula313); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal30);



                    // AST REWRITE
                    // elements: linearterm, MACRO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 42:45: -> ^( MACRO ( PRED linearterm )+ )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:42:48: ^( MACRO ( PRED linearterm )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_MACRO.nextNode(), root_1);

                        if ( !(stream_linearterm.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_linearterm.hasNext() ) {
                            adaptor.addChild(root_1, (Object)adaptor.create(PRED, "PRED"));
                            adaptor.addChild(root_1, stream_linearterm.nextTree());

                        }
                        stream_linearterm.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, formula_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formula"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:1: expr : (s= pre -> pre ) ( ( '&&' expr )+ -> ^( AND[\"and\"] $s ( expr )+ ) | ( '||' expr )+ -> ^( OR[\"and\"] $s ( expr )+ ) | ( '->' expr ) -> ^( IMP[\"imp\"] $s expr ) | ( '<->' expr ) -> ^( BIIMP[\"biimp\"] $s expr ) )? ;
    public final PresburgerParser.expr_return expr() throws RecognitionException {
        PresburgerParser.expr_return retval = new PresburgerParser.expr_return();
        retval.start = input.LT(1);
        int expr_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;
        Token string_literal33=null;
        Token string_literal35=null;
        Token string_literal37=null;
        PresburgerParser.pre_return s = null;

        PresburgerParser.expr_return expr32 = null;

        PresburgerParser.expr_return expr34 = null;

        PresburgerParser.expr_return expr36 = null;

        PresburgerParser.expr_return expr38 = null;


        Object string_literal31_tree=null;
        Object string_literal33_tree=null;
        Object string_literal35_tree=null;
        Object string_literal37_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_pre=new RewriteRuleSubtreeStream(adaptor,"rule pre");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:5: ( (s= pre -> pre ) ( ( '&&' expr )+ -> ^( AND[\"and\"] $s ( expr )+ ) | ( '||' expr )+ -> ^( OR[\"and\"] $s ( expr )+ ) | ( '->' expr ) -> ^( IMP[\"imp\"] $s expr ) | ( '<->' expr ) -> ^( BIIMP[\"biimp\"] $s expr ) )? )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:7: (s= pre -> pre ) ( ( '&&' expr )+ -> ^( AND[\"and\"] $s ( expr )+ ) | ( '||' expr )+ -> ^( OR[\"and\"] $s ( expr )+ ) | ( '->' expr ) -> ^( IMP[\"imp\"] $s expr ) | ( '<->' expr ) -> ^( BIIMP[\"biimp\"] $s expr ) )?
            {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:7: (s= pre -> pre )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:8: s= pre
            {
            pushFollow(FOLLOW_pre_in_expr345);
            s=pre();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pre.add(s.getTree());


            // AST REWRITE
            // elements: pre
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 46:14: -> pre
            {
                adaptor.addChild(root_0, stream_pre.nextTree());

            }

            retval.tree = root_0;}
            }

            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:21: ( ( '&&' expr )+ -> ^( AND[\"and\"] $s ( expr )+ ) | ( '||' expr )+ -> ^( OR[\"and\"] $s ( expr )+ ) | ( '->' expr ) -> ^( IMP[\"imp\"] $s expr ) | ( '<->' expr ) -> ^( BIIMP[\"biimp\"] $s expr ) )?
            int alt7=5;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:22: ( '&&' expr )+
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:22: ( '&&' expr )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==31) ) {
                            int LA5_1 = input.LA(2);

                            if ( (synpred9_Presburger()) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:23: '&&' expr
                    	    {
                    	    string_literal31=(Token)match(input,31,FOLLOW_31_in_expr353); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_31.add(string_literal31);

                    	    pushFollow(FOLLOW_expr_in_expr355);
                    	    expr32=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);



                    // AST REWRITE
                    // elements: s, expr
                    // token labels: 
                    // rule labels: retval, s
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 46:35: -> ^( AND[\"and\"] $s ( expr )+ )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:38: ^( AND[\"and\"] $s ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND, "and"), root_1);

                        adaptor.addChild(root_1, stream_s.nextTree());
                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:63: ( '||' expr )+
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:63: ( '||' expr )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==36) ) {
                            int LA6_2 = input.LA(2);

                            if ( (synpred11_Presburger()) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:64: '||' expr
                    	    {
                    	    string_literal33=(Token)match(input,36,FOLLOW_36_in_expr375); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_36.add(string_literal33);

                    	    pushFollow(FOLLOW_expr_in_expr377);
                    	    expr34=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr34.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);



                    // AST REWRITE
                    // elements: s, expr
                    // token labels: 
                    // rule labels: retval, s
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 46:76: -> ^( OR[\"and\"] $s ( expr )+ )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:79: ^( OR[\"and\"] $s ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR, "and"), root_1);

                        adaptor.addChild(root_1, stream_s.nextTree());
                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:103: ( '->' expr )
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:103: ( '->' expr )
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:104: '->' expr
                    {
                    string_literal35=(Token)match(input,39,FOLLOW_39_in_expr397); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(string_literal35);

                    pushFollow(FOLLOW_expr_in_expr399);
                    expr36=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr36.getTree());

                    }



                    // AST REWRITE
                    // elements: expr, s
                    // token labels: 
                    // rule labels: retval, s
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 46:115: -> ^( IMP[\"imp\"] $s expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:118: ^( IMP[\"imp\"] $s expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMP, "imp"), root_1);

                        adaptor.addChild(root_1, stream_s.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:142: ( '<->' expr )
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:142: ( '<->' expr )
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:143: '<->' expr
                    {
                    string_literal37=(Token)match(input,40,FOLLOW_40_in_expr417); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(string_literal37);

                    pushFollow(FOLLOW_expr_in_expr419);
                    expr38=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr38.getTree());

                    }



                    // AST REWRITE
                    // elements: s, expr
                    // token labels: 
                    // rule labels: retval, s
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 46:155: -> ^( BIIMP[\"biimp\"] $s expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:158: ^( BIIMP[\"biimp\"] $s expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BIIMP, "biimp"), root_1);

                        adaptor.addChild(root_1, stream_s.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class pre_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pre"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:49:1: pre : ( '(' expr ')' -> ^( expr ) | formula -> ^( formula ) );
    public final PresburgerParser.pre_return pre() throws RecognitionException {
        PresburgerParser.pre_return retval = new PresburgerParser.pre_return();
        retval.start = input.LT(1);
        int pre_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal39=null;
        Token char_literal41=null;
        PresburgerParser.expr_return expr40 = null;

        PresburgerParser.formula_return formula42 = null;


        Object char_literal39_tree=null;
        Object char_literal41_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_formula=new RewriteRuleSubtreeStream(adaptor,"rule formula");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:50:5: ( '(' expr ')' -> ^( expr ) | formula -> ^( formula ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==41) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=MACRO && LA8_0<=INT)||(LA8_0>=30 && LA8_0<=31)||LA8_0==36||(LA8_0>=42 && LA8_0<=43)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:50:7: '(' expr ')'
                    {
                    char_literal39=(Token)match(input,41,FOLLOW_41_in_pre460); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal39);

                    pushFollow(FOLLOW_expr_in_pre461);
                    expr40=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr40.getTree());
                    char_literal41=(Token)match(input,38,FOLLOW_38_in_pre462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal41);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 50:17: -> ^( expr )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:50:19: ^( expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_expr.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:51:7: formula
                    {
                    pushFollow(FOLLOW_formula_in_pre474);
                    formula42=formula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formula.add(formula42.getTree());


                    // AST REWRITE
                    // elements: formula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 51:15: -> ^( formula )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:51:18: ^( formula )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_formula.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, pre_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pre"

    public static class f_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "f"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:1: f : expr EOF -> ^( expr ) ;
    public final PresburgerParser.f_return f() throws RecognitionException {
        PresburgerParser.f_return retval = new PresburgerParser.f_return();
        retval.start = input.LT(1);
        int f_StartIndex = input.index();
        Object root_0 = null;

        Token EOF44=null;
        PresburgerParser.expr_return expr43 = null;


        Object EOF44_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:3: ( expr EOF -> ^( expr ) )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:5: expr EOF
            {
            pushFollow(FOLLOW_expr_in_f495);
            expr43=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr43.getTree());
            EOF44=(Token)match(input,EOF,FOLLOW_EOF_in_f497); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF44);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 53:14: -> ^( expr )
            {
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:17: ^( expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_expr.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, f_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "f"

    public static class linearpred_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "linearpred"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:55:1: linearpred : linearterm ( comp linearterm )+ -> ^( PRED linearterm ( comp linearterm )+ ) ;
    public final PresburgerParser.linearpred_return linearpred() throws RecognitionException {
        PresburgerParser.linearpred_return retval = new PresburgerParser.linearpred_return();
        retval.start = input.LT(1);
        int linearpred_StartIndex = input.index();
        Object root_0 = null;

        PresburgerParser.linearterm_return linearterm45 = null;

        PresburgerParser.comp_return comp46 = null;

        PresburgerParser.linearterm_return linearterm47 = null;


        RewriteRuleSubtreeStream stream_comp=new RewriteRuleSubtreeStream(adaptor,"rule comp");
        RewriteRuleSubtreeStream stream_linearterm=new RewriteRuleSubtreeStream(adaptor,"rule linearterm");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:56:3: ( linearterm ( comp linearterm )+ -> ^( PRED linearterm ( comp linearterm )+ ) )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:56:5: linearterm ( comp linearterm )+
            {
            pushFollow(FOLLOW_linearterm_in_linearpred515);
            linearterm45=linearterm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_linearterm.add(linearterm45.getTree());
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:56:16: ( comp linearterm )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=44 && LA9_0<=49)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:56:17: comp linearterm
            	    {
            	    pushFollow(FOLLOW_comp_in_linearpred518);
            	    comp46=comp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_comp.add(comp46.getTree());
            	    pushFollow(FOLLOW_linearterm_in_linearpred520);
            	    linearterm47=linearterm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_linearterm.add(linearterm47.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);



            // AST REWRITE
            // elements: linearterm, linearterm, comp
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 56:35: -> ^( PRED linearterm ( comp linearterm )+ )
            {
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:56:38: ^( PRED linearterm ( comp linearterm )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED, "PRED"), root_1);

                adaptor.addChild(root_1, stream_linearterm.nextTree());
                if ( !(stream_linearterm.hasNext()||stream_comp.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_linearterm.hasNext()||stream_comp.hasNext() ) {
                    adaptor.addChild(root_1, stream_comp.nextTree());
                    adaptor.addChild(root_1, stream_linearterm.nextTree());

                }
                stream_linearterm.reset();
                stream_comp.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, linearpred_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "linearpred"

    public static class linearterm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "linearterm"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:1: linearterm : linmon ( sgnlinmon )* ;
    public final PresburgerParser.linearterm_return linearterm() throws RecognitionException {
        PresburgerParser.linearterm_return retval = new PresburgerParser.linearterm_return();
        retval.start = input.LT(1);
        int linearterm_StartIndex = input.index();
        Object root_0 = null;

        PresburgerParser.linmon_return linmon48 = null;

        PresburgerParser.sgnlinmon_return sgnlinmon49 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:3: ( linmon ( sgnlinmon )* )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:5: linmon ( sgnlinmon )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_linmon_in_linearterm551);
            linmon48=linmon();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, linmon48.getTree());
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:12: ( sgnlinmon )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=42 && LA10_0<=43)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:13: sgnlinmon
            	    {
            	    pushFollow(FOLLOW_sgnlinmon_in_linearterm554);
            	    sgnlinmon49=sgnlinmon();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sgnlinmon49.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, linearterm_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "linearterm"

    public static class con_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "con"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:1: con : ( '&&' -> ^( AND[\"and\"] ) | '||' -> ^( OR[\"or\"] ) | '->' -> ^( IMP[\"implies\"] ) | '<->' -> ^( BIIMP[\"implies\"] ) );
    public final PresburgerParser.con_return con() throws RecognitionException {
        PresburgerParser.con_return retval = new PresburgerParser.con_return();
        retval.start = input.LT(1);
        int con_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal50=null;
        Token string_literal51=null;
        Token string_literal52=null;
        Token string_literal53=null;

        Object string_literal50_tree=null;
        Object string_literal51_tree=null;
        Object string_literal52_tree=null;
        Object string_literal53_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:5: ( '&&' -> ^( AND[\"and\"] ) | '||' -> ^( OR[\"or\"] ) | '->' -> ^( IMP[\"implies\"] ) | '<->' -> ^( BIIMP[\"implies\"] ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt11=1;
                }
                break;
            case 36:
                {
                alt11=2;
                }
                break;
            case 39:
                {
                alt11=3;
                }
                break;
            case 40:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:7: '&&'
                    {
                    string_literal50=(Token)match(input,31,FOLLOW_31_in_con567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_31.add(string_literal50);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 63:13: -> ^( AND[\"and\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:16: ^( AND[\"and\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND, "and"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:64:7: '||'
                    {
                    string_literal51=(Token)match(input,36,FOLLOW_36_in_con583); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(string_literal51);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 64:13: -> ^( OR[\"or\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:64:16: ^( OR[\"or\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR, "or"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:65:7: '->'
                    {
                    string_literal52=(Token)match(input,39,FOLLOW_39_in_con599); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(string_literal52);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 65:13: -> ^( IMP[\"implies\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:65:16: ^( IMP[\"implies\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMP, "implies"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:66:7: '<->'
                    {
                    string_literal53=(Token)match(input,40,FOLLOW_40_in_con615); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(string_literal53);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 66:14: -> ^( BIIMP[\"implies\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:66:17: ^( BIIMP[\"implies\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BIIMP, "implies"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, con_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "con"

    public static class linmon_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "linmon"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:69:1: linmon : ( ( '+' )? INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | ( '+' )? VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) );
    public final PresburgerParser.linmon_return linmon() throws RecognitionException {
        PresburgerParser.linmon_return retval = new PresburgerParser.linmon_return();
        retval.start = input.LT(1);
        int linmon_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal54=null;
        Token INT55=null;
        Token VAR56=null;
        Token VAR57=null;
        Token char_literal58=null;
        Token INT59=null;
        Token VAR60=null;
        Token VAR61=null;
        Token char_literal62=null;
        Token INT63=null;
        Token char_literal64=null;
        Token INT65=null;
        Token char_literal66=null;
        Token VAR67=null;
        Token VAR68=null;
        Token char_literal69=null;
        Token VAR70=null;
        Token VAR71=null;

        Object char_literal54_tree=null;
        Object INT55_tree=null;
        Object VAR56_tree=null;
        Object VAR57_tree=null;
        Object char_literal58_tree=null;
        Object INT59_tree=null;
        Object VAR60_tree=null;
        Object VAR61_tree=null;
        Object char_literal62_tree=null;
        Object INT63_tree=null;
        Object char_literal64_tree=null;
        Object INT65_tree=null;
        Object char_literal66_tree=null;
        Object VAR67_tree=null;
        Object VAR68_tree=null;
        Object char_literal69_tree=null;
        Object VAR70_tree=null;
        Object VAR71_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:3: ( ( '+' )? INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | ( '+' )? VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) )
            int alt19=6;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:5: ( '+' )? INT VAR ( VAR )?
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:5: ( '+' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==42) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: '+'
                            {
                            char_literal54=(Token)match(input,42,FOLLOW_42_in_linmon640); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_42.add(char_literal54);


                            }
                            break;

                    }

                    INT55=(Token)match(input,INT,FOLLOW_INT_in_linmon643); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT55);

                    VAR56=(Token)match(input,VAR,FOLLOW_VAR_in_linmon645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR56);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:18: ( VAR )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==VAR) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR57=(Token)match(input,VAR,FOLLOW_VAR_in_linmon647); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR57);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, INT, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 70:23: -> ^( PLUS[\"+\"] INT VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:26: ^( PLUS[\"+\"] INT VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:70:47: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:71:5: '-' INT VAR ( VAR )?
                    {
                    char_literal58=(Token)match(input,43,FOLLOW_43_in_linmon669); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal58);

                    INT59=(Token)match(input,INT,FOLLOW_INT_in_linmon672); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT59);

                    VAR60=(Token)match(input,VAR,FOLLOW_VAR_in_linmon674); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR60);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:71:18: ( VAR )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==VAR) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR61=(Token)match(input,VAR,FOLLOW_VAR_in_linmon676); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR61);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, INT, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 71:22: -> ^( MINUS[\"-\"] INT VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:71:25: ^( MINUS[\"-\"] INT VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:71:46: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:5: ( '+' )? INT
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:5: ( '+' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==42) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: '+'
                            {
                            char_literal62=(Token)match(input,42,FOLLOW_42_in_linmon696); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_42.add(char_literal62);


                            }
                            break;

                    }

                    INT63=(Token)match(input,INT,FOLLOW_INT_in_linmon699); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT63);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 72:15: -> ^( PLUS[\"+\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:18: ^( PLUS[\"+\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:73:5: '-' INT
                    {
                    char_literal64=(Token)match(input,43,FOLLOW_43_in_linmon717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal64);

                    INT65=(Token)match(input,INT,FOLLOW_INT_in_linmon720); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT65);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:15: -> ^( MINUS[\"-\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:73:18: ^( MINUS[\"-\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:5: ( '+' )? VAR ( VAR )?
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:5: ( '+' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==42) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: '+'
                            {
                            char_literal66=(Token)match(input,42,FOLLOW_42_in_linmon737); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_42.add(char_literal66);


                            }
                            break;

                    }

                    VAR67=(Token)match(input,VAR,FOLLOW_VAR_in_linmon740); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR67);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:14: ( VAR )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==VAR) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR68=(Token)match(input,VAR,FOLLOW_VAR_in_linmon742); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR68);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:22: -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:25: ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(INT, "1"));
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:50: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:5: '-' VAR ( VAR )?
                    {
                    char_literal69=(Token)match(input,43,FOLLOW_43_in_linmon767); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal69);

                    VAR70=(Token)match(input,VAR,FOLLOW_VAR_in_linmon770); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR70);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:14: ( VAR )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==VAR) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR71=(Token)match(input,VAR,FOLLOW_VAR_in_linmon772); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR71);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 75:22: -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:25: ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(INT, "1"));
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:51: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, linmon_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "linmon"

    public static class sgnlinmon_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sgnlinmon"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:78:1: sgnlinmon : ( '+' INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | '+' INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | '+' VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) );
    public final PresburgerParser.sgnlinmon_return sgnlinmon() throws RecognitionException {
        PresburgerParser.sgnlinmon_return retval = new PresburgerParser.sgnlinmon_return();
        retval.start = input.LT(1);
        int sgnlinmon_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal72=null;
        Token INT73=null;
        Token VAR74=null;
        Token VAR75=null;
        Token char_literal76=null;
        Token INT77=null;
        Token VAR78=null;
        Token VAR79=null;
        Token char_literal80=null;
        Token INT81=null;
        Token char_literal82=null;
        Token INT83=null;
        Token char_literal84=null;
        Token VAR85=null;
        Token VAR86=null;
        Token char_literal87=null;
        Token VAR88=null;
        Token VAR89=null;

        Object char_literal72_tree=null;
        Object INT73_tree=null;
        Object VAR74_tree=null;
        Object VAR75_tree=null;
        Object char_literal76_tree=null;
        Object INT77_tree=null;
        Object VAR78_tree=null;
        Object VAR79_tree=null;
        Object char_literal80_tree=null;
        Object INT81_tree=null;
        Object char_literal82_tree=null;
        Object INT83_tree=null;
        Object char_literal84_tree=null;
        Object VAR85_tree=null;
        Object VAR86_tree=null;
        Object char_literal87_tree=null;
        Object VAR88_tree=null;
        Object VAR89_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:79:3: ( '+' INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | '+' INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | '+' VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) )
            int alt24=6;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:79:5: '+' INT VAR ( VAR )?
                    {
                    char_literal72=(Token)match(input,42,FOLLOW_42_in_sgnlinmon806); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal72);

                    INT73=(Token)match(input,INT,FOLLOW_INT_in_sgnlinmon808); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT73);

                    VAR74=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon810); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR74);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:79:17: ( VAR )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==VAR) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR75=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon812); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR75);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, VAR, INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:22: -> ^( PLUS[\"+\"] INT VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:79:25: ^( PLUS[\"+\"] INT VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:79:46: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:5: '-' INT VAR ( VAR )?
                    {
                    char_literal76=(Token)match(input,43,FOLLOW_43_in_sgnlinmon834); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal76);

                    INT77=(Token)match(input,INT,FOLLOW_INT_in_sgnlinmon837); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT77);

                    VAR78=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon839); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR78);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:18: ( VAR )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==VAR) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR79=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon841); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR79);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, INT, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:22: -> ^( MINUS[\"-\"] INT VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:25: ^( MINUS[\"-\"] INT VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:46: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:81:5: '+' INT
                    {
                    char_literal80=(Token)match(input,42,FOLLOW_42_in_sgnlinmon861); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal80);

                    INT81=(Token)match(input,INT,FOLLOW_INT_in_sgnlinmon863); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT81);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:14: -> ^( PLUS[\"+\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:81:17: ^( PLUS[\"+\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:5: '-' INT
                    {
                    char_literal82=(Token)match(input,43,FOLLOW_43_in_sgnlinmon881); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal82);

                    INT83=(Token)match(input,INT,FOLLOW_INT_in_sgnlinmon884); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT83);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:15: -> ^( MINUS[\"-\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:18: ^( MINUS[\"-\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:83:5: '+' VAR ( VAR )?
                    {
                    char_literal84=(Token)match(input,42,FOLLOW_42_in_sgnlinmon901); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal84);

                    VAR85=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR85);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:83:13: ( VAR )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==VAR) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR86=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon905); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR86);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:21: -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:83:24: ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(INT, "1"));
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:83:49: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:5: '-' VAR ( VAR )?
                    {
                    char_literal87=(Token)match(input,43,FOLLOW_43_in_sgnlinmon930); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal87);

                    VAR88=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon933); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VAR.add(VAR88);

                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:14: ( VAR )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==VAR) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: VAR
                            {
                            VAR89=(Token)match(input,VAR,FOLLOW_VAR_in_sgnlinmon935); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VAR.add(VAR89);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VAR, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:22: -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:25: ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(INT, "1"));
                        adaptor.addChild(root_1, stream_VAR.nextNode());
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:51: ( VAR )?
                        if ( stream_VAR.hasNext() ) {
                            adaptor.addChild(root_1, stream_VAR.nextNode());

                        }
                        stream_VAR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, sgnlinmon_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "sgnlinmon"

    public static class cons_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cons"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:87:1: cons : ( ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) );
    public final PresburgerParser.cons_return cons() throws RecognitionException {
        PresburgerParser.cons_return retval = new PresburgerParser.cons_return();
        retval.start = input.LT(1);
        int cons_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal90=null;
        Token INT91=null;
        Token char_literal92=null;
        Token INT93=null;

        Object char_literal90_tree=null;
        Object INT91_tree=null;
        Object char_literal92_tree=null;
        Object INT93_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:88:3: ( ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==INT||LA26_0==42) ) {
                alt26=1;
            }
            else if ( (LA26_0==43) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:88:5: ( '+' )? INT
                    {
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:88:5: ( '+' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==42) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:0:0: '+'
                            {
                            char_literal90=(Token)match(input,42,FOLLOW_42_in_cons969); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_42.add(char_literal90);


                            }
                            break;

                    }

                    INT91=(Token)match(input,INT,FOLLOW_INT_in_cons972); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT91);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 88:14: -> ^( PLUS[\"+\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:88:17: ^( PLUS[\"+\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "+"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:89:5: '-' INT
                    {
                    char_literal92=(Token)match(input,43,FOLLOW_43_in_cons989); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal92);

                    INT93=(Token)match(input,INT,FOLLOW_INT_in_cons992); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT93);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 89:14: -> ^( MINUS[\"-\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:89:17: ^( MINUS[\"-\"] INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS, "-"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, cons_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "cons"

    public static class comp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comp"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:92:1: comp : ( '==' -> ^( EQ[\"eq\"] ) | '!=' -> ^( NEQ[\"neq\"] ) | '>=' -> ^( GEQ[\"geq\"] ) | '<=' -> ^( LEQ[\"leq\"] ) | '>' -> ^( GT[\"gt\"] ) | '<' -> ^( LT[\"lt\"] ) );
    public final PresburgerParser.comp_return comp() throws RecognitionException {
        PresburgerParser.comp_return retval = new PresburgerParser.comp_return();
        retval.start = input.LT(1);
        int comp_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal94=null;
        Token string_literal95=null;
        Token string_literal96=null;
        Token string_literal97=null;
        Token char_literal98=null;
        Token char_literal99=null;

        Object string_literal94_tree=null;
        Object string_literal95_tree=null;
        Object string_literal96_tree=null;
        Object string_literal97_tree=null;
        Object char_literal98_tree=null;
        Object char_literal99_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:92:6: ( '==' -> ^( EQ[\"eq\"] ) | '!=' -> ^( NEQ[\"neq\"] ) | '>=' -> ^( GEQ[\"geq\"] ) | '<=' -> ^( LEQ[\"leq\"] ) | '>' -> ^( GT[\"gt\"] ) | '<' -> ^( LT[\"lt\"] ) )
            int alt27=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt27=1;
                }
                break;
            case 45:
                {
                alt27=2;
                }
                break;
            case 46:
                {
                alt27=3;
                }
                break;
            case 47:
                {
                alt27=4;
                }
                break;
            case 48:
                {
                alt27=5;
                }
                break;
            case 49:
                {
                alt27=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:92:8: '=='
                    {
                    string_literal94=(Token)match(input,44,FOLLOW_44_in_comp1015); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal94);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 92:13: -> ^( EQ[\"eq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:92:16: ^( EQ[\"eq\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EQ, "eq"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:93:8: '!='
                    {
                    string_literal95=(Token)match(input,45,FOLLOW_45_in_comp1031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(string_literal95);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 93:13: -> ^( NEQ[\"neq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:93:16: ^( NEQ[\"neq\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEQ, "neq"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:94:8: '>='
                    {
                    string_literal96=(Token)match(input,46,FOLLOW_46_in_comp1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal96);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 94:13: -> ^( GEQ[\"geq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:94:16: ^( GEQ[\"geq\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GEQ, "geq"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:95:8: '<='
                    {
                    string_literal97=(Token)match(input,47,FOLLOW_47_in_comp1063); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal97);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 95:13: -> ^( LEQ[\"leq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:95:16: ^( LEQ[\"leq\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LEQ, "leq"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:96:8: '>'
                    {
                    char_literal98=(Token)match(input,48,FOLLOW_48_in_comp1079); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(char_literal98);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 96:13: -> ^( GT[\"gt\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:96:16: ^( GT[\"gt\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GT, "gt"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:97:8: '<'
                    {
                    char_literal99=(Token)match(input,49,FOLLOW_49_in_comp1096); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal99);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:13: -> ^( LT[\"lt\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:97:16: ^( LT[\"lt\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LT, "lt"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, comp_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "comp"

    public static class num_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "num"
    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:100:1: num : ( VAR | INT );
    public final PresburgerParser.num_return num() throws RecognitionException {
        PresburgerParser.num_return retval = new PresburgerParser.num_return();
        retval.start = input.LT(1);
        int num_StartIndex = input.index();
        Object root_0 = null;

        Token set100=null;

        Object set100_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:100:5: ( VAR | INT )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:
            {
            root_0 = (Object)adaptor.nil();

            set100=(Token)input.LT(1);
            if ( input.LA(1)==VAR||input.LA(1)==INT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set100));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, num_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "num"

    // $ANTLR start synpred9_Presburger
    public final void synpred9_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:23: ( '&&' expr )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:23: '&&' expr
        {
        match(input,31,FOLLOW_31_in_synpred9_Presburger353); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred9_Presburger355);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_Presburger

    // $ANTLR start synpred10_Presburger
    public final void synpred10_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:22: ( ( '&&' expr )+ )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:22: ( '&&' expr )+
        {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:22: ( '&&' expr )+
        int cnt30=0;
        loop30:
        do {
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }


            switch (alt30) {
        	case 1 :
        	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:23: '&&' expr
        	    {
        	    match(input,31,FOLLOW_31_in_synpred10_Presburger353); if (state.failed) return ;
        	    pushFollow(FOLLOW_expr_in_synpred10_Presburger355);
        	    expr();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt30 >= 1 ) break loop30;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(30, input);
                    throw eee;
            }
            cnt30++;
        } while (true);


        }
    }
    // $ANTLR end synpred10_Presburger

    // $ANTLR start synpred11_Presburger
    public final void synpred11_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:64: ( '||' expr )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:64: '||' expr
        {
        match(input,36,FOLLOW_36_in_synpred11_Presburger375); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred11_Presburger377);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_Presburger

    // $ANTLR start synpred12_Presburger
    public final void synpred12_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:63: ( ( '||' expr )+ )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:63: ( '||' expr )+
        {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:63: ( '||' expr )+
        int cnt31=0;
        loop31:
        do {
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }


            switch (alt31) {
        	case 1 :
        	    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:64: '||' expr
        	    {
        	    match(input,36,FOLLOW_36_in_synpred12_Presburger375); if (state.failed) return ;
        	    pushFollow(FOLLOW_expr_in_synpred12_Presburger377);
        	    expr();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt31 >= 1 ) break loop31;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(31, input);
                    throw eee;
            }
            cnt31++;
        } while (true);


        }
    }
    // $ANTLR end synpred12_Presburger

    // $ANTLR start synpred13_Presburger
    public final void synpred13_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:103: ( ( '->' expr ) )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:103: ( '->' expr )
        {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:103: ( '->' expr )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:104: '->' expr
        {
        match(input,39,FOLLOW_39_in_synpred13_Presburger397); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred13_Presburger399);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_Presburger

    // $ANTLR start synpred14_Presburger
    public final void synpred14_Presburger_fragment() throws RecognitionException {   
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:142: ( ( '<->' expr ) )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:142: ( '<->' expr )
        {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:142: ( '<->' expr )
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:143: '<->' expr
        {
        match(input,40,FOLLOW_40_in_synpred14_Presburger417); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred14_Presburger419);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_Presburger

    // Delegated rules

    public final boolean synpred11_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_Presburger() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Presburger_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\1\5\11\uffff";
    static final String DFA7_minS =
        "\1\37\4\0\5\uffff";
    static final String DFA7_maxS =
        "\1\50\4\0\5\uffff";
    static final String DFA7_acceptS =
        "\5\uffff\1\5\1\1\1\2\1\3\1\4";
    static final String DFA7_specialS =
        "\1\uffff\1\3\1\1\1\2\1\0\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\1\5\1\3\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "46:21: ( ( '&&' expr )+ -> ^( AND[\"and\"] $s ( expr )+ ) | ( '||' expr )+ -> ^( OR[\"and\"] $s ( expr )+ ) | ( '->' expr ) -> ^( IMP[\"imp\"] $s expr ) | ( '<->' expr ) -> ^( BIIMP[\"biimp\"] $s expr ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_4 = input.LA(1);

                         
                        int index7_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Presburger()) ) {s = 9;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index7_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_2 = input.LA(1);

                         
                        int index7_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_Presburger()) ) {s = 7;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index7_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_3 = input.LA(1);

                         
                        int index7_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Presburger()) ) {s = 8;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index7_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Presburger()) ) {s = 6;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index7_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\2\uffff\1\6\4\uffff\1\12\3\uffff";
    static final String DFA19_minS =
        "\4\32\3\uffff\1\32\3\uffff";
    static final String DFA19_maxS =
        "\1\53\1\34\1\61\1\34\3\uffff\1\61\3\uffff";
    static final String DFA19_acceptS =
        "\4\uffff\1\5\1\1\1\3\1\uffff\1\6\1\2\1\4";
    static final String DFA19_specialS =
        "\13\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\4\1\uffff\1\2\15\uffff\1\1\1\3",
            "\1\4\1\uffff\1\2",
            "\1\5\4\uffff\1\6\4\uffff\5\6\1\uffff\10\6",
            "\1\10\1\uffff\1\7",
            "",
            "",
            "",
            "\1\11\4\uffff\1\12\4\uffff\5\12\1\uffff\10\12",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "69:1: linmon : ( ( '+' )? INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | ( '+' )? VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) );";
        }
    }
    static final String DFA24_eotS =
        "\13\uffff";
    static final String DFA24_eofS =
        "\3\uffff\1\10\1\uffff\1\12\5\uffff";
    static final String DFA24_minS =
        "\1\52\3\32\1\uffff\1\32\5\uffff";
    static final String DFA24_maxS =
        "\1\53\2\34\1\61\1\uffff\1\61\5\uffff";
    static final String DFA24_acceptS =
        "\4\uffff\1\5\1\uffff\1\6\1\1\1\3\1\2\1\4";
    static final String DFA24_specialS =
        "\13\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\2",
            "\1\4\1\uffff\1\3",
            "\1\6\1\uffff\1\5",
            "\1\7\4\uffff\1\10\4\uffff\5\10\1\uffff\10\10",
            "",
            "\1\11\4\uffff\1\12\4\uffff\5\12\1\uffff\10\12",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "78:1: sgnlinmon : ( '+' INT VAR ( VAR )? -> ^( PLUS[\"+\"] INT VAR ( VAR )? ) | '-' INT VAR ( VAR )? -> ^( MINUS[\"-\"] INT VAR ( VAR )? ) | '+' INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) | '+' VAR ( VAR )? -> ^( PLUS[\"+\"] INT[\"1\"] VAR ( VAR )? ) | '-' VAR ( VAR )? -> ^( MINUS[\"-\"] INT[\"1\"] VAR ( VAR )? ) );";
        }
    }
 

    public static final BitSet FOLLOW_linearpred_in_formula153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_formula161 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_formula163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_formula181 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_formula184 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_formula186 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_formula188 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_num_in_formula190 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_formula192 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_formula194 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_num_in_formula196 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_formula198 = new BitSet(new long[]{0x00000E11DE000000L});
    public static final BitSet FOLLOW_expr_in_formula202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_formula227 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_formula230 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_formula232 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_formula234 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_num_in_formula236 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_formula238 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_formula240 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_num_in_formula242 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_formula244 = new BitSet(new long[]{0x00000E11DE000000L});
    public static final BitSet FOLLOW_expr_in_formula248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUANT_in_formula273 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_formula275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_formula302 = new BitSet(new long[]{0x00000C0014000000L});
    public static final BitSet FOLLOW_linearterm_in_formula304 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_37_in_formula307 = new BitSet(new long[]{0x00000C0014000000L});
    public static final BitSet FOLLOW_linearterm_in_formula309 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_38_in_formula313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_in_expr345 = new BitSet(new long[]{0x0000019080000002L});
    public static final BitSet FOLLOW_31_in_expr353 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_expr355 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_36_in_expr375 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_expr377 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_39_in_expr397 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_expr399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_expr417 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_expr419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_pre460 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_pre461 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_pre462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formula_in_pre474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_f495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_f497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linearterm_in_linearpred515 = new BitSet(new long[]{0x0003F00000000000L});
    public static final BitSet FOLLOW_comp_in_linearpred518 = new BitSet(new long[]{0x00000C0014000000L});
    public static final BitSet FOLLOW_linearterm_in_linearpred520 = new BitSet(new long[]{0x0003F00000000002L});
    public static final BitSet FOLLOW_linmon_in_linearterm551 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_sgnlinmon_in_linearterm554 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_31_in_con567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_con583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_con599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_con615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_linmon640 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_linmon643 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_linmon645 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_linmon647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_linmon669 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_linmon672 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_linmon674 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_linmon676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_linmon696 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_linmon699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_linmon717 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_linmon720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_linmon737 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_linmon740 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_linmon742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_linmon767 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_linmon770 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_linmon772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_sgnlinmon806 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_sgnlinmon808 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon810 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_sgnlinmon834 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_sgnlinmon837 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon839 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_sgnlinmon861 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_sgnlinmon863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_sgnlinmon881 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_sgnlinmon884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_sgnlinmon901 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon903 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_sgnlinmon930 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon933 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_VAR_in_sgnlinmon935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_cons969 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_cons972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_cons989 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_INT_in_cons992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_comp1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_comp1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_comp1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_comp1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_comp1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_comp1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_num0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred9_Presburger353 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred9_Presburger355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred10_Presburger353 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred10_Presburger355 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_36_in_synpred11_Presburger375 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred11_Presburger377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred12_Presburger375 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred12_Presburger377 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_39_in_synpred13_Presburger397 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred13_Presburger399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred14_Presburger417 = new BitSet(new long[]{0x00000E10DE000000L});
    public static final BitSet FOLLOW_expr_in_synpred14_Presburger419 = new BitSet(new long[]{0x0000000000000002L});

}