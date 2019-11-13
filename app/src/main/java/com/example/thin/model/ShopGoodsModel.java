package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.CartBean;
import com.example.thin.bean.CommonBean;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public class ShopGoodsModel extends BaseModel {
    public void getShopDetail(String id, HttpGsonCallback<ShopBean> callback) {
        invoke(apiService.shopDetail(id), callback);
    }

    public void getGoodsDetail(String id, HttpGsonCallback<GoodsBean> callback) {
        invoke(apiService.goodsDetail(id), callback);
    }


    public void addCart(String productId, String count, HttpGsonCallback<CommonBean> callback) {
        invoke(apiService.addCart(productId, count), callback);
    }

    public void cartList(HttpGsonCallback<CartBean> callback) {
        invoke(apiService.cartList(), callback);
    }
}
