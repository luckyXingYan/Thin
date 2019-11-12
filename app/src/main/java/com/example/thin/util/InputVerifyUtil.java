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
    private static final String EMPTY_FORMAT = "%s不得为空";
    private static final String WRONG_TIP_FORMAT = "请正确输入%s";
    private static final String PASSWORD_FORMAT = "%s必须为%d~%d位字符,需包含字母、数字、符号至少两种组合";
    private static final String NICK_NAME_FORMAT = "%s必须为%d~%d位";
    private static final String PASSWORD_UNEQUAL = "%s不一致，请重新输入";
    private static final String OK = "OK";


    public static String checkMobile(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            return String.format(EMPTY_FORMAT, "手机号");
        } else if (mobile.length() < MOBILE_LENGTH || mobile.length() > MOBILE_LENGTH) {
            return String.format(WRONG_TIP_FORMAT, "手机号");
        } else {
            return OK;
        }
    }

    public static String checkRegisterPwd(String pwd, String pwd2) {
        if (TextUtils.isEmpty(pwd)) {
            return String.format(EMPTY_FORMAT, "密码");
        } else if (!pwd.matches("(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?_.-]+)$)^[\\w~!@#$%^&*?_.-]{8,20}")) {
            return String.format(PASSWORD_FORMAT, "密码", 8, 20);
        } else if (TextUtils.isEmpty(pwd2)) {
            return String.format(EMPTY_FORMAT, "确认密码");
        } else if (!TextUtils.equals(pwd, pwd2)) {
            return String.format(PASSWORD_UNEQUAL, "密码");
        } else {
            return OK;
        }
    }

    public static String checkLoginPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            return String.format(EMPTY_FORMAT, "密码");
        } else if (!pwd.matches("(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?_.-]+)$)^[\\w~!@#$%^&*?_.-]{8,20}")) {
            return String.format(PASSWORD_FORMAT, "密码", 8, 20);
        } else {
            return OK;
        }
    }

    public static String checkNickName(String nickName) {
        if (TextUtils.isEmpty(nickName)) {
            return String.format(EMPTY_FORMAT, "昵称");
        }
//        else if (!nickName.matches("8,20")) {
//            return String.format(NICK_NAME_FORMAT, "昵称", 8, 20);
//        }
        else {
            return OK;
        }
    }

    public static String checkTargetWeight(String targetWeight) {
        if (TextUtils.isEmpty(targetWeight)) {
            return String.format(EMPTY_FORMAT, "目标体重");
        } else {
            return OK;
        }
    }

    public static String checkUpdateAddress(String deliveryName, String deliveryTelephone, String area, String detailedAddress) {
        if (TextUtils.isEmpty(deliveryName)) {
            return String.format(EMPTY_FORMAT, "收件人");
        }
        if (TextUtils.isEmpty(deliveryTelephone)) {
            return String.format(EMPTY_FORMAT, "手机号");
        } else if (deliveryTelephone.length() < MOBILE_LENGTH || deliveryTelephone.length() > MOBILE_LENGTH) {
            return String.format(WRONG_TIP_FORMAT, "手机号");
        }
        if (TextUtils.isEmpty(area)) {
            return String.format(EMPTY_FORMAT, "所在地区");
        }
        if (TextUtils.isEmpty(detailedAddress)) {
            return String.format(EMPTY_FORMAT, "详细地址");
        }
        return OK;
    }
}
