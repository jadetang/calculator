package github.jadetang.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class LexerTest {


    @Test
    public void testHasNextToken(){
        Lexer l = new Lexer("a");
        assertTrue(l.hasNextToken());
    }


    @Test
    public void basicAdd(){
        Lexer l  = new Lexer("+-*/55.1");
        while (l.hasNextToken()){
            System.out.println(l.nextToken());
        }
    }

    @Test
    public void testInvalidNumber(){
        Lexer l = new Lexer("(5.55)");
        while (l.hasNextToken()){
            System.out.println(l.nextToken());
        }
    }

}