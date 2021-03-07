package NB7;

import java.util.*;

public class LinkedStack<E> implements StackInt<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E element, Node<E>ref){
            this.data = element;
            this.next = ref;
        }
    }
    private Node<E> top;


    public LinkedStack(){
        this.top = null;
    }

    @Override
    public E push(E item) {
        top = new Node<E>(item,top);
        return item;
    }

    @Override
    public E pop() throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }else{
            E deletedItem = top.data;
            top = top.next;
            return deletedItem;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public E peek() throws EmptyStackException {
        if(empty()){
            throw new EmptyStackException();
        }else{
            return top.data;
        }
    }

    public int size(){
        Node<E> nodeRef = top;
        int size = 0;
        while(nodeRef!=null){
            size++;
            nodeRef = nodeRef.next;
        }
        return size;
    }

    public E flush(){
        Node<E> lastElement = null;

        while (top!= null){
            if(top.next == null){
                lastElement = top;
                top= null;
                return (E) lastElement;
            }
            top = top.next;
        }
        return (E) lastElement;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> nodeRef = top;

        if(nodeRef == null){
            sb.append("| EMPTY LIST |");
        }else {
            while (nodeRef != null) {
                sb.append(nodeRef.data);
                if (nodeRef.next != null) {
                    sb.append(" --> ");
                }
                nodeRef = nodeRef.next;
            }
        }
        return sb.toString();
    }
}
