/* 
 * source: https://joshhug.gitbooks.io/hug61b/content/chap2/exercises/Government.java
 */

 /* 
  * https://blog.csdn.net/q610376681/article/details/49359819
  * solving: Cannot make a static reference to the non-static method greaterTreasury(Government, Government) from the type Government 
  */
  
/** A rather contrived exercise to test your understanding of when
    nested classes may be made static. This is NOT an example of good
    class design, even after you fix the bug.

    The challenge with this file is to delete the keyword static the
    minimum number of times so that the code compiles.

    Guess before TRYING to compile, otherwise the compiler will spoil
    the problem.*/
    public class Government {
        private int treasury = 5;
    
        private void spend() {
            treasury -= 1;
        }
    
        private void tax() {
            treasury += 1;
        }
    
        public void report() {
            System.out.println(treasury);
        }
    
        public static Government greaterTreasury(Government a, Government b) {
            if (a.treasury > b.treasury) {
                return a;
            }
            return b;
        }
    
        public static class Peasant {
            public void doStuff() {
                System.out.println("hello");			
            }
        }
    
        public class King {
            public void doStuff() {
                spend();			
            }
        }
    
        public class Mayor {
            public void doStuff() {
                tax();			
            }
        }
    
        public class Accountant {
            public void doStuff() {
                report();			
            }
        }
    
        public class Thief {
            public void doStuff() {
                treasury = 0;			
            }
        }
    
        public static class Explorer {
            public void doStuff(Government a, Government b) {
                Government favorite = Government.greaterTreasury(a, b);
                System.out.println("The best government has treasury " + favorite.treasury);			
            }
        }
    }