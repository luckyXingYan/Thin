package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.RegisterLoginBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/5
 * @Desc:
 */
public class RegisterLoginModel extends BaseModel {
    public void register(String mobile, String password, HttpGsonCallback<RegisterLoginBean> callback) {
        invoke(apiService.register(mobile, password), callback);
    }

    public void login(String mobile, String password, HttpGsonCallback<RegisterLoginBean> callback) {
        invoke(apiService.login(mobile, password), callback);
    }

    public void evaluate(String nickname, String sex, String height, String targetWeight, String concernPosition, HttpGsonCallback<RegisterLoginBean> callback) {
        invoke(apiService.evaluate(nickname, sex, height, targetWeight, concernPosition), callback);
    }
}
