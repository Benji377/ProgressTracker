package com.minecraftmod.progresstracker;

import net.minecraft.item.Item;

public class Counter {
    private int max_count;
    private int current_count;
    private Item item;

    public int getMax_count() {
        return max_count;
    }
    public void setMax_count(int max_num) {
        this.max_count = max_num;
    }

    public int getCurrent_count() {
        return current_count;
    }
    public void setCurrent_count(int count_num) {
        this.current_count = count_num;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item new_item) {
        this.item = new_item;
    }

    public void increaseCounter(int increaser) {
        setCurrent_count(getCurrent_count()+increaser);
    }

    public Counter(Item counter_item, int max_num) {
        setCurrent_count(0);
        setMax_count(max_num);
        setItem(counter_item);
    }

    /*
    Notes:
    - to delete an object, do:
        Counter c = new Counter()
        ...
        c = null // deleted
     */
}
