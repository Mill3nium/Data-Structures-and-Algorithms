package NB262;

import java.util.*;

public class Main {

    public static String uniqueValues(ArrayList<String> values){
        StringBuilder sb = new StringBuilder();
        // convert ArrayList to HastSet.
        HashSet<String> uniqueValues = new HashSet<>(); // Filters all the duplicates
        uniqueValues.addAll(values);

        var count = 0;
        for(var u: uniqueValues){
            count++;
            sb.append(u + " ");
        }
        sb.append(" , Nr of unique words: " +  count );

        return sb.toString();
    }

    public static void main(String[] args)
    {

        // Create ArrayList
        ArrayList<String> ArrList = new ArrayList<String>();

        // add values in ArrayList
        ArrList.add("Milan");
        ArrList.add("Robin");
        ArrList.add("Leo");
        ArrList.add("Mohamed");
        ArrList.add("Milan");
        ArrList.add("Milan");
        ArrList.add("Milan");

        // display original ArrayList
        System.out.println("Original ArrayList is : " + ArrList);
        System.out.println(uniqueValues(ArrList));
    }
}
