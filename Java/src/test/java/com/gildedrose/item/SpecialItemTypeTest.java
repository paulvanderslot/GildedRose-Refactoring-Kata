package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class SpecialItemTypeTest {

    @Test
    void agedBrieNameGivesTheAgedBrieEnum() throws Exception {
        Optional<SpecialItemType> optionalType = SpecialItemType.forName(SpecialItemType.AGED_BRIE.getName());

        assertThat(optionalType.isPresent()).isTrue();
        assertThat(optionalType.get()).isEqualTo(SpecialItemType.AGED_BRIE);
    }

    @Test
    void sulfurasNameGivesTheSulfurasEnum() throws Exception {
        Optional<SpecialItemType> optionalType = SpecialItemType.forName(SpecialItemType.SULFURAS.getName());

        assertThat(optionalType.isPresent()).isTrue();
        assertThat(optionalType.get()).isEqualTo(SpecialItemType.SULFURAS);
    }

    @Test
    void backstagePassesNameGivesTheBackstagePassesEnum() throws Exception {
        Optional<SpecialItemType> optionalType = SpecialItemType.forName(SpecialItemType.BACKSTAGE_PASSES.getName());

        assertThat(optionalType.isPresent()).isTrue();
        assertThat(optionalType.get()).isEqualTo(SpecialItemType.BACKSTAGE_PASSES);
    }

    @Test
    void randomNameGivesEmptyOptional() throws Exception {
        Optional<SpecialItemType> optionalType = SpecialItemType.forName("random");

        assertThat(optionalType.isPresent()).isFalse();
    }
}
