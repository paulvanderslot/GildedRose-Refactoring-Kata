package com.gildedrose.items;

import java.util.Optional;

import com.gildedrose.Item;

public class UpdatableItemFactory {

    private UpdatableItemFactory() {
    }

    public static UpdatableItem create(Item item) {
        Optional<SpecialItemType> specialItemType = SpecialItemType.forName(item.name);
        if (specialItemType.isPresent()) {
            return createSpecialItem(specialItemType.get(), item);
        }
        return new BasicItem(item);
    }

    private static UpdatableItem createSpecialItem(SpecialItemType specialItemType, Item item) {
        switch (specialItemType) {
            case AGED_BRIE:
                return new AgedBrieItem(item);
            case SULFURAS:
                return new SulfurasItem(item);
            case BACKSTAGE_PASSES:
                return new BackStagePassesItem(item);
            default:
                throw new IllegalStateException("Special item not implemented: " + specialItemType);
        }
    }
}
