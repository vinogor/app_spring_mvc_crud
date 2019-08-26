grammar Example4;

prog:
//        stat
        oper
;


oper: OPERATOR+;


stat: LineStat+ ;

//OperStart       : '# ' [A-Z_]+  ;


//Line          : (~('#')) (.)*? EndOfLine;
//LineStat          :  ~('/' | '#') (.)*? EndOfLine;
LineStat          :  [a-zA-Z_]*? EndOfLine;
//Line          :  [a-zA-Z_]*? EndOfLine;


//LINE_COMMENT:   ('// ' (.)+? EndOfLine) -> skip;

EndOfLine       : '\n' | EOF;


OPERATOR:        '# ' [A-Z_]+ EndOfLine ;


// все строки начинающиеся с '//' - выкидываем
LineComment:
                ('//')
                ~[\r\n]*
                EndOfLine -> skip;

// всё что не распознали - выкидываем
//ERROR_RECONGNIGION:  .    -> skip;

