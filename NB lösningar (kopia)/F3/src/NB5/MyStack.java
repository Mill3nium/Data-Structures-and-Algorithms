package NB5;
import java.util.*;

public class MyStack<E> implements StackInt<E>{

    private ArrayList<E> values;

    public MyStack() {
        this.values = new ArrayList<E>();
    }

    @Override
    public E push(E item) {
        if(item instanceof Integer){
            values.add(item);
        }
        return item;
    }

    @Override
    public E peek() throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }
        return values.get(values.size() -1);
    }

    @Override
    public E pop() throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }
        E ret = values.get(values.size()-1);
        values.remove(values.size()-1);
        return ret;
    }

    @Override
    public boolean empty() {
        return values.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (values.size() == 0) {
            sb.append("[]");
            return sb.toString();
        }
        sb.append("[");
        for (int i = 0; i < values.size(); i++) {
            if(i!= 0){
                sb.append(",");
            }
            sb.append(values.get(i) );
        }
        sb.append("]");

        return sb.toString();
    }
}

