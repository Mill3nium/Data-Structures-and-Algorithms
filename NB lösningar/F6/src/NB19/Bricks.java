package NB19;

public class Bricks {
    /**
     * Problem definition : An array of balls of three colors (Red, White and
     * Blue) is given. The balls are kept in random positions. Write a program
     * to rearrange the balls in the respective color groups.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] balls = new int[] {  3, 3, 3, 2, 1, 1, 1};
        int redPointer = 0, whitePointer = 0, bluePointer = balls.length - 1;
        while (whitePointer <= bluePointer) {
            // the white pointer is pointing to a red ball.
            if (balls[whitePointer] == 1) {
                // you might not need this condition check if you use a third variable for swapping the contents.
                if (redPointer != whitePointer) {
                    // code to swap without the third variable.
                    balls[redPointer] = balls[redPointer] + balls[whitePointer];
                    balls[whitePointer] = balls[redPointer]	- balls[whitePointer];
                    balls[redPointer] = balls[redPointer] - balls[whitePointer];
                }

                redPointer++;
                whitePointer++;

            }
            // the white pointer is pointing to a white ball.
            else if (balls[whitePointer] == 2) {
                whitePointer++;
            }
            // the white pointer is pointing to a blue ball.
            else {
                // same argument as above.
                if (whitePointer != bluePointer) {
                    balls[whitePointer] = balls[whitePointer] + balls[bluePointer];
                    balls[bluePointer] = balls[whitePointer] - balls[bluePointer];
                    balls[whitePointer] = balls[whitePointer] - balls[bluePointer];
                }
                bluePointer--;
            }
        }

        // print the array output.
        for (redPointer = 0; redPointer < balls.length; redPointer++) {
            System.out.print(balls[redPointer] + " , ");
        }
        System.out.println();
    }



}