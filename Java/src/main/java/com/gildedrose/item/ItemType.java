package com.gildedrose.item;

import java.util.Arrays;

enum ItemType {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    BASIC_ITEM(""); // Basic item has no specific name. It is everything else.

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    /**
     * When there is no Item with a matching name, Basic Item is returned.
     */
    static ItemType forName(String matchingName) {
        return Arrays.stream(values())
                .filter(specialItem -> specialItem.name.equals(matchingName))
                .findAny()
                .orElseGet(() -> BASIC_ITEM);
    }
}
