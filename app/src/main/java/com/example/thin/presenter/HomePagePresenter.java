package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.TypeBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.model.HomePageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class HomePagePresenter extends BasePresenter<IHomePageView> {
    private HomePageModel model;
    public void getTypeList(Context context) {

        model.getTypeList(new HttpGsonCallback<List<TypeBean>>(context) {
            @Override
            public void onSuccess(List<TypeBean> data) {
                if (isViewAttached()) {
                    getView().updateData(data);
                }
            }
        });

    }

    //首页热门列表  keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1
    public void getHot(String keyWord, String isHot, String groupId, String pageNo, String pageSize, Context context) {
        model.getHot(keyWord, isHot, groupId, pageNo, pageSize, new HttpGsonCallback<List<ShopBean>>(context) {
            @Override
            public void onSuccess(List<ShopBean> data) {
                if (isViewAttached()) {
                    getView().updateHot(data);
                }
            }
        });
    }

    @Override
    public void createModel() {
        model = new HomePageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
