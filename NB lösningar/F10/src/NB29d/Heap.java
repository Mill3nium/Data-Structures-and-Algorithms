package NB29d;

import java.util.*;

public class Heap {
    private int size; // size of the heap

    public Heap(int maxSize) {
        this.size = 0;
    }

    public void sort(int[] list) {

        size = 1;
        while (size < list.length) {
            offer(list[size],list);
            //System.out.println(Arrays.toString(list));
        }
        while (size > 1) {
            list[size - 1] = poll(list);
        }
    }

    //put number on first empty place
    public boolean offer(int data, int[] list) {
        list[size] = data;
        reheapOffer(size,list);
        size++;
        return true;
    }

    private void reheapOffer(int pos,int[] list) {
        int parent = (pos-1)/2;

        if(pos!=0 && list[parent]<list[pos]){
            swap(pos,parent,list);
            reheapOffer(parent,list);
        }
    }

    public int poll(int[] list) {
        int returnData = list[0];
        list[0] = list[size - 1];
        size--;
        reheapPoll(0,list);
        return returnData;
    }

    private void reheapPoll(int pos,int[] list) {

        int largest = pos; // Initialize largest as root
        int leftChild = 2 * pos + 1; // left = 2*i + 1
        int rightChild = 2 * pos + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChild < size && list[leftChild] > list[largest])
            largest = leftChild;

        // If right child is larger than largest so far
        if (rightChild < size && list[rightChild] > list[largest])
            largest = rightChild;

        // If largest is not root(basecase)
        if (largest != pos) {
            swap(pos, largest,list);
            // Recursively reheap
            reheapPoll(largest,list);
        }else return;
    }

    private void swap(int p1, int p2,int[] list) {
        int tmp = list[p1];
        list[p1] = list[p2];
        list[p2] = tmp;
    }
}
