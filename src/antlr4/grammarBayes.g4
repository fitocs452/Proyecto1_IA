/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar grammarBayes;

// Definicion de letra y digito
fragment LETTER : ('a'..'z'|'A'..'Z') ;
fragment DIGIT :'0'..'9' ;

// Definicion de operador de probabilidad y simbolo de negacion
COMMAND : ('P' | 'p');
NEGATION: '!';

// Definicion de premisa, numbero e igualdad
PROMISE:   LETTER;
NUM : DIGIT ('.'? DIGIT* )? ;
EQUALS: '=';

// Definicion de white space (Para ignorarlo al momento de leer)
WS : 
    [\t\r\n\f ]+ -> skip ;

// Definicion de un comentario (Para ignorarlo al momento de leer)
COMMENT:
        ( '//' ~[\r\n]* '\r'? '\n'	
        | '/*' .*? '*/'	
        ) -> skip
    ;								
    
// Gramatica aceptada para Bayes
number: NUM;
program:
        probability+ ;

// Operador 1
operator: negation? PROMISE (',')?;
// Kleen de operador 1
op: operator* ;

// Operador 1
operator2: negation? PROMISE (',')?;
// Kleen de operador 1
op2: operator2* ;

// Calculo de probabilidad: P(A, B .. | C )
probability:
    COMMAND '(' op (condition  op2)?  ')' EQUALS number
;

condition: ('|'); 
negation: NEGATION;

cliBayes: expression+
	;

expression
        : 'P' '(' op (condition  op2)?  ')'
        ;