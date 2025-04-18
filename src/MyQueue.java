import java.util.Iterator;

public class MyQueue<T extends Comparable<T>> {

    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new IllegalStateException("Queue is empty");
        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    public T peek() {
        if (list.size() == 0) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }


    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
