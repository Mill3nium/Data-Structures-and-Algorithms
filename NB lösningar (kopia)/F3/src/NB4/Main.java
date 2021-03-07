package NB4;

import java.util.*;

public class Main {

    public static class ParenthesesCheck {

        private static final String OPEN = "([{";
        private static final String CLOSE = ")]}";

        public static boolean isBalanced(String expression){
            Stack<Character> s = new Stack<Character>();
            boolean balanced = true;
            try{
                int  index = 0;
                while(balanced && index < expression.length() ){
                    char nextCh = expression.charAt(index);
                    if(isOpen(nextCh)){ // returns true if ch is an opening parenthesis
                        s.push(nextCh);
                    }else if(isClose(nextCh)){// returns true if ch is a closing parenthesis
                        char topCh = s.pop();
                        balanced = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
                    }
                    index++;
                }
            }catch (EmptyStackException ex){
                balanced = false;
            }
            return (balanced && s.empty());
        }

        private static boolean isClose(char ch) {
            return CLOSE.indexOf(ch) > -1;
        }

        private static boolean isOpen(char ch) {
            return OPEN.indexOf(ch) > -1;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String  userInput;

        do{
            System.out.println("Enter expression: ");
            userInput = scan.nextLine();
            if (ParenthesesCheck.isBalanced(userInput)) {
                System.out.println(userInput + ", BALANCED\n");
            } else
                System.out.println(userInput + ", NOT BALANCED\n");

            System.out.println("Again? y/n");
            userInput = scan.nextLine();
        }while(userInput.charAt(0) != 'n');
    }
    // balanced: (w * (x + y) / z - (p / (r-q)))
    // not balanced: (w * [x + y) / z - [p / {r - q}])
}
