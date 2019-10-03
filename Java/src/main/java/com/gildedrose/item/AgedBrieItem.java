package com.gildedrose.item;

import com.gildedrose.Item;

class AgedBrieItem extends UpdatableItem {

    private final Item item;

    AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
