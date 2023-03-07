public class Palindrome {
    /* put characters of a string into a Deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            D.addLast(word.charAt(i));
        }
        return D;
    }
    
    /* Dicide if a word is a Palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> D = wordToDeque(word);
        return isPalindromeHelper(D);
    }

    /* The helper method of isPalidrome using recursive */
    private boolean isPalindromeHelper(Deque<Character> D) {
        if (D.removeFirst() != D.removeLast() && D.size() != 0) {
            return false;
        } else if (D.size() == 0) {
            return true;
        }
        return isPalindromeHelper(D);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> D = wordToDeque(word);
        for (int i = 0; i < (D.size() / 2); i++) {
            if (! cc.equalChars(D.removeFirst(), D.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
