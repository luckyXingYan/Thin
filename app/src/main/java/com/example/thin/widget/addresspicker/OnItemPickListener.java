package com.example.thin.widget.addresspicker;

/**
 * Created by xingyan on 2018/1/5 10:36.
 * Email:lucky_xyic@sina.cn
 * ToDo:点击确认按钮选中item的回调
 */

public interface OnItemPickListener<T> {
    void onItemPicked(int index, T item);
}
