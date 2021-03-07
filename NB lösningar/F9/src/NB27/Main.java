package NB27;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Car[] carList = new Car[10];
        String carBrand;
        int yearModel;
        int nrOfMiles;

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("/Users/milanlanguric/Desktop/Algoritmer & datastrukturer/Övningsuppgifter & NB/NB lösningar/F9/src/NB27/Cars.txt"));

            int i = 0;
            String line = in.readLine();
            while (line != null) {
                carBrand = line;
                line = in.readLine();
                yearModel = Integer.parseInt(line);
                line = in.readLine();
                nrOfMiles = Integer.parseInt(line);
                line = in.readLine();
                carList[i] = new Car(carBrand,yearModel,nrOfMiles);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            if(in!=null)in.close();
        }

        System.out.println("Unsorted list: ");
        for(int i = 0; i<carList.length ; i++){
            System.out.println("Car "+ (i+1) + ": "+ carList[i]);
        }
        System.out.println();

        Arrays.sort(carList);
        System.out.println("Sorted list: ");
        for(int i = 0; i<carList.length ; i++){
            System.out.println("Car "+ (i+1) + ": "+ carList[i]);
        }

        PrintWriter pr = null;
        try {
            pr = new PrintWriter("/Users/milanlanguric/Desktop/Algoritmer & datastrukturer/Övningsuppgifter & NB/NB lösningar/F9/src/NB27/newList.txt");

            for (int i=0; i<carList.length ; i++) {
                pr.println(carList[i]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }finally {
            if(pr!=null)pr.close();
        }

        //test CompareCar class
        System.out.println();
        System.out.println("Sort by model year: ");
        Arrays.sort(carList,new CompareCar());
        for(int i = 0; i<carList.length ; i++){
            System.out.println("Car "+ (i+1) + ": "+ carList[i]);
        }

    }
}
