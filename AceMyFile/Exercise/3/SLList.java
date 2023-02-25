/* src: https://sp18.datastructur.es/materials/discussion/disc03.pdf, disc 03 
 * (1 More Practice with Linked Lists)
 * better solutions than mine: https://sp18.datastructur.es/materials/discussion/disc03sol.pdf
*/
public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            this.item = i;
            this.next = n;
        }
    }

    private IntNode first;
    private int size;

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size++;
    }

    /* get num-th node's first */
    public int get(int num) {
        IntNode p = this.first;
        for (; num > 1; num--) {
            p = p.next;
        }
        return p.item;
    }

    /*
     * insert an item into a specified node
     * say: pos=3, x=11
     * before: 1 2 3 4 5
     * after: 1 2 11 3 4 5
     */
    public void insert(int x, int position) {
        int tempPos = size;
        IntNode tempL = new IntNode(this.get(tempPos), null);
        while (tempPos > 1) {
            tempPos--;
            tempL = new IntNode(get(tempPos), tempL);
            if (tempPos == position + 1) {
                tempL = new IntNode(x, tempL);
                this.size++;
            }
        }
        this.first = tempL;
    }

    /* iteratively reverse the SLList */
    /*
     * 1 2 3 4 5
     * 5 2 3 4 1
     */
    public void iterativeReverse() {
        IntNode p = new IntNode(this.get(0), null);
        for (int i = 2; i <= this.size; i++) {
            p = new IntNode(this.get(i), p);
        }
        this.first = p;
    }

    /* officail solution to recursively reverse */
    public void reverse() {
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front) {
        if (front == null || front.next == null) {
            return front;   // 返回最后一个节点作为reversed的头
        } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;  // 把后一个的next指向前一个node
            front.next = null;        // 把前一个的next设成null
            return reversed;          // 上面两步就把新节点串到reversed的最后了，只要返回reversed即可
        }
    }

    /* officail solution to reverse iteratively, way more elegant */
    /*
     * Changing every node's next point to its previous node
     */
    /*
     * public void reverse(){
     * IntNode frontOfReversed = null;
     * IntNode nextNodeToAdd = first;
     * while (nextNodeToAdd != null) {
     * IntNode remainderOfOriginal = nextNodeToAdd.next;
     * nextNodeToAdd.next = frontOfReversed;
     * frontOfReversed = nextNodeToAdd;
     * nextNodeToAdd = remainderOfOriginal;
     * }
     * first = frontOfReversed;
     * }
     */

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(5);
        L.addFirst(4);
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.insert(11, 2);
        L.iterativeReverse();
        L.reverse();
    }
}