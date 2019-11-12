package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;
import com.example.thin.iview.IGoodsDetailView;
import com.example.thin.iview.IShopDetailView;
import com.example.thin.model.ShopGoodsModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public class GoodsDetailPresenter extends BasePresenter<IGoodsDetailView> {
    private ShopGoodsModel model;

    public void getGoodsDetail(Context context, String id) {
        model.getGoodsDetail(id, new HttpGsonCallback<GoodsBean>(context) {
            @Override
            public void onSuccess(GoodsBean data) {
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
