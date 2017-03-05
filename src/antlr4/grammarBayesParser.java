// Generated from /home/amorales/Universidad/InteligenciaArtificial/Proyecto1/PrimeraParte/src/antlr4/grammarBayes.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammarBayesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, COMMAND=6, NEGATION=7, PROMISE=8, 
		NUM=9, EQUALS=10, WS=11, COMMENT=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'P'", "'('", "')'", "'|'", "','", "COMMAND", "'!'", "PROMISE", 
		"NUM", "'='", "WS", "COMMENT"
	};
	public static final int
		RULE_number = 0, RULE_program = 1, RULE_operator = 2, RULE_op = 3, RULE_operator2 = 4, 
		RULE_op2 = 5, RULE_probability = 6, RULE_condition = 7, RULE_negation = 8, 
		RULE_cliBayes = 9, RULE_expression = 10;
	public static final String[] ruleNames = {
		"number", "program", "operator", "op", "operator2", "op2", "probability", 
		"condition", "negation", "cliBayes", "expression"
	};

	@Override
	public String getGrammarFileName() { return "grammarBayes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammarBayesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(grammarBayesParser.NUM, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<ProbabilityContext> probability() {
			return getRuleContexts(ProbabilityContext.class);
		}
		public ProbabilityContext probability(int i) {
			return getRuleContext(ProbabilityContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); probability();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMAND );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode PROMISE() { return getToken(grammarBayesParser.PROMISE, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(29); negation();
				}
			}

			setState(32); match(PROMISE);
			setState(34);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(33); match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEGATION || _la==PROMISE) {
				{
				{
				setState(36); operator();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator2Context extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode PROMISE() { return getToken(grammarBayesParser.PROMISE, 0); }
		public Operator2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitOperator2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator2Context operator2() throws RecognitionException {
		Operator2Context _localctx = new Operator2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_operator2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(42); negation();
				}
			}

			setState(45); match(PROMISE);
			setState(47);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(46); match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op2Context extends ParserRuleContext {
		public Operator2Context operator2(int i) {
			return getRuleContext(Operator2Context.class,i);
		}
		public List<Operator2Context> operator2() {
			return getRuleContexts(Operator2Context.class);
		}
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEGATION || _la==PROMISE) {
				{
				{
				setState(49); operator2();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProbabilityContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(grammarBayesParser.EQUALS, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public Op2Context op2() {
			return getRuleContext(Op2Context.class,0);
		}
		public TerminalNode COMMAND() { return getToken(grammarBayesParser.COMMAND, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitProbability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(COMMAND);
			setState(56); match(T__3);
			setState(57); op();
			setState(61);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(58); condition();
				setState(59); op2();
				}
			}

			setState(63); match(T__2);
			setState(64); match(EQUALS);
			setState(65); number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67); match(T__1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegationContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(grammarBayesParser.NEGATION, 0); }
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(NEGATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CliBayesContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CliBayesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cliBayes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitCliBayes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CliBayesContext cliBayes() throws RecognitionException {
		CliBayesContext _localctx = new CliBayesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cliBayes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71); expression();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public Op2Context op2() {
			return getRuleContext(Op2Context.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarBayesVisitor ) return ((grammarBayesVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(T__4);
			setState(77); match(T__3);
			setState(78); op();
			setState(82);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(79); condition();
				setState(80); op2();
				}
			}

			setState(84); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\3\6\3\34\n\3\r\3\16\3\35\3\4\5\4!\n\4\3\4\3\4\5\4%\n"+
		"\4\3\5\7\5(\n\5\f\5\16\5+\13\5\3\6\5\6.\n\6\3\6\3\6\5\6\62\n\6\3\7\7\7"+
		"\65\n\7\f\7\16\78\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b@\n\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\6\13K\n\13\r\13\16\13L\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\fU\n\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2W\2\30\3\2\2"+
		"\2\4\33\3\2\2\2\6 \3\2\2\2\b)\3\2\2\2\n-\3\2\2\2\f\66\3\2\2\2\169\3\2"+
		"\2\2\20E\3\2\2\2\22G\3\2\2\2\24J\3\2\2\2\26N\3\2\2\2\30\31\7\13\2\2\31"+
		"\3\3\2\2\2\32\34\5\16\b\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35"+
		"\36\3\2\2\2\36\5\3\2\2\2\37!\5\22\n\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2"+
		"\"$\7\n\2\2#%\7\7\2\2$#\3\2\2\2$%\3\2\2\2%\7\3\2\2\2&(\5\6\4\2\'&\3\2"+
		"\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\t\3\2\2\2+)\3\2\2\2,.\5\22\n\2-,"+
		"\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\7\n\2\2\60\62\7\7\2\2\61\60\3\2\2\2\61"+
		"\62\3\2\2\2\62\13\3\2\2\2\63\65\5\n\6\2\64\63\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\r\3\2\2\28\66\3\2\2\29:\7\b\2\2:;\7\4\2\2;?"+
		"\5\b\5\2<=\5\20\t\2=>\5\f\7\2>@\3\2\2\2?<\3\2\2\2?@\3\2\2\2@A\3\2\2\2"+
		"AB\7\5\2\2BC\7\f\2\2CD\5\2\2\2D\17\3\2\2\2EF\7\6\2\2F\21\3\2\2\2GH\7\t"+
		"\2\2H\23\3\2\2\2IK\5\26\f\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\25"+
		"\3\2\2\2NO\7\3\2\2OP\7\4\2\2PT\5\b\5\2QR\5\20\t\2RS\5\f\7\2SU\3\2\2\2"+
		"TQ\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\5\2\2W\27\3\2\2\2\f\35 $)-\61\66?L"+
		"T";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}