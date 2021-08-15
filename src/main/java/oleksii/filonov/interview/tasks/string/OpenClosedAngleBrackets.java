package oleksii.filonov.interview.tasks.string;


import static java.lang.Math.max;

public class OpenClosedAngleBrackets {

    private static final char OPENED = '<';
    private static final char CLOSED = '>';

    public static String fastAppendSolution(String angles) {
        if (angles.isEmpty()) return angles;
        StringBuilder output = new StringBuilder();
        int openedCounter = 0;
        for (char symbol : angles.toCharArray()) {
            if (symbol == CLOSED) {
                if (openedCounter == 0) {
                    output.append(OPENED);
                } else {
                    openedCounter--;
                }
            } else {
                openedCounter++;
            }
            output.append(symbol);
        }
        while (openedCounter > 0) {
            openedCounter--;
            output.append(CLOSED);
        }
        return output.toString();
    }

    public static String countingSolution(String angles) {
        if (angles.isEmpty()) return angles;

        StringBuilder output = new StringBuilder();
        int openedCounter = 0;
        int closedCounter = 0;

        for (int i = 0; i < angles.length(); i++) {
            switch (angles.charAt(i)) {
                case OPENED: {
                    if (closedCounter > 0) {
                        printOutput(output, openedCounter, closedCounter);
                        openedCounter = 1;
                        closedCounter = 0;
                    } else {
                        openedCounter++;
                    }
                    break;
                }
                case CLOSED: {
                    closedCounter++;
                    break;
                }
                default:
                    throw new IllegalArgumentException("Symbol '" + i + "' is not supported");
            }
        }
        if (closedCounter > 0 || openedCounter > 0) {
            printOutput(output, openedCounter, closedCounter);
        }
        return output.toString();
    }

    private static void printOutput(StringBuilder output, int openedCounter, int closedCounter) {
        appendSymbol(output, max(openedCounter, closedCounter), OPENED);
        appendSymbol(output, max(openedCounter, closedCounter), CLOSED);
    }

    private static void appendSymbol(StringBuilder output, int maxBrackets, char opened) {
        while (maxBrackets > 0) {
            output.append(opened);
            maxBrackets--;
        }
    }

}
