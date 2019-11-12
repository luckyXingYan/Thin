package com.example.thin.widget.addresspicker;

import java.util.List;

/**
 * Created by xingyan on 2018/1/5 10:57.
 * Email:lucky_xyic@sina.cn
 * ToDo:The simple Array wheel adapter
 */

public class ArrayWheelAdapter<T> implements WheelAdapter {
    /**
     * The default items length
     */
    private static final int DEFAULT_LENGTH = 4;

    // items
    private List<T> items;
    // length
    private int length;

    /**
     * Constructor
     *
     * @param items  the items
     * @param length the max items length
     */
    private ArrayWheelAdapter(List<T> items, int length) {
        this.items = items;
        this.length = length;
    }

    /**
     * Constructor
     *
     * @param items the items
     */
    public ArrayWheelAdapter(List<T> items) {
        this(items, DEFAULT_LENGTH);
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "";
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }
}
