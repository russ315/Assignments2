import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements IMyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkBounds(index);
        Node node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Node current = getNode(index);
            Node newNode = new Node(item);
            Node prevNode = current.prev;

            newNode.next = current;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        Node node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new NoSuchElementException();
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new NoSuchElementException();
        removeNode(tail);
    }

    @Override
    public void sort() {
        if (size <= 1) return;

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data.compareTo(j.data) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(T item) {
        int index = 0;
        for (Node node = head; node != null; node = node.next) {
            if (node.data.equals(item)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int index = size - 1;
        for (Node node = tail; node != null; node = node.prev) {
            if (node.data.equals(item)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Comparable[size];
        int i = 0;
        for (Node node = head; node != null; node = node.next) {
            array[i++] = node.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        checkBounds(index);
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void removeNode(Node node) {
        if (node.prev == null) head = node.next;
        else node.prev.next = node.next;

        if (node.next == null) tail = node.prev;
        else node.next.prev = node.prev;

        size--;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
