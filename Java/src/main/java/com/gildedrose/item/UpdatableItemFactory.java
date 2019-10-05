package com.gildedrose.item;

import com.gildedrose.Item;

public class UpdatableItemFactory {

    private UpdatableItemFactory() {
    }

    public static UpdatableItem create(Item item) {
        ItemType itemType = ItemType.forName(item.name);
        return createItem(itemType, item);
    }

    private static UpdatableItem createItem(ItemType itemType, Item item) {
        switch (itemType) {
        case AGED_BRIE:
            return new AgedBrieItem(item);
        case SULFURAS:
            return new SulfurasItem(item);
        case BACKSTAGE_PASSES:
            return new BackStagePassesItem(item);
        case BASIC_ITEM:
            return new BasicItem(item);
        default:
            throw new IllegalStateException("Item type not implemented: " + itemType);
        }
    }
}
