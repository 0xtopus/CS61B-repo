/* 
 * source: Exercise B2 from https://sp19.datastructur.es/materials/lectures/lec3/lec3.html
 */
public class Lists1Exercises {
  /**
   * Returns an IntList identical to L, but with
   * each element incremented by x. L is not allowed
   * to change.
   */
  public static IntList incrList(IntList L, int x) {
    int size = L.size();
    IntList newL = new IntList(L.get(size) + x, null);
    while (size>1) {
      size--;
      newL = new IntList(L.get(size) + x, newL);
    }
    L = newL;
    return L;
  }

  /**
   * Returns an IntList identical to L, but with
   * each element incremented by x. Not allowed to use
   * the 'new' keyword.
   */
  public static IntList dincrList(IntList L, int x) {
    IntList nextL = L;
    while(nextL != null){
      nextL.first += x;
      nextL = nextL.rest;
    }
    return L;
  }

  public static void main(String[] args) {
    IntList L = new IntList(5, null);
    L.rest = new IntList(7, null);
    L.rest.rest = new IntList(9, null);

    System.out.println(L.size());
    System.out.println(L.iterativeSize());

    // Test your answers by uncommenting. Or copy and paste the
    // code for incrList and dincrList into IntList.java and
    // run it in the visualizer.
    System.out.println(L.get(1));
    System.out.println(incrList(L, 3));
    System.out.println(L);
    System.out.println(dincrList(L, 3));
  }
}