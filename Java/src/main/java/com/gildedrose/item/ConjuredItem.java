package com.gildedrose.item;

import com.gildedrose.Item;

class ConjuredItem extends UpdatableItem {

    private final Item item;

    ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);

        decreaseQuality(item);
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

}
