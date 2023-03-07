public class WordUnit {
    public static String theLongestString(SLList L) {
        String maxStr = L.get(0);
        for (int i = 1; i < L.size(); i++) {
            String tempStr = L.get(i);
            if (maxStr.compareTo(tempStr) < 0) {
                maxStr = tempStr;
            }
        }
        return maxStr;
    }
}
