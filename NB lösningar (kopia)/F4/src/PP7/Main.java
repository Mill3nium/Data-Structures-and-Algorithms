package PP7;

import NB72.*;

import java.util.*;

public class Main {

    public static void main(String[] args)  throws InfixPostfixEvaluator.SyntaxErrorException{
	// write your code her
        Scanner scan = new Scanner(System.in);
        InfixPostfixEvaluator eval = new InfixPostfixEvaluator();

        System.out.println("Enter infix expression: ");
        String input = scan.nextLine();

        String postFix = eval.convert(input);
        System.out.println("Infix: " + postFix);
        System.out.println("Postfix: " + postFix);
        System.out.println("Result: " + eval.eval(postFix));
    }
}
