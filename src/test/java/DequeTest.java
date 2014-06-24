import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

    @Test
    public void testAddingAndRemoving() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("One");
        // ["One"]

        deque.addFirst("Two");
        // ["Two", "One"]

        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());

        deque.addLast("Three");
        // ["Two", "One", "Three"]
        deque.addLast("Four");
        // ["Two", "One", "Three", "Four]

        assertEquals(4, deque.size());

        assertEquals("Two", deque.removeFirst());
        assertEquals(3, deque.size());

        assertEquals("Four", deque.removeLast());
        assertEquals(2, deque.size());

        assertEquals("Three", deque.removeLast());
        assertEquals(1, deque.size());

        assertEquals("One", deque.removeFirst());
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddingToFrontAndRemovingFromFront() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("One");

        assertEquals("One", deque.removeFirst());
    }

    @Test
    public void testAddingToFrontAndRemovingFromLast() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("One");

        assertEquals("One", deque.removeLast());
    }
}
