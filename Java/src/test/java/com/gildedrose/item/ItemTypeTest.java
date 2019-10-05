package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ItemTypeTest {

    @Test
    void agedBrieNameGivesTheAgedBrieEnum() throws Exception {
        ItemType itemType = ItemType.forName(ItemType.AGED_BRIE.getName());

        assertThat(itemType).isEqualTo(ItemType.AGED_BRIE);
    }

    @Test
    void sulfurasNameGivesTheSulfurasEnum() throws Exception {
        ItemType itemType = ItemType.forName(ItemType.SULFURAS.getName());

        assertThat(itemType).isEqualTo(ItemType.SULFURAS);
    }

    @Test
    void backstagePassesNameGivesTheBackstagePassesEnum() throws Exception {
        ItemType itemType = ItemType.forName(ItemType.BACKSTAGE_PASSES.getName());

        assertThat(itemType).isEqualTo(ItemType.BACKSTAGE_PASSES);
    }

    @Test
    void randomNameGivesBasicItem() throws Exception {
        ItemType itemType = ItemType.forName("random");

        assertThat(itemType).isEqualTo(ItemType.BASIC_ITEM);
    }

    @Test
    void otherNameGivesBasicItem() throws Exception {
        ItemType itemType = ItemType.forName("otherName");

        assertThat(itemType).isEqualTo(ItemType.BASIC_ITEM);
    }
}
