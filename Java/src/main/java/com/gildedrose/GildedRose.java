package com.gildedrose;

import com.gildedrose.items.UpdatableItem;
import com.gildedrose.items.UpdatableItemFactory;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = UpdatableItemFactory.create(item);
            updatableItem.update();
        }
    }
}
