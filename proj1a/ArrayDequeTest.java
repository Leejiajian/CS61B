public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> myDeque = new ArrayDeque<>();
        System.out.println("size: " + myDeque.size() + " ArraySize: " );
        myDeque.addLast("hello");
        myDeque.addLast("good job");
        myDeque.addLast("lijiajian");
        myDeque.addLast("is");
        myDeque.addLast("good boy");
        myDeque.addLast("good boy");
        myDeque.addLast("good boy");
        myDeque.addLast("error");
        myDeque.addLast("good boy");
        System.out.println("size: " + myDeque.size() + " ArraySize: " );
        myDeque.printDeque();
        ArrayDeque<String> copyDeque = new ArrayDeque<>();
        System.out.println();
        copyDeque.printDeque();
        copyDeque.removeFirst();
        System.out.println();
        copyDeque.printDeque();
        copyDeque.removeLast();
        System.out.println();
        copyDeque.printDeque();
        System.out.println();
        System.out.print(copyDeque.get(0));
        ArrayDeque<Double> DDeque = new ArrayDeque<>();
    }
}
