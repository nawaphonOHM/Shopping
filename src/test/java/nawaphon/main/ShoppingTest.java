package nawaphon.main;

import nawaphon.export.Category;
import nawaphon.export.FixAmountCampaign;
import nawaphon.export.Item;
import nawaphon.export.PercentageDiscountCampaign;
import nawaphon.main.builder.CampaignEntryBuilder;
import nawaphon.main.builder.ItemCardBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShoppingTest {

    @Test
    void shopping1() {

        final var shopping = new Shopping(
                ItemCardBuilder.getBuilder().addItem(
                                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                        ).addItem(
                                new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                        )
                        .build(),
                CampaignEntryBuilder.getBuilder().addCampaignable(new FixAmountCampaign(50.0f)).build()
        );

        shopping.process();

        Assertions.assertEquals(550, shopping.getTotalPrice());


    }

    @Test
    void shopping2() {
        final var shopping = new Shopping(
                ItemCardBuilder.getBuilder().addItem(
                                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                        ).addItem(
                                new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                        )
                        .build(),
                CampaignEntryBuilder.getBuilder().addCampaignable(new PercentageDiscountCampaign(10.0f)).build()
        );

        shopping.process();

        Assertions.assertEquals(540, shopping.getTotalPrice());
    }

}