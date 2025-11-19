package nawaphon.main;

import nawaphon.export.*;
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

    @Test
    void shopping3() {
        final var shopping = new Shopping(
                ItemCardBuilder.getBuilder().addItem(
                                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                        ).addItem(
                                new Item(Category.CLOTHING, "Hoodie", 700.0f, 1)
                        ).addItem(
                                new Item(Category.ACCESSORIES, "Watch", 850.0f, 1)
                        ).addItem(
                                new Item(Category.ACCESSORIES, "Bag", 640.0f, 1)
                        )
                        .build(),
                CampaignEntryBuilder.getBuilder().addCampaignable(
                        new PercentageDiscountByItem(Category.CLOTHING, 15.0f)
                ).build()
        );

        shopping.process();

        Assertions.assertEquals(2382.5, shopping.getTotalPrice());
    }

    @Test
    void shopping4() {
        final var shopping = new Shopping(
                ItemCardBuilder.getBuilder().addItem(
                                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                        ).addItem(
                                new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                        ).addItem(
                                new Item(Category.ACCESSORIES, "Belt", 230.0f, 1)
                        )
                        .build(),
                CampaignEntryBuilder.getBuilder().addCampaignable(
                        new DiscountByPoints(68.0f)
                ).build()
        );

        shopping.process();

        Assertions.assertEquals(762, shopping.getTotalPrice());
    }

    @Test
    void shopping5() {
        final var shopping = new Shopping(
                ItemCardBuilder.getBuilder().addItem(
                                new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                        ).addItem(
                                new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                        ).addItem(
                                new Item(Category.ACCESSORIES, "Belt", 230.0f, 1)
                        )
                        .build(),
                CampaignEntryBuilder.getBuilder().addCampaignable(
                        new DiscountByPoints(9999f)
                ).build()
        );

        shopping.process();

        Assertions.assertEquals(664, shopping.getTotalPrice());
    }

    @Test
    void shopping6() {

    }

}