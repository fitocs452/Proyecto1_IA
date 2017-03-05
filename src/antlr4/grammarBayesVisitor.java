// Generated from /home/amorales/Universidad/InteligenciaArtificial/Proyecto1/PrimeraParte/src/antlr4/grammarBayes.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link grammarBayesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface grammarBayesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(@NotNull grammarBayesParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull grammarBayesParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull grammarBayesParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull grammarBayesParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(@NotNull grammarBayesParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull grammarBayesParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#operator2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator2(@NotNull grammarBayesParser.Operator2Context ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#probability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbability(@NotNull grammarBayesParser.ProbabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#cliBayes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCliBayes(@NotNull grammarBayesParser.CliBayesContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull grammarBayesParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarBayesParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull grammarBayesParser.OperatorContext ctx);
}