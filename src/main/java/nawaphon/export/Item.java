package nawaphon.export;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Item {

    @NotNull
    private final Category category;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\p{IsThai}\\-][ a-zA-Z\\p{IsThai}\\-]+[a-zA-Z\\p{IsThai}\\-]$")
    private final String name;

    @Min(0)
    private final float price;

    @Min(0)
    private final int amount;

    public Item(Category category, String name, float price, int amount) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public float getTotalPrice() {
        return price * amount;
    }
}
