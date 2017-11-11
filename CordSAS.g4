/**
 * Define a grammar called CordSAS
 */
grammar CordSAS;

calculation :  expr ;

expr : method                   #methodCall                   
	 | expr ( '*' | '/' ) expr	#multiDiv
	 | expr ( '+' | '-' ) expr  #addSub
	 | leaf                     #leafCall 
	 | '(' expr ')'             #blockExpr
	 ;

// define a methods signature
method : ID '(' methodArguments ')' ;

// methodArguments to be a list of expressions separated by commas.
methodArguments : | expr (',' expr)* ;

// leaf represents terminal nodes in the parse tree
leaf : ID | NUM | PERIOD | dataref;

// defines a time series identifier with colon separators
dataref : (ID | QID) (':' (ID | QID) )+ ;

// define our lexer elements

// Time Period identifier
PERIOD : [0-9]+[QJFMASOND][1-4] | [0-9]+[JFMASOND][a-z]+  ;

// Any number
NUM : [-]?[0-9]+[.0-9]? ;

// Identifier
ID : [a-zA-Z][a-zA-Z0-9_.]* ;

// Quoted Identifier (allows '-' in identifier)
QID : ['][-a-zA-Z0-9_:.]+['] ;

// Ignore whitespace
WS	: [ \t\u000C\r\n]+ -> skip ;