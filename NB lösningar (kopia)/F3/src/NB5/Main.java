package NB5;

public class Main {
    public static void main(String[] args) {
        MyStack s1 = new MyStack();

        System.out.println(s1.toString());
        System.out.println("Empty?: "+s1.empty()+"\n");

         s1.push(1);
         s1.push(2);
         s1.push(3);
         s1.push(4);
         s1.push(5);
        System.out.println(s1.toString());
        System.out.println("Empty?:" + s1.empty());
        System.out.println("Top: " + s1.peek()+"\n");


        System.out.println("Remove top: "+s1.pop());
        System.out.println(s1.toString());
        System.out.println("Remove top: "+s1.pop());
        System.out.println(s1.toString());
        System.out.println("Remove top: "+s1.pop());
        System.out.println(s1.toString()+"\n");

        s1.push(999);
        System.out.println("Push 999: " + s1.toString()+"\n");

        System.out.println("Add illegal element(m):");
        s1.push('m');
        System.out.println(s1.toString());
    }
}
