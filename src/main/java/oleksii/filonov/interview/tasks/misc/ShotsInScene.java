package oleksii.filonov.interview.tasks.misc;

import java.util.*;

public class ShotsInScene {

    //ababaccdac
    //a -> 1
    //ab -> 1
    //aba -> 1

    List<Integer> lengthEachScene(List<Character> inputList) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> shotHistogram = new HashMap<>();

        for (Character character : inputList) {
            shotHistogram.merge(character, 1, Integer::sum);
        }
        Map<Character, Integer> encounterHistogram = new HashMap<>();
        int counter = 0;
        for (Character character : inputList) {
            counter++;
            encounterHistogram.merge(character, 1, Integer::sum);
            if (containsAll(encounterHistogram, shotHistogram)) {
                result.add(counter);
                encounterHistogram.clear();
                counter = 0;
            }
        }
        return result;
    }

    private boolean containsAll(Map<Character, Integer> encounters, Map<Character, Integer> shots) {
        for (Map.Entry<Character, Integer> entry : encounters.entrySet()) {
            Integer shotCount = shots.get(entry.getKey());
            if (!shotCount.equals(entry.getValue())) return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
