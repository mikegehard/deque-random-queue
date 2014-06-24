import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    class DequeIterator<Item> implements Iterator<Item> {

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

    private int size = 0;
    private Node head = null;
    private Node last = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;
        head = newNode;
        if(size == 0) {
            last = head;
        }
        size++;
    }

    public void addLast(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        last = newNode;
        if(size == 0) {
            head = last;
        }
        size++;
    }

    public Item removeFirst() {
        validateSize();
        Item val = head.item;
        head = head.next;
        size--;
        return val;
    }

    public Item removeLast() {
        validateSize();
        Item val = last.item;
        last = last.prev;
        size--;
        return val;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator<Item>();
    }

    private void validateItem(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private void validateSize() {
        if (isEmpty()) throw new NoSuchElementException();
    }

}