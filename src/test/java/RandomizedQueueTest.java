import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class RandomizedQueueTest {

    static final int NUMBER_OF_ITERATIONS = 100000;

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
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            queue.enqueue(i);
        }

        Integer[] results = new Integer[NUMBER_OF_ITERATIONS];

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            results[i] = queue.sample();
        }

        assertEquals(NUMBER_OF_ITERATIONS,results.length);
        assertEquals(NUMBER_OF_ITERATIONS,queue.size());
    }

    @Test
    public void dequeueReturnsItemAndChangesSize() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            queue.enqueue(i);
        }

        Integer[] results = new Integer[NUMBER_OF_ITERATIONS];
        Integer[] expected = new Integer[NUMBER_OF_ITERATIONS];

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            results[i] = queue.dequeue();
            expected[i] = new Integer(i);
        }

        assertEquals(0,queue.size());

        Arrays.sort(results);
        assertEquals(expected, results);
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
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            queue.enqueue(i);
        }

        Iterator<Integer> iter = queue.iterator();

        Integer[] results = new Integer[NUMBER_OF_ITERATIONS];
        Integer[] expected = new Integer[NUMBER_OF_ITERATIONS];

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            assertTrue(iter.hasNext());
            results[i] = iter.next();
            expected[i] = new Integer(i);
        }

        assertFalse(iter.hasNext());
        assertEquals(NUMBER_OF_ITERATIONS, results.length);
    }

    @Test
    public void iterationIsIndependent() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            queue.enqueue(i);
        }

        Iterator<Integer> iter1 = queue.iterator();
        Iterator<Integer> iter2 = queue.iterator();

        Integer[] results1 = new Integer[NUMBER_OF_ITERATIONS];
        Integer[] results2 = new Integer[NUMBER_OF_ITERATIONS];

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            results1[i] = iter1.next();
            results2[i] = iter2.next();
        }

        assertNotEquals(results1, results2);
    }
}
