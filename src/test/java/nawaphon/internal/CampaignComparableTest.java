package nawaphon.internal;

import nawaphon.export.FixAmountCampaign;
import nawaphon.export.SpecialCampaigns;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CampaignComparableTest {

    @Test
    void shouldReturnZeroNumber() {
        final var campaignable1 = new FixAmountCampaign(10.0f);
        final var campaignable2 = new FixAmountCampaign(11.0f);

        final var comparator = new CampaignComparable();

        assertEquals(0, comparator.compare(campaignable1, campaignable2), "Should be equal");

    }

    @Test
    void shouldReturnPositiveNumber() {
        final var campaignable1 = new FixAmountCampaign(11.0f);
        final var campaignable2 = new SpecialCampaigns(10.0f, 5.0f);

        final var comparator = new CampaignComparable();

        assertTrue(comparator.compare(campaignable2, campaignable1) > 0, "Should be positive");
    }

    @Test
    void shouldReturnNegativeNumber() {

    }

}