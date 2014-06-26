import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] storage;
    private int size = 0;
    private Random generator;

    public RandomizedQueue() {
        storage = (Item[]) new Object[10];
        this.generator = new Random();
    }

//    public RandomizedQueue(Random generator) {
//        this();
//        this.generator = generator;
//    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        validateItem(item);
        if (storage.length == size) {
            Item[] newStorage = (Item[]) new Object[storage.length * 2];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
        }
        storage[size] = item;
        size++;
    }

    public Item dequeue() {
        checkItemExists();
        int randomItemIndex = generator.nextInt(size);
        Item item = storage[randomItemIndex];
        storage[randomItemIndex] = null;
        size--;
        return item;
    }

    public Item sample() {
        checkItemExists();
        return storage[generator.nextInt(size)];
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator(generator, Arrays.copyOfRange(storage, 0, size));
    }

    private void checkItemExists() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    private void validateItem(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private Random generator;
        private int currentPosition = 0;
        private Item[] items;

        public RandomQueueIterator(Random r, Item[] items) {
            generator = r;
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return currentPosition != items.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item val = items[generator.nextInt(items.length)];
            currentPosition++;
            return val;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
