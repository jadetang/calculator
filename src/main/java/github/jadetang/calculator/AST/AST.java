package github.jadetang.calculator.AST;

import github.jadetang.calculator.Token;

/**
 * Created by jadetang on 15-6-9.
 */
public abstract class AST {

    protected Token t;

    public AST(Token t){
        this.t = t;
    }

    public abstract int evl();
}
