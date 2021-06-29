import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.concurrent.TransferQueue;

public class ArrayDeque<T> {
    private final int INITIAL_SIZE = 8;
    private static final int SIZE_PROPORTION = 2;
    private T[] items;
    public int ArraySize;//just test it;
    private int nextFirst, nextLast;
    private double loadingRadio;

    public int size(){
        if(isEmpty())
            return 0;
        return (nextLast - nextFirst - 1 + ArraySize) % ArraySize;
    }
    public ArrayDeque(){
        items = (T[])new Object[INITIAL_SIZE];
        ArraySize = INITIAL_SIZE;
        nextFirst = 0;
        nextLast = 0;
        loadingRadio = 0;
    }
    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        if(nextLast > nextFirst){
            System.arraycopy(items,nextFirst+1, a, 0, this.size());

            ArraySize = capacity;
            loadingRadio = size() / (double)ArraySize;
            nextLast = size();
            nextFirst = ArraySize - 1;

        }
        else if((nextFirst == nextLast && size() > 0) || nextFirst > nextLast){
            System.arraycopy(items, (nextFirst + 1) % ArraySize,a, 0, ArraySize - 1 - nextFirst);
            System.arraycopy(items, 0, a, ArraySize - 1 - nextFirst, nextLast);
            loadingRadio = size() /(double)capacity;
            nextLast = size();
            nextFirst = capacity - 1;
            ArraySize = capacity;
        }
        else
            ArraySize = capacity;
        items = a;
    }
    public ArrayDeque(ArrayDeque other){
        ArraySize = other.ArraySize;
        items = (T[])new Object[ArraySize];
        System.arraycopy(other.items,0, items, 0, ArraySize);
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        loadingRadio = other.loadingRadio;
    }
    public void addFirst(T item){
        if(size() == ArraySize - 1)
            resize(SIZE_PROPORTION * ArraySize);
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + ArraySize) % ArraySize;
        if(isEmpty())
            nextLast = (nextLast + 1) % ArraySize;
        loadingRadio =  ((nextLast - nextFirst - 1 + ArraySize) % ArraySize)/(double)ArraySize;
    }
    public void addLast(T item){
        if(size() == ArraySize - 1)
            resize(SIZE_PROPORTION * ArraySize);
        items[nextLast] = item;
        nextLast = (nextLast + 1) % ArraySize;
        if(loadingRadio == 0)
            nextFirst = (nextFirst - 1) % ArraySize;
        loadingRadio =  ((nextLast - nextFirst - 1 + ArraySize) % ArraySize)/(double)ArraySize;
    }
    public boolean isEmpty(){
        if(loadingRadio == 0)
            return true;
        return false;
    }
    public void printDeque(){
        if(isEmpty())
            return;
        int point = (nextFirst + 1) % ArraySize;

        while(point != nextLast){
            System.out.print(items[point] + " ");
            point = (point + 1) % ArraySize;
        }
    }
    public T removeFirst(){
        if(isEmpty())
            return null;
        nextFirst = (nextFirst + 1) % ArraySize;
        T item = items[nextFirst];
        loadingRadio = size()/(double)ArraySize;
        if(ArraySize > INITIAL_SIZE && loadingRadio < 0.25)
            resize((int)(0.5 * ArraySize));
        return item;
    }
    public T removeLast(){
        if(isEmpty())
            return null;
        nextLast = (nextLast - 1) % ArraySize;
        T item = items[nextLast];
        loadingRadio = size()/(double)ArraySize;
        if(ArraySize > INITIAL_SIZE && loadingRadio < 0.25)
            resize((int)(0.5 * ArraySize));
        return item;
    }
    public T get(int index){
        if(index < 0 || index >= size())
            return null;
        return items[(nextFirst + index + 1) % ArraySize];
    }



}
