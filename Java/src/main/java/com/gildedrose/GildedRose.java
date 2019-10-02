package com.gildedrose;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.gildedrose.items.UpdatableItem;
import com.gildedrose.items.UpdatableItemFactory;

class GildedRose {
    private List<UpdatableItem> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items)
            .map(UpdatableItemFactory::create)
            .collect(toList());
    }

    public void updateQuality() {
        items.forEach(UpdatableItem::update);
    }
}
