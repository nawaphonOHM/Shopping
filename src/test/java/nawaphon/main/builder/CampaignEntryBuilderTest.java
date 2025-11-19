package nawaphon.main.builder;

import jakarta.validation.ValidationException;
import nawaphon.export.FixAmountCampaign;
import nawaphon.export.PercentageDiscountCampaign;
import nawaphon.internal.ConflictCampaignIdException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class CampaignEntryBuilderTest {

    @Test
    void shouldAddCampaignableFail() {
        final var builder = CampaignEntryBuilder.getBuilder();

        assertThrowsExactly(ValidationException.class, () ->  builder.addCampaignable(new FixAmountCampaign(-9.0f)));

    }

    @Test
    void shouldBuildSuccess() {
        final var builder = CampaignEntryBuilder.getBuilder();

        assertDoesNotThrow(() -> builder.addCampaignable(new FixAmountCampaign(9.0f)));
    }

    @Test
    void shouldUnableAddCampaignWithDifferentIdButSameCategory() {
        final var builder = CampaignEntryBuilder.getBuilder();

        assertThrowsExactly(ConflictCampaignIdException.class, () ->
                builder.addCampaignable(new FixAmountCampaign(9.0f))
                .addCampaignable(new PercentageDiscountCampaign(9.0f)));
    }
}