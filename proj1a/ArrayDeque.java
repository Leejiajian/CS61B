public class ArrayDeque<T> {
    private final int INITIAL_SIZE = 8;
    private static final int SIZE_PROPORTION = 2;
    private T[] items;
    private int arraySize;
    private int nextFirst, nextLast;
    private double loadingRadio;

    public int size() {
        if(isEmpty())
            return 0;
        return (nextLast - nextFirst - 1 + arraySize) % arraySize;
    }
    public ArrayDeque() {
        items = (T[])new Object[INITIAL_SIZE];
        arraySize = INITIAL_SIZE;
        nextFirst = 0;
        nextLast = 0;
        loadingRadio = 0;
    }
    private void resize(int capacity) {
        T[] a = (T[])new Object[capacity];
        if(nextLast > nextFirst){
            System.arraycopy(items,nextFirst+1, a, 0, this.size());

            arraySize = capacity;
            loadingRadio = size() / (double)arraySize;
            nextLast = size();
            nextFirst = arraySize - 1;

        }
        else if((nextFirst == nextLast && size() > 0) || nextFirst > nextLast) {
            System.arraycopy(items, (nextFirst + 1) % arraySize,a, 0, arraySize - 1 - nextFirst);
            System.arraycopy(items, 0, a, arraySize - 1 - nextFirst, nextLast);
            loadingRadio = size() /(double)capacity;
            nextLast = size();
            nextFirst = capacity - 1;
            arraySize = capacity;
        }
        else{
            arraySize = capacity;
            nextFirst = nextLast = 0;
            loadingRadio = 0;
        }

        items = a;
    }
    /*
        public ArrayDeque(ArrayDeque other){
        arraySize = other.arraySize;
        items = (T[])new Object[arraySize];
        System.arraycopy(other.items,0, items, 0, arraySize);
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        loadingRadio = other.loadingRadio;
    }
    */

    public void addFirst(T item){
        if(size() == arraySize - 1)
            resize(SIZE_PROPORTION * arraySize);
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + arraySize) % arraySize;
        if(isEmpty())
            nextLast = (nextLast + 1) % arraySize;
        loadingRadio =  ((nextLast - nextFirst - 1 + arraySize) % arraySize)/(double)arraySize;
    }
    public void addLast(T item){
        if(size() == arraySize - 1)
            resize(SIZE_PROPORTION * arraySize);
        items[nextLast] = item;
        nextLast = (nextLast + 1) % arraySize;
        if(loadingRadio == 0)
            nextFirst = (nextFirst - 1 + arraySize) % arraySize;
        loadingRadio =  ((nextLast - nextFirst - 1 + arraySize) % arraySize)/(double)arraySize;
    }
    public boolean isEmpty(){
        if(loadingRadio == 0.0)
            return true;
        return false;
    }
    public void printDeque(){
        if(isEmpty())
            return;
        int point = (nextFirst + 1) % arraySize;

        while(point != nextLast){
            System.out.print(items[point] + " ");
            point = (point + 1) % arraySize;
        }
    }
    public T removeFirst(){
        if(isEmpty())
            return null;
        nextFirst = (nextFirst + 1) % arraySize;
        T item = items[nextFirst];
        loadingRadio = size()/(double)arraySize;
        if(loadingRadio == 0)
            nextLast = (nextLast - 1 + arraySize) % arraySize;
        if(arraySize > INITIAL_SIZE && loadingRadio < 0.25)
            resize((int)(0.5 * arraySize));
        return item;
    }
    public T removeLast(){
        if(isEmpty())
            return null;
        nextLast = (nextLast - 1) % arraySize;
        T item = items[nextLast];
        loadingRadio = size()/(double)arraySize;
        if(loadingRadio == 0)
            nextLast = (nextLast - 1 + arraySize) % arraySize;
        if(arraySize > INITIAL_SIZE && loadingRadio < 0.25)
            resize((int)(0.5 * arraySize));
        return item;
    }
    public T get(int index){
        if(isEmpty())
            return null;
        if(nextLast > nextFirst && (index <= nextFirst || index >= nextLast))
            return null;
        if(nextFirst > nextFirst && (index >= nextLast || index <= nextFirst))
            return null;
        return items[(nextFirst + index + 1) % arraySize];
    }



}
