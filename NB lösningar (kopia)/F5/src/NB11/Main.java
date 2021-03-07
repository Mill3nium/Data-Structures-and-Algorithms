package NB11;

public class Main {


    public static int findMaxInt(int A[], int length)
    {
        if(length == 1) // basfall
            return A[0];
        else {
            //int num = Math.max(A[n - 1], findMaxInt(A, n - 1));
            return Math.max(A[length - 1], findMaxInt(A, length - 1));
        }
    }

    public static void main(String[] args) {
	    int[] a = new int[5];

        a[0] = 1;
        a[1] = 2;
        a[2] = 5;
        a[3] = 4;
        a[4] = 3;

        System.out.println(findMaxInt(a,5));
    }
}
