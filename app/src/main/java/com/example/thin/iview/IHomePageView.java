package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.TypeBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IHomePageView extends IBaseView {
    void updateData(List<TypeBean> data);
    void updateHot(List<ShopBean> data);

    void updateBannerData(List<ShopBean> data);
}
