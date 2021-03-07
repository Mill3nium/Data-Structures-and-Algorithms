package NB19;

import java.awt.*;
import java.util.*;

public class BALLS {

    public static void main(String[] args) {

        Brick[] bricks = new Brick[7];
        for(int i = 0; i<bricks.length;i++){
            bricks[i] = new Brick();
        }

        bricks[0].color = Color.BLACK;
        bricks[1].color = Color.BLACK;
        bricks[2].color = Color.BLACK;
        bricks[3].color = Color.EMPTY;
        bricks[4].color = Color.WHITE;
        bricks[5].color = Color.WHITE;
        bricks[6].color = Color.WHITE;

        System.out.println(toString(bricks));

        nrOfExchanges(bricks);
    }

    public static int nrOfExchanges(Brick[] bricks) {
        int nrOfExchanges = 0;
        int emptyPointer = 0;
        int whitePointer = 0;
        int blackPointer = bricks.length-1;

        while (nrOfExchanges < 16 && !isSolved(bricks)) { // Görs mer än 15 => avbryt, eller om isSolved = true
                if(bricks[emptyPointer].color == Color.BLACK ){
                    if(blackPointer!= emptyPointer){
                        Brick temp = bricks[blackPointer];
                        bricks[blackPointer] = bricks[emptyPointer];
                        bricks[emptyPointer] = temp;
                    }
                    System.out.println(blackPointer + " -> " + emptyPointer);
                    blackPointer++;
                    emptyPointer++;
                }
                else if(bricks[blackPointer].color == Color.EMPTY){
                    emptyPointer++;
                }else{
                    if(emptyPointer!= whitePointer){
                        Brick temp = bricks[whitePointer];
                        bricks[whitePointer] = bricks[emptyPointer];
                        bricks[emptyPointer] = temp;
                    }
                }
            System.out.println(toString(bricks));

        }
        return 1;

    }

    public static boolean isSolved(Brick[] bricks) {
        return (Color.WHITE == bricks[0].color && bricks[0].color == bricks[1].color && bricks[1].color == bricks[2].color)
                && ((bricks[4].color == bricks[5].color && bricks[5].color == bricks[6].color && bricks[6].color == Color.BLACK));
    }

    public static boolean isLegalMove(Brick fromBrick, Brick toBrick) {
        return toBrick.color == Color.EMPTY && (Math.abs(fromBrick.index - toBrick.index) <= 2);
    }

    public static String toString(Brick[] bricks){
        var sb = new StringBuilder();
        for (int i = 0; i < bricks.length; i++) {
            sb.append(bricks[i].color);
            sb.append(" | ");
        }
        return sb.toString();
    }

    enum Color {WHITE, BLACK, EMPTY}

    public static class Brick {
        Color color;
        int index;
    }
}
