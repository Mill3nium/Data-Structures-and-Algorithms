package NB9;

public class Main {
    public static void main(String[] args) {
        ListQueue lq = new ListQueue();

        System.out.println(lq.toString());

        lq.offer(1);
        lq.offer(2);
        lq.offer(3);
        lq.offer(4);
        lq.offer(5);
        System.out.println(lq.toString());

        System.out.println("\nPoll: "+ lq.poll());
        lq.poll();
        lq.poll();
        lq.poll();
        lq.poll();
        System.out.println(lq.toString());
        System.out.println("Poll empty list : " + lq.poll());

    }
}
