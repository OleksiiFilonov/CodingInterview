package oleksii.filonov.interview.tasks.datastructures.hashtables;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FetchAllTest {

    @Test
    public void fetchMaximum() {
        Map<String, Set<String>> recommendations = createTestRecommendations();
        Set<String> expected = Set.of("B", "C", "D", "E", "F");

        FetchAll fetchAll = new FetchAll();
        Set<String> actual = fetchAll.fetch(recommendations, "A", 310);

        assertEquals(expected.size(), actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));

        actual = fetchAll.fetch(recommendations, "A", expected.size());

        assertEquals(expected.size(), actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));
    }

    @Test
    public void fetchMaximumWithPriority() {
        Map<String, Set<String>> recommendations = createTestRecommendations();
        Set<String> expected = Set.of("B", "C", "D", "E", "F");

        FetchAll fetchAll = new FetchAll();
        Set<String> actual = fetchAll.fetchWithPriority(recommendations, "A", 310);

        assertEquals(expected.size(), actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));

        actual = fetchAll.fetchWithPriority(recommendations, "A", expected.size());

        assertEquals(expected.size(), actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));
    }

    @Test
    public void fetchUpTo() {
        Map<String, Set<String>> recommendations = createTestRecommendations();
        Set<String> expected = Set.of("B", "C", "D", "E", "F");

        FetchAll fetchAll = new FetchAll();
        int cap = 3;
        Set<String> actual = fetchAll.fetch(recommendations, "A", cap);

        assertEquals(cap, actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));
    }

    @Test
    public void shouldNotFindRecommendationsForUnrelatedProduct() {
        Map<String, Set<String>> recommendations = createTestRecommendations();
        Set<String> expected = Set.of("K", "L");

        FetchAll fetchAll = new FetchAll();
        int cap = 3;
        Set<String> actual = fetchAll.fetch(recommendations, "A", cap);

        assertEquals(cap, actual.size());
        actual.forEach(element -> assertFalse(expected.contains(element)));
    }

    @Test
    public void fetchOnlyOne() {
        Map<String, Set<String>> recommendations = createTestRecommendations();
        Set<String> expected = Set.of("K", "L");

        FetchAll fetchAll = new FetchAll();
        int cap = 1;
        Set<String> actual = fetchAll.fetch(recommendations, "M", cap);

        assertEquals(cap, actual.size());
        actual.forEach(element -> assertTrue(expected.contains(element)));
    }


    private Map<String, Set<String>> createTestRecommendations() {
        Map<String, Set<String>> recommendations = new HashMap<>();
        recommendations.put("A", Set.of("B", "C"));
        recommendations.put("B", Set.of("A", "C", "D"));
        recommendations.put("C", Set.of("B", "A"));
        recommendations.put("D", Set.of("E", "F"));
        recommendations.put("E", Set.of("D"));
        recommendations.put("F", Set.of("D"));
        recommendations.put("M", Set.of("K", "L"));
        recommendations.put("K", Set.of("M"));
        recommendations.put("L", Set.of("M"));
        return recommendations;
    }
}