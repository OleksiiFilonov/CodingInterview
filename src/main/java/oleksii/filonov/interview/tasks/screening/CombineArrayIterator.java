package oleksii.filonov.interview.tasks.screening;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CombineArrayIterator<T> implements Iterator<T> {

    private final Iterator<T> [] iterators;
    private int curIndex = 0;

    public CombineArrayIterator(Iterator<T> ... iterators) {
        this.iterators = iterators;
    }


    @Override
    public boolean hasNext() {
        for (Iterator<T> iterator: iterators)
            if (iterator.hasNext())
                return true;
        return false;
    }

    @Override
    public T next() {
        int count = iterators.length;
        while (count > 0) {
            if (iterators[curIndex].hasNext()) {
                T next = iterators[curIndex].next();
                curIndex++;
                curIndex %= iterators.length;
                return next;
            } else {
                curIndex++;
                curIndex %= iterators.length;
            }
            count--;
        }
        throw new NoSuchElementException("There is no more elements left for iteration");
    }
}
