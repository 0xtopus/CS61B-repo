/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {

        String[] asciisToDestroy = new String[asciis.length];
        for (int i = 0; i < asciis.length; i++) {
            asciisToDestroy[i] = new String(asciis[i]);
        }

        int maxLength = 0;
        for (String str : asciis) {
            maxLength = maxLength > str.length() ? maxLength : str.length();
        }
        
        for (int i = maxLength - 1; i >= 0; i--) {
            sortHelperLSD(asciisToDestroy, i);            
        }

        return asciisToDestroy;
    }

    // main() method to test and debug
    public static void main(String[] args) {
/*         String str = "asghdiuadh";
        try {
            str.charAt(1000);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("lose!");
        } */
        String[] strings = new String[]{"jeg", "jobber", "med", "dette", "i", "100", "arhundrer"};
        // String[] strings = new String[]{"jeg", "liker", "luken", "mat"};
        strings = sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] count = new int[256];
        int[] starts = new int[256];
        
        int[] lettersAtIndex = new int[asciis.length];

        for (int i = 0; i < asciis.length; i++) {
            int letterAscii;
            try {
                // System.out.println(asciis[i].charAt(index));
                letterAscii = (int) asciis[i].charAt(index);
            } catch (StringIndexOutOfBoundsException e) {
                letterAscii = 0;
            }

            lettersAtIndex[i] = letterAscii;
            count[letterAscii]++;
        }

        for (int i = 0; i < starts.length - 1; i++) {
            starts[i + 1] = starts[i] + count[i];
        }

        String[] sortedAsciis = new String[asciis.length];
        for (int i = 0; i < asciis.length; i++) {
            int item = lettersAtIndex[i];
            int place = starts[item];
            sortedAsciis[place] = asciis[i];
            starts[item]++;
        }

        for (int i = 0; i < sortedAsciis.length; i++) {
            asciis[i] = sortedAsciis[i];
        }

        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
