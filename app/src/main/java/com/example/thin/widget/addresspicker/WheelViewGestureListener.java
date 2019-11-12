package com.example.thin.widget.addresspicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by xingyan on 2018/1/5 10:50.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */

final public class WheelViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    final WheelView wheelView;

    public WheelViewGestureListener(WheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelView.scrollBy(velocityY);
        return true;
    }
}
