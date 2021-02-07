package upg2;

public class SingleLinkedList<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int nrOfElements;

    public SingleLinkedList(){
        this.tail = null;
        this.head = null;
        this.nrOfElements = 0;
    }

    public E getTail(){
        return tail.data;
    }

    public E getHead(){
        return head.data;
    }

    public boolean add(E item) {
        add(nrOfElements, item);
        return true;
    }

    public void add(int index, E item) throws IndexOutOfBoundsException{
        if (index < 0 || index > nrOfElements) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item){
        head = new Node<E>(item,head);
        if(nrOfElements== 0){
            tail = head;
        }
        nrOfElements++;
    }

    public void addAfter(Node<E> nodeBefore, E item) {
        Node<E> newNode = new Node<>(item, nodeBefore.next);;
        nodeBefore.next = newNode;

        if(nodeBefore == tail){
            tail = newNode;
        }
        nrOfElements++;
    }

    public E remove(int index)throws IndexOutOfBoundsException  {
        if (index < 0 || index >= nrOfElements) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        E deletedItem;
        if (index == 0) {
            deletedItem = head.data;
            head = head.next;
            //uppdatera tail
        } else {
            Node<E> before = getNode(index - 1); // gets the index before
            deletedItem = before.next.data;
            before.next = before.next.next;

            if(deletedItem == tail){
                tail = before;
            }
        }
        nrOfElements--;
        return deletedItem;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index<0 || index >= nrOfElements){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> node = getNode(index);
        return node.data;
    }

    public Node<E> getNode(int index) {
        if(index == 0){
            return head;
        } else if(index == nrOfElements-1){
            return tail;
        }

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
