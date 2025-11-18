package nawaphon.export;


import jakarta.validation.constraints.Min;

public class FixAmountCampaign extends Campaignable {

    @Min(0)
    private final float amount;

    public FixAmountCampaign(float amount) {
        this.amount = amount;
    }
}
