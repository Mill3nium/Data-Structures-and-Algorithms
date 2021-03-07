package nb0;

import javax.xml.transform.*;

public class Main {

    public static void main(String[] args) {
        MArrayList m1 = new MArrayList();

        //test functionallity
        m1.add(1);
        m1.add(2);
        m1.add(3);
        m1.add(4);
        m1.add(5);
        m1.add(6);
        m1.add(7);
        m1.add(8);
        m1.add(9);
        m1.add(10);

        System.out.println(m1.toString());
        System.out.println(m1.indexOf(5));

        System.out.println("\nRemove index 9:");
        m1.remove(9);
        System.out.println(m1.toString());

        System.out.println("\nSet index 0 to 555");
        m1.set(0,555);
        System.out.println(m1.toString());

        System.out.println("\nAdd 99 to index 5");
        m1.add(5,99);
        System.out.println(m1.toString());
    }
}
