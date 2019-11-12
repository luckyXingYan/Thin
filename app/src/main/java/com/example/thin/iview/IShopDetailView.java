package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.ShopBean;


/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public interface IShopDetailView extends IBaseView {
    void updateData(ShopBean data);
}
