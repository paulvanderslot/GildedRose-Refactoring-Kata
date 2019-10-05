package com.gildedrose.item;

import com.gildedrose.Item;

public class UpdatableItemFactory {

    private UpdatableItemFactory() {
    }

    public static UpdatableItem create(Item item) {
        switch (item.name) {
        case SpecialItemType.AGED_BRIE:
            return new AgedBrieItem(item);
        case SpecialItemType.SULFURAS:
            return new SulfurasItem(item);
        case SpecialItemType.BACKSTAGE_PASSES:
            return new BackStagePassesItem(item);
        case SpecialItemType.CONJURED:
            return new ConjuredItem(item);
        default:
            return new BasicItem(item);
        }
    }

    static class SpecialItemType {
        static final String AGED_BRIE = "Aged Brie";
        static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
        static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        static final String CONJURED = "Conjured Mana Cake";

        private SpecialItemType() {
        }
    }
}
