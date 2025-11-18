package nawaphon.main.builder;

import jakarta.validation.ValidationException;
import nawaphon.export.FixAmountCampaign;
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
}