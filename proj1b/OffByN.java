public class OffByN implements CharacterComparator {
    
    private int distance;

    public OffByN(int N) {
        distance = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(y - x) == distance;
    }
}
