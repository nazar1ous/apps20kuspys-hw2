package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class StackTest {
    private Stack emptyS;
    private Object[] commonArr;
    private Object[] emptyArr;

    @Before
    public void setUp(){
        emptyS = new Stack();
        commonArr = new Object[]{2, 8, 9, 10};
        emptyArr = new Object[0];
    }

    @Test
    public void testPush(){
        for (Object o: commonArr){
            emptyS.push(o);
        }
        assertEquals(10, emptyS.peek());
    }

    @Test
    public void testPop(){
        for (Object o: commonArr){
            emptyS.push(o);
        }
        emptyS.pop();
        assertEquals(9, emptyS.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekError(){
        emptyS.peek();

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueError(){
        emptyS.pop();

    }

}
