package nawaphon.main.builder;


import nawaphon.export.Item;
import nawaphon.internal.ItemCart;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ItemCardBuilder {

    private final ItemCart itemCart = new ItemCart();

    @Contract(" -> new")
    public static @NotNull ItemCardBuilder getBuilder() {
        return new ItemCardBuilder();
    }

    public ItemCardBuilder addItem(Item item) {
        return null;
    }

}
