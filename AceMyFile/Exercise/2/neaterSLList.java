/* source: https://sp18.datastructur.es/materials/lectures/lec4/lec4, Exer B 
 * B Level
 * 1. Starting from the copy of SLList.java provided to you in the lecture code repository, implement the method deleteFirst, which deletes the first element in your SLList. Don’t forget to maintain the three invariants discussed above.

 * 2. Starting from the copy of SLList.java provided to you in the lecture code repository, implement a second constructor that takes in an array of integers, and creates an SLList with those integers. Again, remember to maintain your invariants.

 * 3. If the sentinel node was a null node, would it change anything or would the Intlist be able to function?
 * 	Ans: nope.cuz null node has no "next" so it can't use the methods such as "addFirist()"
*/
 
 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class neaterSLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
			// System.out.println(size);
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	// private static void lectureQuestion() {
	// 	moreNeatSLList L = new moreNeatSLList();
	// 	IntNode n = new IntNode(5, null);
	// }

	/** Creates an empty SLList. */
	public neaterSLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public neaterSLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/* another constructor who takes an array and add its elements to the list */
	public neaterSLList(int[] arr){
		sentinel = new IntNode(63, null);
		for (int i = 0; i < arr.length; i++) {
			addLast(arr[i]);
		}
	}
 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

    /* Delete first node after sentinel node */
    public void deleteFirst(){
		if (size != 0) {
			IntNode p = sentinel;
			p.next = p.next.next;
			size--;
		}
    }

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
		int[] arr = {1,2,3,4,5};
 		// neaterSLList L = new neaterSLList();
 		neaterSLList L = new neaterSLList(arr);
 		L.addLast(20);
		L.deleteFirst();
		L.addFirst(100);
 		System.out.println(L.size());
 	}
}
