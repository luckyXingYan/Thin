package com.example.thin.widget.addresspicker.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyan on 2018/1/4 18:17.
 * Email:lucky_xyic@sina.cn
 * ToDo:个人信息中 区域 中的省
 */

public class AreaProvince extends AreaItemBean {
    private List<AreaCity> cities = new ArrayList<AreaCity>();

    public List<AreaCity> getCities() {
        return cities;
    }

    public void setCities(List<AreaCity> cities) {
        this.cities = cities;
    }
}
