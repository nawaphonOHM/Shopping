package nawaphon.export;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import nawaphon.internal.CampaignCategory;
import nawaphon.internal.Order;


@CampaignCategory(category = "ON_TOP", id = 1)
@Order(2)
public class PercentageDiscountByItem extends Campaignable {

    @NotNull
    private final Category category;

    @Min(0)
    private final float amount;

    public PercentageDiscountByItem(Category category, float amount) {
        this.category = category;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }
}
