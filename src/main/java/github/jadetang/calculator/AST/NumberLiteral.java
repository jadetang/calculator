package github.jadetang.calculator.AST;

import github.jadetang.calculator.Token;

/**
 * Created by jadetang on 15-6-9.
 */
public class NumberLiteral extends AST {

    public NumberLiteral(Token t){
        super(t);
    }

    @Override
    public int evl() {
        return Integer.parseInt(t.value());
    }
}
