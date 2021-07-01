/** Array based list.
 *  @author Josh Hug
 */

public class AList<T> {
    /** Creates an empty list. */
    private static final int INITIAL_SIZE = 100;
    private T[] items;
    private int size;
    public AList() {
        items = (T[])new Object[INITIAL_SIZE];
        size = 0;
    }
    /** resizing */
    public void resize(int capacity) {
           T[] a = (T[])new Object[capacity];
           System.arraycopy(items, 0, a, 0, size);
           items = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if(size == items.length) {
            resize(2 * size);
        }
        items[size] = x;
        ++size;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        return items[--size];
    }
    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1];
        position = Math.min(position, arr.length);
        System.arraycopy(arr, 0, result, 0, position);
        for(int i = position; i < arr.length; ++i)
            arr[i + 1] = arr[i];
        result[position] = item;
        return result;
    }
    public static void reverse(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < (length - i - 1); ++i) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - i - 1] = temp;
        }

    }

    public static int[] replicate(int[] arr) {
        int arrayNumber = 0;
        for(int i = 0; i < arr.length; ++i) {
            arrayNumber += arr[i];
        }
        int[] result = new int[arrayNumber];
        int position = 0;
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[i]; ++j) {
                result[position++] = arr[i];
            }
        }
        return result;
    }
    public static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        AList.printArr(arr);
        AList.printArr(replicate(arr));
        AList.reverse(arr);
        AList.printArr(arr);
    }



}
