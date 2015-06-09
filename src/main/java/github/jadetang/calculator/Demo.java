package github.jadetang.calculator;

import java.util.Scanner;

/**
 * Created by jadetang on 15-6-9.
 */
public class Demo {

    public static void main(String[] args) {
        while (true){
            System.out.println("input expression like (1+2)*3");
            Scanner sc = new Scanner(System.in);
            String expr = sc.nextLine();
            try {
                CParser c = new CParser(new Lexer(expr));
                int result = c.expression().evl();
                System.out.println(expr + "=" + result);
                System.out.println();
            }catch (Exception e){
                System.out.println("some thing is wrong,maybe "+e.getMessage());
            }
        }
    }
}
