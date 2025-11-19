package nawaphon.internal;


import nawaphon.export.*;
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
    }

}