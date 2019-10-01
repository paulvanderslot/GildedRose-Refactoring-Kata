package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GildedRoseSulfurasItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInStaysTheSameAfterOneDay() throws Exception {
        Item sulfuras = new Item(SpecialItemNames.SULFURAS, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { sulfuras });

        gildedRose.updateQuality();

        assertThat(sulfuras.sellIn).isEqualTo(STARTING_SELL_IN);
    }

    @Test
    void qualityStaysTheSameAfterOneDay() throws Exception {
        Item sulfuras = new Item(SpecialItemNames.SULFURAS, STARTING_SELL_IN, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { sulfuras });

        gildedRose.updateQuality();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }

    @Test
    void qualityStaysTheSameWhenSellInIsNegatice() throws Exception {
        Item sulfuras = new Item(SpecialItemNames.SULFURAS, -1, STARTING_QUALITY);
        GildedRose gildedRose = new GildedRose(new Item[] { sulfuras });

        gildedRose.updateQuality();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }
}
