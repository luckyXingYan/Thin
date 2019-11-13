package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.CartBean;
import com.example.thin.bean.CommonBean;
import com.example.thin.iview.IShopCartView;
import com.example.thin.model.ShopGoodsModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/13
 * @Desc:
 *
 */
public class ShopCartPresenter extends BasePresenter<IShopCartView> {
    private ShopGoodsModel model;

    public void getCartList(Context context){
        model.cartList(new HttpGsonCallback<CartBean>(context) {
            @Override
            public void onSuccess(CartBean data) {
                if (isViewAttached()){
                    getView().updateCartList(data);
                }
            }
        });
    }

    @Override
    public void createModel() {
        model = new ShopGoodsModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
