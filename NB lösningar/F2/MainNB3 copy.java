package NB3;

public class MainNB3 {

    public static void main(String[] args) {
            Node[] l1 = new Node[5];

            l1[0] = new Node("Head");

            l1[1] = new Node("Gilgamesh");
            l1[2] = new Node("Löper");
            l1[3] = new Node("På");
            l1[4] = new Node("Stäppen");

            //Connecting nodes
            l1[0].next = l1[1];
            l1[1].next = l1[2];
            l1[2].next = l1[3];
            l1[3].next = l1[4];

            Node nodeRef = new Node("ref");
            nodeRef.next = l1[0].next;

            int i = 1;
            while(nodeRef.next!= null){ //s.95
                System.out.print(nodeRef.next.data);
                nodeRef.next = l1[i++].next;
                if(nodeRef.next != null){
                    System.out.print(" --> ");
                }
            }

            System.out.println("\n");

            //Remove Node
            l1[2].next = l1[2].next.next;
            l1[3].next = null;

            System.out.println("Removing: På ...");

            i=1;
            nodeRef.next = l1[0].next;
            while(nodeRef.next!= null){
                System.out.print(nodeRef.next.data);
                nodeRef.next = l1[i++].next;
                if(nodeRef.next != null){
                    System.out.print(" --> ");
                }
            }

            System.out.println("\n");

            //merge two lists
            Node[] l2 = new Node[3];
            Node[] l3 = new Node[3];

            l2[0] = new Node("Head");
            l2[1] = new Node("1");
            l2[2] = new Node("2");

            l3[0] = new Node("Head");
            l3[1] = new Node("3");
            l3[2] = new Node("4");

            l2[0].next = l2[1];
            l2[1].next = l2[2];

            l2[2].next = l3[0].next;
            l3[0].next = l3[1];
            l3[1].next = l3[2];

        i=0;
        int j = 0;
        nodeRef.next = l2[0].next;
        while(nodeRef.next!= null){
            System.out.print(nodeRef.next.data);
            nodeRef.next = l2[i++].next;
            if(l2[i].next == null){
                nodeRef.next = l3[j++].next;
            }
            if(nodeRef.next != null){
                System.out.print(" --> ");
            }

        }
    }
}
