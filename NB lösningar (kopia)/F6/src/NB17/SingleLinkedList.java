package NB17;

public class SingleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int nrOfElements;

    public SingleLinkedList() {
        this.tail = null;
        this.head = null;
        this.nrOfElements = 0;
    }

    public static void main(String[] args) {
        SingleLinkedList l1 = new SingleLinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        System.out.println(l1);
        System.out.println(l1.getNode(2).data);

    }

    public E getTail() {
        return tail.data;
    }

    public E getHead() {
        return head.data;
    }

    public boolean add(E item) {
        add(nrOfElements, item);
        return true;
    }

    public void add(int index, E item) throws IndexOutOfBoundsException {
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

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        if (nrOfElements == 0) {
            tail = head;
        }
        nrOfElements++;
    }

    public void addAfter(Node<E> nodeBefore, E item) {
        Node<E> newNode = new Node<>(item, nodeBefore.next);
        ;
        nodeBefore.next = newNode;

        if (nodeBefore == tail) {
            tail = newNode;
        }
        nrOfElements++;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= nrOfElements) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        E deletedItem;
        if (index == 0) {
            deletedItem = head.data;
            head = head.next;// head.next is null if head == tail
            if (tail == head) {
                tail = null;//uppdatera tail
            }
        } else {
            Node<E> before = getNode(index - 1); // gets the index before
            deletedItem = before.next.data;
            before.next = before.next.next;

            if (deletedItem == tail) {
                tail = before;
            }
        }
        nrOfElements--;
        return deletedItem;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= nrOfElements) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> node = getNode(index);
        return node.data;
    }

    private Node<E> getNode(int index){ // wrapper
        if (index == 0){
            return head;
        }
        if (index == nrOfElements-1){
            return tail;
        }

        return getNode(index,head);
    }

    private Node<E> getNode(int index, Node<E> node){
        if (index == 0){//basfall
            return node;
        }
        return getNode(index-1,node.next);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" --> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}