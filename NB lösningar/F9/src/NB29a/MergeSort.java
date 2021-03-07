package NB29a;

import java.util.*;

public class MergeSort {

    public static void merge(int[] listA, int[] listB, int[] listC) {
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while (indexA < listA.length && indexB < listB.length) {
            if (listA[indexA] <= listB[indexB]) {
                listC[indexC++] = listA[indexA];
                indexA++;
            }else{
                listC[indexC++] = listB[indexB];
                indexB++;
            }
        }
        while(indexA<listA.length){
            listC[indexC++] = listA[indexA];
            indexA++;
        }
        while(indexB<listB.length){
            listC[indexC++] = listB[indexB];
            indexB++;
        }
    }

    public static void mergeSort(int[] listA){
        if(listA.length == 1){
            return;
        }

        int[] listB = Arrays.copyOfRange(listA,0,listA.length/2);//
        int[] listC = Arrays.copyOfRange(listA,listA.length/2,listA.length);

        mergeSort(listB);
        mergeSort(listC);
        merge(listB,listC,listA);
    }

    public static void main(String[] args) {
        int[] theData = new int[]{2, 10, 1,3,4};
        mergeSort(theData);

        System.out.println("Sorted: ");
        for(int i = 0; i<theData.length; i++){
            System.out.print(theData[i] + "\t");
        }
    }
}
