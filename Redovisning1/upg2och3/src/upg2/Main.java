package upg2;

import org.w3c.dom.*;

public class Main {

    public static void main(String[] args) {


        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 4; i++)
        {
            list.add(i,"e" + i);
        }
        list.remove(3);
        list.add(0,"först");
        list.add(4,"sist");
        System.out.println(list);

    }
}
