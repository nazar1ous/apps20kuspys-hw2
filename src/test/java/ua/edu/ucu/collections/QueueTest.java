package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class QueueTest {
    private Queue emptyQ;
    private Object[] commonArr;
    private Object[] emptyArr;

    @Before
    public void setUp() {
        emptyQ = new Queue();
        commonArr = new Object[]{2, 8, 9, 10};
        emptyArr = new Object[0];
    }

    @Test
    public void testEnqueue() {
        for (Object o : commonArr) {
            emptyQ.enqueue(o);
        }
        assertEquals(2, emptyQ.peek());
    }

    @Test
    public void testDequeue() {
        for (Object o : commonArr) {
            emptyQ.enqueue(o);
        }
        emptyQ.dequeue();
        assertEquals(8, emptyQ.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekError() {
        emptyQ.peek();

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueError() {
        emptyQ.dequeue();

    }

}
