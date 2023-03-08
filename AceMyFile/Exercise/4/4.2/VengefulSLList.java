public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems = new SLList<>();

    public void printLostItems() {
        deletedItems.print();
    }

    /** Override removeLast() */
    @Override
    public Item removeLast() {
        Item temp = super.removeLast();
        deletedItems.addLast(temp);
        return temp;
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> L = new VengefulSLList<>();
        L.addFirst(22);
        L.addFirst(15);
        L.addFirst(9);
        L.addFirst(5);

        L.removeLast();
        L.removeLast();
        L.printLostItems();
    }
}