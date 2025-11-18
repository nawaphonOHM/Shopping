package nawaphon.export;


import jakarta.validation.constraints.Min;

public class SpecialCampaigns extends Campaignable {

    @Min(0)
    private final float everyBaht;

    private final float discount;

    public SpecialCampaigns(float everyBaht, float discount) {
        this.everyBaht = everyBaht;
        this.discount = discount;
    }
}
