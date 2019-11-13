package com.example.thin.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc: 目的时为了 rv 展示不需要嵌套 也可以展示数据
 */
public class OrderDataHelper {
    /**
     * List<Object>有三种数据类型：
     * 1、ShopTempBean 表示每个订单的头部信息（订单号、订单状态、店铺名称）
     * 2、goodList 表示订单中的商品
     *
     * @param resultList
     * @return
     */
    public static List<Object> getSubmitOrderList(List<ShopBean> resultList) {

        List<Object> dataList = new ArrayList<>();
        //遍历每一张大订单
        for (ShopBean orderListBean : resultList) {
            //将店铺信息 存储到 ShopTempBean 实体
            ShopTempBean orderHeadInfo = new ShopTempBean();
            orderHeadInfo.shopId = orderListBean.shopId;
            orderHeadInfo.shopName = orderListBean.shopName;

            //将商品存储到 goodList 中
            List<GoodsBean> goodList = orderListBean.cartProductVos;

            dataList.add(orderHeadInfo);
            if (goodList != null) {
                for (GoodsBean goodBean : goodList) {
                    dataList.add(goodBean);
                }
            }
        }
        return dataList;
    }

    /**
     * List<Object>有三种数据类型：
     * 1、ShopTempBean 表示每个订单的头部信息（订单号、订单状态、店铺名称）
     * 2、goodList 表示订单中的商品
     * 3、orderBottomBean 表示订单的支付信息（金额、订单状态）
     *
     * @param resultList
     * @return
     */
    public static List<Object> getMyOrderList(List<ShopBean> resultList) {
        List<Object> dataList = new ArrayList<>();
        //遍历每一张大订单
        for (ShopBean orderListBean : resultList) {
            //将店铺信息 存储到 ShopTempBean 实体
            ShopTempBean orderHeadInfo = new ShopTempBean();
            orderHeadInfo.shopId = orderListBean.shopId;
            orderHeadInfo.shopName = orderListBean.shopName;

            //将商品存储到 goodList 中
            List<GoodsBean> goodList = orderListBean.cartProductVos;

            //item底部物流存储到 footBean 中
            String shopStatus = orderListBean.shopStatus;

            dataList.add(orderHeadInfo);
            if (goodList != null) {
                for (GoodsBean goodBean : goodList) {
                    dataList.add(goodBean);
                }
            }
            dataList.add(shopStatus);
        }
        return dataList;
    }
}
