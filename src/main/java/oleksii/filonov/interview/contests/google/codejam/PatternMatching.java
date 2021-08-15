package oleksii.filonov.interview.contests.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.out;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
 */
public class PatternMatching {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }
            analyzePatterns(caseIndex, patterns);
        }
    }

    private static void analyzePatterns(int caseIndex, String[] patterns) {
        String pref = "";
        String suf = "";
        boolean isOK = true;
        List<String> middle = new LinkedList<>();
        for (String pattern : patterns) {
            int last = -1;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    if (last == -1) {
                        String otherPref = pattern.substring(0, j);
                        if (otherPref.length() > pref.length()) {
                            String temp = pref;
                            pref = otherPref;
                            otherPref = temp;
                        }
                        if (!pref.startsWith(otherPref)) {
                            isOK = false;
                            break;
                        }
                    } else {
                        String mid = pattern.substring(last + 1, j);
                        if (!mid.isEmpty())
                            middle.add(mid);
                    }
                    last = j;
                }
            }
            if (!isOK)
                break;
            String otherSuf = pattern.substring(last + 1);
            if (otherSuf.length() > suf.length()) {
                String temp = suf;
                suf = otherSuf;
                otherSuf = temp;
            }
            if (!suf.endsWith(otherSuf)) {
                isOK = false;
                break;
            }
        }
        if (isOK) {
            out.println(String.format("Case #%s: %s", caseIndex, pref + String.join("", middle) + suf));
        } else {
            out.println(String.format("Case #%s: *", caseIndex));
        }
    }

}
