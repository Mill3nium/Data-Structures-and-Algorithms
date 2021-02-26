package upg8;

public class Main {

    public static void buildTree(BinarySearchTree<Integer> b, int[] v) {
        for (int data : v) {
            b.add(data);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        buildTree(bst, new int[]{30, 20, 40, 15, 25, 35, 45, 10, 17, 22, 27, 32, 37, 42, 47, 16, 23, 28, 39, 49, 29, 51});
        System.out.println(bst);

        for (int i = 0; i < 52; i++) {
            System.out.print("" + i + ":" + bst.getNextLarger(i) + "#");
        }
    }
}

