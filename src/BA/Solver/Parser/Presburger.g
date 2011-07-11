grammar Presburger;

options { 
output=AST;
backtrack=true;
memoize=true;
}

tokens {
  PLUS;
  MINUS;
  NEG;
  AND;
  OR;
  IMP;
  BIIMP;
  ALL;
  EX;
  EQ;
  NEQ;
  GEQ;
  LEQ;
  GT;
  LT;
  L;
  R;
  PRED;
  FORAND;
  FOROR;
  CONSTNUM;
  MACRO;
}



formula
   :   linearpred 
   | '!' expr  -> ^(NEG["not"] expr) 
   | '&&' ('[' VAR '=' num '.' '.' num ']')+ expr -> ^(FORAND (VAR num num)+ expr) 
   | '||' ('[' VAR '=' num '.' '.' num ']')+ expr -> ^(FOROR (VAR num num)+ expr) 
   | QUANT expr           -> ^( QUANT expr) 
   | MACRO linearterm (',' linearterm)* ')' -> ^(MACRO (PRED linearterm)+)
   ;

expr
    : (s=pre -> pre)(('&&' expr)+ -> ^(AND["and"] $s expr+) | ('||' expr)+ -> ^(OR["and"] $s expr+) | ('->' expr) -> ^(IMP["imp"] $s expr) | ('<->' expr) -> ^(BIIMP["biimp"] $s expr))?
    ;
        
pre 
    : '('expr')'->^(expr)
    | formula -> ^(formula);
       
f : expr EOF -> ^(expr);
	
linearpred 
  : linearterm (comp linearterm)+ -> ^(PRED linearterm (comp linearterm)+)
  ;

linearterm 
  : linmon (sgnlinmon)*
  ;

con : '&&'  -> ^(AND["and"])
    | '||'  -> ^(OR["or"])
    | '->'  -> ^(IMP["implies"])
    | '<->'  -> ^(BIIMP["implies"])
    ;

linmon 	
  : '+'? INT VAR VAR? -> ^(PLUS["+"]  INT VAR VAR?)
  | '-'  INT VAR VAR?-> ^(MINUS["-"] INT VAR VAR?)
  | '+'? INT  -> ^(PLUS["+"]  INT )
  | '-'  INT  -> ^(MINUS["-"] INT )
  | '+'? VAR VAR?    -> ^(PLUS["+"] INT["1"] VAR VAR?)
  | '-'  VAR VAR?    -> ^(MINUS["-"] INT["1"] VAR VAR?)
  ;
	
sgnlinmon 
  : '+' INT VAR VAR? -> ^(PLUS["+"]  INT VAR VAR?)
  | '-'  INT VAR VAR?-> ^(MINUS["-"] INT VAR VAR?)
  | '+' INT  -> ^(PLUS["+"]  INT )
  | '-'  INT  -> ^(MINUS["-"] INT )
  | '+' VAR VAR?    -> ^(PLUS["+"] INT["1"] VAR VAR?)
  | '-'  VAR VAR?    -> ^(MINUS["-"] INT["1"] VAR VAR?)
  ;

cons 	
  : '+'? INT -> ^(PLUS["+"]  INT )
  | '-'  INT -> ^(MINUS["-"] INT )
  ;
  
comp : '==' -> ^(EQ["eq"])
     | '!=' -> ^(NEQ["neq"])
     | '>=' -> ^(GEQ["geq"])
     | '<=' -> ^(LEQ["leq"])
     | '>'  -> ^(GT["gt"])
     | '<'  -> ^(LT["lt"])
     ;
     
num : VAR | INT;
     
QUANT 
     : 'A'VAR+':'
     | 'E'VAR+':'
     ;
     
MACRO  :  ('A'..'Z')('a'..'z')*'(';

VAR  :  ('a'..'z')('[' (('a'..'z')('+' INT)? | INT) ']')*;	

INT : ('0'..'9')+;

WS : (' '|'\n'|'\t'|'\r')+ { skip(); };