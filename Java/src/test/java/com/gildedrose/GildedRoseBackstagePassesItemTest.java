package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.items.SpecialItemNames;

public class GildedRoseBackstagePassesItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInDecreasesOneAfterOneDay() throws Exception {
        Item backstagePasses = new Item(SpecialItemNames.BACKSTAGE_PASSES, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    void qualityIncreasesOneAfterOneDay() throws Exception {
        Item backstagePasses = new Item(SpecialItemNames.BACKSTAGE_PASSES, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(STARTING_QUALITY + 1);
    }

    @Test
    void qualityIncreasesTwoWhenSellInBecomesBetween10And5() throws Exception {
        int sellInLimitWhenQualityIncreasesTwo = 11;
        Item backstagePasses =
            new Item(SpecialItemNames.BACKSTAGE_PASSES, sellInLimitWhenQualityIncreasesTwo, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(STARTING_QUALITY + 2);
    }

    @Test
    void qualityIncreasesThreeWhenSellInBecomesBetween5And0() throws Exception {
        int sellInLimitWhenQualityIncreasesThree = 6;
        Item backstagePasses =
            new Item(SpecialItemNames.BACKSTAGE_PASSES, sellInLimitWhenQualityIncreasesThree, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(STARTING_QUALITY + 3);
    }

    @Test
    void qualityDoesNotBecomeMoreThan50() throws Exception {
        int sellInLimitWhenQualityIncreasesThree = 5;
        Item backstagePasses =
            new Item(SpecialItemNames.BACKSTAGE_PASSES, sellInLimitWhenQualityIncreasesThree, 48);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(50);
    }

    @Test
    void qualityBecomesZeroWhenSellInIs0() throws Exception {
        Item backstagePasses = new Item(SpecialItemNames.BACKSTAGE_PASSES, 0, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(0);
    }

    @Test
    void qualityBecomesZeroWhenSellInIsBelow0() throws Exception {
        Item backstagePasses = new Item(SpecialItemNames.BACKSTAGE_PASSES, -1, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { backstagePasses });

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(0);
    }
}
