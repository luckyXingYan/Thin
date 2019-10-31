package com.example.thin.eventbus;

/**
 * @Author: xingyan
 * @Date: 2019/10/31
 * @Desc: 纯通知更新 eventbus 不传递数据
 */
public class TotalPriceEvent {
    public static TotalPriceEvent getInstance() {
        return new TotalPriceEvent();
    }
}
