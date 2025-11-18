package nawaphon.export;


import jakarta.validation.constraints.Min;

public class SpecialCampaigns extends Campaignable {

    @Min(0)
    private final float everyBaht;

    public SpecialCampaigns(float everyBaht) {
        this.everyBaht = everyBaht;
    }
}
