import static org.junit.Assert.*;
import  org.junit.Test;

public class SLListTest {
    @Test
    public void testAddFirst() {
        SLList L = new SLList("the 1st msg");
        L.addFirst("the 2nd msg");
        L.addFirst("the 3rd msg");

        assertEquals(L.sentinel.next.item, "the 3rd msg");
        assertEquals(L.sentinel.next.next.item, "the 2nd msg");
        assertEquals(L.sentinel.next.next.next.item, "the 1st msg");
    }

    @Test 
    public void testSize() {
        SLList L = new SLList();
        L.addFirst("the 2nd msg");
        L.addFirst("the 3rd msg");

        assertEquals(L.size(), 2);
    }

    @Test
    public void  testGet() {
        SLList L = new SLList("the 1st msg");
        L.addFirst("the 2nd msg");
        L.addFirst("the 3rd msg");

        String expexted = "the 1st msg";
        String actual = L.get(2);

        assertEquals(expexted, actual);

        String expexted2 = "the 3rd msg";
        String actual2 = L.get(0);

        assertEquals(expexted2, actual2);

        assertEquals(null, L.get(10000));
    }
}
