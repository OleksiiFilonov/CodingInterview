package oleksii.filonov.interview.tasks.string;

import java.util.LinkedList;
import java.util.List;

public class LexigraphicallySmaller {

    public String findLexSmallestString(String s, int a, int b) {
        List<Integer> digit = new LinkedList<>();
        for (char c : s.toCharArray()) {
            digit.add(Character.getNumericValue(c));
        }
        String smallest = s;
        while (true) {
            System.out.println("smallest: " + smallest);
            //add
            String addition = add(smallest, a);
            System.out.println("addition: " + addition);
            if (addition.compareTo(smallest) < 0) {
                smallest = addition;
                continue;
            }
            //rotate
            String rotation = rotate(smallest, b);
            System.out.println("rotation: " + rotation);
            if (rotation.compareTo(smallest) < 0) {
                smallest = rotation;
                continue;
            }
            break;
        }
        return smallest;
    }

    private String rotate(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }

    private String add(String s, int a) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0)
                sb.append(s.charAt(i));
            else
                sb.append((Character.getNumericValue(s.charAt(i)) + a) % 10);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LexigraphicallySmaller smaller = new LexigraphicallySmaller();
        //System.out.println(smaller.findLexSmallestString("5525", 9, 2));//2050
        System.out.println(smaller.findLexSmallestString("43987654",7,3));
    }
}
