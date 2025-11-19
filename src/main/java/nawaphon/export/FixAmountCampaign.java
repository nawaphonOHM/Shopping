package nawaphon.export;


import jakarta.validation.constraints.Min;
import nawaphon.internal.CampaignCategory;
import nawaphon.internal.Order;

@CampaignCategory(category = "COUPON", id = 1)
@Order(1)
public class FixAmountCampaign extends Campaignable {

    @Min(0)
    private final float amount;

    public FixAmountCampaign(float amount) {
        this.amount = amount;
    }
}
