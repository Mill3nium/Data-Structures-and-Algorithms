package TEST8;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTree(){
        root=null;
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }

    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }else{
            return add(data,root);
        }
    }

    public E find(E target){
        return find(target, root);
    }

    private E find(E target, Node<E> node){
        if(node==null)
            return null;
        //int order=target.compareTo(node.data);
        if(target.compareTo(node.data)==0)
            return node.data;
        if(target.compareTo(node.data)<0)
            return find(target,node.left);
        return find(target,node.right);
    }

    /**
     * Wrapper for getNextLarger method
     * @param value The object being searched for
     * @return The value of the second largest value, if larger than the last element, returns null
     * */
    public E getNextLarger(E value) {
        return getNextLarger(value,root);
    }

    /**
     *Returns the second largest object, if the submitted value is larger
     * than the stored element, return null, also if the list is empty
     * @param value Submitted value
     * @param node Root node
     * @return The value closest to the submitted value
     * */
    private E getNextLarger(E value, Node<E> node) {
        if(node==null)
            return null;
        int res = value.compareTo(node.data);
        if(res>0)
            return getNextLarger(value,node.right);
        if(res==0)
            return getNextLarger(value,node.right);

        E leftData = getNextLarger(value,node.left);
        if(leftData == null)
            return node.data;
        if(value.compareTo(leftData)<=0)
            return leftData;
        return node.data;
    }


}
