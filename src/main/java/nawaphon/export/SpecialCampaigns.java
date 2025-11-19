package nawaphon.export;


import jakarta.validation.constraints.Min;
import nawaphon.internal.CampaignCategory;
import nawaphon.internal.Order;


@CampaignCategory(category = "SEASONAL", id = 1)
@Order(3)
public class SpecialCampaigns extends Campaignable {

    @Min(0)
    private final float everyBaht;

    @Min(0)
    private final float discount;

    public SpecialCampaigns(float everyBaht, float discount) {
        this.everyBaht = everyBaht;
        this.discount = discount;
    }

    public float getEveryBaht() {
        return everyBaht;
    }
}
