package com.example.thin.widget.addresspicker;

import com.example.thin.widget.addresspicker.bean.AreaCity;
import com.example.thin.widget.addresspicker.bean.AreaCounty;
import com.example.thin.widget.addresspicker.bean.AreaProvince;

/**
 * Created by xingyan on 2018/1/5 10:58.
 * Email:lucky_xyic@sina.cn
 * ToDo:选择地址
 */

public interface OnLinkageListener {
    void onAddressPicked(AreaProvince province, AreaCity city, AreaCounty county);
}
