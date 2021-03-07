package NB12;

public class MainIter {

    public static int powerIter(int base, int exponent) {
        int result = 1;

        while(exponent != 0) {
            result *= base;
            --exponent;
        }
        return result;
    }

    public static void main(String[] args) {

        int base = 3, exponent = 4;

        System.out.println(powerIter(base,exponent));
    }
}