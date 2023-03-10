/** @source:https://sp18.datastructur.es/materials/discussion/examprep04.pdf 
 *  @solution: https://sp18.datastructur.es/materials/discussion/examprep04sol.pdf
 * ok, I see I should not modified the existing code and i will lose some points here.
*/
public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, null);
    }

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            if (next == null) {
                return item;
            }
            return Math.max(item, next.max());
        }
    }

    public int max() {
        return sentinel.next.max();
    }
}