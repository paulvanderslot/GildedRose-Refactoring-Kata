package com.gildedrose.items;

import com.gildedrose.Item;

public interface UpdatableItem {

    void update();

    default void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Item cannot increase above 50
     */
    default void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    /**
     * Item cannot decrease below 0
     */
    default void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
