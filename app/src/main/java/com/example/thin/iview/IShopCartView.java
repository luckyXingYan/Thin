package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.CartBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/13
 * @Desc:
 */
public interface IShopCartView extends IBaseView {
    void updateCartList(CartBean data);
}
