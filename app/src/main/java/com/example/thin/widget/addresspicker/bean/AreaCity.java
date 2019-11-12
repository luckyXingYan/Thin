package com.example.thin.widget.addresspicker.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyan on 2018/1/4 18:18.
 * Email:lucky_xyic@sina.cn
 * ToDo:个人信息中 区域 中的市
 */

public class AreaCity extends AreaItemBean {
    private String provinceId;
    private List<AreaCounty> counties = new ArrayList<AreaCounty>();

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public List<AreaCounty> getCounties() {
        return counties;
    }

    public void setCounties(List<AreaCounty> counties) {
        this.counties = counties;
    }
}
