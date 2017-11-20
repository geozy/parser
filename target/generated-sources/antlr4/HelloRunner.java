
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class HelloRunner 
{
    public static void main( String[] args) throws Exception 
    {
    	// Sample String
    	//String in ="AS1 + aggregate( 23, complete, sum( AD:BD7, 234))";
    	//String in = "conround((INDEX(CVM:Q,2017Q1)*VALUE(CP:A,2017Q1)/100),3)";
    	//String in = "round(pcdif('INDEX-4DP',4,1),1)";
    	//String in = "round(index('I-FBW':CP/FBW:CP,2017),4)";
    	//String in = "W1";
    	//String in = "0";
    	//String in = "A1 + A2 * A3 - A4";
    	//String in = "f1(a) + f2(b) + f3(c) + f4(d) * f5(e) + f6(f) / 16" ;
    	//String in = "(f1(a) + f2(b) + f3(c) + f4(d) * f5(e) + f6(f)) / 16" ;
    	String in = "Round(lag(AF63-D6111-D6121-D6131+D6221-D61SC-D81-D82-K5,-1)/(1+DISC.RATE+REVAL.RATE),1)";
    	
        ANTLRInputStream input = new ANTLRInputStream( in);

        // Generate Token Stream
        CordSASLexer lexer = new CordSASLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // begin parsing at rule 'calculation'
        CordSASParser parser = new CordSASParser(tokens);
        ParseTree tree = parser.calculation(); 
        
        // print LISP-style tree
        System.out.println(tree.toStringTree(parser)); 
        
        System.out.println("\n\n" + in + "\n");
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener();
        
        // Output the Execution Plan
        walker.walk(listener, tree);
        
        // Output as JSON
        String jsonOut = listener.asJSON(); 
        System.out.println("\n\n" + jsonOut + "\n");
        
        // Prettify using GSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonOut);
        String prettyJsonString = gson.toJson(je);
        System.out.println("\n\n" + prettyJsonString + "\n");
        
        
        
              
    }
}