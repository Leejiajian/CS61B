public class IntList {
    private int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        first = f;
        rest = r;
    }
    public void skippify() {
        IntList p = this;
        int n = 1;
        while(p != null) {
            IntList next = p.rest;
            for(int i = 0; i < n; ++i) {
                if(next == null)
                    break;
                next = next.rest;
            }
            p.rest = next;
            p = next;
            ++n;

        }
    }
    public static void removeDuplicates(IntList p) {
        if(p == null)
            return;
        IntList current = p.rest;
        IntList previous = p;
        while(current != null) {
            if(previous.first == current.first) {
                previous.rest = current.rest;
            }
            else{
                previous = current;
            }
            current = current.rest;
        }
    }


}
