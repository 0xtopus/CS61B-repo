public class IntList{
    public int first;
    public IntList rest;
    
    // constructor
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public static void main(String[] args) {
        // create the list
        IntList L = new IntList(7,null);  
        L = new IntList(6,L);                 
        L = new IntList(5,L);
        L = new IntList(4,L);
        L = new IntList(3,L);
        L = new IntList(2,L);
        L = new IntList(1,L);

        // size test
        System.out.println("\n*****recursive*****");
        System.out.println("the size is: " + IntList.size(1,L));
        System.out.println("\n*****iterative*****");
        System.out.println("the size is: " + L.iterativeSize());
        
        // get test
        System.out.println("\n*****get() test*****");
        System.out.println("the 4th L.first is: " +L.get(4));

    }

    /*
    *method: size()
    *desc: return the number of items in L recursively (static method)
    */
    public static int size(int num,IntList L){
        if (L.rest == null) {
            return 1;
        } else {
            num += IntList.size(num,L.rest);
            return num;
        }
    }

    /*
    *method: iterativeSize()
    *desc: return the number of items in L iteratively (non-static method)
    */
    public int iterativeSize(){
        int num;
        IntList nextL = this;
        for (num = 1; ; num++) {
                // System.out.println(nextL.first);
            nextL = nextL.rest; 
            if (nextL.rest == null) {
                num++;
                break;
            }
        }
        return num;
    }

    /* 
     * method: get(int i)
     * desc: get what's inside the ith L.first
     */
    public int get(int i) {
        IntList p = this;
        for (int j = 1; j!=i; j++) {    
            p = p.rest;
        }
        return p.first;
    }
}

/* 
! the example from lecturer:
 * Return the size of the list using... recursion! 
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

 !tips: recommend that when you write iterative data structure code 
 !that you use the name p to remind yourself that the variable is holding a pointer.

 * Return the size of the list using no recursion! 
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }
 */