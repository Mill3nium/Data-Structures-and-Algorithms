package NB8;

import java.util.*;

public class ArrayQueue<E> extends AbstractQueue<E> {
    private int front,rear, size,maxSize;
    private boolean compress;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialMaxSize){
        this.size = 0;
        this.front = 0;
        this.maxSize = initialMaxSize;
        this.rear = maxSize-1;
        this.data = (E[]) new Object[maxSize];
        this.compress = false;
    }

    @Override
    public boolean offer(E element) {
        if(size == maxSize){
            reallocate();
        }else if(size < maxSize*0.25 ){
            //compress();
            compress = true;
            reallocate();
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(size== 0) {
            return null;
        }else if(size < maxSize*0.25 ){
            compress = true;
            reallocate();
        }

        size--;
        E element = data[front];
        front = (front + 1) % maxSize;
        return element;
    }

    @Override
    public E peek() {
        if(size == 0){
            return null;
        }
        return data[front];
    }

    @SuppressWarnings("unchecked")
    private void reallocate(){
        int newMaxSize;
        if(!compress) {
            newMaxSize = 2 * maxSize;
        }else {
            newMaxSize = maxSize / 2;
            compress = false;
        }

        E[] newData= (E[]) new Object[newMaxSize];
        int j = front;
        for(int i = 0; i<size; i++){
            newData[i] = data[i];
            j = (j + 1) % maxSize;//
        }
        front = 0;
        rear = size-1;
        maxSize= newMaxSize;
        data = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }


    private class Itr implements Iterator{
        private int index;
        private int count= 0;

        public Itr() {
            index = front;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue= data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public boolean hasNext() {
            return count< size;
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < data.length; i++) {
             if (i != 0) {
                sb.append(", ");
             }
             if(data[i] == null){
                 sb.append(" ");
             }
             if(data[i]!= null){
                 sb.append(data[i]);
             }
        }
        sb.append("]");
        return sb.toString();
    }
}
