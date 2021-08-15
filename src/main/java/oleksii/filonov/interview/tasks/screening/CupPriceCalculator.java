package oleksii.filonov.interview.tasks.screening;

import java.util.ArrayList;
import java.util.List;

public class CupPriceCalculator {

    private final Size size;
    private final List<String> condiments;
    private final double basePrice;
    private final double[] condimentPriceSchema;

    public CupPriceCalculator(Size size, double basePrice, double[] condimentPriceSchema) {
        this.size = size;
        this.condiments = new ArrayList<>();
        this.basePrice = basePrice;
        this.condimentPriceSchema = condimentPriceSchema;
    }

    public CupPriceCalculator addCondiment(String condiment) {
        condiments.add(condiment);
        return this;
    }

    public double getTotal() {
        return basePrice + condiments.size() * condimentPriceSchema[size.ordinal()];
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }
}
