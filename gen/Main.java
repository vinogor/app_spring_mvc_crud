import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main( String[] args)
    {
        HelloLexer lexer = new HelloLexer(CharStreams.fromString("hello world123"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new HelloWalker(), tree);

        System.out.println();

        CodePointCharStream codePointCharStream2 = CharStreams.fromString("12*(5-6)");
        ExpLexer lexer2 = new ExpLexer(codePointCharStream2);
        CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
        ExpParser parser2 = new ExpParser(tokens2);
        System.out.println("Result: " + parser2.eval().value);


    }
}