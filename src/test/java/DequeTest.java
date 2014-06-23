import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DequeTest {
    @Test(expectedExceptions = NullPointerException.class)
    public void testAddingNullItemToFront() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddingNullItemToEnd() {
        Deque<String> deque = new Deque<String>();

        deque.addLast(null);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testRemovingFirstItemFromEmptyDeque() {
        Deque<String> deque = new Deque<String>();

        deque.removeFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testRemovingLastItemFromEmptyDeque() {
        Deque<String> deque = new Deque<String>();

        deque.removeLast();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRemoveOnIteratorUnsupported() {
        Deque<String> deque = new Deque<String>();

        deque.iterator().remove();
    }

    @Test(expectedExceptions = java.util.NoSuchElementException.class)
    public void testNextRaisesWhenNoMoreElements() {
        Deque<String> deque = new Deque<String>();

        deque.iterator().next();
    }

    @Test
    public void testNewDequeIsEmpty() {
        Deque<String> deque = new Deque<String>();

        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }
}
