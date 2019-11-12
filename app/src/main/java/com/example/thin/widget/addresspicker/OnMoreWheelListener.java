package com.example.thin.widget.addresspicker;

/**
 * Created by xingyan on 2018/1/5 10:27.
 * Email:lucky_xyic@sina.cn
 * ToDo:针对地址选择，车牌选择等提供的外部回调接口
 */

public interface OnMoreWheelListener {
    void onFirstWheeled(int index, String item);

    void onSecondWheeled(int index, String item);

    void onThirdWheeled(int index, String item);
}
