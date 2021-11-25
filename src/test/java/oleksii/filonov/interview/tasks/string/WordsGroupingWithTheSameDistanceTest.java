package oleksii.filonov.interview.tasks.string;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static oleksii.filonov.interview.tasks.string.WordsGroupingWithTheSameDistance.group;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordsGroupingWithTheSameDistanceTest {

    @Test
    public void groupLong() {
        Collection<List<String>> grouped = group(new String[]{"abc", "dog", "grj", "bcd", "def", "apple"});
        assertTrue(contains(grouped, new ArrayList<>(List.of("abc", "bcd", "def"))));
        assertTrue(contains(grouped, new ArrayList<>(List.of("dog", "grj"))));
        assertTrue(contains(grouped, new ArrayList<>(List.of("apple"))));
    }

    @Test
    public void groupAll() {
        Collection<List<String>> grouped = group(new String[]{"ab", "xy", "yz"});
        assertTrue(contains(grouped, new ArrayList<>(List.of("ab", "xy", "yz"))));
    }

    @Test
    public void groupNegative() {
        // az -> ba
        // 0,25 -> 1,0
        Collection<List<String>> grouped = group(new String[]{"az", "ba"});
        assertTrue(contains(grouped, new ArrayList<>(List.of("az", "ba"))));
    }

    @Test
    public void groupNone() {
        Collection<List<String>> grouped = group(new String[]{"abc", "sdf", "ase", "a"});
        assertTrue(contains(grouped, new ArrayList<>(List.of("abc"))));
        assertTrue(contains(grouped, new ArrayList<>(List.of("sdf"))));
        assertTrue(contains(grouped, new ArrayList<>(List.of("ase"))));
        assertTrue(contains(grouped, new ArrayList<>(List.of("a"))));
    }

    private boolean contains(Collection<List<String>> grouped, List<String> lookFor) {
        for (List<String> list : grouped) {
            if (list.equals(lookFor))
                return true;
        }
        return false;
    }
}