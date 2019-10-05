package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class GildedRoseRegressionTest {

    @Test
    void regressionTest() throws Exception {
        Item[] items = createItems();
        GildedRose app = new GildedRose(items);
        int days = 8;

        String gildedRoseOverview = giveOverview(items, app, days);

        String expected = readFileToString("regressionTestResult.txt");
        assertThat(expected).isEqualTo(gildedRoseOverview);

    }

    private String readFileToString(String fileName) throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getResource(fileName).toURI());
        return new String(Files.readAllBytes(path));
    }

    private Item[] createItems() {
        return new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 3, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
                new Item("Conjured Mana Cake", 3, 11) };
    }

    private String giveOverview(Item[] items, GildedRose app, int days) {
        StringBuilder result = new StringBuilder();

        for (int day = 0; day < days; day++) {
            result.append("-------- day " + day + " --------");
            result.append(System.lineSeparator());
            result.append(giveItemsOverview(items));
            app.updateQuality();
        }
        return result.toString();
    }

    private String giveItemsOverview(Item[] items) {
        StringBuilder result = new StringBuilder();

        result.append("name, sellIn, quality");
        for (Item item : items) {
            result.append(System.lineSeparator());
            result.append(item);
        }
        result.append(System.lineSeparator());
        return result.toString();
    }

}
