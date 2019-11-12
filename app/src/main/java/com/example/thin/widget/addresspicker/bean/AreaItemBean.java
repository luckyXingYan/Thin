package com.example.thin.widget.addresspicker.bean;

/**
 * Created by xingyan on 2018/1/4 18:16.
 * Email:lucky_xyic@sina.cn
 * ToDo:个人信息中 区域省市区的字段
 */

public class AreaItemBean extends AreaJavaBean {
    private String areaId;
    private String areaName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "areaId=" + areaId + ",areaName=" + areaName;
    }
}
