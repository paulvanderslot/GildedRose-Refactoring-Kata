package com.gildedrose.item;

import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.AGED_BRIE;
import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.BACKSTAGE_PASSES;
import static com.gildedrose.item.UpdatableItemFactory.SpecialItemType.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class UpdatableItemTest {

    private static final int DEFAULT_SELL_IN = 0;
    private static final int DEFAULT_QUALITY = 0;

    @Test
    void agedBrieNameCreatesAnAgedBrieItem() throws Exception {
        Item item = new Item(AGED_BRIE, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        assertThat(updatableItem).isInstanceOf(AgedBrieItem.class);
    }

    @Test
    void backstagePassesNameCreatesABackstagePassesItem() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        assertThat(updatableItem).isInstanceOf(BackStagePassesItem.class);
    }

    @Test
    void sulfurasNameCreatesASulfurasItem() throws Exception {
        Item item = new Item(SULFURAS, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        assertThat(updatableItem).isInstanceOf(SulfurasItem.class);
    }

    @Test
    void randomNameCreatesABasicItem() throws Exception {
        Item item = new Item("random", DEFAULT_SELL_IN, DEFAULT_QUALITY);

        UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        assertThat(updatableItem).isInstanceOf(BasicItem.class);
    }

    @Test
    void otherNameCreatesABasicItem() throws Exception {
        Item item = new Item("otherItem", DEFAULT_SELL_IN, DEFAULT_QUALITY);

        UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        assertThat(updatableItem).isInstanceOf(BasicItem.class);
    }
}
