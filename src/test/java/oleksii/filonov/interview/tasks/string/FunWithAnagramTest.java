package oleksii.filonov.interview.tasks.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FunWithAnagramTest {

    @Test
    void reduce() {
        assertArrayEquals(new String[]{"code", "frame", "framer"},
                FunWithAnagram.reduce(new String[]{"code", "doce", "ecod", "framer", "frame"}));
    }

    @Test
    public void reduceSimple() {
        assertArrayEquals(new String[]{"bla", "blaa", "blu", "tac"},
                FunWithAnagram.reduce(new String[]{"tac", "cta", "cat", "bla", "lab", "blaa", "blu"}));
    }
}