package com.gildedrose.items;

import com.gildedrose.Item;

public class UpdatableItemFactory {

    public static UpdatableItem create(Item item) {
        switch (item.name) {
            case SpecialItemNames.AGED_BRIE:
                return new AgedBrieItem(item);
            case SpecialItemNames.SULFURAS:
                return new SulfurasItem(item);
            case SpecialItemNames.BACKSTAGE_PASSES:
                return new BackStagePassesItem(item);
            default:
                return new BasicItem(item);
        }
    }
}
