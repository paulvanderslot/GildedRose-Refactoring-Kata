package com.gildedrose.item;

import com.gildedrose.Item;

class BasicItem extends UpdatableItem {

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
