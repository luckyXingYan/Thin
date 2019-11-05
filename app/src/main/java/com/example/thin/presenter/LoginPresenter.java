package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.RegisterLoginBean;
import com.example.thin.iview.ILoginView;
import com.example.thin.model.RegisterLoginModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/5
 * @Desc:
 */
public class LoginPresenter extends BasePresenter<ILoginView> {
    private RegisterLoginModel model;

    public void login(Context context,String mobile, String password){
        model.login(mobile, password, new HttpGsonCallback<RegisterLoginBean>(context) {
            @Override
            public void onSuccess(RegisterLoginBean data) {
                if (isViewAttached()){
                    getView().loginSuccess(data);
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
