package com.example.thin.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class OrderDataHelper {
    /**
     * List<Object>有三种数据类型：
     * 1、CartShopBean 表示每个订单的头部信息（订单号、订单状态、店铺名称）
     * 2、orderProductInfo 表示订单中的商品
     * 3、OrderPayInfo 表示订单的支付信息（金额、订单状态）
     *
     * @param resultList
     * @return
     */
    public static List<Object> getDataAfterHandle(List<CartListBean> resultList) {

        List<Object> dataList = new ArrayList<>();
        //遍历每一张大订单
        for (CartListBean orderListBean : resultList) {
            //订单编号 订单状态
            CartShopBean orderHeadInfo = new CartShopBean();
            orderHeadInfo.titile = orderListBean.title;

            List<CartGoodsBean> orderProductList;
            //订单商品
            orderProductList = orderListBean.goods;

            dataList.add(orderHeadInfo);
            if (orderProductList != null) {
                for (int i = 0; i < orderProductList.size(); i++) {
                    dataList.add(orderProductList.get(i));
                }
            }
        }
        return dataList;
    }

    public static List<Object> getDataAfterHandle2(List<CartListBean> resultList) {

        List<Object> dataList = new ArrayList<>();
        //遍历每一张大订单
        for (CartListBean orderListBean : resultList) {
            //订单编号 订单状态
            CartShopBean orderHeadInfo = new CartShopBean();
            orderHeadInfo.titile = orderListBean.title;

            List<CartGoodsBean> orderProductList;
            //订单商品
            orderProductList = orderListBean.goods;

            FootBean footBean;
            footBean = orderListBean.footBean;

            dataList.add(orderHeadInfo);
            if (orderProductList != null) {
                for (int i = 0; i < orderProductList.size(); i++) {
                    dataList.add(orderProductList.get(i));
                }
            }
            dataList.add(footBean);
        }
        return dataList;
    }
}
