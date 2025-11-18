package nawaphon.export;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import nawaphon.internal.CampaignCategory;


@CampaignCategory(category = "ON_TOP", id = 1)
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
