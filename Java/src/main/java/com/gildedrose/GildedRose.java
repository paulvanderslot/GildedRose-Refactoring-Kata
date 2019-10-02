package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
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

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateBackstagePasses(Item item) {
        decreaseSellIn(item);

        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
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

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
