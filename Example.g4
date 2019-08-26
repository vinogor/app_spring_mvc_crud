

grammar Example;

result :
        checkDefVars
        text
        ;

checkDefVars : (DEFINE Space defName EndOfLine)* ;

defName : Identifier;

text : TEXT;

TEXT    :
        ( '#if' Space ([A-Z_])+ EndOfLine
        | '#else' Space ([A-Z_])+ EndOfLine
        | '#elif' Space ([A-Z_])+ EndOfLine
        | '#endif' Space ([A-Z_])+ EndOfLine
        )
        ;

Identifier      : ([A-Z_])+ ;
Space           : ' ';
EndOfLine       : '\n' | EOF;

DEFINE : '#define';

LINE_COMMENT:   '// ' (.)*? ('\n' | EOF) -> skip;