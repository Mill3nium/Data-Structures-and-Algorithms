package NB71;

import java.util.*;

public class PostfixEvaluator {

    public static class SyntaxErrorException extends Exception{
        public SyntaxErrorException(String message){
            super(message);
        }
    }
    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    private int evalOp(char op){
        int rhs = operandStack.pop();
        int lhs = operandStack.pop();

        int result = 0;

        switch (op){
            case '+': result = lhs + rhs;
            break;
            case '-': result = lhs - rhs;
                break;
            case '/': result = lhs / rhs;
                break;
            case '*': result = lhs * rhs;
                break;
        }
        return result;
    }

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException{
        operandStack = new Stack<Integer>();

        String[] tokens = expression.split("\\s+");
        try{
            for(String nextToken: tokens){
                char firstChar = nextToken.charAt(0);
                if(Character.isDigit(firstChar)){
                    int value = Integer.parseInt(nextToken);
                    operandStack.push(value);
                }else if(isOperator(firstChar)){
                    int result = evalOp(firstChar);
                    operandStack.push(result);
                }else{
                    throw new SyntaxErrorException("invalid character encountered: " + firstChar);
                }
            }
            int answer = operandStack.pop();
            if(operandStack.empty()){
                return answer;
            }else{
                throw new SyntaxErrorException("Syntax Error");
            }
        }catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error");
        }
    }
}

