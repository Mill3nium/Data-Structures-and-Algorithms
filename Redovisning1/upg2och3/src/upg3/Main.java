package upg3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add("e" + i);
        }

        Iterator<String> iter = list.iterator();
        iter.next();
       // iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        System.out.println(list);

    }
}
