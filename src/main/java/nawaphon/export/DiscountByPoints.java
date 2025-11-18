package nawaphon.export;


import jakarta.validation.constraints.Min;
import nawaphon.internal.CampaignCategory;


@CampaignCategory(category = "ON_TOP", id = 2)
public class DiscountByPoints extends Campaignable {

    @Min(0)
    private final float points;

    public DiscountByPoints(float points) {
        this.points = points;
    }
}
