package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == SpecialItemName.SULFURAS) continue

            item.sellIn = item.sellIn - 1

            when (item.name) {
                SpecialItemName.AGE_BRIE -> {
                    increaseQuality(item)
                }

                SpecialItemName.BACKSTAGE_PASSES -> {
                    increaseQuality(item)
                    if (item.sellIn < 10) {
                        increaseQuality(item)
                    }

                    if (item.sellIn < 5) {
                        increaseQuality(item)
                    }
                }

                else -> degradeQuality(item)
            }

            if (item.sellIn < 0) {
                when (item.name) {
                    SpecialItemName.AGE_BRIE -> increaseQuality(item)
                    SpecialItemName.BACKSTAGE_PASSES -> item.quality = 0
                    else -> degradeQuality(item)
                }
            }
        }
    }

    private fun degradeQuality(item: Item, value: Int = 1) {
        if (item.quality > 0) {
            item.quality = item.quality - value
        }
    }

    private fun increaseQuality(item: Item, value: Int = 1) {
        if (item.quality < 50) {
            item.quality = item.quality + value
        }
    }
}

