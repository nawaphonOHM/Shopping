package nawaphon.export;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PercentageDiscountByItem extends Campaignable {

    @NotNull
    private final Category category;

    @Min(0)
    private final float amount;

    public PercentageDiscountByItem(Category category, float amount) {
        this.category = category;
        this.amount = amount;
    }
}
