import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("bloolb"));
        assertTrue(palindrome.isPalindrome("tenet"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
        assertFalse(palindrome.isPalindrome("abbA"));
        assertFalse(palindrome.isPalindrome("cat"));
    }

    @Test
    public void testIsOffByOnePalindrome() {
        OffByOne cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("String", cc));
        assertFalse(palindrome.isPalindrome("word", cc));
        assertFalse(palindrome.isPalindrome("ilg", cc));
        
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("bopa", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("i", cc));
    }
}
