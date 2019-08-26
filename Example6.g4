// Грамматика для файлов с набором определённых символов.
// Пример для тестирвоания грамматики закомментирован ниже

/*

FEATURE_MANAGED_ETW=true
ES_BUILD_STANDALONE=false

*/

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