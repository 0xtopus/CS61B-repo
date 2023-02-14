/* Source: Improvement #4 of https://joshhug.gitbooks.io/hug61b/content/chap2/chap22.html
 * mission: write addLast() method and size() method
 * */
public class newSLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first; 

    public newSLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    /** desc: recursively addLast() method   */
    public void addLast(int x) {
        IntNode p = first;
        p = p.next;
        if (this.first.next.next == null) {
            p.next = new IntNode(x, null);
        } else {
            newSLList temp = new newSLList(p.item);
            temp.first.next = p.next;
            temp.addLast(x);
        }
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        if (this.first.next == null) {
            return 1;
        }
        newSLList nextL = new newSLList(this.first.next.item);
        nextL.first.next = this.first.next.next;
        return 1 + nextL.size();

    }

    /* test main */
    public static void main(String[] args) {
        newSLList L = new newSLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(3);
        System.out.println("\n******* get old L size recursively *********");
        System.out.println(L.size());
        System.out.println("\n******* add new last recursively *********");
        L.addLast(1);
        /* and you will find L's last is 1 now */
        System.out.println("the num you add is: " + L.first.next.next.next.next.item);
        System.out.println("\n******* get new L size recursively *********");
        System.out.println(L.size());

    }
}
