public class SLList{
    public IntNode first;
    
    public SLList(int x){
        first = new IntNode(x, null);
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(5);
        L.addFirst(10);
    }


}