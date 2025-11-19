package nawaphon.internal;


import nawaphon.main.CampaignEntry;
import org.jetbrains.annotations.NotNull;

public abstract class DiscountCalulator {


    public static boolean sortedCampaign(@NotNull CampaignEntry campaign) {

        campaign.sortedBy(new CampaignComparable());

        return true;
    }

}
