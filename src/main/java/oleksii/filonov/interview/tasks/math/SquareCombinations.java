package oleksii.filonov.interview.tasks.math;

public class SquareCombinations {

    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1; i <= 16; i++) {
            for (int j = i + 1; j <= 16; j++) {
                for (int k = j + 1; k <= 16; k++) {
                    int m = 34 - k - j - i;
                    if(m > 0) {
                        counter++;
                        System.out.println(String.format("%s: [%s, %s, %s, %s]", counter, i, j, k, m));
                    }
                }
            }
        }
    }
}
