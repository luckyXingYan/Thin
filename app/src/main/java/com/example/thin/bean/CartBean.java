package com.example.thin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartBean implements Serializable {
//    public String title;
//    public String id;
//    public List<GoodBean> goods = new ArrayList<>();
//    public OrderBottomBean orderBottomBean;

    public String userId;
    public CartNumBean cartTotalVo;
    public List<ShopBean> cartShopVos;
}
