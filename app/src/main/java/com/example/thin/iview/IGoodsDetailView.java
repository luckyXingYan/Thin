package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.GoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public interface IGoodsDetailView extends IBaseView {
    void updateData(GoodsBean data);
    void addCart();
}
