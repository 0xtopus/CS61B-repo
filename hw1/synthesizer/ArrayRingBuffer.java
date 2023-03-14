package synthesizer;

import java.util.Iterator;

import javax.management.RuntimeErrorException;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        first = 0;
        last = 0;
        fillCount = 0;
    }
    
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (x == null) {
            return;
        }
        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        if (last >= capacity) {
            last = 0;
        }
        rb[last] = x;
        last++;
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        if (first >= capacity) {
            first = 0;
        }
        T temp = rb[first];
        rb[first] = null;
        first++;
        fillCount--;
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer is empty.");
        }
        if (first >= capacity) {
            first = 0;
        }
        return rb[first];
    }

    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;

        public ArrayRingBufferIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < fillCount;
        }

        public T next() {
            T returnItem = rb[pos];
            pos++;
            return returnItem;
        }
    }
}
