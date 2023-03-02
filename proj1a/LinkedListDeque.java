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
        sentinel = new Node(null,null,null);
        size = 0;
    }

    /* create a deep copy of other */
    public LinkedListDeque(T other){
        sentinel.next = new Node(other, sentinel, sentinel);
//        sentinel.prev = sentinel.next;
//        size = 1;
    }

    /* desc: add item at the first place
    * @param: T item
    *  */
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

    /* get the size of the deque */
    public int size(){
        return size;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /* Print every Node's first(or item in official file) */
    public void printDeque(){
        Node p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(p.first);
            p = p.next;
        }
    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null */
    public T removeFirst(){
        if (size == 0) {
            return null;
        }
        T temp = sentinel.next.first;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        System.out.println(L.isEmpty());
        L.addLast("the 0 msg");
        System.out.println("\n Remove first");
        System.out.println(L.removeFirst());
        L.addFirst("the 2nd msg");
        L.addFirst("the 3rd msg");
        L.removeFirst();
        System.out.println("\n Remove first");
        System.out.println(L.removeFirst());
        System.out.println(L.removeFirst());
        L.addLast("the -1 msg ");
        L.addFirst("the 4rd msg");
        System.out.println("\n print Size");
        System.out.println(L.size());
        System.out.println("\n isEmpty");
        System.out.println(L.isEmpty());
        System.out.println("\n print Deque");
        L.printDeque();
    }
}