package com.example.thin.widget.addresspicker;


/**
 * Created by xingyan on 2018/1/5 10:27.
 * Email:lucky_xyic@sina.cn
 * ToDo:点击确认按钮选中item的回调
 */

public interface OnMoreItemPickListener<T> {
    void onItemPicked(T t1, T t2, T t3);
}
