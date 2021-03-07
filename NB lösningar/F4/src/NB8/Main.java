package NB8;

public class Main {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(20);

        //empty
        System.out.println(aq.toString());

        aq.offer(1);
        System.out.println(aq.toString());
        aq.offer(2);
        System.out.println(aq.toString());
        aq.offer(3);
        System.out.println(aq.toString());
        aq.offer(4);
        System.out.println(aq.toString());
        aq.offer(5);
        System.out.println(aq.toString());
        aq.offer(6);
        System.out.println(aq.toString());
        aq.offer(7);
        System.out.println(aq.toString());
        aq.offer(8);
        System.out.println(aq.toString());
        aq.offer(9);
        System.out.println(aq.toString());
        aq.offer(10);
        System.out.println(aq.toString());
        aq.offer(11);
        System.out.println(aq.toString());
        aq.poll();
        aq.poll();
        aq.poll();
        aq.poll();
        aq.poll();
        aq.poll();
        aq.poll();
        aq.poll();

        System.out.println(aq.toString());

    }
}
