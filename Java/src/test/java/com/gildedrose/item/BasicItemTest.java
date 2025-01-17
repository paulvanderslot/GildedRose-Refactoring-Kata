package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class BasicItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    public void sellInDecreasesOneAfterOneUpdate() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(basicItem);

        updatableItem.update();

        assertThat(basicItem.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    public void sellInDecreasesTwoAfterTwoUpdates() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(basicItem);

        updatableItem.update();
        updatableItem.update();

        assertThat(basicItem.sellIn).isEqualTo(STARTING_SELL_IN - 2);
    }

    @Test
    public void qualityDecreasesOneAfterOneUpdate() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(basicItem);

        updatableItem.update();

        assertThat(basicItem.quality).isEqualTo(STARTING_QUALITY - 1);
    }

    @Test
    public void qualityDecreasesTwoAfterTwoUpdates() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(basicItem);

        updatableItem.update();
        updatableItem.update();

        assertThat(basicItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesTwoWhenSellInDateBecomesNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", 0, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(lowSellInItem);

        updatableItem.update();

        assertThat(lowSellInItem.sellIn).isEqualTo(-1);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesOneWhenSellInDateIsAlmostNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", 1, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(lowSellInItem);

        updatableItem.update();

        assertThat(lowSellInItem.sellIn).isEqualTo(0);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 1);
    }

    @Test
    void qualityDecreasesTwoWhenSellInDateIsNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", -1, STARTING_QUALITY);
        BasicItem updatableItem = new BasicItem(lowSellInItem);

        updatableItem.update();

        assertThat(lowSellInItem.sellIn).isEqualTo(-2);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityCantBecomeNegativeWhenDecreasingOne() throws Exception {
        Item lowQualityInItem = new Item("basicItem", STARTING_SELL_IN, 0);
        BasicItem updatableItem = new BasicItem(lowQualityInItem);

        updatableItem.update();

        assertThat(lowQualityInItem.quality).isEqualTo(0);
    }

    @Test
    void qualityCantBecomeNegativeWhenDecreasingTwo() throws Exception {
        Item lowQualityInItem = new Item("basicItem", -1, 1);
        BasicItem updatableItem = new BasicItem(lowQualityInItem);

        updatableItem.update();

        assertThat(lowQualityInItem.quality).isEqualTo(0);
    }

}
