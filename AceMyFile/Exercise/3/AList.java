/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    int size;
    int[] arr;  
    /** Creates an empty list. */
    public AList() {
        /* init AList */
        arr = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size>=100) {
            int[] arrMega = new int[size+1];
            System.arraycopy(arr,0,arrMega,0,size);
            arrMega[size] = x;
            arr = arrMega;
        } else {
            arr[size] = x;
        }
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return arr[size-1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return arr[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int temp = arr[size];
        arr[size-1] = 0;   // in fact you can leave the last item alone, only deduct size variant by 1
        size--;
        return temp;
    }
} 