package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun `given item is normal when end of the date then degrade SellIn and Quality by 1`() {
        // Arrange
        val item = Item("+5 Dexterity Vest", 10, 20)
        val app = GildedRose(listOf(item))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(9, app.items[0].sellIn)
        assertEquals(19, app.items[0].quality)
    }

    @Test
    fun `given item is normal and sellIn is 0 when end of the date then degrade SellIn by 1 and Quality by 2`() {
        // Arrange
        val item = Item("+5 Dexterity Vest", 0, 20)
        val app = GildedRose(listOf(item))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun `given item is normal and quality is 0 when end of the date then degrade SellIn by 1 and Quality still 0`() {
        // Arrange
        val item = Item("+5 Dexterity Vest", 10, 0)
        val app = GildedRose(listOf(item))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(9, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `given item is Aged Brie sellIn is 0 when end of the date then degrade SellIn by 1 and Quality increase by 2`() {
        // Arrange
        val ageBrie = Item("Aged Brie", 0, 20)
        val app = GildedRose(listOf(ageBrie))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `given item is Aged Brie when end of the date then degrade SellIn by 1 and Quality increase by 1`() {
        // Arrange
        val ageBrie = Item("Aged Brie", 10, 20)
        val app = GildedRose(listOf(ageBrie))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(9, app.items[0].sellIn)
        assertEquals(21, app.items[0].quality)
    }

    @Test
    fun `given item is Aged Brie and quality is 50 when end of the date then degrade SellIn by 1 and Quality still 50`() {
        // Arrange
        val ageBrie = Item("Aged Brie", 10, 50)
        val app = GildedRose(listOf(ageBrie))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(9, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun `given item is Sulfuras when end of the date then degrade SellIn by 1 and Quality still 80`() {
        // Arrange
        val sulfuras = Item("Sulfuras, Hand of Ragnaros", 1, 80)
        val app = GildedRose(listOf(sulfuras))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(1, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes when end of the date then degrade SellIn and Quality by 1`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(14, app.items[0].sellIn)
        assertEquals(21, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 11 when end of the date then degrade SellIn and Quality increase by 1`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(10, app.items[0].sellIn)
        assertEquals(21, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 10 when end of the date then degrade SellIn and Quality increase by 2`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(9, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 9 when end of the date then degrade SellIn and Quality increase by 2`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 9, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(8, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 6 when end of the date then degrade SellIn and Quality increase by 2`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(5, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 5 when end of the date then degrade SellIn and Quality increase by 3`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(4, app.items[0].sellIn)
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 4 when end of the date then degrade SellIn and Quality increase by 3`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 4, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(3, app.items[0].sellIn)
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun `given item is Backstage passes and sellIn is 0 when end of the date then degrade SellIn and Quality is 0`() {
        // Arrange
        val backStagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        val app = GildedRose(listOf(backStagePasses))

        // Action
        app.updateQuality()

        // Assert
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }
}


