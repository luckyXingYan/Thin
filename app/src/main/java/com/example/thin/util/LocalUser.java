
package com.example.thin.util;


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


    private UserInfo profile;


    /**
     * 更新用户数据
     *
     * @param profile
     */
    public void updateProfile(UserInfo profile) {
        this.profile = profile;
        save();
    }

    private void save() {
        PreferenceUtil.getInstance().setString(Constants.USER_ID, profile.userId);
        PreferenceUtil.getInstance().setString(Constants.USER_NAME, profile.userName);
    }

    /**
     * /**
     * 得到用户数据
     *
     * @return
     */
    public UserInfo getProfile() {
        return profile;
    }


    /**
     * 是否已登陆
     *
     * @return
     */
    public boolean isLogin() {
        return getProfile() != null;
    }
}
