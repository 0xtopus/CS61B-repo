/* exercise from lec7
 * @source: https://sp18.datastructur.es/materials/lectures/lec7/lec7
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class SameArrayTest {

    /* Build a complicated array */
    private void arrayBuilder(int[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new int[]{1,2,3};
            }
        }
    }

    /* Test for arraybuilder() */
    @Test
    public void testArrayBuilder() {
        int[][][] actualArr = new int[4][3][];
        int[][][] expectedArr = {
            {
                {1, 2, 3}, {1, 2, 3}, {1, 2, 3}
            },
            {
                {1, 2, 3}, {1, 2, 3}, {1, 2, 3}
            },
            {
                {1, 2, 3}, {1, 2, 3}, {1, 2, 3}
            },
            {
                {1, 2, 3}, {1, 2, 3}, {1, 2, 3}
            }
        };

        arrayBuilder(actualArr);

        assertArrayEquals(expectedArr, actualArr);
    }

    /* Test if the two arrays are identical  */
    @Test
    public void testSameArray() {
        int[][][] arr1 = new int[4][3][];
        int[][][] arr2 = new int[4][3][];

        arrayBuilder(arr1);
        arrayBuilder(arr2);
        
        assertArrayEquals(arr1, arr2);
    }
}
