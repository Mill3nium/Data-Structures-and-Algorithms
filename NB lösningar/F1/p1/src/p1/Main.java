package p1;

import java.util.*;

public class Main {

    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for(int i = 0; i< aList.size(); i++){
            if(aList.get(i).equals(oldItem)){
                aList.set(i,newItem);
            }
        }
    }

    public String toString(ArrayList<String> aList) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< aList.size(); i ++){
            sb.append(aList.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
	    ArrayList<String> l = new ArrayList<String>();

	    for(int i = 0; i < 10; i++ ){
	        l.add("Value:"+i);
        }
        System.out.println(l.toString());
        System.out.println();

        System.out.println("Set Value:0 to Value:555");
	    replace(l,"Value:0","Value:555");

        System.out.println(l.toString());
        
    }
}
