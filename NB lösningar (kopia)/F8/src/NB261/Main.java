package NB261;

import java.util.*;

public class Main {
    // Function to calculate the most frequent word in the array.
    public static void FrequentWord(String array[])
    {
        // Insert all unique strings and update count if a string is not unique.
        Map<String,Integer> hshmap = new HashMap<String, Integer>();
        String tempMax = null;
        int occurance = 0;

        for (String str : array)
        {
            int nrOfOccurances = 0;

            if (hshmap.keySet().contains(str)) // if already exists then update count.
            {
                nrOfOccurances = hshmap.get(str);// Gets nr of occurances
                hshmap.put(str, ++nrOfOccurances) ;//Adds the new value to hashmap
            }
            else {
                nrOfOccurances = 1;
                hshmap.put(str, 1); // else insert it in the map.
            }

            if(nrOfOccurances > occurance){ //Find new max value
                tempMax = str;
                occurance = nrOfOccurances;
            }
        }
        //System.out.println(tempMax );

        System.out.println("Most frequent word: "+ tempMax);
        System.out.println("Count: "+ occurance);
    }

    // Main
    public static void main(String[] args)
    {
        String[] arr = { "Milan", "Mohamed", "Robin" , "Robin", "Robin" };
        FrequentWord(arr);
    }
}
