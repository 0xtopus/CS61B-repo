import org.junit.Test;
import static org.junit.Assert.*;
public class SortTest {
    @Test
    public void testSort() {
        String[] input = {"1", "3", "4", "2", "9", "5", "6"};
        String[] expected = {"1", "2", "3", "4", "5", "6", "9"};

        Sort.sort(input);

        assertArrayEquals(input, expected);

    }

}
