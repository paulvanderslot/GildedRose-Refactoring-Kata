package com.gildedrose.items;

import com.gildedrose.Item;

public interface UpdatableItem {

    public void update();

    static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Item cannot increase above 50
     */
    static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    /**
     * Item cannot decrease below 0
     */
    static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
