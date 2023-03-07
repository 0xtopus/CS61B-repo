import static org.junit.Assert.*;
import org.junit.Test;

public class WordUnitTest {
    @Test
    public void testTheLongestString() {
        SLList L = new SLList("the 1st msg");
        L.addFirst("the 2nd msg");
        L.addFirst("the longestttttttttttttt msg");
        L.addFirst("the 3rd msg");

        String expected = "the longestttttttttttttt msg";
        String actual = WordUnit.theLongestString(L);

        assertEquals(expected, actual);

        SLList L1 = new SLList();
        assertEquals(WordUnit.theLongestString(L1), null);
    }
}
