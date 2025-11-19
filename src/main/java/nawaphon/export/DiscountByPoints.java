package nawaphon.export;


import jakarta.validation.constraints.Min;
import nawaphon.internal.CampaignCategory;
import nawaphon.internal.Order;


@CampaignCategory(category = "ON_TOP", id = 2)
@Order(2)
public class DiscountByPoints extends Campaignable {

    @Min(0)
    private final float points;

    public DiscountByPoints(float points) {
        this.points = points;
    }

    public float getPoints() {
        return points;
    }
}
