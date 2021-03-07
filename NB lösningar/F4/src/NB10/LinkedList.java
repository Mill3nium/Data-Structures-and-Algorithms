package NB10;

public class LinkedList<E> {
    private static class Node<E>{
        private Node<E> next;
        private Node<E> prev;
        private E data;

        public Node(E element, Node<E> next){
            this.data = element;
            this.prev = null;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        int size = 0;
    }

    public boolean offerFirst( E item){
        head = new Node<E>(item, head);
        if(size == 0){
            tail = head;
        }
        head.prev = null;

        size++;
        return true;
    }

//    public void offerLast( E item) {
//        Node<E> newNode = new Node<>(item, tail);;
//        tail.next = newNode;
//
//       // if(nodeBefore == tail){
//            tail = newNode;
//        }
//        //nrOfElements++;
//    }

    @Override public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> nodeRef = head;

        while(nodeRef!= null){
            sb.append(nodeRef.data).append(" + ");
            nodeRef = nodeRef.next;
        }
        return sb.toString();
    }
}
