package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.HotBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IHomePageView extends IBaseView {
    void updateHot(List<HotBean> data);

    void updateBannerData(List<HotBean> data);
}
