package nawaphon.main;


import nawaphon.export.Item;
import nawaphon.internal.ItemCart;

import java.util.Iterator;

public class ItemCartEntry {

    private final ItemCart itemCart;

    public ItemCartEntry(ItemCart itemCart) {
        this.itemCart = itemCart;
    }

    public Iterator<Item> iterator() {
        return itemCart.iterator();
    }
}
