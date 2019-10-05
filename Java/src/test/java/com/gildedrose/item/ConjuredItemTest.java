package com.gildedrose.item;

import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.CONJURED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class ConjuredItemTest {

    private static final int STARTING_QUALITY = 20;
    private static final int STARTING_SELL_IN = 30;

    @Test
    public void sellInDecreasesOneAfterUpdate() {
        Item conjuredItem = new Item(CONJURED, STARTING_SELL_IN, STARTING_QUALITY);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.sellIn).isEqualTo(STARTING_SELL_IN - 1);
    }

    @Test
    public void qualityDecreasesTwoAfterUpdate() {
        Item conjuredItem = new Item(CONJURED, STARTING_SELL_IN, STARTING_QUALITY);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesFourWhenSellInDateBecomesNegative() throws Exception {
        Item conjuredItem = new Item(CONJURED, 0, STARTING_QUALITY);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.sellIn).isEqualTo(-1);
        assertThat(conjuredItem.quality).isEqualTo(STARTING_QUALITY - 4);
    }

    @Test
    void qualityDecreasesTwoWhenSellInDateIsAlmostNegative() throws Exception {
        Item conjuredItem = new Item(CONJURED, 1, STARTING_QUALITY);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.sellIn).isEqualTo(0);
        assertThat(conjuredItem.quality).isEqualTo(STARTING_QUALITY - 2);
    }

    @Test
    void qualityDecreasesFourWhenSellInDateIsNegative() throws Exception {
        Item conjuredItem = new Item(CONJURED, -1, STARTING_QUALITY);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.sellIn).isEqualTo(-2);
        assertThat(conjuredItem.quality).isEqualTo(STARTING_QUALITY - 4);
    }

    @Test
    void qualityCantBecomeNegative() throws Exception {
        Item conjuredItem = new Item(CONJURED, -1, 3);
        ConjuredItem updatableItem = new ConjuredItem(conjuredItem);

        updatableItem.update();

        assertThat(conjuredItem.quality).isEqualTo(0);
    }

}
