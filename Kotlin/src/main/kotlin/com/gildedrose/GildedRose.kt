package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == SpecialItemName.SULFURAS) continue

            if (items[i].name != SpecialItemName.AGE_BRIE && items[i].name != SpecialItemName.BACKSTAGE_PASSES) {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == SpecialItemName.BACKSTAGE_PASSES) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            items[i].sellIn = items[i].sellIn - 1

            if (items[i].sellIn < 0) {
                if (items[i].name != SpecialItemName.AGE_BRIE) {
                    if (items[i].name != SpecialItemName.BACKSTAGE_PASSES) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

