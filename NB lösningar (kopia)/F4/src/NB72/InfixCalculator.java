package NB72;
import java.util.EmptyStackException;
import java.util.Stack;


import java.util.*;

public class InfixCalculator {

    public static class SyntaxErrorException extends Exception{

        SyntaxErrorException(String message){
            super(message);
        }
    }
    private static final String OPERATORS = "+-*/()";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    private StringBuilder postfix;
    private Stack<Character> operatorStack;

    private Stack<Integer> operandStack;

    private int evalOp(char op){
        int rhs = operandStack.pop();
        int lhs = operandStack.pop();
        int result = 0;

        switch (op){
            case '+' : result = lhs + rhs;
                break;
            case '-' : result = lhs - rhs;
                break;
            case '/' : result = lhs / rhs;
                break;
            case '*' : result = lhs * rhs;
                break;
        }
        return result;
    }

    public int eval(String expression)throws SyntaxErrorException{
        operandStack = new Stack<>();

        String[] tokens = expression.split("\\s+");
        try {
            for(String nextToken : tokens){
                char firstChar = nextToken.charAt(0);
                if(Character.isDigit(firstChar)){
                    int value = Integer.parseInt(nextToken);
                    operandStack.push(value);
                }

                else if (isOperator(firstChar)){
                    var result = evalOp(firstChar);
                    operandStack.push(result);
                }
                else{
                    throw new SyntaxErrorException("Invalid character encounter:" + firstChar);
                }
            }

            int answer = operandStack.pop();

            if(operandStack.empty()){
                return answer;
            }else{
                throw new SyntaxErrorException("Syntax Error: stack should be empty");
            }
        }catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: the stack is empty");
        }
    }

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }

    private int precedence(char op){
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    public String convert(String expression) throws SyntaxErrorException{
        operatorStack = new Stack<>();
        postfix = new StringBuilder();

        try {
            Scanner scan = new Scanner(expression);
            String nextToken;
            while ((nextToken = scan.findInLine("[]\\p{L}\\p{N}]+|[-+/\\*()]"))!=null)
            {
                char firstChar = nextToken.charAt(0);
                if(Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)){
                    postfix.append(nextToken);
                    postfix.append(' ');
                }
                else if (isOperator(firstChar)){
                    processOperator(firstChar);
                }
                else{
                    throw new SyntaxErrorException("Unexpected Character Encountered:" + firstChar);
                }
            }

            while (!operatorStack.empty()){
                char op = operatorStack.pop();
                if(op =='(') throw new SyntaxErrorException("Unmatched opening parenthesis");
                postfix.append(op);
                postfix.append(' ');
            }

            return postfix.toString();

        }catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: the stack is empty");
        }
    }
    private void processOperator(char op){
        if(operatorStack.empty() || op == '('){
            operatorStack.push(op);
        }else{
            char topOp = operatorStack.peek();
            if (precedence(op)> precedence(topOp)){
                operatorStack.push(op);
            }else{
                while (!operatorStack.empty() && precedence(op)<= precedence(topOp)){
                    operatorStack.pop();
                    if(topOp == '('){
                        break;
                    }
                    postfix.append(topOp);
                    postfix.append(' ');
                    if(!operatorStack.empty()){
                        topOp = operatorStack.peek();
                    }
                }
                if(op != ')'){
                    operatorStack.push(op);
                }
            }
        }
    }
}


