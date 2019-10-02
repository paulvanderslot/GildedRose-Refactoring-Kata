package com.gildedrose;

class GildedRose {
    private static final int FIRST_SELL_IN_LIMIT_FOR_INCREASED_BACKSTAGE_PASS_QUALITY = 10;
    private static final int SECOND_SELL_IN_LIMIT_FOR_INCREASED_BACKSTAGE_PASS_QUALITY = 5;

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals(SpecialItemNames.AGED_BRIE)) {
            updateAgedBrie(item);
        }
        else if (item.name.equals(SpecialItemNames.SULFURAS)) {
            // do nothing
        }
        else if (item.name.equals(SpecialItemNames.BACKSTAGE_PASSES)) {
            updateBackstagePasses(item);
        }
        else {
            updateBasicItem(item);
        }
    }

    private void updateBasicItem(Item item) {
        decreaseSellIn(item);

        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn <= FIRST_SELL_IN_LIMIT_FOR_INCREASED_BACKSTAGE_PASS_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn <= SECOND_SELL_IN_LIMIT_FOR_INCREASED_BACKSTAGE_PASS_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item) {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Item cannot increase above 50
     */
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    /**
     * Item cannot decrease below 0
     */
    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
