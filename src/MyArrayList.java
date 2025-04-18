import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements IMyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void addFirst(T item) {
        if (length == elements.length) {
            increaseCapacity();
        }
        for (int i = length; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = item;
        length++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[length - 1];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null;
    }

    @Override
    public void removeFirst() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        for (int i = 0; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null;
    }

    @Override
    public void removeLast() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        elements[--length] = null;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                @SuppressWarnings("unchecked")
                Comparable<T> current = (Comparable<T>) elements[j];
                T next = (T) elements[j + 1];
                if (current.compareTo(next) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(item)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public boolean exists(T item) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = (T) elements[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < length;
            }

            @Override
            public T next() {
                return (T) elements[current++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
