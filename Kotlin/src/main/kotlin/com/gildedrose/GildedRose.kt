package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == SpecialItemName.SULFURAS) continue

            when (items[i].name) {
                SpecialItemName.AGE_BRIE -> {
                    increaseQuality(items[i])
                }

                SpecialItemName.BACKSTAGE_PASSES -> {
                    increaseQuality(items[i])
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i])
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i])
                    }
                }

                else -> degradeQuality(items[i])
            }

            items[i].sellIn = items[i].sellIn - 1

            if (items[i].sellIn < 0) {
                if (items[i].name != SpecialItemName.AGE_BRIE) {
                    if (items[i].name != SpecialItemName.BACKSTAGE_PASSES) {
                        degradeQuality(items[i])
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
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

