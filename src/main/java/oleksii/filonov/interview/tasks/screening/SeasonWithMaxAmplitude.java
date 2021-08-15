package oleksii.filonov.interview.tasks.screening;

public class SeasonWithMaxAmplitude {

    private final String[] seasons = new String[]{"WINTER", "SPRING", "SUMMER", "AUTUMN"};

    public String solution(int[] T) {
        int seasonLength = T.length / 4;
        int maxAmplitude = Integer.MIN_VALUE;
        int maxAmplitudeSeason = 0;
        for (int seasonIndex = 0; seasonIndex < seasons.length; seasonIndex++) {
            int seasonMin = Integer.MAX_VALUE;
            int seasonMax = Integer.MIN_VALUE;
            for (int i = 0; i < seasonLength; i++) {
                seasonMin = Math.min(seasonMin, T[seasonIndex * seasonLength + i]);
                seasonMax = Math.max(seasonMax, T[seasonIndex * seasonLength + i]);
            }
            if (maxAmplitude < (seasonMax - seasonMin)) {
                maxAmplitude = seasonMax - seasonMin;
                maxAmplitudeSeason = seasonIndex;
            }
        }
        return seasons[maxAmplitudeSeason];
    }

    public static void main(String[] args) {
        SeasonWithMaxAmplitude seasonWithMaxAmplitude = new SeasonWithMaxAmplitude();
        System.out.println(seasonWithMaxAmplitude.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
    }
}
