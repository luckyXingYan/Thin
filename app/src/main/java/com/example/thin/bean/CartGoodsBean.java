package com.example.thin.bean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartGoodsBean {
    public String title;
    public String id;
    public String price;
    public String num = "2";
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
