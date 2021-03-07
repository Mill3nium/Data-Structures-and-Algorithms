package SC23;

public class MainSC23 {

    public static void sort1(int[] anArray){
        for(int i = 3; i < anArray.length -1; i++){
            anArray[i + 1 ] = anArray[i];
        }
    }

    public static void sort2(int[] anArray){
        for(int i = anArray.length -1; i > 3; i--){
            anArray[i - 1 ] = anArray[i];
        }
    }

    public static void placeMiddleAtEnd(int[] anArray){

        int middleValue = anArray[anArray.length/2];
        int index = anArray.length / 2;

        for(int i = index ; i < anArray.length-1; i++ ){
            anArray[i] = anArray[i +1];
        }
        anArray[anArray.length-1] = middleValue;
    }

    public static void main(String[] args) {
        int[] a1 = {0,1,2,3,4,5,6,7,8,9};
        int[] a2 = new int[10];

        System.arraycopy(a1,0,a2,0,a1.length);

        sort1(a1);
        sort2(a2);

        for(int i = 0; i < 8 ; i++){
            System.out.print(a1[i]);
            System.out.print(" ");
        }
//        System.out.println();
//        System.out.println();
//        for(int i = 0; i < 8 ; i++){
//            System.out.print(a2[i]);
//            System.out.print(" ");
//        }
        System.out.println();
        System.out.println();

        for(int i = 0; i < 8 ; i++){
            System.out.print(a1[i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Remove middle element, place at end");
        placeMiddleAtEnd(a1);

        for(int i = 0; i < 8 ; i++){
            System.out.print(a1[i]);
            System.out.print(" ");
        }

    }
}
