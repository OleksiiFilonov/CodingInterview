package oleksii.filonov.interview.tasks.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnomalyDetection {

    /**
     * @param cpu       - metrics, e.g [9, 10, 5, 3]
     * @param threshold - percent for anomaly
     * @return time and anomaly
     */
    public static List<int[]> detectAnomalies(int[] cpu, int threshold) {
        List<int[]> result = new ArrayList<>();
        int[] prefixSum = calculatePrefixSum(cpu);
        Arrays.stream(prefixSum).forEach(data -> System.out.print(data + " "));
        double thresholdD = (double) threshold / 100;
        System.out.println(thresholdD);
        for (int i = 1; i < cpu.length; i++) {
            double average = (double) prefixSum[i - 1] / (i);
            double diff = (average - cpu[i]) / average;
            System.out.println("Index: " + i + " diff: " + diff + " prefix: " + prefixSum[i - 1] + " current: " + cpu[i] + " average: " + average);
            if (Math.abs(diff) > thresholdD)
                result.add(new int[]{i + 1, (int) (diff * 100)});
        }
        return result;
    }

    private static int[] calculatePrefixSum(int[] cpu) {
        int[] prefixSum = new int[cpu.length];
        prefixSum[0] = cpu[0];
        for (int i = 1; i < cpu.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + cpu[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        detectAnomalies(new int[]{9, 10, 5, 3}, 20).forEach(data -> System.out.println(Arrays.toString(data)));
        detectAnomalies(new int[]{10, 10, 5}, 20).forEach(data -> System.out.println(Arrays.toString(data)));
    }
}
