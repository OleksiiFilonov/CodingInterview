package oleksii.filonov.interview.tasks.math;

//Greatest common divisor
public class GCD {

    public int generalizedGCD(int num, int[] arr) {
        if (num == 1)
            return arr[0];
        int num1 = arr[0];
        int num2 = arr[1];
        int gcd = gcd(num1, num2);
        for (int i = 2; i < num; i++) {
            gcd = gcd(arr[i], gcd);
        }
        return gcd;
    }

    private int gcd(int num1, int num2) {
        int remainder = num1 % num2;
        if (remainder == 0)
            return num2;
        else
            return gcd(num2, remainder);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.generalizedGCD(5, new int[]{2, 4, 6, 8, 10}));
        System.out.println(gcd.generalizedGCD(5, new int[]{2, 3, 4, 5, 6}));
        System.out.println(3 % 5);
    }


}
