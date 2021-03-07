package NB221;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree<>();
        char[] letters = {'H', 'B', 'N', 'A', 'E', 'C', 'F', 'D'};

        for (int i = 0; i < 8; i++) {
            bst.add(letters[i]);
        }
        bst.levelOrder(bst.root);

    }

    public static class BinarySearchTree<E extends Comparable<E>> {

        private Node<E> root;

        private void levelOrder(Node<E> root) {
            if (root == null)
                return;

            Queue<Node> q = new LinkedList<>();

            // Pushing root node into the queue.
            q.add(root);

            // Pushing delimiter into the queue.
            q.add(null);

            // Executing loop till queue becomes
            // empty
            while (!q.isEmpty()) {

                //get element
                Node currentElement = q.poll();

                // condition to check the
                // occurence of next level
                if (currentElement == null) {
                    if (!q.isEmpty()) {
                        q.add(null);
                        System.out.println();
                    }
                } else {
                    // Pushing left child current node
                    if (currentElement.left != null) {
                        q.add(currentElement.left);
                    }

                    // Pushing right child current node
                    if (currentElement.right != null) {
                        q.add(currentElement.right);
                    }

                    if (currentElement.data == root.data) {
                        System.out.println(currentElement.data);
                    }
                    System.out.print(currentElement.left + " ");
                    System.out.print(currentElement.right + " ");
                }
            }
        }

        private boolean add(E data, Node<E> node) {
            if (data.compareTo(node.data) == 0) {
                return false;
            } else if (data.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<E>(data);
                    return true;
                } else {
                    return add(data, node.left);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<>(data);
                    return true;
                } else {
                    return add(data, node.right);
                }
            }
        }

        public boolean add(E data) {
            if (root == null) {
                root = new Node<E>(data);
                return true;
            } else {
                return add(data, root);
            }

        }

        private void inOrder(Node<E> node, StringBuilder sb) {
            if (node != null) {
                inOrder(node.left, sb);
                sb.append(":" + node.toString());
                inOrder(node.right, sb);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            inOrder(root, sb);
            //postorder(root);
            //preorder(root);
            return sb.toString();
        }

        private class Node<E> {
            private E data;
            private Node<E> left, right;


            private Node(E d) {
                this.data = d;
                left = right = null;
            }

            public void BinarySearchTree() {
                root = null;
            }

            @Override
            public String toString() {
                return data.toString();
            }
        }
    }
}


