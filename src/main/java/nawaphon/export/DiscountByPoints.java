package nawaphon.export;


import jakarta.validation.constraints.Min;

public class DiscountByPoints extends Campaignable {

    @Min(0)
    private final float points;

    public DiscountByPoints(float points) {
        this.points = points;
    }
}
