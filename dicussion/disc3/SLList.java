public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode n) {
            this.item = item;
            this.next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }
    public void addFirst(int item) {
        sentinel.next = new IntNode(item, sentinel.next);
        ++size;
    }
    public int size() {
        return size;
    }
    public void addLast(int item) {
        ++size;
        IntNode p = sentinel;
        while(p.next != null)
            p = p.next;
        p.next = new IntNode(item, null);

    }
    private static IntNode get(IntNode p, int index) {
        if (p == null)
            return null;
        if (index == 0)
            return p;
        return SLList.get(p.next, index - 1);
    }
    public IntNode get(int index) {
        if(index == 0)
            return sentinel;
        return SLList.get(this.sentinel.next, index - 1);
    }
    public void insert(int item, int position) {
        IntNode frontInsertPosition = get(position);
        if (frontInsertPosition == null) {
            return;
        }
        IntNode insertNode = new IntNode(item, frontInsertPosition.next);
        frontInsertPosition.next = insertNode;
        ++size;
    }
    /*
    public void reverse() {
        IntNode frontItemReversed = null;
        IntNode reversedItem = sentinel.next;
        while(reversedItem != null) {
            IntNode remainderOriginal = reversedItem.next;
            reversedItem.next = frontItemReversed;
            frontItemReversed = reversedItem;
            reversedItem = remainderOriginal;
        }
        sentinel.next = frontItemReversed;
    }



    public void reverseAfterP(IntNode frontReversedNode, IntNode nodeReversed) {
        if (nodeReversed == null){
            sentinel.next.next = null;
           sentinel.next = frontReversedNode;
           return;
        }
        IntNode remainderOriginal = nodeReversed.next;
        nodeReversed.next = frontReversedNode;
        reverseAfterP(nodeReversed, remainderOriginal);


    }
    public void reverse() {
        if(sentinel.next != null)
            reverseAfterP(sentinel.next, sentinel.next.next);
        return;
    }

     */
    //Answer:
    public void reverse() {
         sentinel.next = reverseRecursiveHelper(sentinel.next);
        }

         private IntNode reverseRecursiveHelper(IntNode front) {
         if (front == null || front.next == null) {
            return front;
            } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
             front.next.next = front;
             front.next = null;
             return reversed;
             }
         }
    private void printSLList(IntNode p) {
        if(p == null)
            return;
        System.out.print(p.item + " ");
        printSLList(p.next);
    }
    //用来屏蔽接口细节
    public void printSLList(){
        printSLList(sentinel.next);
    }
    public static void main(String[] args) {
        SLList s = new SLList();

        s.addLast(1000);

        s.addFirst(3);
        s.addFirst(5);
        s.addLast(12);
        s.addFirst(4);
        s.printSLList();
        System.out.println();
        s.insert(100, 0);
        s.printSLList();
        s.reverse();
        System.out.println();
        s.printSLList();
    }




}