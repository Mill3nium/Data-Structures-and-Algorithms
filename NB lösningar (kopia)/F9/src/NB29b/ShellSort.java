package NB29b;

public class ShellSort {

    public static void shellSort(int[] list){
        int gap = list.length/2;
        int temp = 0;

        while (gap > 0) {
            for(int i = gap; i<list.length; i++){
                temp = list[i];
                int dataIndex = i;

                while(dataIndex>=gap-1 && temp < list[dataIndex]){
                    list[dataIndex] = list[dataIndex-gap];
                    dataIndex-=gap;
                }
                list[dataIndex] = temp;
            }
            if(gap == 2){
                gap =1;
            }else
                gap /=2.2;
        }

    }

    public static void main(String[] args) {
        int[] theData = new int[]{2, 10, 1,3,4};
        shellSort(theData);

        System.out.println("Sorted: ");
        for(int i = 0; i<theData.length; i++){
            System.out.print(theData[i] + "\t");
        }
    }
}
