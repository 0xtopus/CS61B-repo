package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity(); // return size of the buffer

    int fillCount(); // return number of items currently in the buffer

    void enqueue(T x); // add item x to the end

    T dequeue(); // delete and return item from the front

    T peek(); // return (but do not delete) item from the front

    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    // is the buffer full (fillCount is same as capacity)?
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
