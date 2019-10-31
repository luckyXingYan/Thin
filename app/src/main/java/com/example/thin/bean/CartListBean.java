package com.example.thin.bean;

import android.provider.Contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartListBean implements Serializable {
    public String title;
    public String id;
    public List<CartGoodsBean> goods = new ArrayList<>();
    public FootBean footBean;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CartListBean) {
            CartListBean data = (CartListBean) obj;
            if (data.id.equals(this.id)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
