package nawaphon.export;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Item {

    @NotNull
    private final Category category;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\p{IsThai}\\-][ a-zA-Z\\p{IsThai}\\-]+[a-zA-Z\\p{IsThai}\\-]$")
    private final String name;

    public Item(Category category, String name) {
        this.category = category;
        this.name = name;
    }
}
