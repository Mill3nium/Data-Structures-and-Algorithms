package NB16;

import java.util.*;

public class Kulor {

    public static void main(String[] args) {
        System.out.println(nrOfExchanges(2, 1, 3, 0));
    }

    public static int nrOfExchanges(int blue, int white, int red, int nrOfExchanges) {

        Queue<State> queue = new LinkedList<>();
        State stateOfBall = new State(blue, red, white, nrOfExchanges); // skapar en klass tillstånd med färegerna på kulorna

        while (stateOfBall.nrOfExchanges < 16 && !stateOfBall.isSolved()) { // Görs mer än 15 => avbryt, eller om isSolved = true
                                                        //Exchanges ökar för varje varv
            if (stateOfBall.blue > 0) {
                queue.offer(new State(stateOfBall.blue - 1, stateOfBall.red + 1, stateOfBall.white + 3, stateOfBall.nrOfExchanges + 1));
            }
            if (stateOfBall.red > 0) {
                queue.offer(new State(stateOfBall.blue + 2, stateOfBall.red - 1, stateOfBall.white + 1, stateOfBall.nrOfExchanges + 1));
            }
            if (stateOfBall.white > 0) {
                queue.offer(new State(stateOfBall.blue + 3, stateOfBall.red + 4, stateOfBall.white - 1, stateOfBall.nrOfExchanges + 1));
            }

            stateOfBall = queue.poll(); // Hämtar senaste tillstånd
            System.out.println("blue: " + stateOfBall.blue + " red: " + stateOfBall.red + " white: " + stateOfBall.white + " exchanges: " + stateOfBall.nrOfExchanges);

            if (stateOfBall.nrOfExchanges == 15) {
                return Integer.MAX_VALUE;
            }

        }

        System.out.println("blue: " + stateOfBall.blue + " red: " + stateOfBall.red + " white: " + stateOfBall.white + " exchanges: " + stateOfBall.nrOfExchanges);

        if (stateOfBall.isSolved()) {
            return stateOfBall.nrOfExchanges;
        } else return Integer.MAX_VALUE;

    }

    public static class State {
        int blue, red, white;
        int nrOfExchanges;
        boolean solved;

        public State(int blue, int red, int white, int nrOfExchanges) {
            this.blue = blue;
            this.red = red;
            this.white = white;
            this.nrOfExchanges = nrOfExchanges;
            solved = false;
        }

        public boolean isSolved() {
            return (blue == white) && (blue == red);
        }
    }
}
