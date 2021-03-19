package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (       !item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item.name.equals("Sulfuras, Hand of Ragnaros")
                    && item.quality > 0) {
                        reduceItemQuality(item);
            } else {
                if (item.quality < 50) {
                    increaseItemQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                                this.increaseIfBelowThreshold(item);
                        }

                        if (item.sellIn < 6){
                                this.increaseIfBelowThreshold(item);
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                reduceItemQuality(item);
                            }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseIfBelowThreshold(item);
                }
            }
        }
    }

    private void increaseIfBelowThreshold(Item item) {
        if (item.quality < 50) {
           increaseItemQuality(item);
        }
    }

    private void increaseItemQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void reduceItemQuality(Item item) {
        item.quality = item.quality - 1;
        if(item.name.equals("Conjured Mana Cake")){
            item.quality = item.quality - 1;
        }
    }

}
