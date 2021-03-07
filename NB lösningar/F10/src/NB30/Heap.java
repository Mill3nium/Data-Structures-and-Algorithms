package NB30;

import java.util.Arrays;

public class Heap<E extends Comparable<E>> {

    private E data[];
    int size;
    private int nextPos;//current size

    public Heap(int size){
        this.size = size;
        this.data = (E[]) new Comparable[size];

    }

    public void offer(E element){
        int parentIndex = (nextPos-1)/2;
        int index = nextPos;
        if (nextPos >=size){
            reallocate();
        }
        data[index] = element;
        while (index != 0 && data[index].compareTo(data[parentIndex]) < 0){
            swap(index,parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
        nextPos++;
    }

    public E poll(){
        E deletedItem = data[0];
        data[0] = data[nextPos-1];
        nextPos--;
        int index = 0;
        int smallestChildIndex;
        int leftChildIndex = 1;
        int rightChildIndex = 2;


        while (leftChildIndex < nextPos || rightChildIndex <  nextPos){
            if (data[index].compareTo(data[rightChildIndex]) > 0 || data[index].compareTo(data[leftChildIndex]) > 0){
                if (data[leftChildIndex].compareTo(data[rightChildIndex]) > 0){
                    smallestChildIndex = rightChildIndex;
                } else smallestChildIndex = leftChildIndex;
                swap(smallestChildIndex,index);
                index = smallestChildIndex;
                leftChildIndex = index*2 +1;
                rightChildIndex = leftChildIndex+1;
            } else break;
        }

        return deletedItem;
    }

    private void reallocate(){
        data = Arrays.copyOf(data,size*2);
    }


    private void swap(int childIndex, int parentIndex){
        E tmp = data[childIndex];
        data[childIndex] = data[parentIndex];
        data[parentIndex] = tmp;
    }

    @Override
    public String toString(){
        StringBuilder info= new StringBuilder("[");

        for (int i = 0; i< nextPos; i++){
            info.append(data[i].toString()).append(", ");
        }

        info.append("]");
        return info.toString();
    }

}
