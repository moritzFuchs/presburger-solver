// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g 2011-05-20 21:40:20

var PresburgerLexer = function(input, state) {
// alternate constructor @todo
// public PresburgerLexer(CharStream input)
// public PresburgerLexer(CharStream input, RecognizerSharedState state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    this.dfa4 = new PresburgerLexer.DFA4(this);
    PresburgerLexer.superclass.constructor.call(this, input, state);


};

org.antlr.lang.augmentObject(PresburgerLexer, {
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
    T__33: 33,
    NEQ: 13,
    WS: 20,
    T__34: 34,
    T__35: 35,
    T__36: 36,
    EX: 11,
    ALL: 10,
    NEG: 6,
    OR: 8,
    IMP: 9,
    GT: 16,
    PLUS: 4,
    VAR: 18,
    GEQ: 14,
    EQ: 12,
    LEQ: 15
});

(function(){
var HIDDEN = org.antlr.runtime.Token.HIDDEN_CHANNEL,
    EOF = org.antlr.runtime.Token.EOF;
org.antlr.lang.extend(PresburgerLexer, org.antlr.runtime.Lexer, {
    LT : 17,
    T__29 : 29,
    T__28 : 28,
    T__27 : 27,
    T__26 : 26,
    T__25 : 25,
    T__24 : 24,
    T__23 : 23,
    T__22 : 22,
    T__21 : 21,
    INT : 19,
    MINUS : 5,
    AND : 7,
    EOF : -1,
    T__30 : 30,
    T__31 : 31,
    T__32 : 32,
    T__33 : 33,
    NEQ : 13,
    WS : 20,
    T__34 : 34,
    T__35 : 35,
    T__36 : 36,
    EX : 11,
    ALL : 10,
    NEG : 6,
    OR : 8,
    IMP : 9,
    GT : 16,
    PLUS : 4,
    VAR : 18,
    GEQ : 14,
    EQ : 12,
    LEQ : 15,
    getGrammarFileName: function() { return "/Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g"; }
});
org.antlr.lang.augmentObject(PresburgerLexer.prototype, {
    // $ANTLR start T__21
    mT__21: function()  {
        try {
            var _type = this.T__21;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:7:7: ( '!' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:7:9: '!'
            this.match('!'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__21",

    // $ANTLR start T__22
    mT__22: function()  {
        try {
            var _type = this.T__22;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:8:7: ( '(' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:8:9: '('
            this.match('('); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__22",

    // $ANTLR start T__23
    mT__23: function()  {
        try {
            var _type = this.T__23;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:9:7: ( '&&' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:9:9: '&&'
            this.match("&&"); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__23",

    // $ANTLR start T__24
    mT__24: function()  {
        try {
            var _type = this.T__24;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:10:7: ( ')' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:10:9: ')'
            this.match(')'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__24",

    // $ANTLR start T__25
    mT__25: function()  {
        try {
            var _type = this.T__25;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:11:7: ( '==' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:11:9: '=='
            this.match("=="); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__25",

    // $ANTLR start T__26
    mT__26: function()  {
        try {
            var _type = this.T__26;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:12:7: ( '+' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:12:9: '+'
            this.match('+'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__26",

    // $ANTLR start T__27
    mT__27: function()  {
        try {
            var _type = this.T__27;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:13:7: ( '-' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:13:9: '-'
            this.match('-'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__27",

    // $ANTLR start T__28
    mT__28: function()  {
        try {
            var _type = this.T__28;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:14:7: ( 'A' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:14:9: 'A'
            this.match('A'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__28",

    // $ANTLR start T__29
    mT__29: function()  {
        try {
            var _type = this.T__29;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:15:7: ( 'E' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:15:9: 'E'
            this.match('E'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__29",

    // $ANTLR start T__30
    mT__30: function()  {
        try {
            var _type = this.T__30;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:16:7: ( '||' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:16:9: '||'
            this.match("||"); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__30",

    // $ANTLR start T__31
    mT__31: function()  {
        try {
            var _type = this.T__31;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:17:7: ( '->' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:17:9: '->'
            this.match("->"); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__31",

    // $ANTLR start T__32
    mT__32: function()  {
        try {
            var _type = this.T__32;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:18:7: ( '!=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:18:9: '!='
            this.match("!="); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__32",

    // $ANTLR start T__33
    mT__33: function()  {
        try {
            var _type = this.T__33;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:19:7: ( '>=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:19:9: '>='
            this.match(">="); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__33",

    // $ANTLR start T__34
    mT__34: function()  {
        try {
            var _type = this.T__34;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:20:7: ( '<=' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:20:9: '<='
            this.match("<="); 




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__34",

    // $ANTLR start T__35
    mT__35: function()  {
        try {
            var _type = this.T__35;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:21:7: ( '>' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:21:9: '>'
            this.match('>'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__35",

    // $ANTLR start T__36
    mT__36: function()  {
        try {
            var _type = this.T__36;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:22:7: ( '<' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:22:9: '<'
            this.match('<'); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__36",

    // $ANTLR start VAR
    mVAR: function()  {
        try {
            var _type = this.VAR;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:6: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:9: ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )*
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:9: ( 'a' .. 'z' )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:10: 'a' .. 'z'
            this.matchRange('a','z'); 



            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:80:19: ( 'a' .. 'z' | '0' .. '9' | '_' )*
            loop1:
            do {
                var alt1=2;
                var LA1_0 = this.input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:
                    if ( (this.input.LA(1)>='0' && this.input.LA(1)<='9')||this.input.LA(1)=='_'||(this.input.LA(1)>='a' && this.input.LA(1)<='z') ) {
                        this.input.consume();

                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        this.recover(mse);
                        throw mse;}



                    break;

                default :
                    break loop1;
                }
            } while (true);




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "VAR",

    // $ANTLR start INT
    mINT: function()  {
        try {
            var _type = this.INT;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:5: ( ( '0' .. '9' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:7: ( '0' .. '9' )+
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:7: ( '0' .. '9' )+
            var cnt2=0;
            loop2:
            do {
                var alt2=2;
                var LA2_0 = this.input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:82:8: '0' .. '9'
                    this.matchRange('0','9'); 


                    break;

                default :
                    if ( cnt2 >= 1 ) {
                        break loop2;
                    }
                        var eee = new org.antlr.runtime.EarlyExitException(2, this.input);
                        throw eee;
                }
                cnt2++;
            } while (true);




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "INT",

    // $ANTLR start WS
    mWS: function()  {
        try {
            var _type = this.WS;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:4: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:84:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            var cnt3=0;
            loop3:
            do {
                var alt3=2;
                var LA3_0 = this.input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
                case 1 :
                    // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:
                    if ( (this.input.LA(1)>='\t' && this.input.LA(1)<='\n')||this.input.LA(1)=='\r'||this.input.LA(1)==' ' ) {
                        this.input.consume();

                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        this.recover(mse);
                        throw mse;}



                    break;

                default :
                    if ( cnt3 >= 1 ) {
                        break loop3;
                    }
                        var eee = new org.antlr.runtime.EarlyExitException(3, this.input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             skip(); 



            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "WS",

    mTokens: function() {
        // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | VAR | INT | WS )
        var alt4=19;
        alt4 = this.dfa4.predict(this.input);
        switch (alt4) {
            case 1 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:10: T__21
                this.mT__21(); 


                break;
            case 2 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:16: T__22
                this.mT__22(); 


                break;
            case 3 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:22: T__23
                this.mT__23(); 


                break;
            case 4 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:28: T__24
                this.mT__24(); 


                break;
            case 5 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:34: T__25
                this.mT__25(); 


                break;
            case 6 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:40: T__26
                this.mT__26(); 


                break;
            case 7 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:46: T__27
                this.mT__27(); 


                break;
            case 8 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:52: T__28
                this.mT__28(); 


                break;
            case 9 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:58: T__29
                this.mT__29(); 


                break;
            case 10 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:64: T__30
                this.mT__30(); 


                break;
            case 11 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:70: T__31
                this.mT__31(); 


                break;
            case 12 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:76: T__32
                this.mT__32(); 


                break;
            case 13 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:82: T__33
                this.mT__33(); 


                break;
            case 14 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:88: T__34
                this.mT__34(); 


                break;
            case 15 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:94: T__35
                this.mT__35(); 


                break;
            case 16 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:100: T__36
                this.mT__36(); 


                break;
            case 17 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:106: VAR
                this.mVAR(); 


                break;
            case 18 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:110: INT
                this.mINT(); 


                break;
            case 19 :
                // /Users/moritzfuchs/Documents/Studium/6. Semester/Bachelorarbeit/workspace/Presburger Solver/src/BA/Solver/Parser/Presburger.g:1:114: WS
                this.mWS(); 


                break;

        }

    }

}, true); // important to pass true to overwrite default implementations

org.antlr.lang.augmentObject(PresburgerLexer, {
    DFA4_eotS:
        "\u0001\uffff\u0001\u0011\u0005\uffff\u0001\u0013\u0003\uffff\u0001"+
    "\u0015\u0001\u0017\u000b\uffff",
    DFA4_eofS:
        "\u0018\uffff",
    DFA4_minS:
        "\u0001\u0009\u0001\u003d\u0005\uffff\u0001\u003e\u0003\uffff\u0002"+
    "\u003d\u000b\uffff",
    DFA4_maxS:
        "\u0001\u007c\u0001\u003d\u0005\uffff\u0001\u003e\u0003\uffff\u0002"+
    "\u003d\u000b\uffff",
    DFA4_acceptS:
        "\u0002\uffff\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001"+
    "\u0006\u0001\uffff\u0001\u0008\u0001\u0009\u0001\u000a\u0002\uffff\u0001"+
    "\u0011\u0001\u0012\u0001\u0013\u0001\u000c\u0001\u0001\u0001\u000b\u0001"+
    "\u0007\u0001\u000d\u0001\u000f\u0001\u000e\u0001\u0010",
    DFA4_specialS:
        "\u0018\uffff}>",
    DFA4_transitionS: [
            "\u0002\u000f\u0002\uffff\u0001\u000f\u0012\uffff\u0001\u000f"+
            "\u0001\u0001\u0004\uffff\u0001\u0003\u0001\uffff\u0001\u0002"+
            "\u0001\u0004\u0001\uffff\u0001\u0006\u0001\uffff\u0001\u0007"+
            "\u0002\uffff\u000a\u000e\u0002\uffff\u0001\u000c\u0001\u0005"+
            "\u0001\u000b\u0002\uffff\u0001\u0008\u0003\uffff\u0001\u0009"+
            "\u001b\uffff\u001a\u000d\u0001\uffff\u0001\u000a",
            "\u0001\u0010",
            "",
            "",
            "",
            "",
            "",
            "\u0001\u0012",
            "",
            "",
            "",
            "\u0001\u0014",
            "\u0001\u0016",
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
            ""
    ]
});

org.antlr.lang.augmentObject(PresburgerLexer, {
    DFA4_eot:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerLexer.DFA4_eotS),
    DFA4_eof:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerLexer.DFA4_eofS),
    DFA4_min:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(PresburgerLexer.DFA4_minS),
    DFA4_max:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(PresburgerLexer.DFA4_maxS),
    DFA4_accept:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerLexer.DFA4_acceptS),
    DFA4_special:
        org.antlr.runtime.DFA.unpackEncodedString(PresburgerLexer.DFA4_specialS),
    DFA4_transition: (function() {
        var a = [],
            i,
            numStates = PresburgerLexer.DFA4_transitionS.length;
        for (i=0; i<numStates; i++) {
            a.push(org.antlr.runtime.DFA.unpackEncodedString(PresburgerLexer.DFA4_transitionS[i]));
        }
        return a;
    })()
});

PresburgerLexer.DFA4 = function(recognizer) {
    this.recognizer = recognizer;
    this.decisionNumber = 4;
    this.eot = PresburgerLexer.DFA4_eot;
    this.eof = PresburgerLexer.DFA4_eof;
    this.min = PresburgerLexer.DFA4_min;
    this.max = PresburgerLexer.DFA4_max;
    this.accept = PresburgerLexer.DFA4_accept;
    this.special = PresburgerLexer.DFA4_special;
    this.transition = PresburgerLexer.DFA4_transition;
};

org.antlr.lang.extend(PresburgerLexer.DFA4, org.antlr.runtime.DFA, {
    getDescription: function() {
        return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | VAR | INT | WS );";
    },
    dummy: null
});
 
})();