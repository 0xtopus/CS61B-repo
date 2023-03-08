public class RotatingSLList<Item> extends SLList<Item> {
    /** rotate a SLList's last item to the first place */
    public void rotateRight() {
        addFirst(removeLast());
    }
}
