package upg9;

import java.util.*;

public class Main {
    static final int SIZE = 1000000;

    public static void main(String[] args) {

        int array[] = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(random.nextInt());
        }

        long startTime = System.currentTimeMillis();
        radixSort(array);
        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("Total time to sort: " + totalTime + " ms");
        System.out.println("Is sorted?: " + isSorted(array));
    }

    public static boolean isSorted(int[] array) {
        boolean sorted = true;

        //Checks if sorting is correct
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                //throw new IllegalStateException();
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static int getMax(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static void radixSort(int array[]) {

        int max = getMax(array);
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(array, array.length, i);
        }
    }

    private static void countingSort(int array[], int nrOfElements, int notation) {
        int output[] = new int[nrOfElements];
        int count[] = new int[10];

        //räknar förekommanden som slutar på 0-9
        for (int i = 0; i < nrOfElements; i++) {
            count[(array[i] / notation) % 10]++;//%10 get entalet
        }

        //Räknar hur många tal som slutar på 0-9
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = nrOfElements - 1; i >= 0; i--) {
            output[count[(array[i] / notation) % 10] - 1] = array[i];
            count[(array[i] / notation) % 10]--;
        }

        //Kopierar output till array(efter att tex tiotalen blivit sorterade)
        if (nrOfElements >= 0) {
            System.arraycopy(output, 0, array, 0, nrOfElements);
        }
    }
}
