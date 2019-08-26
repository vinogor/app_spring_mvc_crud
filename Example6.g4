// Грамматика для файлов с набором определённых символов.
//
// Ввиду недостаточных знаний, пришлось добавить ряд особенностей,
// без введения которых совсем ничего не хотело работать:
//   в грамматике
//      - обработал пока только 2 директивы #if и #else
//   в коде для тестирования грамматики
//      - добавил в самый конец пустую строку

grammar Example6;

file:
        line+
    ;

line:  defVar Equals value EndOfLine ;

defVar         : LettersUpCase ;
value          : Boolean ;

Equals          : '=';
LettersUpCase   : [A-Z_]+ ;
Boolean         : 'true'|'false';
EndOfLine       : '\n';