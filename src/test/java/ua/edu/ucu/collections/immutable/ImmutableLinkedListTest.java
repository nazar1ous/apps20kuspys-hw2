package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList emptyList;
    private ImmutableLinkedList bigList;
    private ImmutableLinkedList commonList;

    private Object[] commonArr;
    private Object[] bigArr;
    private Object[] emptyArr;

    @Before
    public void setUp() throws Exception {
        commonArr = new Object[]{1, 9, 4, 10};
        bigArr = new Object[]{2, 4, 20, 1, -6,
                4, 10, 33, 9};
        emptyArr = new Object[0];

        emptyList = new ImmutableLinkedList(emptyArr);
        bigList = new ImmutableLinkedList(bigArr);
        commonList = new ImmutableLinkedList(commonArr);
    }

    @Test
    public void testToArray_1() {
        assertArrayEquals(emptyList.toArray(), emptyArr);
        assertArrayEquals(bigList.toArray(), bigArr);
        assertArrayEquals(commonList.toArray(), commonArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll_exe1() {
        assertArrayEquals(emptyList.addAll(5, bigArr).toArray(), commonArr);
        assertArrayEquals(emptyList.addAll(-1, bigArr).toArray(), commonArr);

    }

    @Test
    public void testAddAll() {
        assertArrayEquals(bigList.addAll(3, commonArr).toArray(),
                new Object[]{2, 4, 20, 1, 9,
                        4, 10, 1, -6, 4, 10, 33, 9});
        assertArrayEquals(emptyList.addAll(0, commonArr).toArray(), commonArr);
        assertArrayEquals(commonList.addAll(commonList.size(),
                new Object[0]).toArray(), commonArr);
    }

    @Test
    public void testAddAll_without_id() {
        assertArrayEquals(commonList.addAll(commonArr).toArray(),
                new Object[]{1, 9, 4, 10, 1, 9, 4, 10});
    }

    @Test
    public void testAdd_common() {
        ImmutableLinkedList temp = new ImmutableLinkedList(emptyList.toArray());
        for (Object o : bigArr) {
            temp = temp.add(o);
        }
        assertArrayEquals(temp.toArray(), bigArr);
    }

    @Test
    public void testAdd_index() {
        ImmutableLinkedList temp = new ImmutableLinkedList(commonList.toArray());
        for (Object o : commonArr) {
            temp = temp.add(3, o);
        }
        assertArrayEquals(temp.toArray(),
                new Object[]{1, 9, 4, 10,
                        4, 9, 1, 10});
    }

    @Test
    public void testGet() {
        assertEquals(bigList.get(6), 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_error() {
        assertEquals(bigList.get(15), 10);
        assertEquals(bigList.get(-1), 10);

    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList act = commonList.removeFirst();
        assertArrayEquals(act.toArray(), new Object[]{9, 4, 10});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length - 1);
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList act = commonList.removeLast();
        assertArrayEquals(act.toArray(), new Object[]{1, 9, 4});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstLastErrors() {
        ImmutableLinkedList act = emptyList.removeFirst();
        ImmutableLinkedList act1 = emptyList.removeLast();
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList act = commonList.remove(3);
        assertArrayEquals(act.toArray(), new Object[]{1, 9, 4});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length - 1);

        ImmutableLinkedList act2 = commonList.remove(2);
        assertArrayEquals(act2.toArray(), new Object[]{1, 9, 10});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act2.size(), commonArr.length - 1);

    }

    @Test
    public void testSet() {
        ImmutableLinkedList act = commonList.set(3, 100);
        assertArrayEquals(act.toArray(), new Object[]{1, 9, 4, 100});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length);
    }

    @Test
    public void testIndexOf() {
        assertEquals(emptyList.indexOf(40), -1);
        assertEquals(bigList.indexOf(10), 6);

        assertEquals(bigList.indexOf(229), -1);
    }

    @Test
    public void testSize() {
        ImmutableLinkedList act = bigList.remove(3);
        act = act.remove(3).remove(5);
        assertEquals(act.size(), bigArr.length - 3);

    }

    @Test
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(bigList.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals(emptyList.toString(), "");
        assertEquals(commonList.toString(), "1, 9, 4, 10");
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList act = commonList.addFirst(3);
        assertArrayEquals(act.toArray(), new Object[]{3, 1, 9, 4, 10});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length + 1);

        ImmutableLinkedList act2 = emptyList.addFirst(2);
        assertArrayEquals(act2.toArray(), new Object[]{2});
        assertEquals(act2.size(), 1);

    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList act = commonList.addLast(5);
        assertArrayEquals(act.toArray(), new Object[]{1, 9, 4, 10, 5});
        assertArrayEquals(commonList.toArray(), commonArr);
        assertEquals(act.size(), commonArr.length + 1);

        ImmutableLinkedList act2 = emptyList.addLast(9);
        assertArrayEquals(act2.toArray(), new Object[]{9});
        assertEquals(act2.size(), 1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstLast() {
        emptyList.getFirst();
        emptyList.getLast();
    }

    @Test
    public void testGetFirstLast_common() {
        assertEquals(commonList.getFirst(), 1);
        assertEquals(commonList.getLast(), 10);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList arr = new ImmutableLinkedList(bigList.toArray());
        arr = arr.clear();
        assertEquals(arr.size(), 0);
        assertArrayEquals(arr.toArray(), new Object[0]);
    }
}