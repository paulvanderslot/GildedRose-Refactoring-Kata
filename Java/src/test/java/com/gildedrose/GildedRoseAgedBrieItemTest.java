package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GildedRoseAgedBrieItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInDecreasesOneAfterOneDay() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();

        assertThat(agedBrie.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    void qualityIncreasesOneAfterOneDay() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 1);
    }

    @Test
    void qualityIncreasesTwoAfterTwoDays() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityIncreasesTwoWhenSellInIsNegative() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, -1, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingOne() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, STARTING_SELL_IN, 50);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(50);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingTwo() throws Exception {
        Item agedBrie = new Item(SpecialItemNames.AGED_BRIE, -1, 49);
        GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(50);
    }
}
