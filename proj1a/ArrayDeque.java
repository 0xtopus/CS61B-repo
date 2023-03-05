public class ArrayDeque<T> {
    private int size;
    private T[] arrayDeque;

    private int front;
    private int end;

    /* create an empty arrayDeque */
    public ArrayDeque() {
        arrayDeque = (T []) new Object[8];  // initial length is 8
        front = 3;
        end = 4;
        size = 0;
    }

    /* create a deep copy of the given arrayDeque */
    public ArrayDeque(ArrayDeque other) {
        arrayDeque = (T []) new Object[other.arrayDeque.length];
        System.arraycopy(other.arrayDeque, 0, arrayDeque, 0, arrayDeque.length);
        front = other.front;
        end = other.end;
        size = other.size;
    }

    /* resizing arrayDeque */
    // shrink func is needed
    private void resizing(int capacity) {
        T[] newArrayDeque = (T []) new Object[capacity];
        /* assign original items to the expanded array in order */
        for (int i = front + 1, j = 0; j < size; i++, j++) {
            /* if i exceeds the length then go back to 0 */
            if (i >= arrayDeque.length) {
                i = 0;
            }
            newArrayDeque[j] = arrayDeque[i];
        }
        /* update old array to the expanded fresh new one */
        end = size;
        front = newArrayDeque.length - 1;
        arrayDeque = newArrayDeque;
    }

    /* add content to the first place of arrayDeque */
    public void addFirst(T item) {
        if (size >= arrayDeque.length) {
            resizing(arrayDeque.length * 2);
        }
        size++;     //increase size
        arrayDeque[front] = item;
        front = front > 0 ? front - 1 : arrayDeque.length - 1; // update the position of front
    }

    /* add content to the last place of arrayDeque */
    public void addLast(T item) {
        if (size >= arrayDeque.length) {
            resizing(arrayDeque.length * 2);
        }
        size++;     //increase size
        arrayDeque[end] = item;
        end = end < arrayDeque.length - 1 ? end + 1 : 0; // update the position of front
    }

    /* remove the first item of arrayDeque */
    public T removeFirst() {
        // if it is empty, return null
        if (isEmpty()) {
            return null;
        }
        // go to the next box and change position of front
        if (++front >= arrayDeque.length) {
            front = 0;
        }
        // get the delete item
        T temp = arrayDeque[front];
        // wipe it out to release memory
        arrayDeque[front] = null;
        // decrease size
        size--;
        // resizing the array if it is too "empty"
        if (size < arrayDeque.length / 4 && arrayDeque.length > 8) {
            resizing(arrayDeque.length / 2);
        }
        return temp;
    }

    /* remove the last item of arrayDeque */
    public T removeLast() {
        // if it is empty, return null
        if (isEmpty()) {
            return null;
        }
        // go to the box in front of end and change position of end
        if (--end < 0) {
            end = arrayDeque.length - 1;
        }
        // get the delete item
        T temp = arrayDeque[end];
        // wipe it out to release memory
        arrayDeque[end] = null;
        // decrease size
        size--;
        // resizing the array if it is too "empty"
        if (size < arrayDeque.length / 4 && arrayDeque.length > 8) {
            resizing(arrayDeque.length / 2);
        }
        return temp;
    }

    /* get the size of arrayDeque */
    public int size() {
        return size;
    }

    /* check if arrayDeque is empty */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /* print all items in arraydeque */
    public void printDeque() {
        for (int i = front + 1; i != end; i++) {
            if (i >= arrayDeque.length) {
                i = 0;
            }
            System.out.println(arrayDeque[i]);
        }
    }

    /* get the content of arrayDeque at given index*/
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return arrayDeque[(front + index + 1) % arrayDeque.length];
    }

/*    public static void main(String[] args) {
        ArrayDeque<String> Arr = new ArrayDeque();
        Arr.removeLast();
        System.out.println(Arr.get(4));
        Arr.printDeque();
        System.out.println(Arr.isEmpty());
        Arr.addFirst("the " + 1 + " msg");
        Arr.addFirst("the " + 2 + " msg");
        Arr.addLast("the " + -1 + " msg");
        Arr.addLast("the " + -2 + " msg");
        Arr.addLast("the " + -3 + " msg");
        Arr.addLast("the " + -4 + " msg");
        Arr.addLast("the " + -5 + " msg");
        Arr.get(6);
        System.out.println(Arr.get(2));
        System.out.println(Arr.get(9));
        System.out.println(Arr.get(0));
    }*/

/*
    public static void main(String[] args) {
        ArrayDeque<String> Arr = new ArrayDeque();
        Arr.removeLast();
        Arr.printDeque();
        System.out.println(Arr.isEmpty());
        Arr.addFirst("the " + 1 + " msg");
        Arr.addFirst("the " + 2 + " msg");
        Arr.addLast("the " + -1 + " msg");
        Arr.addLast("the " + -2 + " msg");
        Arr.addLast("the " + -3 + " msg");
        Arr.addLast("the " + -4 + " msg");
        Arr.addLast("the " + -5 + " msg");
        Arr.addFirst("the 3 msg");
        Arr.addFirst("the 4 msg");
        Arr.addLast("the -6 msg");
        Arr.addFirst("the 5 msg");
        Arr.addFirst("the 6 msg");
        Arr.addFirst("the 7 msg");
        Arr.addLast("the -7 msg");

        Arr.printDeque();

        Arr.addLast("the last of msg");
        Arr.addFirst("the 8 msg");
        Arr.addFirst("the 9 msg");
        Arr.addFirst("the 10 msg");
        Arr.addLast("the -1000000 msg");

        for (int i = 0; i < 13; i++) {
            Arr.removeFirst();
        }
        Arr.removeLast();

        for (int i = 0; i < 6; i++) {
            Arr.removeLast();
        }

        Arr.addLast("they are fking annoying");
        Arr.addLast("they are fking annoying");
        Arr.addFirst("they are fking annoying");
        Arr.addLast("they are fking annoying");
        Arr.addLast("they are fking annoying");
        Arr.addLast("they are fking annoying");
        Arr.addFirst("they are fking annoying");
        Arr.addFirst("they are fking annoying");
        Arr.addFirst("they are fking annoying");

        for (int i = 0; i < 10; i++) {
            Arr.addFirst("the " + i + " msg");
        }
        for (int i = -1; i > -15; i--) {
            Arr.addLast("the " + i + " msg");
        }
        for (int i = 0; i < Arr.size; i++) {
            System.out.println(Arr.get(i) + "\n");
        }
        Arr.printDeque();
        ArrayDeque Arr2 = new ArrayDeque(Arr);
        Arr.addLast("the real end of Arr");
        System.out.println(Arr.size());
        System.out.println(Arr.isEmpty());
    }*/
}
