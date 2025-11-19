package nawaphon.main;


import nawaphon.internal.DiscountCalulator;

import java.math.BigDecimal;

public class Shopping {

    private final ItemCartEntry itemCartEntry;
    private final CampaignEntry campaignEntry;

    private float totalPrice = 0.0f;

    public Shopping(ItemCartEntry itemCartEntry, CampaignEntry campaignEntry) {
        this.itemCartEntry = itemCartEntry;
        this.campaignEntry = campaignEntry;
    }

    public boolean process() {
        itemCartEntry.iterator().forEachRemaining(item -> totalPrice += item.getTotalPrice());

        DiscountCalulator.sortedCampaign(campaignEntry);

        totalPrice = DiscountCalulator.calculateTotal(itemCartEntry).total();

        campaignEntry.getCampaignables().forEachRemaining(campaignable ->
                totalPrice = new BigDecimal(totalPrice)
                .subtract(new BigDecimal(DiscountCalulator.calculateDiscount(itemCartEntry, campaignable).discount()))
                .floatValue());


        return true;
    }
}
