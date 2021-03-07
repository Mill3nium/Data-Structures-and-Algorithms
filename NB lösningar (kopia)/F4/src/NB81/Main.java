package NB81;

public class Main {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);

        System.out.println(aq.toString()+"\n");

        aq.offer(1);
        aq.offer(2);
        aq.offer(3);
        aq.offer(4);
        aq.offer(5);
        System.out.println(aq.toString());

        aq.offer(6);
        System.out.println(aq.toString());

        aq.offer(7);
        aq.offer(8);
        aq.offer(9);
        aq.offer('a');
        aq.offer('b');
        System.out.println(aq.toString());

        aq.poll();
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
