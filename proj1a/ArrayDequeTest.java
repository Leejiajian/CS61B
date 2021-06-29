public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> DDeque = new ArrayDeque<>();
        DDeque.addFirst(0);
        DDeque.removeFirst();
        DDeque.addFirst(2);
        DDeque.removeFirst();
        System.out.println(DDeque.isEmpty());
    }
}
