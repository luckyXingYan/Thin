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
    //http://172.24.132.216:8093/thinbar-octopus/shop/query?keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1

    private static final String COMMON_ROOT = "/thinbar-octopus";

    public final class INDEX {

        private static final String ROOT = COMMON_ROOT + "/shop";
        public static final String HOME_HOT = ROOT + "/query";
    }

    public final class USER {
        private static final String ROOT = COMMON_ROOT + "/api/user";
        public static final String REGISTER = ROOT + "/register/userRegister";
        public static final String LOGIN = ROOT + "/login/userLogin";
        public static final String EVALUATE = ROOT + "/evaluating/userEvaluating";
    }

    public final class PRODUCT {
        //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
        private static final String ROOT = COMMON_ROOT + "/v2/movie";
    }

}