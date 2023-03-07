public class SLList{
    public class IntNode {
        String item;
        IntNode next;

        private IntNode(String first, IntNode n) {
            item = first;
            next = n;
        }

        private String getHandler(int num) {
            if (num == 0) {
                return this.item;
            }
            return this.next.getHandler(num-1);
        }
    }

    public IntNode sentinel = new IntNode(null, null);
    private int size;

    public SLList() {
        size = 0;
    }

    public SLList(String item) {
        sentinel.next = new IntNode(item, null);
        size = 1;
    }

    public void addFirst(String item) {
        sentinel.next = new IntNode(item, sentinel.next);
        size++;
    }

    public String get(int num) {
        IntNode p = sentinel.next;
        /* if num is legal */
        if (num >= size) {
            return null;
        }
        return p.getHandler(num);
    }

    public int size() {
        return size;
    }
}