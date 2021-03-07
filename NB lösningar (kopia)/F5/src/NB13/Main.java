package NB13;

public class Main {

    public static double sqrtR (long x, double e, double a) {

        if (Math.abs(a * a - x) <= e) { //basfall
            return a;
        } else {
            a = (a * a + x) / (2 * a);
            return 1.0 *(sqrtR(x, e, a));
        }
    }
    public static void main(String[] args) {
        int n = 81,a = 1,e = 3;
        System.out.format("double : %."+e+"f", sqrtR(n,a,e));
    }
}
