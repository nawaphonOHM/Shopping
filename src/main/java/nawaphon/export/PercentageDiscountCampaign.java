package nawaphon.export;


import jakarta.validation.constraints.Min;
import nawaphon.internal.CampaignCategory;

@CampaignCategory(category = "COUPON", id = 2)
public class PercentageDiscountCampaign extends Campaignable {


    @Min(0)
    private final float percentage;

    public PercentageDiscountCampaign(float percentage) {
        this.percentage = percentage;
    }
}
