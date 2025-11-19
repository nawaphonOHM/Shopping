package nawaphon.export;


import jakarta.validation.constraints.NotNull;

public class Item {

    @NotNull
    private final Category category;

    public Item(Category category) {
        this.category = category;
    }
}
