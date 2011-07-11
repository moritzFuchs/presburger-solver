grammar test;

tokens{
ALL;
EX;

}


test	: QUANT 
	| MACRO ')';


          
MACRO  :  ('A'..'Z')('a'..'z')*'(';

VAR  :  ('a'..'z')('[' (('a'..'z')('+' INT)? | INT) ']')*;	

INT : ('0'..'9')+;

WS : (' '|'\n'|'\t'|'\r')+ { skip(); };