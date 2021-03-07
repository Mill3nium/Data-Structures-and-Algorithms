package NB9;

import java.util.*;

public class ListQueue<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E dataItem){
            this.data = dataItem;
            this.next = null;
        }

        private Node(E dataItem, Node<E> nodeRef){
            this.data = dataItem;
            this.next = nodeRef;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public ListQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean offer(E item){
        if(front == null){
            rear = new Node<E>(item);
            front = rear;
        } else{
            rear.next = new Node<E>(item);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public E poll(){
        E item = peek();
        if(item == null){
            return null;
        }
        front = front.next;
        size--;
        return item;
    }

    public E peek(){
        if(size == 0){
            return null;
        }else
            return front.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> nodeRef = front;
        if(nodeRef!= null) {
            sb.append("[");
            while (nodeRef != null) {
                sb.append(nodeRef.data);
                if (nodeRef.next != null) {
                    sb.append(" --> ");
                }
                nodeRef = nodeRef.next;
            }
            sb.append("]");
        }else{
            sb.append("[]");
        }
        return sb.toString();
    }

}
