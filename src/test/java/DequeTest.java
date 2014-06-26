import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

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

        Iterator<String> iterator = deque.iterator();

        assertFalse(iterator.hasNext());
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
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 0; i < 150; i++) {
            deque.addFirst(i);
        }

        for (int i = 149; i >= 0; i--) {
            assertEquals(new Integer(i), deque.removeFirst());
        }
    }

    @Test
    public void testAddingToFrontAndRemovingFromLast() {
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 0; i < 150; i++) {
            deque.addFirst(i);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(new Integer(i), deque.removeLast());
        }
    }

    @Test
    public void testAddingToEndAndRemovingFromFront() {
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 0; i < 150; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(new Integer(i), deque.removeFirst());
        }
    }

    @Test
    public void testIteration() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("One");
        deque.addFirst("Two");
        // ["Two", "One"]

        Iterator<String> iterator = deque.iterator();

        assertEquals("Two", iterator.next());
        assertTrue(iterator.hasNext());

        assertEquals("One", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
