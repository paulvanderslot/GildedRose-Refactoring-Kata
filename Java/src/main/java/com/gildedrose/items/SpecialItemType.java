package com.gildedrose.items;

import java.util.Arrays;
import java.util.Optional;

public enum SpecialItemType {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert");

    private final String name;

    SpecialItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<SpecialItemType> forName(String matchingName) {
        return Arrays.stream(values())
            .filter(specialItem -> specialItem.name.equals(matchingName))
            .findAny();
    }
}
