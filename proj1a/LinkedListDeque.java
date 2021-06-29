public class LinkedListDeque<T> {
    private class TNode{
        private TNode prev, next;
        private T item;
        public TNode(TNode prev, TNode next, T item){
            this.prev = prev;
            this.next  = next;
            this.item = item;
        }
    }
    private TNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }
    //api
    public void addFirst(T item){
        TNode nodeAfterSentinel = sentinel.next;
        sentinel.next = new TNode(sentinel, nodeAfterSentinel, item);
        nodeAfterSentinel.prev = sentinel.next;
        size += 1;

    }
    public void addLast(T item){
        TNode lastNode = sentinel.prev;
        lastNode.next = new TNode(lastNode, sentinel, item);
        sentinel.prev = lastNode.next;
        size += 1;
    }
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }
    public int size(){
        return size;
    }
    public void print(TNode p){
        if(p != sentinel)
            System.out.print(p.item + " ");
        else
            return;
        print(p.next);
    }
    public void printDeque(){
        print(sentinel.next);
    }
    public T removeFirst(){
        if(isEmpty())
            return null;
        --size;
        TNode deleteNode = sentinel.next;
        sentinel.next = deleteNode.next;
        deleteNode.next.prev = sentinel;
        deleteNode.next = deleteNode.prev = null;
        return deleteNode.item;
    }
    public T removeLast(){
        if(isEmpty())
            return null;
        --size;
        TNode deleteNode = sentinel.prev;
        sentinel.prev = deleteNode.prev;
        deleteNode.prev.next = sentinel;
        deleteNode.next = deleteNode.prev = null;
        return deleteNode.item;

    }
    public T get(int index) {
        if (isEmpty() || index >= size())
            return null;
        int count = 0;
        TNode point = sentinel.next;
        while (point != sentinel && count != index) {
            ++count;
            point = point.next;
        }
        if (point == sentinel)
            return null;
        return point.item;
    }
    //may be some problems
    private TNode get(TNode p, int index){
        if(p == sentinel)
            return null;
        if(index == 0)
            return p;
        return get(p.next, index-1);

    }

    public T getRecursive(int index){
        if(index >= size())
            return null;
        return get(sentinel.next, index).item;

    }



}
