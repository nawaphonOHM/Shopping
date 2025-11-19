package nawaphon.internal;


import nawaphon.export.*;
import nawaphon.main.CampaignEntry;
import nawaphon.main.ItemCartEntry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class DiscountCalulator {


    public static boolean sortedCampaign(@NotNull CampaignEntry campaign) {

        campaign.sortedBy(new CampaignComparable());

        return true;
    }

    @Contract("_, null -> fail")
    public static @NotNull DiscountReceived calculateDiscount(ItemCartEntry itemCart, Campaignable campaign) {

        if (campaign instanceof FixAmountCampaign) {
            return new DiscountReceived(((FixAmountCampaign) campaign).getAmount());
        }

        if (campaign instanceof PercentageDiscountCampaign) {
            var total = BigDecimal.ZERO;

            for (final var iterator = itemCart.iterator(); iterator.hasNext(); ) {
                var item = iterator.next();

                total = total.add(new BigDecimal(item.getTotalPrice()));
            }

            final var remaining = new BigDecimal(((PercentageDiscountCampaign) campaign).getPercentage())
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

            return new DiscountReceived(total.multiply(remaining).floatValue());
        }

        if (campaign instanceof PercentageDiscountByItem) {
            var total = BigDecimal.ZERO;

            for (final var iterator = itemCart.iterator(); iterator.hasNext(); ) {
                var item = iterator.next();

                if (!item.getCategory().equals(((PercentageDiscountByItem) campaign).getCategory())) {
                    continue;
                }

                total = total.add(new BigDecimal(item.getTotalPrice()));
            }

            final var remaining = new BigDecimal(((PercentageDiscountByItem) campaign).getAmount())
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

            return new DiscountReceived(total.multiply(remaining).floatValue());
        }

        if (campaign instanceof DiscountByPoints) {
            var total = BigDecimal.ZERO;

            for (final var iterator = itemCart.iterator(); iterator.hasNext(); ) {
                var item = iterator.next();

                total = total.add(new BigDecimal(item.getTotalPrice()));
            }

            final var maxDiscount = total.multiply(new BigDecimal("0.20"));


            return new DiscountReceived(maxDiscount.min(new BigDecimal(((DiscountByPoints) campaign).getPoints()))
                    .floatValue());
        }

        if (campaign instanceof SpecialCampaigns) {
            var total = BigDecimal.ZERO;

            for (final var iterator = itemCart.iterator(); iterator.hasNext(); ) {
                var item = iterator.next();

                total = total.add(new BigDecimal(item.getTotalPrice()));
            }

            final var mulipiler = total.divideToIntegralValue(
                    new BigDecimal(((SpecialCampaigns) campaign).getEveryBaht())
            );

            return new DiscountReceived(
                    mulipiler.multiply(new BigDecimal(((SpecialCampaigns) campaign).getDiscount())).floatValue()
            );
        }

        throw new UnexpectedReachHereException();
    }

}
