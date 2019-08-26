grammar Example3;

prog: stat+ ;

stat:
           define     // 1
        | expr        //    2
        |  EndOfLine //    3

     ;

expr:   operStart ' ' ('!')? Identifier EndOfLine
        cSharpOperators
        operEnd EndOfLine
 ;

cSharpOperators: line* ;

//line : ~'#' ( Any | Symbols | Digits )+? EndOfLine;
line : (Any)+ EndOfLine;

operStart    : '#if'

        ;

operEnd      : '#endif'
        ;


define:
        (DEFINE Space defName EndOfLine)+
;

defName : Identifier;

Digits           : '0'..'9';
Symbols          : '('|')'|'='|'"'|'.'|','|'|'|'>'|'<'|' '|';'|'*'|'+';
Any              : . ;

Text            : ([a-z_])+ ;
Identifier      : ([A-Z_])+ ;
Space           : ' ';
EndOfLine       : '\n' | EOF;

DEFINE : '#define';

//comment: LINE_COMMENT;

LINE_COMMENT:   '// ' (.)*? ('\n' | EOF) -> skip;
//LINE_COMMENT:   '// ' (.)*? EndOfLine ;