package com.example.thin.util;

import android.text.TextUtils;

/**
 * <br>包名：com.yingu.jr.utils
 * <br>项目名称：jr
 * <br>描述：输入检查
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/7/1 0001 15:28
 */
public class InputVerifyUtil {

    private static final int MOBILE_LENGTH = 11;


    public static String checkMobile(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            return "请输入您的手机号";
        } else if (mobile.length() < MOBILE_LENGTH || mobile.length() > MOBILE_LENGTH) {
            return "手机号格式有误";
        } else {
            return "OK";
        }
    }

    public static String checkRegisterPwd(String pwd, String pwd2) {
        if (TextUtils.isEmpty(pwd)) {
            return "请输入您的密码";
        } else if (!pwd.matches("(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?_.-]+)$)^[\\w~!@#$%^&*?_.-]{8,20}")) {
            return "8-20位字符，需包含字母、数字、符号至少两种组合";
        } else if (TextUtils.isEmpty(pwd2)) {
            return "请输入您的确认密码";
        } else if (!TextUtils.equals(pwd, pwd2)) {
            return "密码不一致，请重新输入";
        } else {
            return "OK";
        }
    }

    public static String checkLoginPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            return "请输入您的密码";
        } else if (!pwd.matches("(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?_.-]+)$)^[\\w~!@#$%^&*?_.-]{8,20}")) {
            return "8-20位字符，需包含字母、数字、符号至少两种组合";
        } else {
            return "OK";
        }
    }
}
