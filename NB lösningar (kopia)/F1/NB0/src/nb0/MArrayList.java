package nb0;
import java.util.Arrays;

public class MArrayList<E> {

    private E[] data;
    private int nrElements;
    private int maxSize = 10;

    public MArrayList(){
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element) throws ArrayIndexOutOfBoundsException{
        if(nrElements == maxSize){
            reallocate();
        }
        data[nrElements++] = element;
        return true;
    }

    public void add(int index,E element){
        if(0<=index && index<=nrElements){
            if(nrElements==maxSize){
                reallocate();
            }
            for(int i= nrElements; i>index;i--) {
                 data[i] = data[i - 1];
            }
                data[index] = element;
                nrElements++;
                return;
            }
        throw new ArrayIndexOutOfBoundsException(index);
    }


    public E get(int index) throws ArrayIndexOutOfBoundsException{
        if(index<0 && index>=maxSize){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }

    public E set(int index, E newValue){
        if(index < 0 || index >= maxSize){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = data[index];
        data[index] = newValue;
        return oldValue;
    }

    public void reallocate(){
        maxSize*=2;
        data = Arrays.copyOf(data,maxSize);
    }

    public E remove(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= nrElements){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = data[index];
        for(int i = index + 1; i < nrElements; i++){
            data[i-1] = data[i];
        }
        nrElements--;
        return returnValue;
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; (i < data.length && index == -1); i++) {
            if (data[i] == element) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(int i = 0;i<nrElements;i++){
            if (data[i] == null) {
                s.append(" ");
            } else {
                s.append(data[i]).append(", ");
            }
        }
        return s.toString();
    }
}
