package upg6;

import java.util.*;

public class PacketRobotDephtFirst {

    private final static int MAXLETTERS = 5;
    private static String finalCombo; // save first result from combo

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //String input;
        //System.out.print("Enter five characters: ");
        //input = scan.nextLine();

        //String input = "BECAD";

        //String packetOrder = order(input, 0, "");
        //System.out.println("The combination: " + input + " takes " + packetOrder.length() + " steps: " + packetOrder);

        System.out.println("Order: " + order("BEACD").length() + ", steps: " + order("BEACD"));
        System.out.println("Order: " + order("BAECD").length() + ", steps: " + order("BAECD") );
        System.out.println("Order: " + order("EADBC").length() + ", steps: " + order("EADBC") );

    }

    /**
     * Wrapper method order
     * @param boxes combination
     * @return sorted combination
     * */
    public static String order(String boxes){
        return order(boxes,0,"");
    }

    public static String order(String boxes, int steps, String shortestCombo) {
        if (!boxes.contains("A") || !boxes.contains("B") || !boxes.contains("C") ||
                !boxes.contains("D") || !boxes.contains("E") || boxes.length() != MAXLETTERS) {
            throw new IllegalArgumentException();
        }

        Queue<State> q = new LinkedList<State>();

        q.add(new State(boxes, shortestCombo, steps)); // add first state

        while (!q.isEmpty()) {
            State current = q.poll(); //get front of queue
            if (isAlphabeticalOrder(current.currentState)) {
                finalCombo = current.combo; //ex sbsssb
                return finalCombo;
                //break;
            }
            State ss = s(current.currentState, current.combo + "s", current.steps + 1); // add state with new values
            q.add(ss);// go left/right
            State sb = b(current.currentState, current.combo + "b", current.steps + 1);
            q.add(sb);
            //System.out.println(current.currentState);
        }
        return finalCombo;
    }

    /**
     * Swaps two first characters
     * @param boxes contains old box combination
     * @return returns a updated box combination
     */
    public static State b(String boxes, String combo, int steps) {
        char[] boxesCharArray = boxes.toCharArray();
        char temp = boxesCharArray[1];
        boxesCharArray[1] = boxesCharArray[0];
        boxesCharArray[0] = temp;
        String newBoxCombo = new String(boxesCharArray);

        return new State(newBoxCombo, combo, steps);
    }

    /**
     * Move last box to first index
     * @param boxes contains old box combination
     * @return returns a updated box combination
     */
    public static State s(String boxes, String combo, int steps) {
        char[] boxesCharArray = boxes.toCharArray();
        char temp = boxesCharArray[boxesCharArray.length - 1];
        for (int i = 0; i < boxesCharArray.length - 1; i++) {
            boxesCharArray[boxesCharArray.length - 1 - i] = boxesCharArray[boxesCharArray.length - 2 - i];
        }
        boxesCharArray[0] = temp;
        String newBoxCombo = new String(boxesCharArray);
        return new State(newBoxCombo, combo, steps);
    }

    /**
     * @param boxes contains the box combination
     * @return returns true if boxes are in alphabetical order, false if not
     */
    public static boolean isAlphabeticalOrder(String boxes) {
        char[] alphabeticalOrder = {'A', 'B', 'C', 'D', 'E'};
        char[] oldOrder = boxes.toCharArray();
        return Arrays.equals(alphabeticalOrder, oldOrder);
    }
    /**
     * Saves state each loop(switched box combination)
     * (Keeps track of which path we have taken)
     * */
    public static class State {
        String currentState;
        String combo;
        int steps;

        public State(String currentState, String combo, int steps) {
            this.currentState = currentState; // boxes
            this.combo = combo; // way
            this.steps = steps;
        }
    }
}
