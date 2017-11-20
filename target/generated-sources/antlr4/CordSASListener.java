// Generated from CordSAS.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CordSASParser}.
 */
public interface CordSASListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CordSASParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterCalculation(CordSASParser.CalculationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CordSASParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitCalculation(CordSASParser.CalculationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiDiv}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiDiv(CordSASParser.MultiDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiDiv}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiDiv(CordSASParser.MultiDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CordSASParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CordSASParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leafCall}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLeafCall(CordSASParser.LeafCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leafCall}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLeafCall(CordSASParser.LeafCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(CordSASParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(CordSASParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(CordSASParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link CordSASParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(CordSASParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CordSASParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(CordSASParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CordSASParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(CordSASParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CordSASParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodArguments(CordSASParser.MethodArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CordSASParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodArguments(CordSASParser.MethodArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CordSASParser#leaf}.
	 * @param ctx the parse tree
	 */
	void enterLeaf(CordSASParser.LeafContext ctx);
	/**
	 * Exit a parse tree produced by {@link CordSASParser#leaf}.
	 * @param ctx the parse tree
	 */
	void exitLeaf(CordSASParser.LeafContext ctx);
	/**
	 * Enter a parse tree produced by {@link CordSASParser#dataref}.
	 * @param ctx the parse tree
	 */
	void enterDataref(CordSASParser.DatarefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CordSASParser#dataref}.
	 * @param ctx the parse tree
	 */
	void exitDataref(CordSASParser.DatarefContext ctx);
}