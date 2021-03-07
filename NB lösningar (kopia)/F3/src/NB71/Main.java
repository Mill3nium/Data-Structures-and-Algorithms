package NB71;

import java.util.*;

public class Main {
    public static void main(String[] args) throws PostfixEvaluator.SyntaxErrorException {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        System.out.println(evaluator.eval("12 6 + 3 /"));
    }

}
