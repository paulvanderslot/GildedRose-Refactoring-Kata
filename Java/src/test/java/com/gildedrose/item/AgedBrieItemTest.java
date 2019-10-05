package com.gildedrose.item;

import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class AgedBrieItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInDecreasesOneAfterOneUpdate() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    void qualityIncreasesOneAfterOneUpdate() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 1);
    }

    @Test
    void qualityIncreasesTwoAfterTwoUpdates() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, STARTING_SELL_IN, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();
        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityIncreasesTwoWhenSellInIsNegative() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, -1, STARTING_QUALITY);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingOne() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, STARTING_SELL_IN, 50);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(50);
    }

    @Test
    void qualityCantBecomeMoreThan50WhenIncreasingTwo() throws Exception {
        Item agedBrie = new Item(AGED_BRIE, -1, 49);
        AgedBrieItem updatableItem = new AgedBrieItem(agedBrie);

        updatableItem.update();

        assertThat(agedBrie.quality).isEqualTo(50);
    }
}
