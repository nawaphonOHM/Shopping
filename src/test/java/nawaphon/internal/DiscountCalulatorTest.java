package nawaphon.internal;


import nawaphon.export.*;
import nawaphon.main.CampaignEntry;
import nawaphon.main.builder.CampaignEntryBuilder;
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

    @Test
    void calculatePercentageDiscount() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                )
                .build();

        final var campaign = new PercentageDiscountCampaign(10.0f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(60, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());
    }

    @Test
    void calculatePercentageDiscountByItem() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hoodie", 700.0f, 1)
                ).addItem(
                        new Item(Category.ACCESSORIES, "Watch", 850.0f, 1)
                ).addItem(
                        new Item(Category.ACCESSORIES, "Bag", 640.0f, 1)
                )
                .build();

        final var campaign = new PercentageDiscountByItem(Category.CLOTHING, 15.0f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(157.5, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());
    }

    @Test
    void calculateDiscountByPointsNotMoreThanMaxDiscount() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Belt", 230.0f, 1)
                )
                .build();

        final var campaign = new DiscountByPoints(68.0f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(68, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());
    }

    @Test
    void calculateDiscountByPointsMoreThanMaxDiscount() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Belt", 230.0f, 1)
                )
                .build();


        final var campaign = new DiscountByPoints(9999f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(166, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());
    }

    @Test
    void calculateDiscountBySpecialCampaigns() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Belt", 230.0f, 1)
                )
                .build();

        final var campaign = new SpecialCampaigns(300.0f, 40.0f);

        DiscountCalulator.calculateDiscount(itemCart, campaign);

        Assertions.assertEquals(80, DiscountCalulator.calculateDiscount(itemCart, campaign).discount());
    }

    @Test
    void calculateTotalReceived() {
        final var itemCart = ItemCardBuilder.getBuilder().addItem(
                        new Item(Category.CLOTHING, "T-shirt", 350.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Hat", 250.0f, 1)
                ).addItem(
                        new Item(Category.CLOTHING, "Belt", 230.0f, 1)
                )
                .build();

        Assertions.assertEquals(830, DiscountCalulator.calculateTotal(itemCart).total());
    }

    @Test
    void sortedCampaign() {
        final var campaign1 = new PercentageDiscountCampaign(15.0f);
        final var campaign2 = new SpecialCampaigns(500.0f, 50.0f);

        final var campaignEntry = CampaignEntryBuilder.getBuilder()
                .addCampaignable(campaign2)
                .addCampaignable(campaign1)
                .build();

        Assertions.assertDoesNotThrow(() -> DiscountCalulator.sortedCampaign(campaignEntry));

        Assertions.assertEquals(campaign1, campaignEntry.get(0));
        Assertions.assertEquals(campaign2, campaignEntry.get(1));
    }
}