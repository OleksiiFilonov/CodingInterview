package oleksii.filonov.interview.contests.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.codechef.com/MAY20B/problems/CORUS
 */
public class IsolationCenters {
    public static void main1(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int Q = in.nextInt();
            String viruses = in.next();
            char[] patientsPerVirus = new char[26];
            for (char virus : viruses.toCharArray()) {
                patientsPerVirus[virus - 'a']++;
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < Q; i++) {
                int numOfCenters = in.nextInt();
                int inQueue = 0;
                for (int numOfPatients : patientsPerVirus) {
                    if (numOfPatients > numOfCenters)
                        inQueue += numOfPatients - numOfCenters;
                }
                output.append(inQueue).append(System.lineSeparator());
            }
            System.out.print(output);
        }
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList();
        for (int num : arr1) {
            result.add(num);
        }
        removeNotIncludedFrom(result, arr2);
        removeNotIncludedFrom(result, arr3);
        return result;
    }

    private static void removeNotIncludedFrom(List<Integer> result, int[] array) {
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (Arrays.binarySearch(array, next) > -1)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        System.out.print(arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8}));
    }
}
