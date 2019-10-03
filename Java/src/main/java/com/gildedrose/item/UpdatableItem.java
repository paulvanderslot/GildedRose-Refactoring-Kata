package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class UpdatableItem {

    public abstract void update();

    protected final void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Item cannot increase above 50
     */
    protected final void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    /**
     * Item cannot decrease below 0
     */
    protected final void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
