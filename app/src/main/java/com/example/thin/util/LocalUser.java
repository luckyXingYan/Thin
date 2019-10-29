
package com.example.thin.util;


import android.text.TextUtils;

import com.example.thin.bean.UserInfo;

import java.io.Serializable;

public class LocalUser implements Serializable {
    private static LocalUser instance = null;

    public static LocalUser getInstance() {
        if (instance == null) {
            instance = new LocalUser();
        }
        return instance;
    }

    /**
     * 更新用户数据
     */
    public void setUserId(String userId) {
        PreferenceUtil.getInstance().setString(Constants.USER_ID, userId);
    }

    public void setUserName(String userName) {
        PreferenceUtil.getInstance().setString(Constants.USER_NAME, userName);
    }

    public void setUserSex(String userSex) {
        PreferenceUtil.getInstance().setString(Constants.USER_SEX, userSex);
    }

    public void setUserTargetWeight(String userTargetWeight) {
        PreferenceUtil.getInstance().setString(Constants.USER_TARGET_WEIGHT, userTargetWeight);
    }

    public void setUserBodyHeight(String userBodyHeight) {
        PreferenceUtil.getInstance().setString(Constants.USER_BODY_HEIGHT, userBodyHeight);
    }

    public void setUserNickName(String userNickName) {
        PreferenceUtil.getInstance().setString(Constants.USER_NICK_NAME, userNickName);
    }

    public void getUserId() {
        PreferenceUtil.getInstance().getString(Constants.USER_ID);
    }

    public void getUserName() {
        PreferenceUtil.getInstance().getString(Constants.USER_NAME);
    }

    public void getUserSex() {
        PreferenceUtil.getInstance().getString(Constants.USER_SEX);
    }

    public void getUserTargetWeight() {
        PreferenceUtil.getInstance().getString(Constants.USER_TARGET_WEIGHT);
    }

    /**
     * 是否已登陆
     *
     * @return
     */
    public boolean isLogin() {
        return !TextUtils.isEmpty(PreferenceUtil.getInstance().getString(Constants.USER_ID));
    }
}
