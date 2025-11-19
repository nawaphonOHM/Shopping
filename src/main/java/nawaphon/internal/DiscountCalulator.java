package nawaphon.internal;


import nawaphon.export.Campaignable;
import nawaphon.export.FixAmountCampaign;
import nawaphon.main.CampaignEntry;
import nawaphon.main.ItemCartEntry;
import org.jetbrains.annotations.NotNull;

public abstract class DiscountCalulator {


    public static boolean sortedCampaign(@NotNull CampaignEntry campaign) {

        campaign.sortedBy(new CampaignComparable());

        return true;
    }

    public static DiscountReceived calculateDiscount(ItemCartEntry itemCart, Campaignable campaign) {

        if (campaign instanceof FixAmountCampaign) {
            return new DiscountReceived(((FixAmountCampaign) campaign).getAmount());
        }

        return null;
    }

}
