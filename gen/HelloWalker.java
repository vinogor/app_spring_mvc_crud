public class HelloWalker extends HelloBaseListener {

    @Override
    public void enterR(HelloParser.RContext ctx ) {
        System.out.println( "Entering R : " + ctx.ID().getText() );
    }

    @Override
    public void exitR(HelloParser.RContext ctx ) {
        System.out.println( "Exiting R" );
    }
}