package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.HotBean;
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

    //首页热门列表  keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1
    public void getHot(String keyWord, String isHot, String groupId, String pageNo, String pageSize, Context context) {
        model.getHot(keyWord, isHot, groupId, pageNo, pageSize, new HttpGsonCallback<List<HotBean>>(context) {
            @Override
            public void onSuccess(List<HotBean> data) {
                if (isViewAttached()) {
                    getView().updateHot(data);
                }
            }
        });
    }

//    //模拟 首页广告
//    public void getBannerData(String start, String count, Context context) {
//        model.getHomePageData(start, count, new HttpGsonCallback<List<HotBean>>(context) {
//
//            @Override
//            public void onSuccess(List<HotBean> data) {
//                if (isViewAttached()) {
//                    getView().updateHomeData(data);
//                }
//            }
//
//            @Override
//            public void onBizFailed(int code, String errorMsg) {
//                super.onBizFailed(code, errorMsg);
//            }
//        });
//    }

    @Override
    public void createModel() {
        model = new HomePageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
