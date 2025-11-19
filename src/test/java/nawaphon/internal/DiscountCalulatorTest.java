package nawaphon.internal;


import nawaphon.export.Category;
import nawaphon.export.FixAmountCampaign;
import nawaphon.export.Item;
import nawaphon.main.builder.ItemCardBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountCalulatorTest {

    @Test
    void calculateFixAmountDiscount() {

        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
        ).addItem(
                new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                )
                .build();

        final var campaign = new FixAmountCampaign(50.0f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(50, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());

    }

}