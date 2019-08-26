// Грамматика для файлов с исходным кодом на языке C#.
//
// Ввиду недостаточности знаний и дефицита времени, пришлось добавить ряд особенностей,
//   в грамматике
//      - обработал пока только 2 директивы #if и #else
//   в коде для тестирования грамматики (он ниже закомментирован)
//      - для корректной работы надо добавлять в самый конец пустую строку

/*

#if FEATURE_MANAGED_ETW
// OK if we get this far without an exception, then we can at least write out error messages.
// Set m_provider, which allows this.
m_provider = provider;
#endif
#if !ES_BUILD_STANDALONE
// API available on OS >= Win 8 and patched Win 7.
// Disable only for FrameworkEventSource to avoid recursion inside exception handling.
var osVer = Environment.OSVersion.Version.Major * 10 + Environment.OSVersion.Version.Minor;
if (this.Name != "System.Diagnostics.Eventing.FrameworkEventSource" || osVer >= 62)
#endif

*/

grammar Example5;

file:
        block+
    ;

block :
        start
        body
        end
     ;

start : '#if ' inverse LettersUpCase '\n' ;
    inverse: '!'?;
    LettersUpCase         : [A-Z_]+ ;


body  :  ( comment
         | static
         )+
    ;

        comment    : '// ' AnySymbols '\n' ;  // почему-то выражение вида (.)*? не работает
        static     :  AnySymbols '\n'  ;      // почему-то через НЕ не работает NOT_COMMENT: ~('/');
        AnySymbols :  ([a-zA-Z0-9_ ,.;><=()"+|*] | ('!='))+  ; // костыльно

end :  '#endif' '\n' ;


LettersDownCase   : [a-z_]+ ;
EndOfLine         : ('\n'); // хотел это поставить вместо '\n', но пишет [mismatched input '\n' expecting EndOfLine]
                            // плюс в конце текста пришлось пустую строчку добавить