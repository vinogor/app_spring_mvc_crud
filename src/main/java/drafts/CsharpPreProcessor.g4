grammar CsharpPreProcessor;


// входное правило:
// строка #define + 1 или более пробелов + имя переменной + 0 или более пробелов + конец файла


defineSentence :
//DEFINE Whitespace+ macroName Whitespace* (argList)? Whitespace* ( macroBody Whitespace*)? EOF
(DEFINE Whitespace+ macroName Whitespace*)* EOF
 ;

DEFINE : '#define';

Whitespace : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ /*-> skip */;

macroName : Identifier;

Identifier
                    //    : IdentifierNondigit ( IdentifierNondigit  | Digit )* ;
                        : ([a-zA-Z_])+ ;


//macroBody : .+ ;


//argList : LPAREN argListMember  ( Whitespace* COMMA Whitespace* argListMember )* Whitespace* RPAREN ;

//argListMember : Identifier;


//macroValue : Identifier | STRING;


STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;


fragment
IdentifierNondigit
    : Nondigit  | UniversalCharacterName;

fragment
UniversalCharacterName :
    '\\u' HexQuad
    | '\\U' HexQuad HexQuad ;

fragment
HexQuad :
     HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

fragment
HexadecimalDigit : [0-9a-fA-F] ;

fragment
Nondigit : [a-zA-Z_];

SEMICOLON: ';';
MISC : '?' | ':' | '<' | '>' | '\\' ;
PERCENT: '%' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURL : '{' ;
RCURL : '}' ;
LSQUARE : '[' ;
RSQUARE : ']' ;
DOT: '.';
COMMA: ',';
OPERATION: '*' | '/' | '+' | '-' | '=' | '|' | '&' | '~' | '!';

fragment Digit: [0-9];

