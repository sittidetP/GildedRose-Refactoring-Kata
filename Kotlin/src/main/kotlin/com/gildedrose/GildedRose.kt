package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == SpecialItemName.SULFURAS) continue

            items[i].sellIn = items[i].sellIn - 1

            when (items[i].name) {
                SpecialItemName.AGE_BRIE -> {
                    increaseQuality(items[i])
                }

                SpecialItemName.BACKSTAGE_PASSES -> {
                    increaseQuality(items[i])
                    if (items[i].sellIn < 10) {
                        increaseQuality(items[i])
                    }

                    if (items[i].sellIn < 5) {
                        increaseQuality(items[i])
                    }
                }

                else -> degradeQuality(items[i])
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != SpecialItemName.AGE_BRIE) {
                    when (items[i].name) {
                        SpecialItemName.BACKSTAGE_PASSES -> items[i].quality = 0
                        else -> degradeQuality(items[i])
                    }
                } else {
                    increaseQuality(items[i])
                }
            }
        }
    }

    private fun degradeQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun increaseQuality(item: Item, value: Int = 1) {
        if (item.quality < 50) {
            item.quality = item.quality + value
        }
    }
}

