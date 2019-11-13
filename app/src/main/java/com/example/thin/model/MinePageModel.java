package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.UpdateAddressBean;

/**
 * @Author: Mr.Z
 * @Date: 2018/9/20
 * @Desc:
 */
public class MinePageModel extends BaseModel {
    public void addAddress(String deliveryName, String deliveryTelephone, String provinceId, String cityId, String countyId, String detailedAddress, HttpGsonCallback<UpdateAddressBean> callback) {
        invoke(apiService.addAddress(deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress), callback);
    }

    public void updateAddress(String id, String deliveryName, String deliveryTelephone, String provinceId, String cityId, String countyId, String detailedAddress, HttpGsonCallback<UpdateAddressBean> callback) {
        invoke(apiService.updateAddress(id, deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress), callback);
    }
}
