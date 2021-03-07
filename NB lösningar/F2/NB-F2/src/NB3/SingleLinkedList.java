package NB3;

public class SingleLinkedList<E> {
    private Node head;
    private int nrOfElements;

    public SingleLinkedList(){
        this.head = null;
        this.nrOfElements = 0;
    }

    public void addFirst(String element){
        head = new Node(element);
        nrOfElements++;
    }


}
