package github.jadetang.calculator;

import github.jadetang.calculator.AST.AST;
import github.jadetang.calculator.AST.BinaryExpr;
import github.jadetang.calculator.AST.NumberLiteral;

import java.util.ArrayList;

import static github.jadetang.calculator.Token.EOF;
import static github.jadetang.calculator.Token.TokenType.*;

/**
 * a parser that parse expression like 1*2+3 (1*2)+3
 *
 * BNF:
 * factor: NUMBER | "(" expression ")"
 * term:   factor { ("*"|"/") factor}
 * expression: term {("+"|"-" term)}
 *
 */
public class CParser {

    private ArrayList<Token> tokens;
    //current token
    private Token t;

    private int pos;

    public CParser(Lexer l){
        tokens = new ArrayList<Token>(20);
        while (l.hasNextToken()){
            tokens.add(l.nextToken());
        }
        pos = 0;
        t = tokens.get(0);
    }

    public AST expression() throws ParseException{
        AST left = term();
        while( t.type() == ADD || t.type() == MINUS){
            Token op = t;
            advance();
            AST right = term();
            left = new BinaryExpr(op,left,right);
        }
        return left;
    }

    private AST term() throws ParseException{
        AST left = factor();
        while( t.type() == MULTI || t.type() == DIVISION){
            Token op = t;
            advance();
            AST right = factor();
            left = new BinaryExpr(op,left,right);
        }
        return left;
    }

    public AST factor() throws ParseException{
        if( t.type() == LPAREN ){
            advance();
            AST e = expression();
            if( t.type() == RPAREN ){
                advance();
                return e;
            }else {
                throw new ParseException();
            }
        }else{
            if( t.type() == INT ){
                Token temp = t;
                advance();
                return new NumberLiteral(temp);
            }else {
                throw new ParseException();
            }
        }
    }

    protected final void advance() {
        if (pos == tokens.size() - 1) {
            t = EOF;
        } else {
            t = tokens.get(++pos);
        }
    }

    protected final Token lookahead(){
        if (pos == tokens.size() - 1) {
            return EOF;
        } else {
            return tokens.get(pos+1);
        }
    }




}
