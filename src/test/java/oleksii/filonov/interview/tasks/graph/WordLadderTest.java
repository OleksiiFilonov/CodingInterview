package oleksii.filonov.interview.tasks.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordLadderTest {

    @Test
    void ladderLength() {
        WordLadder wordLadder = new WordLadder();
        assertEquals(2, wordLadder.ladderLength("hit", "hot", List.of("hot")));
        assertEquals(5, wordLadder.ladderLength(
                "hit", "cog",List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }
}