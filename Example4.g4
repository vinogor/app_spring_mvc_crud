grammar Example4;

prog:
//        stat
        oper
        | LineComment
        | EndOfLine

;


oper: operatorLine+;

//
//stat: LineStat+ ;

//OperStart       : '# ' [A-Z_]+  ;


//Line          : (~('#')) (.)*? EndOfLine;
//LineStat          :  ~('/' | '#') (.)*? EndOfLine;
//LineStat          :  [a-zA-Z_]*? EndOfLine;
//Line          :  [a-zA-Z_]*? EndOfLine;


//LINE_COMMENT:   ('// ' (.)+? EndOfLine) -> skip;



operatorLine    :   OperatorLineStart
                    (Stat EndOfLine)*
                    OperatorLineEnd
                ;

OperatorLineStart    :   '# ' OperatorStart [ A-Z_]+ EndOfLine;
OperatorLineEnd      :      '# ' OperatorEnd [ A-Z_]+ EndOfLine;


OperatorStart   :   'if' ;
OperatorEnd     :   'endif';
Stat            :   (.)+?    ;


EndOfLine       : '\n' | EOF;

// все строки начинающиеся с '//' - выкидываем
LineComment:
                ('//')
                ~[\r\n]*
                EndOfLine -> skip;

// всё что не распознали - выкидываем
//ERROR_RECONGNIGION:  .    -> skip;

