package com.example.thin.widget.addresspicker;

/**
 * Created by xingyan on 2018/1/5 10:39.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */

public interface WheelAdapter<T> {
    /**
     * Gets items count
     *
     * @return the count of wheel items
     */
    int getItemsCount();

    /**
     * Gets a wheel item by index.
     *
     * @param index the item index
     * @return the wheel item text or null
     */
    T getItem(int index);

    /**
     * Gets maximum item length. It is used to determine the wheel width.
     * If -1 is returned there will be used the default wheel width.
     *
     * @param o
     * @return the maximum item length or -1
     */
    int indexOf(T o);
}
