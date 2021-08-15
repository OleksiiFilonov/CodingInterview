package oleksii.filonov.interview.tasks.screening;

import java.util.*;

/**
 * Similar to https://leetcode.com/problems/cinema-seat-allocation/
 */
public class AirplaneSeatsAllocation {

    public int solution(int N, String S) {
        //I think the best to solve this task with the bit manipulation and if I had more time I would do it that way
        //free - false, occupied - true;
        char[] aisle = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        Map<Character, Integer> aisleMap = new HashMap<>();
        for (int i = 0; i < aisle.length; i++) {
            aisleMap.put(aisle[i], i);
        }
        boolean[][] seats = new boolean[N][aisle.length];
        if (!S.isEmpty()) {
            for (String seat : S.split(" ")) {
                if (!seat.isEmpty()) {
                    int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                    Integer column = aisleMap.get(seat.charAt(seat.length() - 1));
                    seats[row - 1][column] = true;
                }
            }
        }
        return families(seats);
    }

    private int families(boolean[][] seats) {
        int families = 0;
        for (boolean[] seat : seats) {
            int members = 0;
            for (int column = 1; column < 9; column++) {
                if (seat[column]) {
                    members = 0;
                } else {
                    members++;
                    if (members == 4) {
                        members = 0;
                        families++;
                    }
                }
            }
        }
        return families;
    }

    public int solutionBit(int N, String S) {
        //I think the best to solve this task with the bit manipulation and if I had more time I would do it that way
        //free - false, occupied - true;
        char[] aisle = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        Map<Character, Integer> aisleMap = new HashMap<>();
        for (int i = 0; i < aisle.length; i++) {
            aisleMap.put(aisle[i], i);
        }
        BitSet[] seats = new BitSet[N];
        for (int i = 0; i < N; i++) {
            seats[i] = new BitSet(aisle.length);
            seats[i].set(0, aisle.length - 1);
        }

        for (String seat : S.split(" ")) {
            if (!seat.isEmpty()) {
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                Integer column = aisleMap.get(seat.charAt(seat.length() - 1));
                seats[row - 1].flip(column);
            }
        }
        return familiesBit(seats);
    }

    private int familiesBit(BitSet[] seats) {
        int families = 0;
        final BitSet _2Families = new BitSet(seats[0].length());
        _2Families.set(1, 9);
        final BitSet _1_1Family = new BitSet();
        _1_1Family.set(1, 5);
        final BitSet _1_2Family = new BitSet();
        _1_2Family.set(3, 7);
        final BitSet _1_3Family = new BitSet();
        _1_3Family.set(5, 9);
        for (BitSet seat : seats) {
            if (seat.intersects(_2Families)) {
                families += 2;
            } else if (seat.intersects(_1_1Family)
                    || seat.intersects(_1_2Family)
                    || seat.intersects(_1_3Family)) {
                families += 1;
            }
        }
        return families;
    }

    private final short[] oneFamilies = new short[]{0b0111100000, 0b0001111000, 0b0000011110};
    private final short twoFamily = 0b0111111110;

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, Comparator.comparing(a -> a[0]));
        int families = 0;
        for (int i = 0, j = 0; i < n; i++) {
            int row = Short.MAX_VALUE;
            while (j < reservedSeats.length && reservedSeats[j][0] == i + 1) {
                row &= ~(1 << reservedSeats[j][1] -1);
                j++;
            }
            if (row == Short.MAX_VALUE || (twoFamily & row) == twoFamily) {
                families += 2;
            } else if (isOneFamily(row))
                families += 1;
        }
        return families;
    }

    private boolean isOneFamily(int row) {
        for (int pattern : oneFamilies) {
            if ((pattern & row) == pattern)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AirplaneSeatsAllocation airplaneSeatsAllocation = new AirplaneSeatsAllocation();
        System.out.println(airplaneSeatsAllocation.solution(2, "1A 2F 1C"));
        System.out.println(airplaneSeatsAllocation.solution(1, ""));
        System.out.println(airplaneSeatsAllocation.solutionBit(2, "1A 2F 1C"));
        System.out.println(airplaneSeatsAllocation.solutionBit(1, ""));
        System.out.println(airplaneSeatsAllocation.maxNumberOfFamilies(2, new int[][]{{1, 1}, {2, 6}, {1, 3}}));
        System.out.println(airplaneSeatsAllocation.maxNumberOfFamilies(1, new int[][]{}));
    }
}
