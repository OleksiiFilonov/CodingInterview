package oleksii.filonov.interview.tasks.screening;


import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CombineIteratorsTest {

    @Test
    public void iterateOverEqualSizeArrayIterator() {
        Collection<Character> col1 = List.of('1', '2', '3');
        Collection<Character> col2 = List.of('a', 'b', 'c');
        Iterator<Character> combined = new CombineArrayIterator<>(col1.iterator(), col2.iterator());

        for (Character expected: List.of('1', 'a', '2', 'b', '3', 'c')) {
            assertEquals(expected, combined.next());
        }
        assertFalse(combined.hasNext(), "Should reach already the end of iteration");
    }

    @Test
    public void iterateOver3LastSmallerArrayIterator() {
        Collection<Character> col1 = List.of('1', '2', '3');
        Collection<Character> col2 = List.of('a', 'b', 'c');
        Collection<Character> col3 = List.of('A');
        Iterator<Character> combined = new CombineArrayIterator<>(col1.iterator(), col2.iterator(), col3.iterator());

        for (Character expected: List.of('1', 'a', 'A', '2', 'b', '3', 'c')) {
            assertEquals(expected, combined.next());
        }
        assertFalse(combined.hasNext(), "Should reach already the end of iteration");
    }

    @Test
    public void iterateOverEqualSizeListIterator() {
        Collection<Character> col1 = List.of('1', '2', '3');
        Collection<Character> col2 = List.of('a', 'b', 'c');
        Iterator<Character> combined = new CombineListIterator<>(col1.iterator(), col2.iterator());

        for (Character expected: List.of('1', 'a', '2', 'b', '3', 'c')) {
            assertEquals(expected, combined.next());
        }
        assertFalse(combined.hasNext(), "Should reach already the end of iteration");
    }

    @Test
    public void iterateOver3LastSmallerListIterator() {
        Collection<Character> col1 = List.of('1', '2', '3');
        Collection<Character> col2 = List.of('a', 'b', 'c');
        Collection<Character> col3 = List.of('A');
        Iterator<Character> combined = new CombineListIterator<>(col1.iterator(), col2.iterator(), col3.iterator());

        for (Character expected: List.of('1', 'a', 'A', '2', 'b', '3', 'c')) {
            assertEquals(expected, combined.next());
        }
        assertFalse(combined.hasNext(), "Should reach already the end of iteration");
    }
}