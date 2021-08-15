package oleksii.filonov.interview.tasks.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HousesCompetition {

    public List<Integer> cellCompete(int[] states, int days) {
        int initialDays = days;
        int numOfHouses = states.length;
        int[] previousState = Arrays.copyOf(states, numOfHouses);
        int[] nextDayState = new int[numOfHouses];
        while (initialDays > 0) {
            initialDays--;
            nextDayState[0] = xor(0, previousState[1]);
            for (int i = 1; i < numOfHouses - 1; i++) {
                nextDayState[i] = xor(previousState[i-1], previousState[i+1]);
            }
            nextDayState[numOfHouses-1] = xor(previousState[numOfHouses-2], 0);
            previousState = Arrays.copyOf(nextDayState, numOfHouses);
        }
        return Arrays.stream(nextDayState).boxed().collect(Collectors.toList());
    }

    private int xor(int left, int right) {
        if (left == right)
            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        HousesCompetition housesCompetition = new HousesCompetition();
        System.out.println(Arrays.toString(new int [] {1, 1, 1, 0, 1, 1, 1, 1}));
        System.out.println(housesCompetition.cellCompete(new int [] {1, 1, 1, 0, 1, 1, 1, 1}, 1));
        System.out.println(housesCompetition.cellCompete(new int [] {1, 1, 1, 0, 1, 1, 1, 1}, 2));
    }
}
