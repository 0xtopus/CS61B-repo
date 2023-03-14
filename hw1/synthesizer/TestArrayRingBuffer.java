package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        
        assertEquals(10, arb.capacity());
        assertFalse(arb.isFull());
        assertTrue(arb.isEmpty());

        arb.enqueue(null);
        assertEquals(10, arb.capacity());

        assertNull(arb.peek());

        arb.enqueue(1.1);
        arb.enqueue(2.1);
        
        arb.dequeue();
        
        arb.enqueue(3.1);
        
        assertFalse(arb.isFull());
        
        arb.enqueue(4.1);
        arb.enqueue(5.1);
        
        arb.dequeue();
        
        arb.enqueue(6.1);
        
        assertEquals(4, arb.fillCount());
        assertEquals((Double) 3.1, arb.peek());
        assertEquals((Double) 3.1, arb.dequeue());

        arb.enqueue(7.1);
        arb.enqueue(8.1);
        arb.enqueue(9.1);
        arb.enqueue(10.1);
        arb.enqueue(0.1);
        arb.enqueue(0.2);
        arb.enqueue(0.3);
        assertTrue(arb.isFull());
        assertEquals((Double) 4.1, arb.peek());
    }

    @Test
    public void enqueueNDequeueTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(8);
        arb.enqueue(1.1);
        arb.enqueue(2.1);
        arb.enqueue(3.1);
        assertFalse(arb.isFull());
        arb.enqueue(4.1);
        arb.enqueue(5.1);
        arb.enqueue(6.1);
        assertEquals(6, arb.fillCount());
        arb.enqueue(7.1);
        arb.enqueue(8.1);
        assertTrue(arb.isFull());
        
        assertEquals((Double) 1.1, arb.peek());

        assertEquals(arb.dequeue(), (Double) 1.1);
        assertEquals(arb.dequeue(), (Double) 2.1);
        assertEquals(arb.dequeue(), (Double) 3.1);
        assertEquals(arb.dequeue(), (Double) 4.1);
        assertEquals(arb.dequeue(), (Double) 5.1);
        assertEquals(arb.dequeue(), (Double) 6.1);
        assertEquals(arb.dequeue(), (Double) 7.1);
        assertEquals(arb.dequeue(), (Double) 8.1);

        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
