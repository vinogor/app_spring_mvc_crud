grammar Example2;

options {
	language=Java;
	output=AST;
}

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {-> skip}
    |   '/*' (.)* '*/' {-> skip}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {-> skip}
    ;

fragment
LETTER
	:	('a'..'z'|'A'..'Z');

fragment
DIGIT
	:	'0'..'9';

IDENTIFIER
	:	(LETTER|'_') (LETTER | DIGIT |'_')*;

NUMBER
	:	DIGIT+;

DELIMETER
	:	';';

STRING
	:	'"' ( . )* '"';

value
	:	IDENTIFIER | STRING | NUMBER;

statement:	IDENTIFIER '=' value;

expression
	:	 statement? DELIMETER ;

code:	expression+;