package com.example.thin.widget.addresspicker;

/**
 * Created by xingyan on 2018/1/5 10:56.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */

final public class OnItemPickedRunnable implements Runnable {
    final private WheelView wheelView;
    private OnItemPickListener onItemPickListener;

    public OnItemPickedRunnable(WheelView wheelView, OnItemPickListener onItemPickListener) {
        this.wheelView = wheelView;
        this.onItemPickListener = onItemPickListener;
    }

    @Override
    public final void run() {
        onItemPickListener.onItemPicked(wheelView.getCurrentPosition(), wheelView.getCurrentItem());
    }
}
