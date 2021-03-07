package NB263;

import javax.xml.transform.*;

public class Main {

    public static void main(String[] args) {
        HashTable h1 = new HashTable();

        h1.put(1,"A");
        h1.put(2,"B");
        h1.put(3,"C");
        h1.put(4,"D");
        h1.put(1,"m");

        System.out.println(h1.get(1));
        System.out.println(h1.get(2));
        System.out.println(h1.get(3));
        System.out.println(h1.get(4));

        System.out.println();
        h1.remove(3);
        System.out.println(h1.get(3));

        System.out.println();
        System.out.println(h1.find(1));
    }
}
