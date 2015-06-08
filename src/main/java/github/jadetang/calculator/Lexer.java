package github.jadetang.calculator;

import static github.jadetang.calculator.Token.TokenType.*;

/**
 * @author tangsicheng
 * @version 1.0
 * @since 1.0
 */
public class Lexer {

    private String text;
    //current position
    private int pos;
    //look ahead cha
    private char ch;

    public static final char EOF = (char) -1; //  represent end of file char


    public Lexer(String text) {
        this.text = text;
        pos = 0;
        ch = charAt(pos);
    }


    public boolean hasNextToken() {
        return ch != EOF;
    }

    private char charAt(int index) {
        return text.charAt(index);
    }

    public Token nextToken() {
        for (; ; ) {
            switch (ch) {
                case '+':
                    advance();
                    return new Token(ADD, "+");
                case '-':
                    advance();
                    return new Token(MINUS, "-");
                case '*':
                    advance();
                    return new Token(MULTI, "*");
                case '/':
                    advance();
                    return new Token(DIVISION, "/");
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return scanNumber();
                case '(':
                    advance();
                    return new Token(LPAREN,"(");
                case ')':
                    advance();
                    return new Token(RPAREN,")");
                case EOF:
                    return new Token(Token.TokenType.EOF, "end of file");
                default:
                    throw new IllegalArgumentException(ch + " do not match any token!");
            }
        }
    }

    private Token scanNumber() {
        StringBuilder sb = new StringBuilder(10);
        if(ch == '.'){
            sb.append("0");
        }
        while (isDigit(ch)) {
            sb.append(ch);
            advance();
        }
        if (sb.indexOf(".") > -1) {
            try {
                Double d = Double.parseDouble(sb.toString());
            } catch (NumberFormatException n) {
                throw new IllegalArgumentException(sb.toString() + " is not valid flow number");
            }
            return new Token(FLOW, sb.toString());
        }else {
            try {
                Integer integer = Integer.parseInt(sb.toString());
            }catch (NumberFormatException n) {
                throw new IllegalArgumentException(sb.toString() + " is not valid integer number");
            }
            return new Token(INT, sb.toString());
        }
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9' || ch == '.';
    }




    //return current character and move the pos a step ahead
    protected final void advance() {
        if (pos == text.length() - 1) {
            ch = EOF;
        } else {
            ch = charAt(++pos);
        }
    }

    private char lookAhead() {
        if (pos == text.length() - 1) {
            return EOF;
        } else {
            return charAt(pos + 1);
        }
    }


}
