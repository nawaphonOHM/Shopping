package nawaphon.export;


import jakarta.validation.constraints.NotNull;

public class PercentageDiscountByItem extends Campaignable {

    @NotNull
    private final Category category;

    private final float amount;

    public PercentageDiscountByItem(Category category, float amount) {
        this.category = category;
        this.amount = amount;
    }
}
