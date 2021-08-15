package oleksii.filonov.interview.tasks.math;

public class BigNumbersAddition {

    public static String add(String input1, String input2) {
        String longest = input1;
        String shortest = input2;
        if (longest.length() < shortest.length()) {
            longest = input2;
            shortest = input1;
        }

        int shortLengthIndex = shortest.length() - 1;
        int longLengthIndex = longest.length() - 1;
        int overflow = 0;
        String output = "";
        //1115 + 66 = 1181
        while (shortLengthIndex >= 0) {
            int longV = Integer.parseInt(longest.substring(longLengthIndex, longLengthIndex + 1));
            int shortV = Integer.parseInt(shortest.substring(shortLengthIndex, shortLengthIndex + 1));
            int sum = longV + shortV + overflow;
            overflow = sum / 10;
            output = sum % 10 + output;
            shortLengthIndex--;
            longLengthIndex--;
        }
        while (longLengthIndex >= 0) {
            int longV = Integer.parseInt(longest.substring(longLengthIndex, longLengthIndex + 1));
            int sum = longV + overflow;
            overflow = sum / 10;
            output = sum % 10 + output;
            longLengthIndex--;
        }
        if (overflow > 0)
            output = overflow + output;
        return output;
    }
}
