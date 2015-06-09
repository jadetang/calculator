package github.jadetang.calculator.AST;

import github.jadetang.calculator.Token;

/**
 * Created by jadetang on 15-6-9.
 */
public class BinaryExpr  extends AST{


    private AST left;

    private AST right;


    public BinaryExpr(Token t,AST left,AST right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    @Override
    public int evl() {
        switch (t.type()){
            case ADD:return left.evl()+right.evl();
            case MINUS:return left.evl()-right.evl();
            case MULTI:return left.evl()*right.evl();
            case DIVISION:return left.evl()/right.evl();
            default:throw new RuntimeException(t+" type do not match any operator");
        }
    }
}
