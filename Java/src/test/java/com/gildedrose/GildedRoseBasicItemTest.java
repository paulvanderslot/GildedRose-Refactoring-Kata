package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GildedRoseBasicItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    public void sellInDecreasesOneAfterOneDay() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { basicItem });

        gildedRose.updateQuality();

        assertThat(basicItem.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    public void sellInDecreasesTwoAfterTwoDays() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { basicItem });

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(basicItem.sellIn).isEqualTo(STARTING_SELL_IN - 2);
    }

    @Test
    public void qualityDecreasesOneAfterOneDay() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { basicItem });

        gildedRose.updateQuality();

        assertThat(basicItem.quality).isEqualTo(STARTING_QUALITY - 1);
    }

    @Test
    public void qualityDecreasesTwoAfterTwoDays() {
        Item basicItem = new Item("basicItem", STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { basicItem });

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(basicItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesTwoWhenSellInDateBecomesNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", 0, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { lowSellInItem });

        gildedRose.updateQuality();

        assertThat(lowSellInItem.sellIn).isEqualTo(-1);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesOneWhenSellInDateIsAlmostNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", 1, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { lowSellInItem });

        gildedRose.updateQuality();

        assertThat(lowSellInItem.sellIn).isEqualTo(0);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 1);
    }

    @Test
    void qualityDecreasesTwoWhenSellInDateIsNegative() throws Exception {
        Item lowSellInItem = new Item("basicItem", -1, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { lowSellInItem });

        gildedRose.updateQuality();

        assertThat(lowSellInItem.sellIn).isEqualTo(-2);
        assertThat(lowSellInItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityCantBecomeNegativeWhenDecreasingOne() throws Exception {
        Item lowQualityInItem = new Item("basicItem", STARTING_SELL_IN, 0);
        GildedRose gildedRose = new GildedRose(new Item[] { lowQualityInItem });

        gildedRose.updateQuality();

        assertThat(lowQualityInItem.quality).isEqualTo(0);
    }

    @Test
    void qualityCantBecomeNegativeWhenDecreasingTwo() throws Exception {
        Item lowQualityInItem = new Item("basicItem", -1, 1);
        GildedRose gildedRose = new GildedRose(new Item[] { lowQualityInItem });

        gildedRose.updateQuality();

        assertThat(lowQualityInItem.quality).isEqualTo(0);
    }

}
