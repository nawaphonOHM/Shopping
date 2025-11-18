package nawaphon.internal;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CampaignCategory {

    String category();

    int id();
}
