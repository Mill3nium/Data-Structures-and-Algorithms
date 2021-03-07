package NB72;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InfixCalculator.SyntaxErrorException {
        Scanner scan = new Scanner(System.in);
        InfixCalculator ic = new InfixCalculator();

        System.out.println("Enter infix expression: ");
        String input = scan.nextLine();

        String postFix = ic.convert(input);
        System.out.println("Infix: " + input);
        System.out.println("Result: " + ic.eval(postFix));

    }
}
//3 + (( 4 * 7 ) / 2)