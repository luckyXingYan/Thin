package com.example.thin.base.http.netcore.api;

/**
 * <br>包名：com.netcore.api
 * <br>项目名称：NetCore
 * <br>描述：服务器api访问路径定义
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/19 0019 11:25
 */
public class ApiRoute {

    //http://172.24.132.216:8093/thinbar-octopus/api/user/register/userRegister

    private static final String COMMON_ROOT = "/thinbar-octopus/api";

    public final class INDEX {
        private static final String ROOT = COMMON_ROOT + "";
        public static final String JOIN_SMS_CODE = ROOT + "/v2/join/getsmscode"; // 注册获取短信验证码
    }

    public final class USER {
        private static final String ROOT = COMMON_ROOT + "/user";
        public static final String REGISTER = ROOT + "/register/userRegister";
        public static final String LOGIN = ROOT + "/login/userLogin";
        public static final String EVALUATE = ROOT + "/evaluating/userEvaluating";
    }

    public final class PRODUCT {
        //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
        private static final String ROOT = COMMON_ROOT + "/v2/movie";
        public static final String GET_HOMEPAGE_REDPACKETS_STATUS = ROOT + "/top250";      //获取首页红包上线状态
    }

}