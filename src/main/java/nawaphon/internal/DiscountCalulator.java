package nawaphon.internal;


import nawaphon.export.Campaignable;
import nawaphon.export.FixAmountCampaign;
import nawaphon.export.PercentageDiscountCampaign;
import nawaphon.main.CampaignEntry;
import nawaphon.main.ItemCartEntry;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class DiscountCalulator {


    public static boolean sortedCampaign(@NotNull CampaignEntry campaign) {

        campaign.sortedBy(new CampaignComparable());

        return true;
    }

    public static DiscountReceived calculateDiscount(ItemCartEntry itemCart, Campaignable campaign) {

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

        return null;
    }

}
