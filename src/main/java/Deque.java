import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    class DequeIterator<Item> implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            throw new NoSuchElementException();
//            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Deque() {
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public void addFirst(Item item) {
        validateItem(item);
    }

    public void addLast(Item item) {
        validateItem(item);
    }

    public Item removeFirst() {
        validateSize();
        return null;
    }

    public Item removeLast() {
        validateSize();
        return null;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator<Item>();
    }

    private void validateItem(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private void validateSize() {
        if (size() == 0) throw new NoSuchElementException();
    }

}