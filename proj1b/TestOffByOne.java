import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void offByOneTest() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('g', 'f'));
        assertTrue(offByOne.equalChars('3', '2'));
        assertTrue(offByOne.equalChars('&', '%'));

        assertFalse(offByOne.equalChars('&', ')'));
        assertFalse(offByOne.equalChars('A', 'C'));
        assertFalse(offByOne.equalChars('b', 'C'));
        assertFalse(offByOne.equalChars('a', 'z'));
    }
}
