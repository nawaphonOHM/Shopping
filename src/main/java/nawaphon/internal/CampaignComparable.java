package nawaphon.internal;


import nawaphon.export.Campaignable;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class CampaignComparable implements Comparator<Campaignable> {
    @Override
    public int compare(@NotNull Campaignable campaignable, @NotNull Campaignable t1) {
        final var annotation1 = campaignable.getClass().getAnnotation(Order.class).value();
        final var annotation2 = t1.getClass().getAnnotation(Order.class).value();

        return annotation1 - annotation2;
    }
}
