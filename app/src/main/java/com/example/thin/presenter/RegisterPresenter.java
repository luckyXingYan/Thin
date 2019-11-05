package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.RegisterLoginBean;
import com.example.thin.iview.IRegisterView;
import com.example.thin.model.RegisterLoginModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/5
 * @Desc:
 */
public class RegisterPresenter extends BasePresenter<IRegisterView> {
    private RegisterLoginModel model;

    public void register(Context context, String mobile, String password) {
        model.register(mobile, password, new HttpGsonCallback<RegisterLoginBean>(context) {
            @Override
            public void onSuccess(RegisterLoginBean data) {
                if (isViewAttached()) {
                    getView().registerSuccess(data);
                }
            }

            @Override
            public void onBizFailed(int code, String errorMsg) {
                super.onBizFailed(code, errorMsg);
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
