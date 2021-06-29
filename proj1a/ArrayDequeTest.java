public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> DDeque = new ArrayDeque<>();
        /*
        DDeque.addFirst(0);
        DDeque.removeFirst();
        DDeque.addFirst(2);
        DDeque.removeFirst();
        System.out.println(DDeque.isEmpty());
        */
        //error example

        DDeque.addFirst(0);
        DDeque.addFirst(1);
        DDeque.removeLast();
        DDeque.addFirst(3);
        DDeque.isEmpty();
        DDeque.addFirst(5);
        DDeque.addFirst(6);
        DDeque.removeLast();
        /*
        DDeque.isEmpty();
        DDeque.isEmpty();
        DDeque.addLast(2);
        DDeque.removeLast();
        DDeque.isEmpty();
        DDeque.isEmpty();
        DDeque.isEmpty();
        DDeque.addLast(7);
        DDeque.isEmpty();
        DDeque.removeLast();

         */
    }

}
