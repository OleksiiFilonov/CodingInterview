package oleksii.filonov.interview.tasks.misc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * speed, accuracy, price, value
 */
public class PopularFeatures {


    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        if (topFeatures == 0
                || possibleFeatures == null || possibleFeatures.isEmpty()
                || numFeatureRequests == 0 || featureRequests == null || featureRequests.isEmpty())
            return new ArrayList<>();


        List<String> smallPossibleFeatures = possibleFeatures.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> smallFeatureRequests = featureRequests.stream().map(String::toLowerCase).collect(Collectors.toList());
        Map<String, Integer> featureHistogram = new HashMap<>();
        for (String feature : smallPossibleFeatures) {
            for (String featureRequest : smallFeatureRequests) {
                if (featureRequest.matches(".*\\b" + feature + "\\b.*"))
                    featureHistogram.merge(feature, 1, Integer::sum);
            }
        }

        List<Encounter> topFeatureList = createTopFeaturesList(featureHistogram);

        return limitTopFeaturesList(topFeatures, topFeatureList);
    }

    private List<Encounter> createTopFeaturesList(Map<String, Integer> featureHistogram) {
        List<Encounter> topFeatureList = new ArrayList<>(featureHistogram.size());
        for (Map.Entry<String, Integer> entry : featureHistogram.entrySet()) {
            topFeatureList.add(new Encounter(entry.getKey(), entry.getValue()));
        }

        topFeatureList.sort((o1, o2) -> {
            int frequencyCompare = o2.frequency.compareTo(o1.frequency);
            if (frequencyCompare == 0)
                return o2.feature.compareTo(o1.feature);
            return frequencyCompare;
        });
        return topFeatureList;
    }

    private ArrayList<String> limitTopFeaturesList(int topFeatures, List<Encounter> topFeatureList) {
        ArrayList<String> topFeaturesList = new ArrayList<>();
        int topFeaturesLimit = Math.min(topFeatureList.size(), topFeatures);
        for (int i = 0; i < topFeaturesLimit; i++) {
            topFeaturesList.add(topFeatureList.get(i).feature);
        }
        return topFeaturesList;
    }

    private static class Encounter {
        private final String feature;
        private final Integer frequency;

        private Encounter(String feature, Integer frequency) {
            this.feature = feature;
            this.frequency = frequency;
        }
    }


    public static void main(String[] args) {
        PopularFeatures popularFeatures = new PopularFeatures();
        System.out.println(
                popularFeatures.popularNFeatures(2, 2,
                        List.of("one", "two", "three"), 3,
                        List.of(" one bla three", "two       blathree", "two three")));
    }
}
