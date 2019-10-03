package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class AgedBrieItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInDecreasesOneAfterOneDay() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    void qualityIncreasesOneAfterOneDay() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 1);
    }

    @Test
    void qualityIncreasesTwoAfterTwoDays() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();
        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityIncreasesTwoWhenSellInIsNegative() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), -1, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingOne() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), STARTING_SELL_IN, 50);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(50);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingTwo() throws Exception {
        Item agedBrie = new Item(SpecialItemType.AGED_BRIE.getName(), -1, 49);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(50);
    }
}
