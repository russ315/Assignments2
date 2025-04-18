import java.util.Iterator;

public class MyStack<T extends Comparable<T>>{

    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (list.size() == 0) throw new IllegalStateException("Stack is empty");
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    public T peek() {
        if (list.size() == 0) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }


    public T[] toArray() {
        return list.toArray();
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
