package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.RegisterLoginBean;
import com.example.thin.iview.ICommonView;
import com.example.thin.model.RegisterLoginModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/7
 * @Desc:
 */
public class EvaluatePresenter extends BasePresenter<ICommonView> {
    private RegisterLoginModel model;

    public void evaluate(Context context, String nickname, String sex, String height, String targetWeight, String concernPosition) {
        model.evaluate(nickname, sex, height, targetWeight, concernPosition, new HttpGsonCallback<RegisterLoginBean>(context) {
            @Override
            public void onSuccess(RegisterLoginBean data) {
                if (isViewAttached()) {
                    getView().onSuccess();
                }
            }
        });
    }

    @Override
    public void createModel() {
        model = new RegisterLoginModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
