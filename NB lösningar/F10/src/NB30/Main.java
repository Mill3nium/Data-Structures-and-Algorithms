package NB30;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Heap<String> heap = new Heap<>(10);

        System.out.println(heap.toString());

        for (int i = heap.size; i> 0; i--){
            heap.offer("MILAN"+i);
        }
        System.out.println(heap.toString());
        heap.poll();
        System.out.println(heap.toString());
    }

}