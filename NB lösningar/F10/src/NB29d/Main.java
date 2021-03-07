package NB29d;

public class Main {

    public static void main(String[] args) {
        int[] theData = new int[]{4, 7, 2, 1, 3, 6};
        int[] theData2 = new int[]{3, 1, 6, 5, 2, 4};
        int[] theData3 = new int[]{1, 10, 3, 5, 8, 11};
        Heap h1 = new Heap(6);


        System.out.print("Input:\t");
        for (var e : theData2) {
            System.out.print(e + "\t");
        }

        h1.sort(theData2);
        System.out.print("\n");

        System.out.print("Sorted:\t");

        for (var e : theData2) {
            System.out.print(e + "\t");
        }

        System.out.println("\n");
        System.out.print("Input:\t");
        for (var e : theData) {
            System.out.print(e + "\t");
        }

        h1.sort(theData);
        System.out.print("\n");

        System.out.print("Sorted:\t");

        for (var e : theData) {
            System.out.print(e + "\t");
        }

        System.out.println("\n");

        System.out.print("Input:\t");
        for (var e : theData3) {
            System.out.print(e + "\t");
        }

        h1.sort(theData3);
        System.out.print("\n");

        System.out.print("Sorted:\t");

        for (var e : theData3) {
            System.out.print(e + "\t");
        }

    }

}
