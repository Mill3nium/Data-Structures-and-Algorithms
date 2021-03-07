package NB2;

public class MainNB2 {

    public static void main(String[] args) {
        initList n1 = new initList(10);

        //test functionallity
        n1.add(1);
        n1.add(2);
        n1.add(3);
        n1.add(4);
        n1.add(5);
        n1.add(6);
        n1.add(7);
        n1.add(8);
        n1.add(9);
        //n1.add(10);

        System.out.println(n1.toString());

        n1.add(5,0);

        System.out.println(n1.toString());
    }
}
