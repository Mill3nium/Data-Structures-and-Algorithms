package upg3;

import java.util.*;

public class SingleLinkedList<E> implements  Iterable<E>{

    private class Itr implements Iterator<E> {

        Node<E> current;
        Node<E> bCurrent;
        Node<E> bbCurrent;
        private boolean okToRemove;

        public Itr(Node<E> start) {
            this.current = start;
            this.bCurrent = null;
            this.bbCurrent = null;
            okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            E returnValue = current.data;
            bbCurrent = bCurrent;
            bCurrent = current;
            current = current.next;
            okToRemove = true;
            return returnValue;
        }

        @Override
        public void remove() {
            if(!okToRemove){
                throw new IllegalStateException();
            }
            if(bbCurrent == null){
                head = current;
            }else{
                bbCurrent.next = current;
            }
            bCurrent = bbCurrent;
            nrOfElements--;
            okToRemove = false;

        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Current: "+ current.data+"\n");
            if(bCurrent!= null) {
                sb.append("bCurrent: " + bCurrent.data + "\n");
            }
            if(bbCurrent!= null) {
                sb.append("bbCurrent: " + bbCurrent.data);
            }
            return sb.toString();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private int nrOfElements;

    public SingleLinkedList(){
        this.head = null;
        nrOfElements = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > nrOfElements) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> nodeBefore = getNode(index - 1);
            addAfter(nodeBefore, item);
        }
    }

    public boolean add(E item) {
        add(nrOfElements, item);
        return true;
    }

    public void addFirst(E item) {
        head = new Node<>(item, head);
        nrOfElements++;
    }

    private void addAfter(Node<E> nodeBefore, E item) {
        nodeBefore.next = new Node<>(item, nodeBefore.next);
        nrOfElements++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> nodeRef = head;

        if(nrOfElements != 0) {
            while (nodeRef != null) {
                sb.append(nodeRef.data);
                if (nodeRef.next != null) {
                    sb.append(" --> ");
                }
                nodeRef = nodeRef.next;
            }
        }else{
            sb.append("[ Empty List ]");
        }

        return sb.toString();
    }
}
