package com.example.thin.bean;

import java.util.List;

/**
 * @Author; xingyan
 * @Date; 2019/11/8
 * @Desc;
 */
public class GoodsBean {


    /**
     * pid ; 1
     * productName ; 保健
     * productPrice ; 100.0
     */
    public boolean isSelect;

    public String pid;
    public String productId;

    public String productName;

    public String productPrice;//商品列表、详情单价
    public String unitPrice;//购物车商品单价


    public String productCover;//商品列表、详情图片
    public String imgUrl;//购物车商品图片

    public String groupId;//商品列表、详情店铺id
    public String shopId;//购物车店铺id


    public String count;

    public String productType;
    public String classifyName;
    public String productClassify;
    public String shopName;

    public String isfeature;
    public String freight;
    public String createrTime;
    public String updateTime;
    public String pageView;
    public String realPageView;
    public String sales;
    public String realSales;
    public String inventory;
    public String unit;
    public String status;
    public String remake;
    public String content;
    public String freightPrice;
    public List<ImgListBean> rotationCharts;

}
