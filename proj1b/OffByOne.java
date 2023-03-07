public class OffByOne implements CharacterComparator {
    /* Compare two letters if they are off-by-one */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
