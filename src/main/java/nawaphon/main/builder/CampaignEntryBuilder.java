package nawaphon.main.builder;


import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import nawaphon.export.Campaignable;
import nawaphon.internal.CampaignCategory;
import nawaphon.internal.ConflictCampaignIdException;
import nawaphon.internal.FoundKey;
import nawaphon.internal.FoundValue;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import nawaphon.internal.CampaignEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaignEntryBuilder {

    private final List<Campaignable> campaignables = new ArrayList<>();

    private final Map<FoundKey, FoundValue> campaignTable = new HashMap<>();

    private CampaignEntryBuilder() {

    }

    private Pair<Boolean, RuntimeException> ableToAdd(@NotNull Campaignable campaignable) {
        final var annotation = campaignable.getClass().getAnnotation(CampaignCategory.class);

        final var category = annotation.category();

        if (!campaignTable.containsKey(new FoundKey(category))) {
            campaignTable.put(new FoundKey(category), new FoundValue(annotation.id()));

            return Pair.of(true, null);
        }

        final var number = campaignTable.get(new FoundKey(category));

        if (!number.equals(new FoundValue(annotation.id()))) {
            return Pair.of(false, new ConflictCampaignIdException(category, number.getValue(), annotation.id()));
        }

        return Pair.of(true, null);
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

        final var pair = ableToAdd(campaignable);

        final boolean ok = pair.getLeft();

        if (!ok) {
            throw pair.getRight();
        }

        campaignables.add(campaignable);

        return this;
    }

    public CampaignEntry build() {
        return new CampaignEntry(campaignables);
    }

}
