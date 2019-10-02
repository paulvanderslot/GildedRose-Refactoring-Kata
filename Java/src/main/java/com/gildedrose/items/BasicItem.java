package com.gildedrose.items;

import com.gildedrose.Item;

class BasicItem implements UpdatableItem {

    private final Item item;

    BasicItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);

        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

}
