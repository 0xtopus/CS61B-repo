/* 
 * official solution: https://sp18.datastructur.es/materials/discussion/disc03sol.pdf
 */
public class Array {
    /* 
    * Is it possible to write a version of this method that returns void and changes arr
    * in place (i.e., destructively)?

    * No. Since you can't change the length of original array, youhave to create a new one in your method
    * and it must return the new array to main method or you can't repoint main variant arr to 
    * the new array.

    * Any method destructively changes length of the original array should return a new array.
     */
    public static int[] insert(int[] arr, int item, int position) {
        int[] arr2 = new int[arr.length + 1];
        if (position >= arr.length) {
            System.arraycopy(arr, 0, arr2, 0, arr.length);
        } else{
            System.arraycopy(arr, 0, arr2, 0, position);
            System.arraycopy(arr, position, arr2, position+1, arr.length-position);
            arr2[position] = item;
        }
        return arr2;
    }

    /* a method destructively reverses the items in arr. */
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[(arr.length-1) - i];
            arr[(arr.length-1) - i] = temp;
        }
    }

    /*  
    * a non-destructive method replicate(int[] arr) that replaces the
    * number at index i with arr[i] copies of itself. 
    * For example, replicate([3, 2, 1]) would return [3, 3, 3, 2, 2, 1].
    */
    public static int[] replicate(int[] arr) {
        int newLength = 0;
        for (int item: arr) {
            newLength += item; 
        }
        int[] repArr = new int[newLength];
        newLength = 0;
        for (int item : arr) {
            for (int i = 0; i < item; i++) {
                repArr[newLength] = item;
                newLength++;
            }
        }
        return repArr;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        arr = Array.insert(arr, 7, 2);
        // Array.reverse(arr);
        // int repArr[] = Array.replicate(arr);
    }
}
