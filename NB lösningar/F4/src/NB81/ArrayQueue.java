
package NB81;

import java.util.Arrays;

public class ArrayQueue<E>{
	private int front, rear, size, maxSize;
	private E[] data;

	public ArrayQueue(int initialSize){
		size = 0;
		front = 0;
		maxSize = initialSize;
		rear = 0;//rear = 0  ok
		data = (E[]) new Object[maxSize];
	}

	public boolean offer(E element){
		if(size==maxSize)
			reallocate();
		data[rear] = element;
        rear = (rear + 1 )%maxSize;//rear+1%maxSize; blir fel i beräkningen, vi vill öka rare med 1,
						// om den blir = maxSize ska den bli = 0.
		size++;
		return true;
	}

	public E peek(){
		if(size==0) return null;
		return data[front];
	}

	public E poll(){
		if(size==0){
			return null;
		}else{
			size--;
			E element = data[front];
			front =(front + 1 ) %maxSize;//front+1%maxSize; korrigering, öka front med 1
			return element;
		}	
	}

	private void reallocate() {
		//maxSize*=2;
		//data= Arrays.copyOf(data,maxSize); Går ej arrCopy pga att vi måste behålla ordningen från gamla arrayen.
		int newMaxSize = 2* maxSize; //Front kan tex ligga mitt i arrayen
		E[] newData= (E[]) new Object[newMaxSize];
		int j = front;
		for(int i = 0; i<size; i++){
			newData[i] = data[i];
			j = (j + 1) % maxSize;
		}
		front = 0;
		rear = size;
		maxSize= newMaxSize;
		data = newData;
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		if(size==0){
			sb.append("EMPTY");
			return sb.toString();
		}

		sb.append("Rear: " + rear + ", Front: " + front+"\n");
		for (int i = front; i != rear; i = (i+1)%maxSize) {
			sb.append(data[i]);
		}

		if(front == 0 && rear == 0 && size>0){
			for (int i = 0; i < size; i++) {
				sb.append(data[i]);
			}
		}

		return sb.toString();
	}
}