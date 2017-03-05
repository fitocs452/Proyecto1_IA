// Generated from /home/amorales/Universidad/InteligenciaArtificial/Proyecto1/PrimeraParte/src/antlr4/grammarBayes.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammarBayesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, COMMAND=6, NEGATION=7, PROMISE=8, 
		NUM=9, EQUALS=10, WS=11, COMMENT=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "LETTER", "DIGIT", "COMMAND", 
		"NEGATION", "PROMISE", "NUM", "EQUALS", "WS", "COMMENT"
	};


	public grammarBayesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammarBayes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\5\f\66\n"+
		"\f\3\f\7\f9\n\f\f\f\16\f<\13\f\5\f>\n\f\3\r\3\r\3\16\6\16C\n\16\r\16\16"+
		"\16D\3\16\3\16\3\17\3\17\3\17\3\17\7\17M\n\17\f\17\16\17P\13\17\3\17\5"+
		"\17S\n\17\3\17\3\17\3\17\3\17\3\17\7\17Z\n\17\f\17\16\17]\13\17\3\17\3"+
		"\17\5\17a\n\17\3\17\3\17\3[\2\20\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23"+
		"\t\25\n\27\13\31\f\33\r\35\16\3\2\6\4\2C\\c|\4\2RRrr\5\2\13\f\16\17\""+
		"\"\4\2\f\f\17\17i\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3"+
		"\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+\3\2\2\2\21-\3\2\2\2\23/\3\2\2\2\25"+
		"\61\3\2\2\2\27\63\3\2\2\2\31?\3\2\2\2\33B\3\2\2\2\35`\3\2\2\2\37 \7R\2"+
		"\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7~\2\2&\n\3"+
		"\2\2\2\'(\7.\2\2(\f\3\2\2\2)*\t\2\2\2*\16\3\2\2\2+,\4\62;\2,\20\3\2\2"+
		"\2-.\t\3\2\2.\22\3\2\2\2/\60\7#\2\2\60\24\3\2\2\2\61\62\5\r\7\2\62\26"+
		"\3\2\2\2\63=\5\17\b\2\64\66\7\60\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66:\3"+
		"\2\2\2\679\5\17\b\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2=\65\3\2\2\2=>\3\2\2\2>\30\3\2\2\2?@\7?\2\2@\32\3\2\2\2AC"+
		"\t\4\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\b\16\2\2"+
		"G\34\3\2\2\2HI\7\61\2\2IJ\7\61\2\2JN\3\2\2\2KM\n\5\2\2LK\3\2\2\2MP\3\2"+
		"\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QS\7\17\2\2RQ\3\2\2\2RS\3"+
		"\2\2\2ST\3\2\2\2Ta\7\f\2\2UV\7\61\2\2VW\7,\2\2W[\3\2\2\2XZ\13\2\2\2YX"+
		"\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7,\2\2"+
		"_a\7\61\2\2`H\3\2\2\2`U\3\2\2\2ab\3\2\2\2bc\b\17\2\2c\36\3\2\2\2\13\2"+
		"\65:=DNR[`\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}