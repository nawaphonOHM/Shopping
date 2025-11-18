package nawaphon.export;


import jakarta.validation.constraints.NotNull;

public class PercentageDiscountByItem extends Campaignable {

    @NotNull
    private final Category category;

    public PercentageDiscountByItem(Category category) {
        this.category = category;
    }
}
