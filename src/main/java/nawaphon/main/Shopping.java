package nawaphon.main;


public class Shopping {

    private final ItemCartEntry itemCartEntry;
    private final CampaignEntry campaignEntry;

    private float totalPrice = 0.0f;

    public Shopping(ItemCartEntry itemCartEntry, CampaignEntry campaignEntry) {
        this.itemCartEntry = itemCartEntry;
        this.campaignEntry = campaignEntry;
    }

    public boolean process() {
        return false;
    }
}
