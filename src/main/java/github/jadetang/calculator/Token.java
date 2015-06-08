package github.jadetang.calculator;

/**
 * @author tangsicheng
 * @version 1.0
 * @since 1.0
 */
public class Token {
    /**
     * @author tangsicheng
     * @version 1.0
     * @since 1.0
     */
    public enum TokenType {
        ADD("+"),
        MINUS("-"),
        MULTI("*"),
        DIVISION("/"),
        INT("integer"),
        FLOW("flow"),
        LPAREN("("),
        RPAREN(")"),
        EOF("end of file");

        private String desc;

        private TokenType(String desc) {
            this.desc = desc;
        }
    }





    private TokenType type;

    private String value;

    @Override
    public String toString() {
        return "<" + type + "," + value + ">";
    }


    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }


}





