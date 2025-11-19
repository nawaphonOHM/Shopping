package nawaphon.internal;


public class ConflictCampaignIdException extends RuntimeException {
    public ConflictCampaignIdException(String campaignCategory, int expectedCampaignId, int actualCampaignId) {
        super(String.format("""
                    Expected only one campaign with same category and id.
                    Category: %s
                    Id: %s
                    
                    but got %s
                    """, campaignCategory, expectedCampaignId, actualCampaignId));
    }
}
