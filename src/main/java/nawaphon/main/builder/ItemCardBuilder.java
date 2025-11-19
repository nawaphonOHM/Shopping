package nawaphon.main.builder;


import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import nawaphon.export.Item;
import nawaphon.internal.ItemCart;
import nawaphon.internal.ItemCartEntry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ItemCardBuilder {

    private final ItemCart itemCart = new ItemCart();

    @Contract(" -> new")
    public static @NotNull ItemCardBuilder getBuilder() {
        return new ItemCardBuilder();
    }

    public ItemCardBuilder addItem(Item item) {

        try (final var validator = Validation.buildDefaultValidatorFactory()) {
            final var validate = validator.getValidator().validate(item);

            if (!validate.isEmpty()) {
                throw new ValidationException(validate.toString());
            }
        }

        itemCart.add(item);

        return this;
    }

    public ItemCartEntry build() {
        return new ItemCartEntry(itemCart);
    }

}
