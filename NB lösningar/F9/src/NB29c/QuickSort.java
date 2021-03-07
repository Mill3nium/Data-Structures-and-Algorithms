package NB29c;

public class QuickSort {

    public static void quickSort(int[] list,int first,int last){
        if(first < last){
            var pivIndex = partition(list,first,last);
            quickSort(list, first,pivIndex - 1);
            quickSort(list, pivIndex + 1,last);
        }
    }

    //split up the array
    public static int partition(int[] array, int first, int last)
    {
        var pivot = array[first];
        var up = first;
        var down = last;

        do{
            while ((up < last) && (pivot >= array[up])){
                up++;
            }
            while (pivot <array[down]){
                down--;
            }
            if(up<down){
                swap(array,up,down);
            }
        } while (up < down);

        swap(array,first,down);
        return down; // return index of the pivot value
    }

    public static void swap(int[] array,int first,int last){
        var tmp = array[first];
        array[first] = array[last];
        array[last] = tmp;
    }

    public static void main(String[] args) {
        int[] theData = new int[]{2, 10, 1,3,4};

        quickSort(theData,0,theData.length-1);
        System.out.println("Sorted: ");
        for(int var: theData){
            System.out.print(var + "\t");
        }
    }
}
