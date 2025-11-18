package nawaphon.main.builder;



import nawaphon.export.Campaignable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CampaignEntryBuilder {

    private final List<Campaignable> campaignables = new ArrayList<>();

    private CampaignEntryBuilder() {

    }

    @NotNull
    @Contract(" -> new")
    public static CampaignEntryBuilder getBuilder() {
        return new CampaignEntryBuilder();
    }

    public CampaignEntryBuilder addCampaignable(Campaignable campaignable) {
        campaignables.add(campaignable);

        return this;
    }

}
