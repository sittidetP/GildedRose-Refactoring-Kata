package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == SpecialItemName.SULFURAS) continue

            item.sellIn -= 1

            val isSellInLessThanZero = item.sellIn < 0
            val qualityValue = if (isSellInLessThanZero) 2 else 1
            when (item.name) {
                SpecialItemName.AGE_BRIE -> increaseQuality(item, qualityValue)
                SpecialItemName.BACKSTAGE_PASSES -> {
                    if (isSellInLessThanZero) {
                        item.quality = 0
                    } else {
                        var backStagePassesQuality = 1
                        if (item.sellIn < 5) {
                            backStagePassesQuality = 3
                        } else if (item.sellIn < 10) {
                            backStagePassesQuality = 2
                        }
                        increaseQuality(item, backStagePassesQuality)
                    }
                }
                else -> degradeQuality(item, qualityValue)
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

