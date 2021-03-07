package NB28;

public class Main {


    public static void main(String[] args) {
        int[] theData1 = new int[]{2, 10, 1, 5, 4, 7, 3, 6, 8, 9};
        int[] theData2 = new int[]{2, 10, 1, 5, 4, 7, 3, 6, 8, 9};

        selectionSort(theData1);
        insertionSort(theData2);

        System.out.println("Selection sort: ");
        for (int i = 0; i < theData1.length; i++) {
            System.out.print(theData1[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println("Insertion sort:");
        for (int i = 0; i < theData1.length; i++) {
            System.out.print(theData1[i]);
        }
    }

    public static void selectionSort(int[] list) {

        //Local Declarations
        int minIndex = 0;
        int temp = 0;

        for (int index = 0; index < list.length - 1; index++) {
            minIndex = index;
            for (int i = index + 1; i <= list.length - 1; i++) {
                if (list[i] < list[minIndex]) {
                    minIndex = i;
                }
            }

            temp = list[index];
            list[index] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    public static void insertionSort(int list[]) {
        int hold = 0;
        int walker = 0;

        for (int current = 1; current < list.length; current++) {
            hold = list[current];
            for (walker = current - 1; walker >= 0 && hold < list[walker]; walker--) {
                list[walker + 1] = list[walker];
            }
            list[walker +1 ] = hold;
        }
    }
}
