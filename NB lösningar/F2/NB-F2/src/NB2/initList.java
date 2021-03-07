package NB2;

import java.lang.reflect.*;
import java.util.*;

public class initList<toString> {

    private int maxSize;
    private int nrOfElements;
    private int[] theData;

    public initList(int initialCapacity){
        this.maxSize= initialCapacity;
        this.theData = new int[initialCapacity];
        this.nrOfElements = 0;
    }

    public void reallocate(){
        maxSize*=2;
        theData = Arrays.copyOf(theData,maxSize);
    }

    public boolean add(int element){
        if(nrOfElements == maxSize){
            reallocate();
        }
        theData[nrOfElements++] = element;
        return true;
    }

    public void add(int index, int element) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index > nrOfElements){
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        if(nrOfElements == maxSize){
            reallocate();
        }
        for(int i = nrOfElements; i > index; i--){
            theData[i] = theData[i-1];
        }
        theData[index] = element;
        nrOfElements++;
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >nrOfElements){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theData[index];
    }

    public int set(int index, int newValue) throws ArrayIndexOutOfBoundsException {
        if(index<0 || index >= nrOfElements){
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        int oldValue = theData[index];
        return oldValue;
    }


    public int indexOf(int element) {
        int index = -1;
        for (int i = 0; (i < theData.length && index == -1); i++) {
            if (theData[i] == element) {
                index = i;
            }
        }
        return index;
    }

    public int remove(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= nrOfElements){
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        int returnValue = theData[index];
        for(int i = index + 1; i < nrOfElements; i++){
            theData[i-1] = theData[i];
        }
        nrOfElements--;
        return returnValue;
    }

    public int size(){
        return nrOfElements;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer();

      for(int i = 0; i < size(); i ++){
          if (i == nrOfElements) {
              sb.append(" ");
          }else if(i != 0){
              sb.append(", ");
          }
          sb.append(theData[i]);
      }
      return sb.toString();
    }
}
