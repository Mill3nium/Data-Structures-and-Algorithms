package NB12;

public class Main {

    public static double power(double x, int n){
        if(n == 0){//basfall
            return 1;
        }else{
            return x * power(x,n-1);
        }
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println(power(5,2));
    }
}
