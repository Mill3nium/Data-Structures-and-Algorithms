package NB3;

import java.util.*;

public class MainNB3 {

    public static void main(String[] args) {
        Node n1 = new Node("Gilgamesh");
        Node n2 = new Node("Löper");
        Node n3 = new Node("På");
        Node n4 = new Node("Stäppen");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node nodeRef = n1;

        while(nodeRef != null){
            System.out.print(nodeRef.data);
            if(nodeRef.next!=null){
                System.out.print(" --> ");
            }
            nodeRef = nodeRef.next;
        }

        System.out.println("\n");

        n2.next=n3.next;
        n3.next=null;

        nodeRef = n1;

        while(nodeRef != null){
            System.out.print(nodeRef.data);
            if(nodeRef.next!=null){
                System.out.print(" --> ");
            }
            nodeRef = nodeRef.next;
        }

        System.out.println("\n");

        //Two merged lists
        //list 1
        Node e1 = new Node("Milan");
        Node e2 = new Node("Robin");
        Node e3 = new Node("Elon");

        e1.next = e2;
        e2.next = e3;

        //list 2
        Node f1 = new Node("KTH");
        Node f2 = new Node("SU");
        Node f3 = new Node("LTH");

        f1.next = f2;
        f2.next = f3;

        //merge
        e3.next = f1;

        nodeRef = e1;
        while(nodeRef != null){
            System.out.print(nodeRef.data);
            if(nodeRef.next!=null){
                System.out.print(" --> ");
            }
            nodeRef = nodeRef.next;
        }

        System.out.println("\n");

        //cut list in the middle
        e3.next = null;

        nodeRef = e1;
        while(nodeRef != null){
            System.out.print(nodeRef.data);
            if(nodeRef.next!=null){
                System.out.print(" --> ");
            }
            nodeRef = nodeRef.next;
        }
    }
}
