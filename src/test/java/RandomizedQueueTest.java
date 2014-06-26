import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RandomizedQueueTest {

    @Test
    public void newQueueIsEmpty() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void emptyQueueRaisesOnDequeue() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.dequeue();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void emptyQueueRaisesOnSample() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.sample();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void addingANullItemRaises() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.enqueue(null);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void removeNotSupportedOnIterator() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        Iterator<String> iter = queue.iterator();

        iter.remove();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void nextRaisesWithNoMoreElements() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        Iterator<String> iter = queue.iterator();

        iter.next();
    }

    @Test
    public void addingAnItemChangesSize() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.enqueue("Hello");

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void samplingDoesNotChangeSize() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.enqueue("Hello");

        queue.sample();

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void samplingReturnsRandomValue() {
//        Random r = new Random();
//        r.setSeed(12345);
//        RandomizedQueue<String> queue = new RandomizedQueue<String>(r);
//
//        queue.enqueue("Hello");
//        queue.enqueue("World");
//        queue.enqueue("One");
//        queue.enqueue("Two");
//
//        assertEquals("World", queue.sample());
    }

    @Test
    public void dequeueReturnsItemAndChangesSize() {
//        Random r = new Random();
//        r.setSeed(12345);
//        RandomizedQueue<String> queue = new RandomizedQueue<String>(r);
//
//        queue.enqueue("Hello");
//        queue.enqueue("World");
//        queue.enqueue("One");
//        queue.enqueue("Two");
//
//        assertEquals("World", queue.dequeue());
//        assertEquals(3, queue.size());
    }

    @Test
    public void canAddMoreThan10Items() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        queue.enqueue("Four");
        queue.enqueue("Five");
        queue.enqueue("Six");
        queue.enqueue("Seven");
        queue.enqueue("Eight");
        queue.enqueue("Nine");
        queue.enqueue("Ten");
        queue.enqueue("Eleven");
    }

    @Test
    public void iteration() {
//        Random r = new Random();
//        r.setSeed(12345);
//        RandomizedQueue<String> queue = new RandomizedQueue<String>(r);
//
//        queue.enqueue("One");
//        queue.enqueue("Two");
//        queue.enqueue("Three");
//        queue.enqueue("Four");
//
//        Iterator<String> iter = queue.iterator();
//
//        assertEquals("Two", iter.next());
//        assertTrue(iter.hasNext());
//
//        assertEquals("Three", iter.next());
//        assertTrue(iter.hasNext());
//
//        assertEquals("Four", iter.next());
//        assertTrue(iter.hasNext());
//
//        assertEquals("Four", iter.next());
//        assertFalse(iter.hasNext());
    }
}
