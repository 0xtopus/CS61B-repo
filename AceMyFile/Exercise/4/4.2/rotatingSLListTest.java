import static org.junit.Assert.*;
import org.junit.Test;

public class RotatingSLListTest {
    @Test
    public void testRotateRight() {
        RotatingSLList<Integer> L = new RotatingSLList<>();
        L.addFirst(22);
        L.addFirst(15);
        L.addFirst(9);
        L.addFirst(5);

        L.print();
        L.rotateRight();
        L.print();
        
        RotatingSLList<Integer> Expected = new RotatingSLList<>();
        Expected.addFirst(15);
        Expected.addFirst(9);
        Expected.addFirst(5);
        Expected.addFirst(22);
        for (int i = 0; i < L.size(); i++) {
            assertEquals(Expected.get(i), L.get(i));
        }
    }
}
