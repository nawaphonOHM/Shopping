package nawaphon.main.builder;


import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import nawaphon.export.Campaignable;
import nawaphon.internal.FoundKey;
import nawaphon.internal.FoundValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import nawaphon.main.CampaignEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaignEntryBuilder {

    private final List<Campaignable> campaignables = new ArrayList<>();

    private final Map<FoundKey, FoundValue> campaignTable = new HashMap<>();

    private CampaignEntryBuilder() {

    }

    @NotNull
    @Contract(" -> new")
    public static CampaignEntryBuilder getBuilder() {
        return new CampaignEntryBuilder();
    }

    public CampaignEntryBuilder addCampaignable(Campaignable campaignable) {

        try (final var validator = Validation.buildDefaultValidatorFactory()) {
            final var validate = validator.getValidator().validate(campaignable);

            if (!validate.isEmpty()) {
                throw new ValidationException(validate.toString());
            }
        }

        campaignables.add(campaignable);

        return this;
    }

    public CampaignEntry build() {
        return new CampaignEntry(campaignables);
    }

}
