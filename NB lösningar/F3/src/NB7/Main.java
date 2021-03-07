package NB7;

public class Main {
    public static void main(String[] args) {
        LinkedStack l1 = new LinkedStack();

        System.out.println(l1.toString()+"\n"); // print empty list
        l1.push(1);
        l1.push(2);
        l1.push(3);
        l1.push(4);
        l1.push(5);
        l1.push(6);
        System.out.println(l1.toString());
        System.out.println("Peek on top: " +l1.peek()+"\n");

        System.out.println("Pop: " + l1.pop());
        System.out.println(l1.toString()+ "\n");

        l1.flush();
        System.out.println(l1.toString()+"\n");

        l1.push(1);
        l1.push(2);
        l1.push(3);
        System.out.println(l1.toString()+"\n"); // print empty list

        l1.pop();
        l1.pop();
        l1.pop();
        System.out.println(l1.toString());
    }
}
