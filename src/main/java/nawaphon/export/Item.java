package nawaphon.export;


import jakarta.validation.constraints.NotNull;

public class Item {

    @NotNull
    private final Category category;

    private final String name;

    public Item(Category category, String name) {
        this.category = category;
        this.name = name;
    }
}
