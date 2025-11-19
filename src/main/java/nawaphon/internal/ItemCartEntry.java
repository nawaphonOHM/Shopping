package nawaphon.internal;


import nawaphon.export.Item;

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
