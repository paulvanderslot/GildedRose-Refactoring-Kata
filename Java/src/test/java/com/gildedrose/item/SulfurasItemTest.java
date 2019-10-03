package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class SulfurasItemTest {

    private static final int STARTING_QUALITY = 80;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInStaysTheSameAfterOneDay() throws Exception {
        Item sulfuras = new Item(SpecialItemType.SULFURAS.getName(), STARTING_SELL_IN, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.sellIn).isEqualTo(STARTING_SELL_IN);
    }

    @Test
    void qualityStaysTheSameAfterOneDay() throws Exception {
        Item sulfuras = new Item(SpecialItemType.SULFURAS.getName(), STARTING_SELL_IN, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }

    @Test
    void qualityStaysTheSameWhenSellInIsNegatice() throws Exception {
        Item sulfuras = new Item(SpecialItemType.SULFURAS.getName(), -1, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }
}
