// Source Doc: https://sp18.datastructur.es/materials/hw/hw0/hw0#alternate-java

public class Demo {
    public static void main(String[] args) {
        System.out.println("************* output below *************");
        System.out.println("************* 在下面输出 *************");

        /*
         * conditionals
         */
        // int x=99;
        // if(x<10){
        // System.out.println("增加！");
        // x = x + 10;

        // } else {
        // System.out.println("fuck'ya!");
        // }
        // System.out.println(x);

        /*
         * while
         */
        // int bottles = 99;
        // while (bottles>0) {
        // System.out.println("the number of bottle is " + bottles);
        // bottles--;
        // }
        // System.out.println("no btl remains!");

        /*
         * Doubles and Strings
         */
        // String a = "Achilles";
        // String t = "Tortoise";
        // double aPos = 0;
        // double tPos = 100;
        // double aSpeed = 20;
        // double tSpeed = 10;
        // double totalTime = 0;
        // while (aPos < tPos) {
        // System.out.println("At time: " + totalTime);
        // System.out.println(" " + a + " is at position " + aPos);
        // System.out.println(" " + t + " is at position " + tPos);

        // double timeToReach = (tPos - aPos) / aSpeed;
        // totalTime = totalTime + timeToReach;
        // aPos = aPos + timeToReach * aSpeed;
        // tPos = tPos + timeToReach * tSpeed;
        // }

        /*
         * Excercise 1a - draw a triangle
         */

        /*
         * System.out.print to be a useful alternative
         * to System.out.println.
         * The difference is that System.out.print
         * does not include an automatic newline.
         */
        // for(int i=1; i<=5; i++){
        // for(int j=i; j>0; j--){
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        /*
         * define Functions(Methods)
         */
        // System.out.println(max(15,20));

        /*
         * exer 1B
         */
        // drawTriangle(10);

        /*
         * Array
         */
        // int[] num = new int[]{1,2,3};
        // System.out.println(num[2]);
        // System.out.println(num.length);

        /*
         * Exer 2
         */
        // int[] numbers = new int[]{9, 2, 15, 22, 10, 6};
        // System.out.println(max(numbers));

        /*
         * for loop
         */
        // I have already known it

        /*
         * Breaks and Continue
         */
        // String[] a = { "cat", "dog", "laser horse", "ketchup", "horse", "horbse" };

        // for (int i = 0; i < a.length; i += 1) {
        // if (a[i].contains("horse")) {
        // continue;
        // }
        // for (int j = 0; j < 3; j += 1) {
        // System.out.println(a[i]);
        // }
        // }

        // String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        // for (int i = 0; i < a.length; i += 1) {
        // for (int j = 0; j < 3; j += 1) {
        // System.out.println(a[i]);
        // if (a[i].contains("horse")) {
        // break;
        // }
        // }
        // }

        /*
         * Exer 4
         */
        int[] a1 = { 1, 2, -3, 4, 5, 4 };
        int[] a2 = {1, -1, -1, 10, 5, -1};
        int n1 = 3;
        int n2 = 2;
        windowPosSum(a1, n1);
        windowPosSum(a2, n2);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a1));
        // Should print -1, -1, -1, 14, 4, -1
        System.out.println(java.util.Arrays.toString(a2));

        /*
         * Enhanced loop
         */
        // String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        // // s: started from a[0] to a[a.length-1]
        // for (String s : a) {
        //     for (int j = 0; j < 3; j += 1) {
        //         System.out.println(s);
        //         if (s.contains("horse")) {
        //             break;
        //         }                
        //     }
        // }
    }

    /*
     * define Functions(Methods)
     */
    /*     
    public static int max(int x, int y) {
    if (x>y) {
    return x;
    }
    return y;
    } */

    /*
     * exer 1B
     */
    /*
     * public static void drawTriangle(int N) {
     * for (int i = 1; i <= N; i++) {
     * for (int j = 0; j < i; j++) {
     * System.out.print("*");
     * }
     * System.out.println();
     * }
     * }
     */

    /*
     * Exer 2
     */
    /*
     * public static int max(int[] m) {
     * int maxNum = m[0];
     * for (int i = 1; i < m.length; i++) {
     * if (maxNum < m[i]) {
     * maxNum = m[i];
     * }
     * }
     * return maxNum;
     * }
     */

    /*
     * Exer 4
     */
    public static void windowPosSum(int[] a, int n) {
        // from first num to the last second num of the array
        for (int i = 0; i < a.length - 1; i++) {
            // if a[i]>0, replace a[i] with the sum of itself and n elements after it
            if (a[i] > 0) {
                for (int j = 1; j <= n; j++) {
                    if(i+j > a.length-1) {
                        break;
                    }
                    a[i] += a[i + j];
                }
                
            } else {
                continue; // otherwise a[i] <= 0 then do nothing to a[i]
            }
            
        }
        
    }
}

/*
 * the born of for loop
 * Programmers in the 1950s observed that
 * it was very common to have code that featured
 * initialization of a variable, followed by a
 * loop that begins by checking for a termination
 * condition and ends with an increment operation.
 * Thus was born the for loop.
 */