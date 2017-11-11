/*
 * Antlr Parser Listener is designed to work with the CordSAS.g4 grammer 
 * which is designed to consume SAS calculations and prepare an execution
 * plan for use by the SAS-R replacement project.
 * 
 * The Listener derived from the ANTLR generated CordSASBaseListener.
 * This is a prototype implementation that outputs the following
 * 
 *    - The calculation
 *    - Parser Tree
 *    - Ordered call list
 *    - Raw JSON
 *    - Pretty JSON
 * 
 * 
 * Date  : 11th November 2017
 * Author: George Zygmund.
 * 
 */

import java.util.*;

public class MyListener extends CordSASBaseListener{
	
	
	Stack< String > st = new Stack<String >();
	int v = 0;
	String JSONOutput;
	
	public String asJSON() {
		return JSONOutput;
	}
	
	private String getNextTempVar() {
		return "_v"+ Integer.toString(v++);
	}

	public void enterCalculation(CordSASParser.CalculationContext ctx) { 
		JSONOutput = "{ \"executionPlan\": [";
	}
	
	public void exitCalculation(CordSASParser.CalculationContext ctx) {
		
		// remove last ',' from execution elements		
		JSONOutput = JSONOutput.substring(0, JSONOutput.length() - 1);
		
		// Terminate the executionPlan array
		JSONOutput += "]}";
	}
	
	public void exitLeafCall(CordSASParser.LeafCallContext ctx){ 
		st.push(ctx.getText());
	}
	
	public void exitDataref(CordSASParser.DatarefContext ctx) {
		// TODO: remove any quote marks - not needed after this stage	
	}
	
	public void exitMultiDiv(CordSASParser.MultiDivContext ctx) {
		
		String op = "?";
		if(ctx.children.size() == 3) {
			op = ctx.getChild(1).getText();
		}
		
		String tv = getNextTempVar();
		
		// JSON construction
		String jsonStr = "{";
		
		// Console output
		String outstr = tv + " = ";
		if(op.equals("*")) {
			outstr += "multiply(";
			jsonStr += "\"call\":\"multiply\",";
		}else {
			outstr += "divide(";
			jsonStr += "\"call\":\"divide\",";
		}
		
		String p2 = st.pop();
		String p1 = st.pop();
		
		outstr +=  p1 + "," + p2 + ")";
		
		jsonStr += "\"params:\": [\"" + p1 + "\",\"" + p2 + "\"],";
		jsonStr += "\"out:\":\"" + tv + "\"},";
		JSONOutput+=jsonStr;
		
		st.push(tv);
		System.out.println(outstr);
	}

	
	public void exitAddSub(CordSASParser.AddSubContext ctx) { 
		String op = "?";
		if(ctx.children.size() == 3) {
			op = ctx.getChild(1).getText();
		}
		
		String tv = getNextTempVar();
		
		// JSON construction
		String jsonStr = "{";
		
		String outstr = tv + " = ";
		if(op.equals("+")) {
			outstr += "add(";
			jsonStr += "\"call\":\"add\",";
		}else {
			outstr += "subtract(";
			jsonStr += "\"call\":\"subtract\",";
		}
		
		String p2 = st.pop();
		String p1 = st.pop();
		
		outstr +=  p1 + "," + p2 + ")";
		
		jsonStr += "\"params:\": [\"" + p1 + "\",\"" + p2 + "\"],";
		jsonStr += "\"out:\":\"" + tv + "\"},";
		JSONOutput+=jsonStr;
		
		st.push(tv);
		System.out.println(outstr);
	}
	

	public void enterMethod(CordSASParser.MethodContext ctx) { 
		
		// We use the method name to backstop the parameter list
		st.push(ctx.ID().getText());
	}
	
	public void exitMethod(CordSASParser.MethodContext ctx) {
			
		//int paramCount = ctx.methodArguments().children.size() - 1;		
		String params = "";
		String mname=  ctx.ID().getText();
		
		// JSON construction
		String jsonStr = "{\"call\":\"" + ctx.ID().getText() + "\",\"params:\": [";
		
		
		// Fetch parameters
		String param = st.pop();
		String json_param = "";
		
		int pcount = 0;
		
		// Load parameters until we hit back-stop in stack
		while(!mname.equals(param)) {
			if(pcount++ != 0) {
				params =  param + "," + params;
				json_param = "\"" + param +  "\"," + json_param;
			}else {
				params =  param;	
				json_param = "\"" + param +  "\"";
			}
		  
		    param = st.pop();
		}
		
				
		// Get temporary variable for assignment
		String tv = getNextTempVar();
		
		jsonStr += json_param + "],";	
		jsonStr += "\"out:\":\"" + tv + "\"},";
		JSONOutput+=jsonStr;
		
		// We have popped off all the paramaters , now get method name
		String outstr = tv + " = " + ctx.ID().getText() + "(" + params + ")";
		
		st.push(tv);
		System.out.println(outstr);
	}
	
		
}
