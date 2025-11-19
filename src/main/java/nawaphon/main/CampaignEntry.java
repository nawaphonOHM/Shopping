package nawaphon.main;



import nawaphon.export.Campaignable;

import java.util.Comparator;
import java.util.List;

public class CampaignEntry {

    private final List<Campaignable> campaignables;

    public CampaignEntry(List<Campaignable> campaignables) {
        this.campaignables = campaignables;
    }

    public boolean sortedBy(Comparator<Campaignable> comparator) {
        return false;
    }
}
