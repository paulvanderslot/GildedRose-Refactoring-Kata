package com.gildedrose.item;

import com.gildedrose.Item;

class BackStagePassesItem extends UpdatableItem {

    private static final int FIRST_SELL_IN_LIMIT_FOR_INCREASED_QUALITY = 10;
    private static final int SECOND_SELL_IN_LIMIT_FOR_INCREASED_QUALITY = 5;

    private final Item item;

    BackStagePassesItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn <= FIRST_SELL_IN_LIMIT_FOR_INCREASED_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn <= SECOND_SELL_IN_LIMIT_FOR_INCREASED_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
