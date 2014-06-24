import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    class DequeIterator implements Iterator<Item> {
        private Node current;

        DequeIterator(Node currentHead) {
            current = currentHead;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.item;
            current = current.next;
            return value;
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
        if (size == 0) {
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
        if (size == 0) {
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
        return new DequeIterator(head);
    }

    private void validateItem(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private void validateSize() {
        if (isEmpty()) throw new NoSuchElementException();
    }

}