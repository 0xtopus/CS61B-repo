public class LinkedListDeque<T>{
    public class Node{
        private T first;
        private Node prev;
        private Node next;
        private Node(T i, Node p, Node n){
            first = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    // create a sentinel node
    private Node sentinel;

    /* create an empty list */
    public LinkedListDeque(){
        sentinel = new Node(null,sentinel,sentinel);
        size = 0;
    }

    /* create a deep copy of other */
    public LinkedListDeque(T other){
        sentinel.next = new Node(other, sentinel, sentinel);
//        sentinel.prev = sentinel.next;
//        size = 1;
    }

    /* add item at the first place */
    public void addFirst(T item){
        if (sentinel.next == null){
            sentinel.next = new Node(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next = new Node(item, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size++;
    }

    /* add item at the last place */
    public void addLast(T item){
        if (sentinel.prev == null) {
            sentinel.prev = new Node(item, sentinel, sentinel);
            sentinel.next = sentinel.prev;
        } else {
            sentinel.prev = new Node(item, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size++;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addLast("the 0 msg");
        L.addFirst("the 2nd msg");
        L.addFirst("the 3rd msg");
        L.addLast("the -1 msg ");
    }
}