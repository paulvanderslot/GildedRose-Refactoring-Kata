package com.gildedrose.item;

import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;;

public class SulfurasItemTest {

    private static final int STARTING_QUALITY = 80;
    private static final int STARTING_SELL_IN = 30;

    @Test
    void sellInStaysTheSameAfterOneUpdate() throws Exception {
        Item sulfuras = new Item(SULFURAS, STARTING_SELL_IN, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.sellIn).isEqualTo(STARTING_SELL_IN);
    }

    @Test
    void qualityStaysTheSameAfterOneUpdate() throws Exception {
        Item sulfuras = new Item(SULFURAS, STARTING_SELL_IN, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }

    @Test
    void qualityStaysTheSameWhenSellInIsNegatice() throws Exception {
        Item sulfuras = new Item(SULFURAS, -1, STARTING_QUALITY);
        SulfurasItem updatableItem = new SulfurasItem(sulfuras);

        updatableItem.update();

        assertThat(sulfuras.quality).isEqualTo(STARTING_QUALITY);
    }
}
