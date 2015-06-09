package github.jadetang.calculator;

import github.jadetang.calculator.AST.AST;
import github.jadetang.calculator.AST.NumberLiteral;
import org.junit.Assert;
import org.junit.Test;

public class CParserTest {




    @Test
    public void parseNumber() throws ParseException {
        String str = "01";
        CParser c = new CParser(new Lexer(str));
        AST s = c.factor();
        Assert.assertTrue(s instanceof NumberLiteral);
        Assert.assertEquals(1,s.evl());

    }


    @Test
    public void parseWhole() throws ParseException{
        String str = "((1+3)*5)/4";
        CParser c = new CParser(new Lexer(str));
        AST s = c.expression();
     //   Assert.assertTrue(s instanceof NumberLiteral);
        Assert.assertEquals(5,s.evl());

    }

}