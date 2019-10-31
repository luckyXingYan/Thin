package com.example.thin.bean;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartGoodsBean implements Serializable {
    public String title;
    public String id;
    public String price;
    public String num;
    public String shopId;
    public boolean isSelect;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
