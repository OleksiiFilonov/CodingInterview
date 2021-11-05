package oleksii.filonov.interview.tasks.screening;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CombineListIterator<T> implements Iterator<T> {

    private static class Node<T> {
        private Node<T> next;
        private Iterator<T> value;

        public Node(Iterator<T> value) {
            this.value = value;
        }
    }

    private Node<T> current;
    private final int size;

    public CombineListIterator(Iterator<T>... iterators) {
        this.size = iterators.length;
        if (size > 0) {
            Node<T> dummyHead = new Node<>(null);
            Node<T> current = dummyHead;
            for (int i = 0; i < size; i++) {
                Node<T> newNode = new Node<>(iterators[i]);
                current.next = newNode;
                current = newNode;
            }
            current.next = dummyHead.next;
            this.current = dummyHead.next;
        }

    }


    @Override
    public boolean hasNext() {
        int count = size;
        while (count > 0) {
            if (current.value.hasNext())
                return true;
            current = current.next;
            count--;
        }
        return false;
    }

    @Override
    public T next() {
        int count = size;
        while (count > 0) {
            if (current.value.hasNext()) {
                T next = current.value.next();
                current = current.next;
                return next;
            }
            current = current.next;
            count--;
        }
        throw new NoSuchElementException("There is no more elements left for iteration");
    }
}
