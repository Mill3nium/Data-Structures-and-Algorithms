package p1;

import java.util.*;

public class Main {

    public static void delete(ArrayList<String> aList, String target){
        for(int i = 0; i < aList.size();i++){
            if(aList.get(i).equals(target)){
                aList.remove(aList.get(i));
                break;
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

        System.out.println();
        System.out.println("Remove Value:9");

        delete(l,"Value:9");
        System.out.println(l.toString());
    }
}
