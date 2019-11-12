package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.ShopBean;
import com.example.thin.iview.IShopDetailView;
import com.example.thin.model.ShopGoodsModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public class ShopDetailPresenter extends BasePresenter<IShopDetailView> {
    private ShopGoodsModel model;

    public void getShopDetail(Context context, String id) {
        model.getShopDetail(id, new HttpGsonCallback<ShopBean>(context) {
            @Override
            public void onSuccess(ShopBean data) {
                if (isViewAttached()) {
                    getView().updateData(data);
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
