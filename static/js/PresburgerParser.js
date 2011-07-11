// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g 2011-05-20 21:40:20

var PresburgerParser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    PresburgerParser.superclass.constructor.call(this, input, state);

    this.dfa2 = new PresburgerParser.DFA2(this);

         

    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(PresburgerParser, {
    LT: 17,
    T__29: 29,
    T__28: 28,
    T__27: 27,
    T__26: 26,
    T__25: 25,
    T__24: 24,
    T__23: 23,
    T__22: 22,
    T__21: 21,
    INT: 19,
    MINUS: 5,
    AND: 7,
    EOF: -1,
    T__30: 30,
    T__31: 31,
    T__32: 32,
    WS: 20,
    NEQ: 13,
    T__33: 33,
    T__34: 34,
    T__35: 35,
    T__36: 36,
    EX: 11,
    ALL: 10,
    OR: 8,
    NEG: 6,
    IMP: 9,
    GT: 16,
    PLUS: 4,
    VAR: 18,
    GEQ: 14,
    EQ: 12,
    LEQ: 15
});

(function(){
// public class variables
var LT= 17,
    T__29= 29,
    T__28= 28,
    T__27= 27,
    T__26= 26,
    T__25= 25,
    T__24= 24,
    T__23= 23,
    T__22= 22,
    T__21= 21,
    INT= 19,
    MINUS= 5,
    AND= 7,
    EOF= -1,
    T__30= 30,
    T__31= 31,
    T__32= 32,
    WS= 20,
    NEQ= 13,
    T__33= 33,
    T__34= 34,
    T__35= 35,
    T__36= 36,
    EX= 11,
    ALL= 10,
    OR= 8,
    NEG= 6,
    IMP= 9,
    GT= 16,
    PLUS= 4,
    VAR= 18,
    GEQ= 14,
    EQ= 12,
    LEQ= 15;

// public instance methods/vars
org.antlr.lang.extend(PresburgerParser, org.antlr.runtime.Parser, {
        
    setTreeAdaptor: function(adaptor) {
        this.adaptor = adaptor;
    },
    getTreeAdaptor: function() {
        return this.adaptor;
    },

    getTokenNames: function() { return PresburgerParser.tokenNames; },
    getGrammarFileName: function() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g"; }
});
org.antlr.lang.augmentObject(PresburgerParser.prototype, {

    // inline static return class
    formula_return: (function() {
        PresburgerParser.formula_return = function(){};
        org.antlr.lang.extend(PresburgerParser.formula_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:23:1: formula : ( linearpred | '!' formula -> ^( NEG[\"not\"] formula ) | '(' linearpred ( '&&' linearpred )+ ')' -> ^( AND[\"and\"] linearpred ( linearpred )+ ) | '(' formula con formula ')' -> ^( con formula formula ) | quan VAR formula -> ^( quan VAR formula ) );
    // $ANTLR start "formula"
    formula: function() {
        var retval = new PresburgerParser.formula_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal2 = null;
        var char_literal4 = null;
        var string_literal6 = null;
        var char_literal8 = null;
        var char_literal9 = null;
        var char_literal13 = null;
        var VAR15 = null;
         var linearpred1 = null;
         var formula3 = null;
         var linearpred5 = null;
         var linearpred7 = null;
         var formula10 = null;
         var con11 = null;
         var formula12 = null;
         var quan14 = null;
         var formula16 = null;

        var char_literal2_tree=null;
        var char_literal4_tree=null;
        var string_literal6_tree=null;
        var char_literal8_tree=null;
        var char_literal9_tree=null;
        var char_literal13_tree=null;
        var VAR15_tree=null;
        var stream_21=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 21");
        var stream_VAR=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token VAR");
        var stream_22=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 22");
        var stream_23=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 23");
        var stream_24=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 24");
        var stream_con=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule con");
        var stream_linearpred=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule linearpred");
        var stream_quan=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule quan");
        var stream_formula=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule formula");
        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:24:3: ( linearpred | '!' formula -> ^( NEG[\"not\"] formula ) | '(' linearpred ( '&&' linearpred )+ ')' -> ^( AND[\"and\"] linearpred ( linearpred )+ ) | '(' formula con formula ')' -> ^( con formula formula ) | quan VAR formula -> ^( quan VAR formula ) )
            var alt2=5;
            alt2 = this.dfa2.predict(this.input);
            switch (alt2) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:24:5: linearpred
                    root_0 = this.adaptor.nil();

                    this.pushFollow(PresburgerParser.FOLLOW_linearpred_in_formula105);
                    linearpred1=this.linearpred();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, linearpred1.getTree());


                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:25:5: '!' formula
                    char_literal2=this.match(this.input,21,PresburgerParser.FOLLOW_21_in_formula111);  
                    stream_21.add(char_literal2);

                    this.pushFollow(PresburgerParser.FOLLOW_formula_in_formula113);
                    formula3=this.formula();

                    this.state._fsp--;

                    stream_formula.add(formula3.getTree());


                    // AST REWRITE
                    // elements: formula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 25:33: -> ^( NEG[\"not\"] formula )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:25:36: ^( NEG[\"not\"] formula )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(NEG, "not"), root_1);

                        this.adaptor.addChild(root_1, stream_formula.nextTree());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:26:5: '(' linearpred ( '&&' linearpred )+ ')'
                    char_literal4=this.match(this.input,22,PresburgerParser.FOLLOW_22_in_formula144);  
                    stream_22.add(char_literal4);

                    this.pushFollow(PresburgerParser.FOLLOW_linearpred_in_formula146);
                    linearpred5=this.linearpred();

                    this.state._fsp--;

                    stream_linearpred.add(linearpred5.getTree());
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:26:20: ( '&&' linearpred )+
                    var cnt1=0;
                    loop1:
                    do {
                        var alt1=2;
                        var LA1_0 = this.input.LA(1);

                        if ( (LA1_0==23) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:26:21: '&&' linearpred
                            string_literal6=this.match(this.input,23,PresburgerParser.FOLLOW_23_in_formula149);  
                            stream_23.add(string_literal6);

                            this.pushFollow(PresburgerParser.FOLLOW_linearpred_in_formula151);
                            linearpred7=this.linearpred();

                            this.state._fsp--;

                            stream_linearpred.add(linearpred7.getTree());


                            break;

                        default :
                            if ( cnt1 >= 1 ) {
                                break loop1;
                            }
                                var eee = new org.antlr.runtime.EarlyExitException(1, this.input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    char_literal8=this.match(this.input,24,PresburgerParser.FOLLOW_24_in_formula155);  
                    stream_24.add(char_literal8);



                    // AST REWRITE
                    // elements: linearpred, linearpred
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 26:43: -> ^( AND[\"and\"] linearpred ( linearpred )+ )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:26:46: ^( AND[\"and\"] linearpred ( linearpred )+ )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(AND, "and"), root_1);

                        this.adaptor.addChild(root_1, stream_linearpred.nextTree());
                        if ( !(stream_linearpred.hasNext()) ) {
                            throw new org.antlr.runtime.tree.RewriteEarlyExitException();
                        }
                        while ( stream_linearpred.hasNext() ) {
                            this.adaptor.addChild(root_1, stream_linearpred.nextTree());

                        }
                        stream_linearpred.reset();

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:27:5: '(' formula con formula ')'
                    char_literal9=this.match(this.input,22,PresburgerParser.FOLLOW_22_in_formula175);  
                    stream_22.add(char_literal9);

                    this.pushFollow(PresburgerParser.FOLLOW_formula_in_formula177);
                    formula10=this.formula();

                    this.state._fsp--;

                    stream_formula.add(formula10.getTree());
                    this.pushFollow(PresburgerParser.FOLLOW_con_in_formula179);
                    con11=this.con();

                    this.state._fsp--;

                    stream_con.add(con11.getTree());
                    this.pushFollow(PresburgerParser.FOLLOW_formula_in_formula181);
                    formula12=this.formula();

                    this.state._fsp--;

                    stream_formula.add(formula12.getTree());
                    char_literal13=this.match(this.input,24,PresburgerParser.FOLLOW_24_in_formula183);  
                    stream_24.add(char_literal13);



                    // AST REWRITE
                    // elements: formula, con, formula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 27:33: -> ^( con formula formula )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:27:36: ^( con formula formula )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(stream_con.nextNode(), root_1);

                        this.adaptor.addChild(root_1, stream_formula.nextTree());
                        this.adaptor.addChild(root_1, stream_formula.nextTree());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:28:5: quan VAR formula
                    this.pushFollow(PresburgerParser.FOLLOW_quan_in_formula199);
                    quan14=this.quan();

                    this.state._fsp--;

                    stream_quan.add(quan14.getTree());
                    VAR15=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_formula201);  
                    stream_VAR.add(VAR15);

                    this.pushFollow(PresburgerParser.FOLLOW_formula_in_formula203);
                    formula16=this.formula();

                    this.state._fsp--;

                    stream_formula.add(formula16.getTree());


                    // AST REWRITE
                    // elements: quan, VAR, formula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 28:33: -> ^( quan VAR formula )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:28:36: ^( quan VAR formula )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(stream_quan.nextNode(), root_1);

                        this.adaptor.addChild(root_1, stream_VAR.nextNode());
                        this.adaptor.addChild(root_1, stream_formula.nextTree());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    linearpredRest_return: (function() {
        PresburgerParser.linearpredRest_return = function(){};
        org.antlr.lang.extend(PresburgerParser.linearpredRest_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:32:1: linearpredRest : linearterm '==' cons -> ^( EQ[\"eq\"] linearterm cons ) ;
    // $ANTLR start "linearpredRest"
    linearpredRest: function() {
        var retval = new PresburgerParser.linearpredRest_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal18 = null;
         var linearterm17 = null;
         var cons19 = null;

        var string_literal18_tree=null;
        var stream_25=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 25");
        var stream_linearterm=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule linearterm");
        var stream_cons=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule cons");
        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:33:3: ( linearterm '==' cons -> ^( EQ[\"eq\"] linearterm cons ) )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:33:5: linearterm '==' cons
            this.pushFollow(PresburgerParser.FOLLOW_linearterm_in_linearpredRest241);
            linearterm17=this.linearterm();

            this.state._fsp--;

            stream_linearterm.add(linearterm17.getTree());
            string_literal18=this.match(this.input,25,PresburgerParser.FOLLOW_25_in_linearpredRest243);  
            stream_25.add(string_literal18);

            this.pushFollow(PresburgerParser.FOLLOW_cons_in_linearpredRest245);
            cons19=this.cons();

            this.state._fsp--;

            stream_cons.add(cons19.getTree());


            // AST REWRITE
            // elements: cons, linearterm
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = this.adaptor.nil();
            // 33:26: -> ^( EQ[\"eq\"] linearterm cons )
            {
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:33:29: ^( EQ[\"eq\"] linearterm cons )
                {
                var root_1 = this.adaptor.nil();
                root_1 = this.adaptor.becomeRoot(this.adaptor.create(EQ, "eq"), root_1);

                this.adaptor.addChild(root_1, stream_linearterm.nextTree());
                this.adaptor.addChild(root_1, stream_cons.nextTree());

                this.adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;


            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    linearpred_return: (function() {
        PresburgerParser.linearpred_return = function(){};
        org.antlr.lang.extend(PresburgerParser.linearpred_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:36:1: linearpred : linearterm comp cons -> ^( comp linearterm cons ) ;
    // $ANTLR start "linearpred"
    linearpred: function() {
        var retval = new PresburgerParser.linearpred_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var linearterm20 = null;
         var comp21 = null;
         var cons22 = null;

        var stream_comp=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule comp");
        var stream_linearterm=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule linearterm");
        var stream_cons=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule cons");
        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:37:3: ( linearterm comp cons -> ^( comp linearterm cons ) )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:37:5: linearterm comp cons
            this.pushFollow(PresburgerParser.FOLLOW_linearterm_in_linearpred272);
            linearterm20=this.linearterm();

            this.state._fsp--;

            stream_linearterm.add(linearterm20.getTree());
            this.pushFollow(PresburgerParser.FOLLOW_comp_in_linearpred274);
            comp21=this.comp();

            this.state._fsp--;

            stream_comp.add(comp21.getTree());
            this.pushFollow(PresburgerParser.FOLLOW_cons_in_linearpred276);
            cons22=this.cons();

            this.state._fsp--;

            stream_cons.add(cons22.getTree());


            // AST REWRITE
            // elements: comp, cons, linearterm
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = this.adaptor.nil();
            // 37:26: -> ^( comp linearterm cons )
            {
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:37:29: ^( comp linearterm cons )
                {
                var root_1 = this.adaptor.nil();
                root_1 = this.adaptor.becomeRoot(stream_comp.nextNode(), root_1);

                this.adaptor.addChild(root_1, stream_linearterm.nextTree());
                this.adaptor.addChild(root_1, stream_cons.nextTree());

                this.adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;


            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    linearterm_return: (function() {
        PresburgerParser.linearterm_return = function(){};
        org.antlr.lang.extend(PresburgerParser.linearterm_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:40:1: linearterm : linmon ( sgnlinmon )* ;
    // $ANTLR start "linearterm"
    linearterm: function() {
        var retval = new PresburgerParser.linearterm_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var linmon23 = null;
         var sgnlinmon24 = null;


        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:3: ( linmon ( sgnlinmon )* )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:5: linmon ( sgnlinmon )*
            root_0 = this.adaptor.nil();

            this.pushFollow(PresburgerParser.FOLLOW_linmon_in_linearterm302);
            linmon23=this.linmon();

            this.state._fsp--;

            this.adaptor.addChild(root_0, linmon23.getTree());
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:12: ( sgnlinmon )*
            loop3:
            do {
                var alt3=2;
                var LA3_0 = this.input.LA(1);

                if ( ((LA3_0>=26 && LA3_0<=27)) ) {
                    alt3=1;
                }


                switch (alt3) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:41:13: sgnlinmon
                    this.pushFollow(PresburgerParser.FOLLOW_sgnlinmon_in_linearterm305);
                    sgnlinmon24=this.sgnlinmon();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, sgnlinmon24.getTree());


                    break;

                default :
                    break loop3;
                }
            } while (true);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    linmon_return: (function() {
        PresburgerParser.linmon_return = function(){};
        org.antlr.lang.extend(PresburgerParser.linmon_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:44:1: linmon : ( ( '+' )? INT VAR -> ^( PLUS[\"+\"] INT VAR ) | '-' INT VAR -> ^( MINUS[\"-\"] INT VAR ) | ( '+' )? VAR -> ^( PLUS[\"+\"] INT[\"1\"] VAR ) | '-' VAR -> ^( MINUS[\"-\"] INT[\"1\"] VAR ) );
    // $ANTLR start "linmon"
    linmon: function() {
        var retval = new PresburgerParser.linmon_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal25 = null;
        var INT26 = null;
        var VAR27 = null;
        var char_literal28 = null;
        var INT29 = null;
        var VAR30 = null;
        var char_literal31 = null;
        var VAR32 = null;
        var char_literal33 = null;
        var VAR34 = null;

        var char_literal25_tree=null;
        var INT26_tree=null;
        var VAR27_tree=null;
        var char_literal28_tree=null;
        var INT29_tree=null;
        var VAR30_tree=null;
        var char_literal31_tree=null;
        var VAR32_tree=null;
        var char_literal33_tree=null;
        var VAR34_tree=null;
        var stream_INT=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token INT");
        var stream_VAR=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token VAR");
        var stream_26=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 26");
        var stream_27=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 27");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:3: ( ( '+' )? INT VAR -> ^( PLUS[\"+\"] INT VAR ) | '-' INT VAR -> ^( MINUS[\"-\"] INT VAR ) | ( '+' )? VAR -> ^( PLUS[\"+\"] INT[\"1\"] VAR ) | '-' VAR -> ^( MINUS[\"-\"] INT[\"1\"] VAR ) )
            var alt6=4;
            switch ( this.input.LA(1) ) {
            case 26:
                var LA6_1 = this.input.LA(2);

                if ( (LA6_1==VAR) ) {
                    alt6=3;
                }
                else if ( (LA6_1==INT) ) {
                    alt6=1;
                }
                else {
                    var nvae =
                        new org.antlr.runtime.NoViableAltException("", 6, 1, this.input);

                    throw nvae;
                }
                break;
            case INT:
                alt6=1;
                break;
            case 27:
                var LA6_3 = this.input.LA(2);

                if ( (LA6_3==INT) ) {
                    alt6=2;
                }
                else if ( (LA6_3==VAR) ) {
                    alt6=4;
                }
                else {
                    var nvae =
                        new org.antlr.runtime.NoViableAltException("", 6, 3, this.input);

                    throw nvae;
                }
                break;
            case VAR:
                alt6=3;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 6, 0, this.input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:5: ( '+' )? INT VAR
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:5: ( '+' )?
                    var alt4=2;
                    var LA4_0 = this.input.LA(1);

                    if ( (LA4_0==26) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:5: '+'
                            char_literal25=this.match(this.input,26,PresburgerParser.FOLLOW_26_in_linmon322);  
                            stream_26.add(char_literal25);



                            break;

                    }

                    INT26=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_linmon325);  
                    stream_INT.add(INT26);

                    VAR27=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_linmon327);  
                    stream_VAR.add(VAR27);



                    // AST REWRITE
                    // elements: VAR, INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 45:18: -> ^( PLUS[\"+\"] INT VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:45:21: ^( PLUS[\"+\"] INT VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(PLUS, "+"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:5: '-' INT VAR
                    char_literal28=this.match(this.input,27,PresburgerParser.FOLLOW_27_in_linmon345);  
                    stream_27.add(char_literal28);

                    INT29=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_linmon348);  
                    stream_INT.add(INT29);

                    VAR30=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_linmon350);  
                    stream_VAR.add(VAR30);



                    // AST REWRITE
                    // elements: INT, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 46:18: -> ^( MINUS[\"-\"] INT VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:46:21: ^( MINUS[\"-\"] INT VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(MINUS, "-"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:47:5: ( '+' )? VAR
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:47:5: ( '+' )?
                    var alt5=2;
                    var LA5_0 = this.input.LA(1);

                    if ( (LA5_0==26) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:47:5: '+'
                            char_literal31=this.match(this.input,26,PresburgerParser.FOLLOW_26_in_linmon367);  
                            stream_26.add(char_literal31);



                            break;

                    }

                    VAR32=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_linmon370);  
                    stream_VAR.add(VAR32);



                    // AST REWRITE
                    // elements: VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 47:18: -> ^( PLUS[\"+\"] INT[\"1\"] VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:47:21: ^( PLUS[\"+\"] INT[\"1\"] VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(PLUS, "+"), root_1);

                        this.adaptor.addChild(root_1, this.adaptor.create(INT, "1"));
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:48:5: '-' VAR
                    char_literal33=this.match(this.input,27,PresburgerParser.FOLLOW_27_in_linmon392);  
                    stream_27.add(char_literal33);

                    VAR34=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_linmon395);  
                    stream_VAR.add(VAR34);



                    // AST REWRITE
                    // elements: VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 48:18: -> ^( MINUS[\"-\"] INT[\"1\"] VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:48:21: ^( MINUS[\"-\"] INT[\"1\"] VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(MINUS, "-"), root_1);

                        this.adaptor.addChild(root_1, this.adaptor.create(INT, "1"));
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    sgnlinmon_return: (function() {
        PresburgerParser.sgnlinmon_return = function(){};
        org.antlr.lang.extend(PresburgerParser.sgnlinmon_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:51:1: sgnlinmon : ( '+' INT VAR -> ^( PLUS[\"+\"] INT VAR ) | '-' INT VAR -> ^( MINUS[\"-\"] INT VAR ) | '+' VAR -> ^( PLUS[\"+\"] INT[\"1\"] VAR ) | '-' VAR -> ^( MINUS[\"-\"] INT[\"1\"] VAR ) );
    // $ANTLR start "sgnlinmon"
    sgnlinmon: function() {
        var retval = new PresburgerParser.sgnlinmon_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal35 = null;
        var INT36 = null;
        var VAR37 = null;
        var char_literal38 = null;
        var INT39 = null;
        var VAR40 = null;
        var char_literal41 = null;
        var VAR42 = null;
        var char_literal43 = null;
        var VAR44 = null;

        var char_literal35_tree=null;
        var INT36_tree=null;
        var VAR37_tree=null;
        var char_literal38_tree=null;
        var INT39_tree=null;
        var VAR40_tree=null;
        var char_literal41_tree=null;
        var VAR42_tree=null;
        var char_literal43_tree=null;
        var VAR44_tree=null;
        var stream_INT=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token INT");
        var stream_VAR=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token VAR");
        var stream_26=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 26");
        var stream_27=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 27");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:52:3: ( '+' INT VAR -> ^( PLUS[\"+\"] INT VAR ) | '-' INT VAR -> ^( MINUS[\"-\"] INT VAR ) | '+' VAR -> ^( PLUS[\"+\"] INT[\"1\"] VAR ) | '-' VAR -> ^( MINUS[\"-\"] INT[\"1\"] VAR ) )
            var alt7=4;
            var LA7_0 = this.input.LA(1);

            if ( (LA7_0==26) ) {
                var LA7_1 = this.input.LA(2);

                if ( (LA7_1==INT) ) {
                    alt7=1;
                }
                else if ( (LA7_1==VAR) ) {
                    alt7=3;
                }
                else {
                    var nvae =
                        new org.antlr.runtime.NoViableAltException("", 7, 1, this.input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==27) ) {
                var LA7_2 = this.input.LA(2);

                if ( (LA7_2==INT) ) {
                    alt7=2;
                }
                else if ( (LA7_2==VAR) ) {
                    alt7=4;
                }
                else {
                    var nvae =
                        new org.antlr.runtime.NoViableAltException("", 7, 2, this.input);

                    throw nvae;
                }
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 7, 0, this.input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:52:5: '+' INT VAR
                    char_literal35=this.match(this.input,26,PresburgerParser.FOLLOW_26_in_sgnlinmon426);  
                    stream_26.add(char_literal35);

                    INT36=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_sgnlinmon428);  
                    stream_INT.add(INT36);

                    VAR37=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_sgnlinmon430);  
                    stream_VAR.add(VAR37);



                    // AST REWRITE
                    // elements: VAR, INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 52:17: -> ^( PLUS[\"+\"] INT VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:52:20: ^( PLUS[\"+\"] INT VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(PLUS, "+"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:5: '-' INT VAR
                    char_literal38=this.match(this.input,27,PresburgerParser.FOLLOW_27_in_sgnlinmon448);  
                    stream_27.add(char_literal38);

                    INT39=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_sgnlinmon450);  
                    stream_INT.add(INT39);

                    VAR40=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_sgnlinmon452);  
                    stream_VAR.add(VAR40);



                    // AST REWRITE
                    // elements: INT, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 53:17: -> ^( MINUS[\"-\"] INT VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:53:20: ^( MINUS[\"-\"] INT VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(MINUS, "-"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:54:5: '+' VAR
                    char_literal41=this.match(this.input,26,PresburgerParser.FOLLOW_26_in_sgnlinmon469);  
                    stream_26.add(char_literal41);

                    VAR42=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_sgnlinmon471);  
                    stream_VAR.add(VAR42);



                    // AST REWRITE
                    // elements: VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 54:17: -> ^( PLUS[\"+\"] INT[\"1\"] VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:54:20: ^( PLUS[\"+\"] INT[\"1\"] VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(PLUS, "+"), root_1);

                        this.adaptor.addChild(root_1, this.adaptor.create(INT, "1"));
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:55:5: '-' VAR
                    char_literal43=this.match(this.input,27,PresburgerParser.FOLLOW_27_in_sgnlinmon493);  
                    stream_27.add(char_literal43);

                    VAR44=this.match(this.input,VAR,PresburgerParser.FOLLOW_VAR_in_sgnlinmon495);  
                    stream_VAR.add(VAR44);



                    // AST REWRITE
                    // elements: VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 55:17: -> ^( MINUS[\"-\"] INT[\"1\"] VAR )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:55:20: ^( MINUS[\"-\"] INT[\"1\"] VAR )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(MINUS, "-"), root_1);

                        this.adaptor.addChild(root_1, this.adaptor.create(INT, "1"));
                        this.adaptor.addChild(root_1, stream_VAR.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    cons_return: (function() {
        PresburgerParser.cons_return = function(){};
        org.antlr.lang.extend(PresburgerParser.cons_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:58:1: cons : ( ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) );
    // $ANTLR start "cons"
    cons: function() {
        var retval = new PresburgerParser.cons_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal45 = null;
        var INT46 = null;
        var char_literal47 = null;
        var INT48 = null;

        var char_literal45_tree=null;
        var INT46_tree=null;
        var char_literal47_tree=null;
        var INT48_tree=null;
        var stream_INT=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token INT");
        var stream_26=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 26");
        var stream_27=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 27");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:3: ( ( '+' )? INT -> ^( PLUS[\"+\"] INT ) | '-' INT -> ^( MINUS[\"-\"] INT ) )
            var alt9=2;
            var LA9_0 = this.input.LA(1);

            if ( (LA9_0==INT||LA9_0==26) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 9, 0, this.input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:5: ( '+' )? INT
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:5: ( '+' )?
                    var alt8=2;
                    var LA8_0 = this.input.LA(1);

                    if ( (LA8_0==26) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:5: '+'
                            char_literal45=this.match(this.input,26,PresburgerParser.FOLLOW_26_in_cons526);  
                            stream_26.add(char_literal45);



                            break;

                    }

                    INT46=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_cons529);  
                    stream_INT.add(INT46);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 59:14: -> ^( PLUS[\"+\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:59:17: ^( PLUS[\"+\"] INT )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(PLUS, "+"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:5: '-' INT
                    char_literal47=this.match(this.input,27,PresburgerParser.FOLLOW_27_in_cons546);  
                    stream_27.add(char_literal47);

                    INT48=this.match(this.input,INT,PresburgerParser.FOLLOW_INT_in_cons549);  
                    stream_INT.add(INT48);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 60:14: -> ^( MINUS[\"-\"] INT )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:60:17: ^( MINUS[\"-\"] INT )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(MINUS, "-"), root_1);

                        this.adaptor.addChild(root_1, stream_INT.nextNode());

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    quan_return: (function() {
        PresburgerParser.quan_return = function(){};
        org.antlr.lang.extend(PresburgerParser.quan_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:1: quan : ( 'A' -> ^( ALL[\"forall\"] ) | 'E' -> ^( EX[\"exists\"] ) );
    // $ANTLR start "quan"
    quan: function() {
        var retval = new PresburgerParser.quan_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal49 = null;
        var char_literal50 = null;

        var char_literal49_tree=null;
        var char_literal50_tree=null;
        var stream_28=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 28");
        var stream_29=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 29");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:6: ( 'A' -> ^( ALL[\"forall\"] ) | 'E' -> ^( EX[\"exists\"] ) )
            var alt10=2;
            var LA10_0 = this.input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            else if ( (LA10_0==29) ) {
                alt10=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 10, 0, this.input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:8: 'A'
                    char_literal49=this.match(this.input,28,PresburgerParser.FOLLOW_28_in_quan572);  
                    stream_28.add(char_literal49);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 63:12: -> ^( ALL[\"forall\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:63:15: ^( ALL[\"forall\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(ALL, "forall"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:64:8: 'E'
                    char_literal50=this.match(this.input,29,PresburgerParser.FOLLOW_29_in_quan588);  
                    stream_29.add(char_literal50);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 64:12: -> ^( EX[\"exists\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:64:15: ^( EX[\"exists\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(EX, "exists"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    con_return: (function() {
        PresburgerParser.con_return = function(){};
        org.antlr.lang.extend(PresburgerParser.con_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:67:1: con : ( '&&' -> ^( AND[\"and\"] ) | '||' -> ^( OR[\"or\"] ) | '->' -> ^( IMP[\"implies\"] ) );
    // $ANTLR start "con"
    con: function() {
        var retval = new PresburgerParser.con_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal51 = null;
        var string_literal52 = null;
        var string_literal53 = null;

        var string_literal51_tree=null;
        var string_literal52_tree=null;
        var string_literal53_tree=null;
        var stream_30=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 30");
        var stream_31=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 31");
        var stream_23=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 23");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:67:5: ( '&&' -> ^( AND[\"and\"] ) | '||' -> ^( OR[\"or\"] ) | '->' -> ^( IMP[\"implies\"] ) )
            var alt11=3;
            switch ( this.input.LA(1) ) {
            case 23:
                alt11=1;
                break;
            case 30:
                alt11=2;
                break;
            case 31:
                alt11=3;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 11, 0, this.input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:67:7: '&&'
                    string_literal51=this.match(this.input,23,PresburgerParser.FOLLOW_23_in_con609);  
                    stream_23.add(string_literal51);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 67:13: -> ^( AND[\"and\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:67:16: ^( AND[\"and\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(AND, "and"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:68:7: '||'
                    string_literal52=this.match(this.input,30,PresburgerParser.FOLLOW_30_in_con625);  
                    stream_30.add(string_literal52);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 68:13: -> ^( OR[\"or\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:68:16: ^( OR[\"or\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(OR, "or"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:69:7: '->'
                    string_literal53=this.match(this.input,31,PresburgerParser.FOLLOW_31_in_con641);  
                    stream_31.add(string_literal53);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 69:13: -> ^( IMP[\"implies\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:69:16: ^( IMP[\"implies\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(IMP, "implies"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    comp_return: (function() {
        PresburgerParser.comp_return = function(){};
        org.antlr.lang.extend(PresburgerParser.comp_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:1: comp : ( '==' -> ^( EQ[\"eq\"] ) | '!=' -> ^( NEQ[\"neq\"] ) | '>=' -> ^( GEQ[\"geq\"] ) | '<=' -> ^( LEQ[\"leq\"] ) | '>' -> ^( GT[\"gt\"] ) | '<' -> ^( LT[\"lt\"] ) );
    // $ANTLR start "comp"
    comp: function() {
        var retval = new PresburgerParser.comp_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal54 = null;
        var string_literal55 = null;
        var string_literal56 = null;
        var string_literal57 = null;
        var char_literal58 = null;
        var char_literal59 = null;

        var string_literal54_tree=null;
        var string_literal55_tree=null;
        var string_literal56_tree=null;
        var string_literal57_tree=null;
        var char_literal58_tree=null;
        var char_literal59_tree=null;
        var stream_32=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 32");
        var stream_35=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 35");
        var stream_36=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 36");
        var stream_33=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 33");
        var stream_34=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 34");
        var stream_25=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token 25");

        try {
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:6: ( '==' -> ^( EQ[\"eq\"] ) | '!=' -> ^( NEQ[\"neq\"] ) | '>=' -> ^( GEQ[\"geq\"] ) | '<=' -> ^( LEQ[\"leq\"] ) | '>' -> ^( GT[\"gt\"] ) | '<' -> ^( LT[\"lt\"] ) )
            var alt12=6;
            switch ( this.input.LA(1) ) {
            case 25:
                alt12=1;
                break;
            case 32:
                alt12=2;
                break;
            case 33:
                alt12=3;
                break;
            case 34:
                alt12=4;
                break;
            case 35:
                alt12=5;
                break;
            case 36:
                alt12=6;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 12, 0, this.input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:8: '=='
                    string_literal54=this.match(this.input,25,PresburgerParser.FOLLOW_25_in_comp662);  
                    stream_25.add(string_literal54);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 72:13: -> ^( EQ[\"eq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:72:16: ^( EQ[\"eq\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(EQ, "eq"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 2 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:73:8: '!='
                    string_literal55=this.match(this.input,32,PresburgerParser.FOLLOW_32_in_comp678);  
                    stream_32.add(string_literal55);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 73:13: -> ^( NEQ[\"neq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:73:16: ^( NEQ[\"neq\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(NEQ, "neq"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 3 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:8: '>='
                    string_literal56=this.match(this.input,33,PresburgerParser.FOLLOW_33_in_comp694);  
                    stream_33.add(string_literal56);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 74:13: -> ^( GEQ[\"geq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:74:16: ^( GEQ[\"geq\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(GEQ, "geq"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 4 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:8: '<='
                    string_literal57=this.match(this.input,34,PresburgerParser.FOLLOW_34_in_comp710);  
                    stream_34.add(string_literal57);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 75:13: -> ^( LEQ[\"leq\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:75:16: ^( LEQ[\"leq\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(LEQ, "leq"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 5 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:76:8: '>'
                    char_literal58=this.match(this.input,35,PresburgerParser.FOLLOW_35_in_comp726);  
                    stream_35.add(char_literal58);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 76:13: -> ^( GT[\"gt\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:76:16: ^( GT[\"gt\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(GT, "gt"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;
                case 6 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:77:8: '<'
                    char_literal59=this.match(this.input,36,PresburgerParser.FOLLOW_36_in_comp743);  
                    stream_36.add(char_literal59);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    var stream_retval=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = this.adaptor.nil();
                    // 77:13: -> ^( LT[\"lt\"] )
                    {
                        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:77:16: ^( LT[\"lt\"] )
                        {
                        var root_1 = this.adaptor.nil();
                        root_1 = this.adaptor.becomeRoot(this.adaptor.create(LT, "lt"), root_1);

                        this.adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    }

    // Delegated rules




}, true); // important to pass true to overwrite default implementations

org.antlr.lang.augmentObject(PresburgerParser, {
    DFA2_eotS:
        "\u003c\uffff",
    DFA2_eofS:
        "\u003c\uffff",
    DFA2_minS:
        "\u0001\u0012\u0002\uffff\u0001\u0012\u0001\uffff\u0003\u0012\u0001"+
    "\u0019\u0001\uffff\u0001\u0019\u0001\u0012\u0001\u0019\u0002\u0012\u0006"+
    "\u0013\u0001\u0019\u0001\u0012\u0001\u0019\u0001\u0012\u0001\u0019\u0001"+
    "\u0013\u0001\u0017\u0001\u0013\u0002\u0019\u0001\u0012\u0001\u0017\u0003"+
    "\u0012\u0002\u0019\u0001\u0012\u0001\u0019\u0002\u0012\u0006\u0013\u0001"+
    "\u0019\u0001\u0012\u0001\u0019\u0001\u0012\u0001\u0019\u0001\u0013\u0001"+
    "\u0017\u0001\u0013\u0002\u0019\u0001\uffff\u0001\u0017",
    DFA2_maxS:
        "\u0001\u001d\u0002\uffff\u0001\u001d\u0001\uffff\u0001\u0013\u0001"+
    "\u0012\u0001\u0013\u0001\u0024\u0001\uffff\u0001\u0024\u0001\u0012\u0001"+
    "\u0024\u0002\u0013\u0006\u001b\u0001\u0024\u0001\u0012\u0001\u0024\u0001"+
    "\u0012\u0001\u0024\u0001\u0013\u0001\u001f\u0001\u0013\u0002\u0024\u0001"+
    "\u001d\u0001\u001f\u0001\u0013\u0001\u0012\u0001\u0013\u0002\u0024\u0001"+
    "\u0012\u0001\u0024\u0002\u0013\u0006\u001b\u0001\u0024\u0001\u0012\u0001"+
    "\u0024\u0001\u0012\u0001\u0024\u0001\u0013\u0001\u0018\u0001\u0013\u0002"+
    "\u0024\u0001\uffff\u0001\u0018",
    DFA2_acceptS:
        "\u0001\uffff\u0001\u0001\u0001\u0002\u0001\uffff\u0001\u0005\u0004"+
    "\uffff\u0001\u0004\u0030\uffff\u0001\u0003\u0001\uffff",
    DFA2_specialS:
        "\u003c\uffff}>",
    DFA2_transitionS: [
            "\u0002\u0001\u0001\uffff\u0001\u0002\u0001\u0003\u0003\uffff"+
            "\u0002\u0001\u0002\u0004",
            "",
            "",
            "\u0001\u0008\u0001\u0006\u0001\uffff\u0002\u0009\u0003\uffff"+
            "\u0001\u0005\u0001\u0007\u0002\u0009",
            "",
            "\u0001\u0008\u0001\u0006",
            "\u0001\u000a",
            "\u0001\u000c\u0001\u000b",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u0015",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u0017\u0001\u0016",
            "\u0001\u0019\u0001\u0018",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u001b\u0006\uffff\u0001\u001a\u0001\u001c",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u001d",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u001e",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u001b",
            "\u0001\u001f\u0006\uffff\u0002\u0009",
            "\u0001\u0020",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u000f\u0001\u000d\u0001\u000e\u0004\uffff\u0001\u0010"+
            "\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014",
            "\u0001\u0024\u0001\u0022\u0001\uffff\u0002\u0009\u0003\uffff"+
            "\u0001\u0021\u0001\u0023\u0002\u0009",
            "\u0001\u001f\u0006\uffff\u0002\u0009",
            "\u0001\u0024\u0001\u0022",
            "\u0001\u0025",
            "\u0001\u0027\u0001\u0026",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u0030",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u0032\u0001\u0031",
            "\u0001\u0034\u0001\u0033",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u0036\u0006\uffff\u0001\u0035\u0001\u0037",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u0038",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u0039",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u0036",
            "\u0002\u003a",
            "\u0001\u003b",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "\u0001\u002a\u0001\u0028\u0001\u0029\u0004\uffff\u0001\u002b"+
            "\u0001\u002c\u0001\u002d\u0001\u002e\u0001\u002f",
            "",
            "\u0002\u003a"
    ]
});

org.antlr.lang.augmentObject(PresburgerParser, {
    DFA2_eot:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerParser.DFA2_eotS),
    DFA2_eof:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerParser.DFA2_eofS),
    DFA2_min:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(PresburgerParser.DFA2_minS),
    DFA2_max:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(PresburgerParser.DFA2_maxS),
    DFA2_accept:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerParser.DFA2_acceptS),
    DFA2_special:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerParser.DFA2_specialS),
    DFA2_transition: (function() {
        var a = [],
            i,
            numStates = PresburgerParser.DFA2_transitionS.length;
        for (i=0; i<numStates; i++) {
            a.push(org.antlr.runtime.DFA.unpackEncodedString(PresburgerParser.DFA2_transitionS[i]));
        }
        return a;
    })()
});

PresburgerParser.DFA2 = function(recognizer) {
    this.recognizer = recognizer;
    this.decisionNumber = 2;
    this.eot = PresburgerParser.DFA2_eot;
    this.eof = PresburgerParser.DFA2_eof;
    this.min = PresburgerParser.DFA2_min;
    this.max = PresburgerParser.DFA2_max;
    this.accept = PresburgerParser.DFA2_accept;
    this.special = PresburgerParser.DFA2_special;
    this.transition = PresburgerParser.DFA2_transition;
};

org.antlr.lang.extend(PresburgerParser.DFA2, org.antlr.runtime.DFA, {
    getDescription: function() {
        return "23:1: formula : ( linearpred | '!' formula -> ^( NEG[\"not\"] formula ) | '(' linearpred ( '&&' linearpred )+ ')' -> ^( AND[\"and\"] linearpred ( linearpred )+ ) | '(' formula con formula ')' -> ^( con formula formula ) | quan VAR formula -> ^( quan VAR formula ) );";
    },
    dummy: null
});
 

// public class variables
org.antlr.lang.augmentObject(PresburgerParser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "NEG", "AND", "OR", "IMP", "ALL", "EX", "EQ", "NEQ", "GEQ", "LEQ", "GT", "LT", "VAR", "INT", "WS", "'!'", "'('", "'&&'", "')'", "'=='", "'+'", "'-'", "'A'", "'E'", "'||'", "'->'", "'!='", "'>='", "'<='", "'>'", "'<'"],
    FOLLOW_linearpred_in_formula105: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_formula111: new org.antlr.runtime.BitSet([0x3C6C0000, 0x00000000]),
    FOLLOW_formula_in_formula113: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_22_in_formula144: new org.antlr.runtime.BitSet([0x0C0C0000, 0x00000000]),
    FOLLOW_linearpred_in_formula146: new org.antlr.runtime.BitSet([0x00800000, 0x00000000]),
    FOLLOW_23_in_formula149: new org.antlr.runtime.BitSet([0x0C0C0000, 0x00000000]),
    FOLLOW_linearpred_in_formula151: new org.antlr.runtime.BitSet([0x01800000, 0x00000000]),
    FOLLOW_24_in_formula155: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_22_in_formula175: new org.antlr.runtime.BitSet([0x3C6C0000, 0x00000000]),
    FOLLOW_formula_in_formula177: new org.antlr.runtime.BitSet([0xC0800000, 0x00000000]),
    FOLLOW_con_in_formula179: new org.antlr.runtime.BitSet([0x3C6C0000, 0x00000000]),
    FOLLOW_formula_in_formula181: new org.antlr.runtime.BitSet([0x01000000, 0x00000000]),
    FOLLOW_24_in_formula183: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_quan_in_formula199: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_formula201: new org.antlr.runtime.BitSet([0x3C6C0000, 0x00000000]),
    FOLLOW_formula_in_formula203: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_linearterm_in_linearpredRest241: new org.antlr.runtime.BitSet([0x02000000, 0x00000000]),
    FOLLOW_25_in_linearpredRest243: new org.antlr.runtime.BitSet([0x0C080000, 0x00000000]),
    FOLLOW_cons_in_linearpredRest245: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_linearterm_in_linearpred272: new org.antlr.runtime.BitSet([0x02000000, 0x0000001F]),
    FOLLOW_comp_in_linearpred274: new org.antlr.runtime.BitSet([0x0C080000, 0x00000000]),
    FOLLOW_cons_in_linearpred276: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_linmon_in_linearterm302: new org.antlr.runtime.BitSet([0x0C000002, 0x00000000]),
    FOLLOW_sgnlinmon_in_linearterm305: new org.antlr.runtime.BitSet([0x0C000002, 0x00000000]),
    FOLLOW_26_in_linmon322: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_linmon325: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_linmon327: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_27_in_linmon345: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_linmon348: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_linmon350: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_26_in_linmon367: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_linmon370: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_27_in_linmon392: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_linmon395: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_26_in_sgnlinmon426: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_sgnlinmon428: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_sgnlinmon430: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_27_in_sgnlinmon448: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_sgnlinmon450: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_sgnlinmon452: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_26_in_sgnlinmon469: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_sgnlinmon471: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_27_in_sgnlinmon493: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_VAR_in_sgnlinmon495: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_26_in_cons526: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_cons529: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_27_in_cons546: new org.antlr.runtime.BitSet([0x00080000, 0x00000000]),
    FOLLOW_INT_in_cons549: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_28_in_quan572: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_29_in_quan588: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_23_in_con609: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_30_in_con625: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_31_in_con641: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_25_in_comp662: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_32_in_comp678: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_33_in_comp694: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_34_in_comp710: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_35_in_comp726: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_36_in_comp743: new org.antlr.runtime.BitSet([0x00000002, 0x00000000])
});

})();