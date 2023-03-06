public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x) { 
        for(int i = 0; i < x.length - 1; i++) {
            int pos = i;
            int min = Integer.parseInt(x[i]);
            for (int j = i + 1; j < x.length; j++) {
                if (min > Integer.parseInt(x[j])) {
                    min = Integer.parseInt(x[j]); 
                    pos = j;    
                }
            }
            if (pos != i) {
                x[pos] = x[i];
                x[i] = Integer.toString(min);
            }
        }
           // find the smallest item
           // move it to the front
           // selection sort the rest (using recursion?)
    }

/*     private String sortHandler(String min, String next) {
        if (min > next) {
            return sortHandler(min, next)
        }
    } */

}