package upg5;

import java.util.*;

public class PacketRobot {

    private final static int MAXDEPHT = 15;
    private final static int MAXLETTERS = 5;

    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
//        String input;
//        System.out.print("Enter five characters: ");
//        input = scan.nextLine();

        //String input = "BECAD";
        //String orderPacket = order(input, 0, "");
        //System.out.println("The combination: " + input + " takes " + orderPacket.length() + " steps: " + orderPacket);

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

    /**
     * @param boxes conatins current order of boxes
     * @param steps nr of swaps
     * @param shortestCombo contains current combination
     */
    public static String order(String boxes, int steps, String shortestCombo) {
        if (!boxes.contains("A") || !boxes.contains("B") || !boxes.contains("C") ||
                !boxes.contains("D") || !boxes.contains("E") || boxes.length() != MAXLETTERS) {
            throw new IllegalArgumentException();
        }

        if (isAlphabeticalOrder(boxes)) {
            return shortestCombo;
        } else if (steps > MAXDEPHT) {
            return  "NOTVALIDSOLUTION";// motsvarande return integer.max
        }

        String ss = order(s(boxes), ++steps, shortestCombo + "s");//gives new order on stack with new packet combo
        String sb = order(b(boxes), ++steps, shortestCombo + "b");

        //System.out.println("ss: "+ss);
        //System.out.println("sb: "+sb);

        if (ss.length() < sb.length())
            return ss;
        else
            return sb;
    }

    /**
     * Swaps two first characters
     * @param boxes contains old box combination
     * @return returns a updated box combination
     */
    public static String b(String boxes) {
        char[] boxesCharArray = boxes.toCharArray();
        char temp = boxesCharArray[1];
        boxesCharArray[1] = boxesCharArray[0];
        boxesCharArray[0] = temp;
        String newBoxCombo = new String(boxesCharArray);
        return newBoxCombo;
    }

    /**
     * Move last box to first index
     * @param boxes contains old box combination
     * @return returns a updated box combination
     */
    public static String s(String boxes) {
        char[] boxesCharArray = boxes.toCharArray();
        char temp = boxesCharArray[boxesCharArray.length - 1];
        for (int i = 0; i < boxesCharArray.length - 1; i++) {
            boxesCharArray[boxesCharArray.length - 1 - i] = boxesCharArray[boxesCharArray.length - 2 - i];
        }
        boxesCharArray[0] = temp;
        String newBoxCombo = new String(boxesCharArray);
        return newBoxCombo;
    }

    /**
     * @param boxes contains the box combination
     * @return returns true if boxes are in alphabetical order, false if not
     */
    public static boolean isAlphabeticalOrder(String boxes) {
        char[] alphabeticalOrder = {'A','B','C','D','E'};
        char[] oldOrder = boxes.toCharArray();
        return Arrays.equals(alphabeticalOrder, oldOrder);
    }
}
